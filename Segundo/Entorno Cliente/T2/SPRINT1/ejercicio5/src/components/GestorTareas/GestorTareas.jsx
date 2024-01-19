import React, { useState, useEffect } from 'react';
import './GestorTareas.css';

function GestorTareas() {
    const [tareas, setTareas] = useState(JSON.parse(localStorage.getItem('tareas')) || []);
    const [nuevaTarea, setNuevaTarea] = useState('');
    const [categoria, setCategoria] = useState('personal');
    const [filtro, setFiltro] = useState('todas');
    const [editando, setEditando] = useState(null);
    const [nuevoNombre, setNuevoNombre] = useState('');

    useEffect(() => {
        localStorage.setItem('tareas', JSON.stringify(tareas));
    }, [tareas]);

    const agregarTarea = () => {
        if (nuevaTarea) {
            setTareas([...tareas, { nombre: nuevaTarea, completada: false, categoria }]);
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

    const empezarEdicion = (index, nombre) => {
        setEditando(index);
        setNuevoNombre(nombre);
    };

    const aplicarEdicion = index => {
        editarTarea(index, nuevoNombre);
        setEditando(null);
        setNuevoNombre('');
    };

    const editarTarea = (index, nuevoNombre) => {
        const nuevasTareas = [...tareas];
        nuevasTareas[index].nombre = nuevoNombre;
        setTareas(nuevasTareas);
    };

    const tareasFiltradas = tareas.filter(tarea => {
        if (filtro === 'todas') return true;
        if (filtro === 'completadas') return tarea.completada;
        return tarea.categoria === filtro;
    });

    return (
        <div className="gestor-tareas">
            <h1>GestorTareas</h1>
            <div className="crear-tarea">
                <label htmlFor="nuevaTarea">Introducir nombre para tarea</label>
                <input
                    type="text"
                    id="nuevaTarea"
                    value={nuevaTarea}
                    onChange={(e) => setNuevaTarea(e.target.value)}
                />
                <select value={categoria} onChange={(e) => setCategoria(e.target.value)}>
                    <option value="personal">Personal</option>
                    <option value="trabajo">Trabajo</option>
                    <option value="estudio">Estudio</option>
                </select>
                <button className="crear" onClick={agregarTarea}>Crear tarea</button>
            </div>
            <div className="filtrar-tareas">
                <select value={filtro} onChange={(e) => setFiltro(e.target.value)}>
                    <option value="todas">Todas</option>
                    <option value="personal">Personal</option>
                    <option value="trabajo">Trabajo</option>
                    <option value="estudio">Estudio</option>
                    <option value="completadas">Completadas</option>
                </select>
            </div>
            <ul>
                {tareasFiltradas.map((tarea, index) => (
                    <li key={index} className={tarea.completada ? 'completada' : ''}>
                        {editando === index ? (
                            <input
                                type="text"
                                value={nuevoNombre}
                                onChange={(e) => setNuevoNombre(e.target.value)}
                                onBlur={() => aplicarEdicion(index)}
                            />
                        ) : (
                            <span>{tarea.nombre}</span>
                        )}
                        Categoría: {tarea.categoria}
                        <input
                            type="checkbox"
                            checked={tarea.completada}
                            onChange={() => toggleCompletada(index)}
                        />
                        {editando === index ? (
                            <button className="editar" onClick={() => aplicarEdicion(index)}>Aplicar</button>
                        ) : (
                            <button className="editar" onClick={() => empezarEdicion(index, tarea.nombre)}>Editar tarea</button>
                        )}
                        <button className="eliminar" onClick={() => eliminarTarea(index)}>Eliminar tarea</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default GestorTareas;
