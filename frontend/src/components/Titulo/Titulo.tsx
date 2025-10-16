import React from 'react';
import './Titulo.css';

const Titulo: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  return (
    <div className="titulo">
      <h1 className="titulo">{children}</h1>
    </div>
  );
};

export default Titulo;
