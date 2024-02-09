import React, { Component } from 'react';

class Galeria extends Component {
  constructor() {
    super();
    this.state = {
      currentIndex: 0,
    };
  }

  handleClick = (index) => {
    this.props.onAbrirModal(this.props.imagenes[index]);
  }

  handlePrevClick = () => {
    const { currentIndex } = this.state;
    if (currentIndex > 0) {
      this.setState({ currentIndex: currentIndex - 1 });
    }
  }

  handleNextClick = () => {
    const { currentIndex } = this.state;
    const { imagenes } = this.props;
    if (currentIndex < imagenes.length - 5) {
      this.setState({ currentIndex: currentIndex + 1 });
    }
  }

  render() {
    const { currentIndex } = this.state;
    const { imagenes } = this.props;
    const visibleImages = imagenes.slice(currentIndex, currentIndex + 5);

    return (
      <div className="galeria">
        <button className="flecha-izquierda" onClick={this.handlePrevClick}>&#8592;</button>
        {visibleImages.map((imagen, index) => (
          <div key={imagen.id} className="imagen">
            <img
              src={imagen.webformatURL}
              alt={imagen.tags}
              onClick={() => this.handleClick(currentIndex + index)}
            />
          </div>
        ))}
        <button className="flecha-derecha" onClick={this.handleNextClick}>&#8594;</button>
      </div>
    );
  }
}

export default Galeria;
