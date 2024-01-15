import { getPokeAPI, getPokemones } from '../services/pokeApiServices/pokeApi.js';

export async function getPokemon(req, res) {
  const pokemonData = req.params.id;
  const data = await getPokeAPI(pokemonData);
  res.status(200).send(data);
}

export async function getListaPokemones(req, res) {
  const data = await getPokemones();
  res.status(200).send(data);
}
