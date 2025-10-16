import React from 'react';
import './BotaoGrande.css';

interface BotaoGrandeProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  children: React.ReactNode; // Aceita qualquer conteúdo como filho (texto ou elementos)
}

const BotaoGrande: React.FC<BotaoGrandeProps> = ({ children, ...props }) => {
  return (
    <button className="botao-grande" {...props}>
      {children}
    </button>
  );
};

export default BotaoGrande;
