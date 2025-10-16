import React from 'react';


interface BotaoPadraoProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  children: React.ReactNode; // Aceita qualquer conteúdo como filho (texto ou elementos)
}

const UsuarioAuditoria: React.FC<BotaoPadraoProps> = ({ children, ...props }) => {
  return (
    <button className="usuario-auditoria" {...props}>
      {children}
    </button>
  );
};

export default UsuarioAuditoria;
