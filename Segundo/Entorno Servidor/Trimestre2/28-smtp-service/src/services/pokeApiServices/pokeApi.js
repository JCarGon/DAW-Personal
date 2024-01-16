import { Logger } from 'winston';

export async function getPokeAPI(pokemonData) {
  let response;
  try {
    response = await fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonData}`);
  } catch (err) {
    Logger.info(err);
  }
  const data = await response.json();
  return data;
}

export async function getPokemones() {
  let response;
  try {
    response = await fetch('https://pokeapi.co/api/v2/pokemon');
  } catch (err) {
    Logger.info(err);
  }
  const data = await response.json();
  return data;
}
