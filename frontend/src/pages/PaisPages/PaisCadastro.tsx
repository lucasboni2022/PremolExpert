import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { PaisComunicaApi } from '../../services/PaisServices/PaisComunicaApi';
import BotaoCadastro from '../../components/BotaoPadrao/BotaoPadrao'; 

interface pais {
  paisId?: number;
  paisNom: string;
  paisSigla: string;
  paisIncPor: number;
  paisIncEm: string;
  paisAltPor?: number;
  paisAltEm?: string;
}

const PaisCadastro: React.FC = () => {
  const [pais, setpais] = useState<pais>({
    paisNom: '',
    paisSigla: '',
    paisIncPor: 1, // Id do usuário pode ser dinamicamente preenchido
    paisIncEm: new Date().toISOString(),
  });
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      PaisComunicaApi.getById(Number(id))
        .then((response) => setpais(response.data))
        .catch((error) => console.error('Erro ao buscar país', error));
    }
  }, [id]);

  const capturaAlteracao = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setpais((prevpais) => ({
      ...prevpais,
      [name]: value,
    }));
  };

  const enviar = (e: React.FormEvent) => {
    e.preventDefault();

    if (id) {
      // Atualiza o país
      PaisComunicaApi.update(Number(id), pais)
        .then(() => navigate('/')) // Navega para a página principal após sucesso
        .catch((error) => {
          if (error.response) {
            const errorMessage = error.response.data?.message || 'Erro desconhecido.';
            alert(`Erro ao atualizar país: ${errorMessage}`);
          } else if (error.request) {
            alert('Erro ao conectar com o servidor. Verifique sua conexão.');
          } else {
            alert('Erro inesperado. Por favor, tente novamente.');
          }
        });
    } else {
      // Cria o novo país
      PaisComunicaApi.create(pais)
        .then(() => navigate('/')) // Navega para a página principal após sucesso
        .catch((error) => {
          if (error.response) {
            const status = error.response.status;
            const message = error.response.data?.Message || 'Erro desconhecido.';

            if (status === 400) {
              alert(`Erro de validação: ${message}. Por favor, verifique os dados.`);
            } else if (status === 500) {
              alert(`Erro inesperado no servidor: ${message}. Tente novamente mais tarde.`);
            } else {
              alert(`Erro: ${message}`);
            }
          } else if (error.request) {
            alert('Erro ao conectar com o servidor. Verifique sua conexão.');
          } else {
            alert('Erro desconhecido. Por favor, tente novamente.');
          }
        });
    }
  };

  const voltar = (e: React.MouseEvent) => {
    e.preventDefault(); // Impede o comportamento do botão de submit, garantindo que só volte
    navigate(-1); // Navega para a página anterior
  };

  return (
    <div>
      <table>
        <tr><td><h1>{id ? 'Cadastro de País' : 'Cadastro de País'}</h1></td></tr>
        <tr><td>
      <form onSubmit={enviar}>
        <table>
          <tr><td>
            <div>
            <table>
              <tr><td><label>Nome:</label></td>
                <td><input
                    type="text"
                    name="paisNom"
                    value={pais.paisNom}
                    onChange={capturaAlteracao}
                    required
                  />
                </td>
              </tr>
              
              <tr><td><label>Sigla</label></td>
                <td><input
                    type="text"
                    name="paisSigla"
                    value={pais.paisSigla}
                    maxLength={4} 
                    onChange={capturaAlteracao}
                    required
                  />
                </td>
              </tr>
            </table>
            </div>
          </td></tr>
          <tr>
            <td className="centro-container">  
                {/* Botão Voltar */}
                <BotaoCadastro type="button" onClick={voltar}>Voltar</BotaoCadastro>

                <BotaoCadastro type="submit">Salvar</BotaoCadastro>
            </td>
          </tr>
        </table>
      </form>
    </td></tr>
      </table>
    </div>
  );
};

export default PaisCadastro;
