"use strict";
function confirmarDatos() {
    const nombreInput = document.getElementById('nombreInput');
    const edadInput = document.getElementById('edadInput');
    if (nombreInput.value && edadInput.value) {
        const mensaje = `¡Hola! Mi nombre es ${nombreInput.value} y tengo ${edadInput.value} años.`;
        alert(mensaje);
    }
    else {
        alert('Por favor, completa todos los campos.');
    }
}
