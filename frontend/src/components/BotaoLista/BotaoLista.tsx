import React from 'react';
import './BotaoLista.css';

interface BotaoPadraoProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  children: React.ReactNode; // Aceita qualquer conteúdo como filho (texto ou elementos)
}

const BotaoPadrao: React.FC<BotaoPadraoProps> = ({ children, ...props }) => {
  return (
    <button className="botao-lista" {...props}>
      {children}
    </button>
  );
};

export default BotaoPadrao;
