async function buscarPokemon() {
  const inputElement = document.getElementById("pokemonInput");
  const pokemonName = inputElement.value.trim().toLowerCase();

  if (pokemonName === "") {
    alert("Debes introducir un nombre de Pokemon.");
    return;
  }

  const apiUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;

  try {
    const response = await fetch(apiUrl);
    if(!response.ok){
      alert('El pokemon no existe');
    }else{
      const data = await response.json();
      mostrarPokemonInfo(data);
    }
  } catch (err) {
    alert(err);
  }
}

function mostrarPokemonInfo(pokemonData) {
  const infoDiv = document.getElementById("pokemonInfo");

  const imageElement = document.getElementById("pokemonImage");
  imageElement.src = pokemonData.sprites.front_default;

  const numberElement = document.getElementById("pokemonNumber");
  numberElement.textContent = "Número de Pokédex: " + pokemonData.id;

  const nameElement = document.getElementById("pokemonName");
  nameElement.textContent = "Nombre: " + pokemonData.name.charAt(0).toUpperCase() + pokemonData.name.slice(1);

  const typesElement = document.getElementById("pokemonTypes");
  typesElement.textContent = "Tipos: " + pokemonData.types.map(type => type.type.name).join(", ");

  infoDiv.style.display = "block";
}