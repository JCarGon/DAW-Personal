let response;
let data;

try {
    response = await fetch('https://pokeapi.co/api/v2/pokemon/dragonite');
} catch (err) {
    console.log(err);
}
if(!response.ok){
    console.log('Error.');
} else{
    console.log(`Status Code: ${response.status}`);
    data = await response.json();
}
console.log(data);