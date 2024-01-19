import './Contador.css';
import React, { useState } from 'react';

function Contador() {
  const [contador, setContador] = useState(0);

  const incrementar = () => {
    setContador(contador + 1);
  };

  return (
    <div className="contador-container">
      <h2>Contador: {contador}</h2>
      <button className="contador-boton" onClick={incrementar}>
        Incrementar
      </button>
    </div>
  );
}

export default Contador;