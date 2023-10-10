async function petition(url) {
  try {
    const response = await fetch(url);
    if (!response.ok) {
      console.log("Error.");
    } else {
      const data = await response.json();
      return data;
    }
  } catch (err) {
    console.log(err);
  }
}

const data = await petition("https://pokeapi.co/api/v2/pokemon/dragonite");
console.log(`Nombre: ${data.name}`);
console.log(`Número de pokédex: ${data.id}`);
console.log(data.stats);