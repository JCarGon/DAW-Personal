function fusionarObjetos(obj1, obj2){
  const objResult = obj1;
  for (const key in obj2) {
    if (objResult.hasOwnProperty(key)) {
      objResult[key] = obj2[key];
    }else {
      objResult[key] = obj2[key];
    }
  }
  console.log(`Objeto 1: ${JSON.stringify(obj1)}`);
  console.log(`Objeto 2: ${JSON.stringify(obj2)}`);
  return objResult;
}

const pepe = {a: 1, b: 2, c: 3, d: 4};
const manuel = {b: 2, z: 3};
console.log(`Objeto resultante: ${JSON.stringify(fusionarObjetos(pepe, manuel))}`);