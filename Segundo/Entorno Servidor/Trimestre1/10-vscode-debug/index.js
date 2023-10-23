const response = await fetch('https://pokeapi.co/api/v2/pokemon/scyther');
const data = await response.json();
console.log(data);