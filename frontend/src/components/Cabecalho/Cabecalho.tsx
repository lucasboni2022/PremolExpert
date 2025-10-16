import React from 'react';
import './Cabecalho.css';



const Cabecalho: React.FC = () => {
  return (
    <div className="cabecalho">
      <img src={'./src/imagens/cabecalho.jpeg'} alt="Imagem do Cabeçalho da PreMolExpert" className="cabecalho-imagem" />
      <h1 className="cabecalho-titulo">PreMolExpert</h1>
    </div>
  );
};

export default Cabecalho;
