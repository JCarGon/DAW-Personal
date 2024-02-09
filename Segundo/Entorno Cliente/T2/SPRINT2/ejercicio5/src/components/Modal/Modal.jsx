import React from 'react';

const Modal = ({ imagen, onClose }) => {
  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content">
        <img src={imagen.largeImageURL} alt={imagen.tags} />
        <p>{imagen.tags}</p>
      </div>
    </div>
  );
};

export default Modal;
