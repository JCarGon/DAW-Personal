import React, { Component } from 'react';

class Buscador extends Component {
  constructor() {
    super();
    this.state = {
      busqueda: '',
    };
  }

  handleChange = (e) => {
    this.setState({ busqueda: e.target.value });
  }

  handleSubmit = (e) => {
    e.preventDefault();
    this.props.onBuscar(this.state.busqueda);
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <input
          type="text"
          placeholder="Buscar imágenes"
          value={this.state.busqueda}
          onChange={this.handleChange}
        />
        <button type="submit">Buscar</button>
      </form>
    );
  }
}

export default Buscador;
