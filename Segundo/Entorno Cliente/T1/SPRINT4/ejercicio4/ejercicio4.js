const resultsPerPage = 5;
let currentPage = 1;
let totalResults = 0;
let genresMap = {};

// Función para obtener géneros disponibles
async function fetchGenres() {
  try {
    const response = await fetch(
      `https://api.themoviedb.org/3/genre/movie/list?api_key=5ecc5e1661fb5027c83b9709f43dec81`
    );
    const data = await response.json();

    genresMap = data.genres.reduce((map, genre) => {
      map[genre.id] = genre.name;
      return map;
    }, {});

    // Llenar la lista desplegable con los géneros
    const genreDropdown = document.getElementById("genreDropdown");
    Object.entries(genresMap).forEach(([id, name]) => {
      const option = document.createElement("option");
      option.value = id;
      option.textContent = name;
      genreDropdown.appendChild(option);
    });
  } catch (error) {
    console.error("Error fetching genres:", error);
  }
}

// Llamada a la función para obtener géneros al cargar la página
fetchGenres();

async function searchMovies() {
  const searchTerm = document.getElementById("searchInput").value;

  try {
    const response = await fetch(
      `https://api.themoviedb.org/3/search/movie?query=${searchTerm}&api_key=5ecc5e1661fb5027c83b9709f43dec81`
    );
    const data = await response.json();

    // Obtener detalles de cada película
    const moviesDetails = await Promise.all(
      data.results.map(async (movie) => {
        const detailsResponse = await fetch(
          `https://api.themoviedb.org/3/movie/${movie.id}?api_key=5ecc5e1661fb5027c83b9709f43dec81&language=es`
        );
        const detailsData = await detailsResponse.json();
        return {
          ...movie,
          overview_es: detailsData.overview,
        };
      })
    );

    displayMovies(moviesDetails, searchMovies);
  } catch (error) {
    console.error("Error fetching data:", error);
  }
}

function displayMovies(movies, searchFunction) {
  const moviesContainer = document.getElementById("moviesContainer");
  const paginationContainer = document.getElementById("paginationContainer");

  // Limpiar resultados anteriores
  moviesContainer.innerHTML = "";
  paginationContainer.innerHTML = "";

  totalResults = movies.length;

  const startIndex = (currentPage - 1) * resultsPerPage;
  const endIndex = startIndex + resultsPerPage;

  const displayedMovies = movies.slice(startIndex, endIndex);
  displayedMovies.forEach((movie) => {
    const movieElement = document.createElement("div");
    movieElement.classList.add("movie");
    movieElement.innerHTML = `
          <h2>${movie.title} (${getYear(movie.release_date)})</h2>
          <p>Género: ${getGenres(movie.genre_ids)}</p>
          <p>Resumen: ${movie.overview_es || "No disponible en español"}</p>
          <p>Puntuación: ${Math.round(movie.vote_average*10)/10}</p>
          <img src="https://image.tmdb.org/t/p/w200${movie.poster_path}" alt="${movie.title}">
      `;
    moviesContainer.appendChild(movieElement);
  });
  createPagination(searchFunction);
}

function createPagination(searchFunction) {
  const paginationContainer = document.getElementById("paginationContainer");

  const totalPages = Math.ceil(totalResults / resultsPerPage);

  for (let i = 1; i <= totalPages; i++) {
    const pageButton = document.createElement("button");
    pageButton.textContent = i;
    pageButton.addEventListener("click", () => {
      currentPage = i;
      searchFunction();
    });
    paginationContainer.appendChild(pageButton);
  }
}

function getGenres(genreIds) {
  return genreIds.map((id) => genresMap[id]).join(", ");
}

async function searchByGenre() {
  const selectedGenreId = document.getElementById("genreDropdown").value;
  const selectedGenreName = genresMap[selectedGenreId];

  if (selectedGenreName) {
    try {
      const response = await fetch(
        `https://api.themoviedb.org/3/discover/movie?with_genres=${selectedGenreId}&api_key=5ecc5e1661fb5027c83b9709f43dec81`
      );
      const data = await response.json();

      // Obtener detalles de cada película
      const moviesDetails = await Promise.all(
        data.results.map(async (movie) => {
          const detailsResponse = await fetch(
            `https://api.themoviedb.org/3/movie/${movie.id}?api_key=5ecc5e1661fb5027c83b9709f43dec81&language=es`
          );
          const detailsData = await detailsResponse.json();
          return {
            ...movie,
            overview_es: detailsData.overview,
          };
        })
      );

      displayMovies(moviesDetails, searchByGenre);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  } else {
    console.error("Invalid genre selection");
  }
}

async function performSearch() {
  const searchTerm = document.getElementById("searchInput").value;
  const selectedGenreId = document.getElementById("genreDropdown").value;

  if (searchTerm && !selectedGenreId) {
    // Búsqueda por nombre
    await searchMovies();
  } else if (!searchTerm && selectedGenreId) {
    // Búsqueda por género
    await searchByGenre();
  } else if (searchTerm && selectedGenreId) {
    // Búsqueda por nombre y género
    try {
      const response = await fetch(
        `https://api.themoviedb.org/3/search/movie?query=${searchTerm}&api_key=5ecc5e1661fb5027c83b9709f43dec81`
      );
      const data = await response.json();

      // Filtrar por género
      const filteredMovies = data.results.filter(
        (movie) => movie.genre_ids.includes(parseInt(selectedGenreId))
      );

      displayMovies(filteredMovies);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  } else {
    console.error("Ingrese un término de búsqueda o seleccione un género");
  }
}

function getYear(releaseDate) {
  return releaseDate ? new Date(releaseDate).getFullYear() : "No disponible";
}

// Nueva función para truncar el resumen a un máximo de 10 líneas
function truncateOverview(overview) {
  const maxLines = 10;
  const lines = overview.split("\n");

  if (lines.length > maxLines) {
    // Conservar solo las primeras 10 líneas
    return lines.slice(0, maxLines).join("\n") + " ...";
  }

  return overview;
}