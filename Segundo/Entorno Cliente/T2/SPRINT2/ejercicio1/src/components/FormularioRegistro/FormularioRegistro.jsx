/* eslint-disable no-unused-vars */
import React, { Component } from 'react';
import './estilos.css';

class FormularioRegistro extends Component {
  constructor() {
    super();
    this.state = {
      nombreUsuario: '',
      correoElectronico: '',
      contrasena: '',
      errores: {
        nombreUsuario: '',
        correoElectronico: '',
        contrasena: ''
      }
    };
  }

  handleInputChange = (event) => {
    const { name, value } = event.target;
    this.setState({ [name]: value }, () => {
      this.validarCampo(name, value);
    });
  }

  validarCampo = (campo, valor) => {
    const { errores } = this.state;
    switch (campo) {
      case 'nombreUsuario':
        if (!valor) {
          errores.nombreUsuario = 'Este campo no puede estar vacío';
        } else if (!/^[a-zA-Z0-9]+$/.test(valor)) {
          errores.nombreUsuario = 'Solo caracteres válidos (a-z/A-Z/0-9)';
        } else {
          errores.nombreUsuario = '';
        }
        break;
      case 'correoElectronico':
        if (!valor) {
          errores.correoElectronico = 'Este campo no puede estar vacío';
        } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(valor)) {
          errores.correoElectronico = 'Formato de correo electrónico no válido';
        } else {
          errores.correoElectronico = '';
        }
        break;
      case 'contrasena':
        if (!valor) {
          errores.contrasena = 'Este campo no puede estar vacío';
        } else if (!/^[a-zA-Z0-9]+$/.test(valor)) {
          errores.contrasena = 'Solo caracteres válidos (a-z/A-Z/0-9)';
        } else {
          errores.contrasena = '';
        }
        break;
      default:
        break;
    }
    this.setState({ errores });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    const { nombreUsuario, correoElectronico, contrasena, errores } = this.state;
    
    if (!nombreUsuario || !correoElectronico || !contrasena) {
      alert('No se deben dejar campos vacíos');
      return;
    } else if (!errores.nombreUsuario && !errores.correoElectronico && !errores.contrasena) {
      alert('Bienvenido al sistema');
    }
  }

  render() {
    const { nombreUsuario, correoElectronico, contrasena, errores } = this.state;

    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <div>
            <h2>Formulario de registro</h2>
            <label>Nombre de Usuario:</label>
            <input
              type="text"
              name="nombreUsuario"
              value={nombreUsuario}
              onChange={this.handleInputChange}
              className={errores.nombreUsuario ? 'error' : ''}
            />
            {errores.nombreUsuario && <span className="error-message">{errores.nombreUsuario}</span>}
          </div>
          <div>
            <label>Correo Electrónico:</label>
            <input
              type="text"
              name="correoElectronico"
              value={correoElectronico}
              onChange={this.handleInputChange}
              className={errores.correoElectronico ? 'error' : ''}
            />
            {errores.correoElectronico && <span className="error-message">{errores.correoElectronico}</span>}
          </div>
          <div>
            <label>Contraseña:</label>
            <input
              type="password"
              name="contrasena"
              value={contrasena}
              onChange={this.handleInputChange}
              className={errores.contrasena ? 'error' : ''}
            />
            {errores.contrasena && <span className="error-message">{errores.contrasena}</span>}
          </div>
          <button type="submit">Registrarse</button>
        </form>
      </div>
    );
  }
}

export default FormularioRegistro;
