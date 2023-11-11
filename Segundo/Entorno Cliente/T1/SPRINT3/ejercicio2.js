function matrizTraspuesta(matriz) {
  const filas = matriz.length;
  const columnas = matriz[0].length;

  const matrizTraspuesta = new Array(columnas);
  for (let i = 0; i < columnas; i++) {
    matrizTraspuesta[i] = new Array(filas);
  }

  for (let i = 0; i < filas; i++) {
    for (let j = 0; j < columnas; j++) {
      matrizTraspuesta[j][i] = matriz[i][j];
    }
  }
  console.log('Matriz original:');
  console.log(matriz);
  return matrizTraspuesta;
}

var matriz = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
];

const resultado = matrizTraspuesta(matriz);
console.log('Matriz traspuesta:');
console.log(resultado);