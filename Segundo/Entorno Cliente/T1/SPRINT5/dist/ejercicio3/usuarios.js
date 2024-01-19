"use strict";
function obtenerDescripcionUsuarios(usuarios) {
    let descripcion = "";
    usuarios.forEach((usuario, index) => {
        descripcion += `Hola, soy el usuario ${usuario.nombre}, tengo ${usuario.edad} años y mi correo electrónico es ${usuario.correo}\n`;
    });
    return descripcion;
}
const usuarios = [
    { nombre: "Juan", edad: 25, correo: "juan@example.com" },
    { nombre: "María", edad: 30, correo: "maria@example.com" },
    { nombre: "Carlos", edad: 22, correo: "carlos@example.com" },
    { nombre: "Ana", edad: 28, correo: "ana@example.com" },
    { nombre: "Pedro", edad: 35, correo: "pedro@example.com" },
];
console.log(obtenerDescripcionUsuarios(usuarios));
