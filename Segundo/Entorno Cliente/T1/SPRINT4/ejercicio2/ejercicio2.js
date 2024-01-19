async function comparePokemon() {
  const pokemon1Input = document.getElementById("pokemon1Input").value;
  const pokemon2Input = document.getElementById("pokemon2Input").value;

  if (!pokemon1Input || !pokemon2Input) {
    alert("No puede haber campos vacíos");
    return;
  }

  try {
    const [pokemon1, pokemon2] = await Promise.all([
      getPokemonData(pokemon1Input),
      getPokemonData(pokemon2Input),
    ]);

    if (!pokemon1 || !pokemon2) {
      alert("Ambos Pokémon deben existir");
      return;
    }

    createTable(pokemon1, pokemon2);
  } catch (error) {
    console.error("Error al obtener datos de la PokeAPI", error);
    alert("Error al obtener datos de la PokeAPI");
  }
}

async function getPokemonData(pokemonName) {
  const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonName.toLowerCase()}`);
  if (!response.ok) {
    return null;
  }

  const pokemonData = await response.json();
  return {
    name: pokemonData.name,
    stats: pokemonData.stats.map((stat) => ({
      name: stat.stat.name,
      value: stat.base_stat,
    })),
  };
}

async function createTable(pokemon1, pokemon2) {
  const tableContainer = document.getElementById("table-container");
  tableContainer.innerHTML = "";

  const table = document.createElement("table");

  const headerRow = table.insertRow();
  headerRow.insertCell().textContent = "Estadísticas";
  headerRow.insertCell().textContent = pokemon1.name;
  headerRow.insertCell().textContent = pokemon2.name;
  headerRow.insertCell().textContent = "Stat Ganadora";

  const stats = [
    "hp",
    "attack",
    "defense",
    "special-attack",
    "special-defense",
    "speed",
  ];
  for (const stat of stats) {
    const row = table.insertRow();
    row.insertCell().textContent = stat;
    row.insertCell().textContent = pokemon1.stats.find((s) => s.name === stat).value;
    row.insertCell().textContent = pokemon2.stats.find((s) => s.name === stat).value;
    row.insertCell().textContent = determineWinner(stat, pokemon1, pokemon2);
  }

  tableContainer.appendChild(table);

  const winnerParagraph = document.getElementById("winnerParagraph");
  const winnerImageContainer = document.getElementById("winnerImage");

  const winner = determineOverallWinner(pokemon1, pokemon2);
  winnerParagraph.textContent = `El Pokémon con mejores estadísticas en conjunto es: ${winner}`;

  const winnerImage = document.createElement("img");
  try{
    const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${winner.toLowerCase()}`);
    if(!response.ok){
      console.log('Algo salió mal en la petición');
    }else{
      const data = await response.json();
      const imageWinner = data.sprites.front_default;
      winnerImage.src = imageWinner;
      winnerImage.alt = `${winner} Sprite`;
      winnerImageContainer.innerHTML = "";
      winnerImageContainer.appendChild(winnerImage);
    }
  } catch(err) {
    console.log(err);
  }
}

function determineWinner(stat, pokemon1, pokemon2) {
  const value1 = pokemon1.stats.find((s) => s.name === stat).value;
  const value2 = pokemon2.stats.find((s) => s.name === stat).value;

  return value1 > value2
    ? pokemon1.name
    : value1 < value2
    ? pokemon2.name
    : "Empate";
}

function determineOverallWinner(pokemon1, pokemon2) {
  const stats1 = pokemon1.stats.reduce((sum, stat) => sum + stat.value, 0);
  const stats2 = pokemon2.stats.reduce((sum, stat) => sum + stat.value, 0);

  if (stats1 === stats2) {
    const avgStats1 = stats1 / pokemon1.stats.length;
    const avgStats2 = stats2 / pokemon2.stats.length;

    return avgStats1 > avgStats2
      ? pokemon1.name
      : avgStats1 < avgStats2
      ? pokemon2.name
      : "Empate por Media";
  }

  return stats1 > stats2 ? pokemon1.name : stats1 < stats2 ? pokemon2.name : "Empate";
}