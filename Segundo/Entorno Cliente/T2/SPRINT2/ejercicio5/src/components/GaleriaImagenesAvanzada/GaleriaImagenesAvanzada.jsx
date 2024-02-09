import React, { Component } from 'react';
import './estilos.css';
import Buscador from '../Buscador/Buscador';
import Galeria from '../Galeria/Galeria';
import Modal from '../Modal/Modal';

class GaleriaImagenesAvanzada extends Component {
  constructor() {
    super();
    this.state = {
      imagenes: [],
      imagenSeleccionada: null,
      paginaActual: 1,
      busqueda: '',
    };
  }

  componentDidMount() {
    this.cargarImagenes();
  }

  cargarImagenes = () => {
    const { paginaActual, busqueda } = this.state;
    const API_KEY = '42174887-e553660c97ee3961a01e84c44';
    const PER_PAGE = 12;
    const URL = `https://pixabay.com/api/?key=${API_KEY}&q=${busqueda}&per_page=${PER_PAGE}&page=${paginaActual}`;

    fetch(URL)
      .then((response) => response.json())
      .then((data) => {
        this.setState((prevState) => ({
          imagenes: [...prevState.imagenes, ...data.hits],
          paginaActual: prevState.paginaActual + 1,
        }));
      })
      .catch((error) => console.error(error));
  }

  handleBuscar = (busqueda) => {
    this.setState({ busqueda, imagenes: [], paginaActual: 1 }, () => {
      this.cargarImagenes();
    });
  }

  abrirModal = (imagen) => {
    this.setState({ imagenSeleccionada: imagen });
  }

  cerrarModal = () => {
    this.setState({ imagenSeleccionada: null });
  }

  render() {
    const { imagenes, imagenSeleccionada } = this.state;
  
    return (
      <div className="galeria-imagenes-avanzada">
        <Buscador onBuscar={this.handleBuscar} />
        <Galeria imagenes={imagenes} onAbrirModal={this.abrirModal} />
        {imagenSeleccionada && (
          <Modal imagen={imagenSeleccionada} onClose={this.cerrarModal} />
        )}
      </div>
    );
  }
}

export default GaleriaImagenesAvanzada;
