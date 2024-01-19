import React, { useState } from 'react';
import './ToDoApp.css';

function ToDoApp() {
    const [tareas, setTareas] = useState([]);
    const [nuevaTarea, setNuevaTarea] = useState('');

    const agregarTarea = () => {
        if (nuevaTarea) {
            setTareas([...tareas, { nombre: nuevaTarea, completada: false }]);
            setNuevaTarea('');
        }
    };

    const toggleCompletada = index => {
        const nuevasTareas = [...tareas];
        nuevasTareas[index].completada = !nuevasTareas[index].completada;
        setTareas(nuevasTareas);
    };

    const eliminarTarea = index => {
        const nuevasTareas = tareas.filter((_, i) => i !== index);
        setTareas(nuevasTareas);
    };

    return (
        <div className="todo-app">
            <h1>ToDoApp</h1>
            <div className="crear-tarea">
                <label htmlFor="nuevaTarea">Introducir nombre para tarea:</label>
                <input
                    type="text"
                    id="nuevaTarea"
                    value={nuevaTarea}
                    onChange={(e) => setNuevaTarea(e.target.value)}
                />
                <button className="crear" onClick={agregarTarea}>Crear tarea</button>
            </div>
            <ul>
              {tareas.map((tarea, index) => (
                  <li key={index} className={tarea.completada ? 'completada' : ''}>
                      Nombre de tarea: {tarea.nombre}
                      <label className="label-completar">
                          <input
                              type="checkbox"
                              checked={tarea.completada}
                              onChange={() => toggleCompletada(index)}
                          />
                      </label>
                      <button className="eliminar" onClick={() => eliminarTarea(index)}>
                          Eliminar tarea
                      </button>
                  </li>
              ))}
            </ul>
        </div>
    );
}

export default ToDoApp;
