const resultsPerPage = 5;
let currentPage = 1;
let totalResults = 0;
let totalPages = 0;
let genresMap = [];

// Llamada a la función para obtener géneros al cargar la página
fetchGenres();

// Limpia las películas favoritas al cerrar la página
window.addEventListener("beforeunload", () => {
  localStorage.removeItem("favoriteMovies");
});

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

// Función para forzar el resumen a un máximo de 10 líneas
function truncateOverview(overview) {
  const maxLines = 10;
  const lines = overview.split("\n");

  if (lines.length > maxLines) {
    // Conservar solo las primeras 10 líneas
    return lines.slice(0, maxLines).join("\n") + " ...";
  }
  return overview;
}

// Función para agregar una película a la lista de favoritos
function addToFavorites(movie) {
  // Obtener películas favoritas del localStorage
  const storedFavorites = JSON.parse(localStorage.getItem("favoriteMovies")) || [];
  // Verificar si la película ya está en favoritos
  const isAlreadyAdded = storedFavorites.some((favMovie) => favMovie.id === movie.id);

  if (isAlreadyAdded) {
    alert("¡Ya tienes esa película en favoritos!");
  } else {
    // Agregar la película a la lista de favoritos
    storedFavorites.push(movie);
    // Guardar la lista actualizada en localStorage
    localStorage.setItem("favoriteMovies", JSON.stringify(storedFavorites));
    alert(`Se ha agregado a favoritos la película ${movie.title}`);
  }
}

// Función para obtener el año de lanzamiento de una película
function getYear(releaseDate) {
  return releaseDate ? new Date(releaseDate).getFullYear() : "No disponible";
}

// Función para realizar la búsqueda de películas
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
    // Cargar las películas favoritas almacenadas
    const storedFavorites = JSON.parse(localStorage.getItem("favoriteMovies")) || [];
    displayMovies([...moviesDetails, ...storedFavorites], searchMovies);
  } catch (error) {
    console.error("Error fetching data:", error);
  }
}

// Función para crear la paginación
function createPagination(searchFunction) {
  const paginationContainer = document.getElementById("paginationContainer");

  // Limpiar paginación anterior
  paginationContainer.innerHTML = "";

  const prevButton = document.createElement("button");
  prevButton.textContent = "Anterior";
  prevButton.addEventListener("click", () => {
    if (currentPage > 1) {
      currentPage--;
      searchFunction();
    }
  });
  paginationContainer.appendChild(prevButton);

  const currentPageSpan = document.createElement("span");
  currentPageSpan.textContent = currentPage + " de " + totalPages;
  paginationContainer.appendChild(currentPageSpan);

  const nextButton = document.createElement("button");
  nextButton.textContent = "Siguiente";
  nextButton.addEventListener("click", () => {
    if (currentPage < totalPages) {
      currentPage++;
      searchFunction();
    }
  });
  paginationContainer.appendChild(nextButton);
}

// Función para crear un elemento de película
function createMovieElement(movie) {
  const movieElement = document.createElement("div");
  movieElement.classList.add("movie");

  const img = document.createElement("img");
  img.src = `https://image.tmdb.org/t/p/w200${movie.poster_path}`;
  img.alt = `${movie.title} Poster`;

  const title = document.createElement("h2");
  title.textContent = movie.title;

  const releaseDate = document.createElement("p");
  releaseDate.textContent = `Año de lanzamiento: ${getYear(movie.release_date)}`;

  const genres = document.createElement("p");
  genres.textContent = `Géneros: ${getGenres(movie.genre_ids)}`;

  const overview = document.createElement("p");
  overview.textContent = truncateOverview(movie.overview_es);

  const addToFavoritesButton = document.createElement("button");
  addToFavoritesButton.textContent = "Añadir a favoritos";
  addToFavoritesButton.style.display = "block";
  addToFavoritesButton.style.margin = "0 auto";
  addToFavoritesButton.style.marginTop = "10px";
  addToFavoritesButton.style.padding = "8px 16px";
  addToFavoritesButton.style.fontSize = "16px";
  addToFavoritesButton.style.cursor = "pointer";
  addToFavoritesButton.style.backgroundColor = "#4caf50";
  addToFavoritesButton.style.color = "white";
  addToFavoritesButton.style.border = "1px solid #4caf50";
  addToFavoritesButton.style.borderRadius = "5px";
  addToFavoritesButton.addEventListener("click", () => {
    addToFavorites(movie);
  });

  movieElement.appendChild(img);
  movieElement.appendChild(title);
  movieElement.appendChild(releaseDate);
  movieElement.appendChild(genres);
  movieElement.appendChild(overview);
  movieElement.appendChild(addToFavoritesButton);

  return movieElement;
}

// Función para mostrar las películas en la página
function displayMovies(movies, searchFunction) {
  const moviesContainer = document.getElementById("moviesContainer");
  const paginationContainer = document.getElementById("paginationContainer");

  // Limpiar resultados anteriores
  moviesContainer.innerHTML = "";
  paginationContainer.innerHTML = "";

  totalResults = movies.length;
  totalPages = Math.ceil(totalResults / resultsPerPage);

  const startIndex = (currentPage - 1) * resultsPerPage;
  const endIndex = startIndex + resultsPerPage;

  const displayedMovies = movies.slice(startIndex, endIndex);
  displayedMovies.forEach((movie) => {
    const movieElement = createMovieElement(movie);
    moviesContainer.appendChild(movieElement);
  });

  // Solo mostrar la paginación si hay más de una página de resultados
  if (totalPages > 1) {
    createPagination(searchFunction);
  }
}

// Función para crear un elemento de película dentro de favoritos
function createFavoriteMovieElement(movie) {
  const movieElement = document.createElement("div");
  movieElement.classList.add("movie");

  const img = document.createElement("img");
  img.src = `https://image.tmdb.org/t/p/w200${movie.poster_path}`;
  img.alt = `${movie.title} Poster`;

  const title = document.createElement("h2");
  title.textContent = movie.title;

  const releaseDate = document.createElement("p");
  releaseDate.textContent = `Año de lanzamiento: ${getYear(movie.release_date)}`;

  const genres = document.createElement("p");
  genres.textContent = `Géneros: ${getGenres(movie.genre_ids)}`;

  const overview = document.createElement("p");
  overview.textContent = truncateOverview(movie.overview_es);

  const removeFromFavoritesButton = document.createElement("button");
  removeFromFavoritesButton.textContent = "Eliminar de favoritos";
  removeFromFavoritesButton.style.display = "block";
  removeFromFavoritesButton.style.margin = "0 auto";
  removeFromFavoritesButton.style.marginTop = "10px";
  removeFromFavoritesButton.style.padding = "8px 16px";
  removeFromFavoritesButton.style.fontSize = "16px";
  removeFromFavoritesButton.style.cursor = "pointer";
  removeFromFavoritesButton.style.backgroundColor = "#e74c3c";
  removeFromFavoritesButton.style.color = "white";
  removeFromFavoritesButton.style.border = "1px solid #e74c3c";
  removeFromFavoritesButton.style.borderRadius = "5px";
  removeFromFavoritesButton.addEventListener("click", () => {
    removeFromFavorites(movie);
  });

  movieElement.appendChild(img);
  movieElement.appendChild(title);
  movieElement.appendChild(releaseDate);
  movieElement.appendChild(genres);
  movieElement.appendChild(overview);
  movieElement.appendChild(removeFromFavoritesButton);

  return movieElement;
}

function displayFavoritesMovies(movies, searchFunction) {
  const moviesContainer = document.getElementById("moviesContainer");
  const paginationContainer = document.getElementById("paginationContainer");

  // Limpiar resultados anteriores
  moviesContainer.innerHTML = "";
  paginationContainer.innerHTML = "";

  totalResults = movies.length;
  totalPages = Math.ceil(totalResults / resultsPerPage);

  const startIndex = (currentPage - 1) * resultsPerPage;
  const endIndex = startIndex + resultsPerPage;

  const displayedMovies = movies.slice(startIndex, endIndex);
  displayedMovies.forEach((movie) => {
    const movieElement = createFavoriteMovieElement(movie);
    moviesContainer.appendChild(movieElement);
  });

  // Solo mostrar la paginación si hay más de una página de resultados
  if (totalPages > 1) {
    createPagination(searchFunction);
  }
}

// Función para obtener géneros de una película
function getGenres(genreIds) {
  return genreIds.map((id) => genresMap[id]).join(", ");
}

// Función para buscar películas por género
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

// Función para búsqueda por nombre o género
async function performSearch() {
  // Resetear la página a 1 al realizar una nueva búsqueda
  currentPage = 1;

  const searchTerm = document.getElementById("searchInput").value;
  const selectedGenreId = document.getElementById("genreDropdown").value;

  if (searchTerm && !selectedGenreId) {
    await searchMovies();
  } else if (!searchTerm && selectedGenreId) {
    await searchByGenre();
  }
}

function showFavorites() {
  // Obtener películas favoritas del localStorage
  const storedFavorites = JSON.parse(localStorage.getItem("favoriteMovies")) || [];
  displayFavoritesMovies(storedFavorites, showFavorites);
}

function removeFromFavorites(movie) {
  const storedFavorites = JSON.parse(localStorage.getItem("favoriteMovies")) || [];
  // Buscar la película en la lista de favoritos
  const index = storedFavorites.findIndex((favMovie) => favMovie.id === movie.id);

  if (index !== -1) {
    // La película está en favoritos, eliminarla
    storedFavorites.splice(index, 1);
    // Actualizar la lista en localStorage
    localStorage.setItem("favoriteMovies", JSON.stringify(storedFavorites));
    alert(`Película ${movie.title} eliminada de favoritos`);
  } else {
    alert(`No puedo borrar la película de favoritos porque no está en favoritos`);
  }
  // Actualizar la visualización de películas favoritas
  showFavorites();
}