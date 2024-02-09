import React, { Component } from 'react';
import './estilos.css';

class AppTareas extends Component {
  constructor() {
    super();
    this.state = {
      tareas: [],
      nuevaTarea: '',
      filtro: 'todas',
    };
  }

  componentDidMount() {
    const tareasGuardadas = localStorage.getItem('tareas');
    if (tareasGuardadas) {
      this.setState({ tareas: JSON.parse(tareasGuardadas) });
    }
  }

  componentDidUpdate() {
    localStorage.setItem('tareas', JSON.stringify(this.state.tareas));
  }

  agregarTarea = () => {
    const { nuevaTarea } = this.state;
    if (nuevaTarea.trim() === '') {
      alert('No se puede crear una tarea sin nombre');
      return;
    }

    const nuevaListaTareas = [...this.state.tareas, { nombre: nuevaTarea, completada: false }];
    this.setState({ tareas: nuevaListaTareas, nuevaTarea: '' });
  }

  marcarCompletada = (index) => {
    const nuevasTareas = [...this.state.tareas];
    nuevasTareas[index].completada = !nuevasTareas[index].completada;
    this.setState({ tareas: nuevasTareas });
  }

  eliminarTarea = (index) => {
    const nuevasTareas = [...this.state.tareas];
    nuevasTareas.splice(index, 1);
    this.setState({ tareas: nuevasTareas });
  }

  cambiarFiltro = (filtro) => {
    this.setState({ filtro });
  }

  render() {
    const { tareas, nuevaTarea, filtro } = this.state;

    let tareasFiltradas = [];
    if (filtro === 'todas') {
      tareasFiltradas = tareas;
    } else if (filtro === 'completadas') {
      tareasFiltradas = tareas.filter((tarea) => tarea.completada);
    } else if (filtro === 'pendientes') {
      tareasFiltradas = tareas.filter((tarea) => !tarea.completada);
    }

    return (
      <div className="app-tareas">
        <h2>Listado de tareas</h2>
        <div className="formulario-tarea">
          <input
            type="text"
            placeholder="Nueva tarea"
            value={nuevaTarea}
            onChange={(e) => this.setState({ nuevaTarea: e.target.value })}
          />
          <button onClick={this.agregarTarea}>Crear Tarea</button>
        </div>
        <div className="filtros">
          <button onClick={() => this.cambiarFiltro('todas')}>Todas</button>
          <button onClick={() => this.cambiarFiltro('completadas')}>Completadas</button>
          <button onClick={() => this.cambiarFiltro('pendientes')}>Pendientes</button>
        </div>
        <ul className="lista-tareas">
          {tareasFiltradas.map((tarea, index) => (
            <li key={index}>
              <span
                className={tarea.completada ? 'completada' : ''}
                onClick={() => this.marcarCompletada(index)}
              >
                {tarea.nombre}
              </span>
              <input
                type="checkbox"
                checked={tarea.completada}
                onChange={() => this.marcarCompletada(index)}
              />
              <button onClick={() => this.eliminarTarea(index)}>Eliminar Tarea</button>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default AppTareas;
