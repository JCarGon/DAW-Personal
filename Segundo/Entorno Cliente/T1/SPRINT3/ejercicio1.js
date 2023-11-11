function filtrarPropiedades(obj, propiedades) {
  const resultado = {};
  for (const propiedad of propiedades) {
    if (obj.hasOwnProperty(propiedad)) {
      resultado[propiedad] = obj[propiedad];
    }
  }
  console.log(`El objeto de entrada es: ${JSON.stringify(obj)}`);
  console.log(`Las propiedades que se queiren son: ${propiedades}`);
  return resultado;
}

const entrada = { a: 1, b: 2, c: 3, d: 4 };
const props = ["a", "c"];
const resultado = filtrarPropiedades(entrada, props);
console.log(resultado);