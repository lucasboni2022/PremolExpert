import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { PaisComunicaApi } from '../../services/PaisServices/PaisComunicaApi';
import BotaoLista from '../../components/BotaoLista/BotaoLista'; 
import BotaoPadrao from '../../components/BotaoPadrao/BotaoPadrao'; 

interface Pais {
  paisId: number;
  paisNom: string;
  paisSigla: string;
}

const PaisLista: React.FC = () => {
  const [paises, setPaises] = useState<Pais[]>([]);

  useEffect(() => {
    PaisComunicaApi.getAll()
      .then((response) => setPaises(response.data))
      .catch((error) => console.error('Erro ao buscar países', error));
  }, []);


  const excluir = (id: number) => {
    if (window.confirm('Tem certeza que deseja excluir?')) {
      PaisComunicaApi.delete(id)
        .then(() => {
          setPaises(paises.filter((pais) => pais.paisId !== id));
          alert('País excluído com sucesso.');
        })
        .catch((error) => {
          if (error.response) {
            // Captura a mensagem do backend
            const errorMessage = error.response.data?.message || 'Erro desconhecido.';
            alert(`Erro ao excluir país: ${errorMessage}`);
          } else if (error.request) {
            alert('Erro ao conectar com o servidor. Verifique sua conexão.');
          } else {
            console.error('Erro inesperado:', error);
            alert('Erro inesperado. Por favor, tente novamente.');
          }
        });
    }
  };

  return (
    <div>
      <h1>Lista de Países</h1>
     <BotaoPadrao><Link to="/criar" className="ajuste-link-botao">Inserir</Link></BotaoPadrao>
      <table>
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Sigla</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {paises.map((pais) => (
            <tr key={pais.paisId}>
              <td>{pais.paisId}</td>
              <td>{pais.paisNom}</td>
              <td>{pais.paisSigla}</td>
              <td>
    
              <BotaoLista><Link to={`/editar/${pais.paisId}`} className="ajuste-link-botao">Editar</Link></BotaoLista>
                {' | '}
                <BotaoLista onClick={() => excluir(pais.paisId)} >
                Excluir
                </BotaoLista>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PaisLista;
