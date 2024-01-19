"use strict";
let tareas = [];
let tareasImportantes = [];
function actualizarListas() {
    mostrarTareas();
    mostrarImportantes();
}
function agregarTarea() {
    const inputTarea = document.getElementById('taskInput');
    const textoTarea = inputTarea.value.trim();
    if (textoTarea !== '') {
        const nuevaTarea = { texto: textoTarea, importante: false };
        tareas.push(nuevaTarea);
        inputTarea.value = '';
        actualizarListas();
    }
}
function mostrarTareas() {
    const tareasContainer = document.getElementById('tareas');
    tareasContainer.innerHTML = '';
    tareas.forEach((tarea, index) => {
        const tareaElement = document.createElement('div');
        tareaElement.classList.add('task');
        tareaElement.innerHTML = `
      <span>${tarea.texto}</span>
      <div class="taskOptions">
        <button onclick="eliminarTarea(${index})">Eliminar</button>
        <button onclick="marcarImportante(${index})">Añadir a importante</button>
      </div>
    `;
        tareasContainer.appendChild(tareaElement);
    });
}
function mostrarImportantes() {
    const importantesContainer = document.getElementById('importantes');
    importantesContainer.innerHTML = '';
    tareasImportantes.forEach(tarea => {
        const tareaElement = document.createElement('div');
        tareaElement.classList.add('task', 'important');
        tareaElement.innerHTML = `
      <span>${tarea.texto}</span>
      <div class="taskOptions">
        <button onclick="quitarImportante('${tarea.texto}')">Quitar de importantes</button>
      </div>
    `;
        importantesContainer.appendChild(tareaElement);
    });
}
function eliminarTarea(index) {
    tareas.splice(index, 1);
    tareasImportantes = tareasImportantes.filter(t => t.texto !== tareas[index].texto);
    actualizarListas();
}
function marcarImportante(index) {
    if (!tareas[index].importante) {
        tareas[index].importante = true;
        tareasImportantes.push(tareas[index]);
        actualizarListas();
    }
}
function quitarImportante(texto) {
    tareasImportantes = tareasImportantes.filter(t => t.texto !== texto);
    actualizarListas();
}
actualizarListas();
