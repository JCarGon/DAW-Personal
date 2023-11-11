function cadenaMasLarga(cadena){
  const result = {
    cadenaMasLarga: '',
    longitud: 0,
  }
  for (let index = 0; index < cadena.length; index++) {
    if(result.longitud < cadena[index].length){
      result.cadenaMasLarga = cadena[index];
      result.longitud = cadena[index].length;
    }
  }
  return result;
}

const arrayDeStrings = [
  "Hola",
  "Este es un string más largo",
  "Corto",
  "Un string un poco más largo",
  "Hoy es un buen día",
  "Otro string",
  "Esto es un ejemplo",
  "String",
  "Un string largo para completar",
  "Último string"
];
console.log(`Array de strings: ${arrayDeStrings}`);
console.log(cadenaMasLarga(arrayDeStrings));