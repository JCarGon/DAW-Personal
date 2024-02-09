import React, { Component } from 'react';
import './estilos.css';

class GaleriaImagenes extends Component {
  constructor() {
    super();
    this.state = {
      imagenes: [],
      imagenSeleccionada: null,
      imagenIndex: 0,
    };
  }

  componentDidMount() {
    const API_KEY = '42174887-e553660c97ee3961a01e84c44';
    const API_URL = `https://pixabay.com/api/?key=${API_KEY}&q=nature&image_type=photo&per_page=100`;

    fetch(API_URL)
      .then((response) => response.json())
      .then((data) => {
        this.setState({ imagenes: data.hits });
      })
      .catch((error) => console.error(error));
  }

  abrirModal = (imagenIndex) => {
    this.setState({ imagenSeleccionada: this.state.imagenes[imagenIndex], imagenIndex });
  }

  cerrarModal = () => {
    this.setState({ imagenSeleccionada: null });
  }

  irImagenSiguiente = () => {
    const { imagenIndex, imagenes } = this.state;
    if (imagenIndex < imagenes.length - 1) {
      this.setState({ imagenSeleccionada: imagenes[imagenIndex + 1], imagenIndex: imagenIndex + 1 });
    }
  }

  irImagenAnterior = () => {
    const { imagenIndex, imagenes } = this.state;
    if (imagenIndex > 0) {
      this.setState({ imagenSeleccionada: imagenes[imagenIndex - 1], imagenIndex: imagenIndex - 1 });
    }
  }

  render() {
    const { imagenes, imagenSeleccionada } = this.state;

    return (
      <div className="galeria-imagenes">
        <div className="imagenes-grid">
          {imagenes.map((imagen, index) => (
            <img
              key={index}
              src={imagen.webformatURL}
              alt={`Imagen ${index}`}
              onClick={() => this.abrirModal(index)}
            />
          ))}
        </div>
        {imagenSeleccionada && (
          <div className="modal">
            <span className="cerrar-modal" onClick={this.cerrarModal}>&times;</span>
            <img src={imagenSeleccionada.webformatURL} alt="Imagen seleccionada" />
            <span className="anterior" onClick={this.irImagenAnterior}>&lt;</span>
            <span className="siguiente" onClick={this.irImagenSiguiente}>&gt;</span>
          </div>
        )}
      </div>
    );
  }
}

export default GaleriaImagenes;
