import React, { Component } from 'react';
import './estilos.css';

class Cronometro extends Component {
  constructor() {
    super();
    this.state = {
      tiempo: 0,
      cronometroActivo: false,
    };
    this.intervalo = null;
  }

  formatearTiempo = (tiempo) => {
    const segundos = Math.floor(tiempo / 1000);
    const minutos = Math.floor(segundos / 60);
  
    const formatoMinutos = (minutos % 60).toString().padStart(2, '0');
    const formatoSegundos = (segundos % 60).toString().padStart(2, '0');
    const formatoMilisegundos = (tiempo % 1000 / 10).toString().padStart(2, '0');
  
    return `${formatoMinutos}:${formatoSegundos}:${formatoMilisegundos}`;
  }  

  iniciarCronometro = () => {
    if (!this.state.cronometroActivo) {
      this.setState({ cronometroActivo: true });
      this.intervalo = setInterval(() => {
        this.setState((prevState) => ({ tiempo: prevState.tiempo + 10 }));
      }, 10);
    }
  }

  pausarCronometro = () => {
    if (this.state.cronometroActivo) {
      clearInterval(this.intervalo);
      this.setState({ cronometroActivo: false });
    }
  }

  reiniciarCronometro = () => {
    if (this.state.tiempo > 0) {
      clearInterval(this.intervalo);
      this.setState({ tiempo: 0, cronometroActivo: false });
    }
  }

  componentWillUnmount() {
    clearInterval(this.intervalo);
  }

  render() {
    const { tiempo, cronometroActivo } = this.state;

    return (
      <div className="cronometro-container">
        <div className="tiempo">
          {this.formatearTiempo(tiempo)}
        </div>
        <div className="botones">
          <button
            className="boton"
            onClick={this.iniciarCronometro}
            disabled={cronometroActivo}
          >
            Play
          </button>
          <button
            className="boton"
            onClick={this.pausarCronometro}
            disabled={!cronometroActivo || tiempo === 0}
          >
            Pause
          </button>
          <button
            className="boton"
            onClick={this.reiniciarCronometro}
            disabled={cronometroActivo || tiempo === 0}
          >
            Restart
          </button>
        </div>
      </div>
    );
  }
}

export default Cronometro;
