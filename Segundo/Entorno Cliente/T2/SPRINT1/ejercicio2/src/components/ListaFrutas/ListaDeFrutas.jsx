import React from 'react';

function ListaDeFrutas({ frutas }) {
  return (
    <ul>
      {frutas.map((fruta) => (
        <li>
          {fruta.nombre}
          &nbsp;
          {fruta.emoji}
        </li>
      ))}
    </ul>
  )
}

export default ListaDeFrutas;
