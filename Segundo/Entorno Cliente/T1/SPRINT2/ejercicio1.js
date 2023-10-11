const botonCambioColor = document.getElementById('cambioColor');

function cambiarColor(){
    const colorR = Math.floor(Math.random() * 256);
    const colorG = Math.floor(Math.random() * 256);
    const colorB = Math.floor(Math.random() * 256);

    const colorAleatorio = `rgb(${colorR}, ${colorG}, ${colorB})`;

    document.body.style.backgroundColor = colorAleatorio;
}

botonCambioColor.addEventListener('click', cambiarColor);