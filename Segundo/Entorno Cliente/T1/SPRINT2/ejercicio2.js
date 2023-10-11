const anchoInput = document.getElementById('ancho');
const altoInput = document.getElementById('alto');
const areaText = document.getElementById('area');

anchoInput.addEventListener('change', calcularArea);
altoInput.addEventListener('change', calcularArea);

function calcularArea() {
    const ancho = parseFloat(anchoInput.value) || 0;
    const alto = parseFloat(altoInput.value) || 0;
    const area = ancho * alto;
    areaText.textContent = area;
};