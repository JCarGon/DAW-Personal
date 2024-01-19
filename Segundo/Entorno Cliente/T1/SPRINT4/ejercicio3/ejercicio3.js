async function showEvolutions() {
  const pokemonInput = document.getElementById("pokemonInput").value;

  if (!pokemonInput) {
    alert("Debes introducir un Pokémon");
    return;
  }

  try {
    const evolutionChain = await getPokemonEvolutionChain(pokemonInput);

    if (!evolutionChain) {
      alert("El Pokémon introducido no existe");
      return;
    }

    displayEvolutionChain(evolutionChain);
  } catch (error) {
    console.error("Error al obtener datos de la PokeAPI", error);
    alert("Error al obtener datos de la PokeAPI");
  }
}

async function getPokemonEvolutionChain(pokemonName) {
  const response = await fetch(`https://pokeapi.co/api/v2/pokemon-species/${pokemonName.toLowerCase()}`);
  if (!response.ok) {
    return null;
  }

  const speciesData = await response.json();
  const evolutionChainUrl = speciesData.evolution_chain.url;

  const evolutionChainResponse = await fetch(evolutionChainUrl);
  if (!evolutionChainResponse.ok) {
    return null;
  }

  const evolutionChainData = await evolutionChainResponse.json();
  return evolutionChainData.chain;
}

async function displayEvolutionChain(evolutionChain) {
  const evolutionContainer = document.getElementById("evolutionContainer");
  evolutionContainer.innerHTML = "";

  let currentEvolution = evolutionChain;

  while (currentEvolution) {
    const pokemonData = await getPokemonData(currentEvolution.species.name);

    const pokemonCard = document.createElement("div");
    pokemonCard.classList.add("pokemon-card");

    const pokemonImage = document.createElement("img");
    pokemonImage.src = pokemonData.sprites.front_default;
    pokemonImage.alt = `${currentEvolution.species.name} Sprite`;
    pokemonImage.classList.add("pokemon-image");

    const pokemonName = document.createElement("p");
    pokemonName.textContent = currentEvolution.species.name;

    const abilities = document.createElement("div");
    abilities.classList.add("abilities");
    pokemonData.abilities.forEach((ability) => {
      const abilityButton = document.createElement("button");
      abilityButton.textContent = ability.name;
      abilityButton.addEventListener("click", () => showAbilityDescription(ability.url));
      abilities.appendChild(abilityButton);
    });

    const moreInfo = document.createElement("div");
    moreInfo.classList.add("more-info");

    pokemonCard.appendChild(pokemonImage);
    pokemonCard.appendChild(pokemonName);
    pokemonCard.appendChild(abilities);
    pokemonCard.appendChild(moreInfo);

    evolutionContainer.appendChild(pokemonCard);

    currentEvolution = currentEvolution.evolves_to[0];
  }
}

async function getPokemonData(pokemonName) {
  const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonName.toLowerCase()}`);
  if (!response.ok) {
    return null;
  }

  const pokemonData = await response.json();
  return {
    sprites: pokemonData.sprites,
    abilities: pokemonData.abilities.map((ability) => ({
      name: ability.ability.name,
      url: ability.ability.url,
    })),
  };
}

async function showAbilityDescription(abilityUrl) {
  try {
    const response = await fetch(abilityUrl);
    if (!response.ok) {
      console.log("Error al obtener datos de la habilidad");
      return;
    }

    const abilityData = await response.json();
    const description = abilityData.flavor_text_entries.find((entry) => entry.language.name === "es").flavor_text;

    alert(description);
  } catch (error) {
    console.error("Error al obtener datos de la PokeAPI", error);
    alert("Error al obtener datos de la habilidad");
  }
}