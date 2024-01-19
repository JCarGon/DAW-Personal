interface Tarea {
  texto: string;
  importante: boolean;
}

let tareas: Tarea[] = [];
let tareasImportantes: Tarea[] = [];

function actualizarListas() {
  mostrarTareas();
  mostrarImportantes();
}

function agregarTarea() {
  const inputTarea = document.getElementById('taskInput') as HTMLInputElement;
  const textoTarea = inputTarea.value.trim();

  if (textoTarea !== '') {
    const nuevaTarea: Tarea = { texto: textoTarea, importante: false };
    tareas.push(nuevaTarea);
    inputTarea.value = '';
    actualizarListas();
  }
}

function mostrarTareas() {
  const tareasContainer = document.getElementById('tareas') as HTMLDivElement;
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
  const importantesContainer = document.getElementById('importantes') as HTMLDivElement;
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

function eliminarTarea(index: number) {
  tareas.splice(index, 1);
  tareasImportantes = tareasImportantes.filter(t => t.texto !== tareas[index].texto);
  actualizarListas();
}

function marcarImportante(index: number) {
  if (!tareas[index].importante) {
    tareas[index].importante = true;
    tareasImportantes.push(tareas[index]);
    actualizarListas();
  }
}


function quitarImportante(texto: string) {
  tareasImportantes = tareasImportantes.filter(t => t.texto !== texto);
  actualizarListas();
}

actualizarListas();
