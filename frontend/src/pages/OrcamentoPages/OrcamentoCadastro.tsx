import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import OrcamentoComunicaApi from '../../services/OrcamentoServices/OrcamentoComunicaApi';
import clienteComunicaApi from '../../services/ClienteServices/ClienteComunicaApi';
import BotaoPadrao from '../../components/BotaoPadrao/BotaoPadrao';
import Cabecalho from '../../components/Cabecalho/Cabecalho';
import ImagemProcurar from "../../imagens/procurar.gif";


interface Pessoa{
  pesId: number;
  pesNom: string;
} 

interface Cliente{
  cliId:number;
  pessoa:Pessoa;
}


interface Orcamento {
  orcId?: number;
  orcNumProEmp: string;
  cliente:Cliente;
  orcNomObr: string;
  orcDatSol?: Date; // formato 'YYYY-MM-DD'
  orcDtaPrevEnt?: string; // formato 'YYYY-MM-DD'
  orcDimTam: string;
  usuId: number;
  orcEtap: number;
  orcDatEntPro: string; // formato 'YYYY-MM-DD'
  orcQtdDiaResEnt: number;
  orcValPed: number;
  orcSalNeg: number;
  orcPesOrc: number;
  orcPesExe: number;
  orcSalPes: number;
  orcIncPor: number;
  orcIncEm: string; // formato 'YYYY-MM-DDTHH:MM:SS'
  orcAltPor?: number;
  orcAltEm?: string; // formato 'YYYY-MM-DDTHH:MM:SS'
  empId: number;
  orcPaiOrcPedId?: number;
  descricaoEtapaProcesso:string;
  
}

function OrcamentoCadastro() {

  const [Orcamento, setOrcamento] = useState<Orcamento>({
    orcNumProEmp: '',
    cliente:{
      cliId:0,
      pessoa:{
        pesId:0,
        pesNom:'',
      }
    },
    orcNomObr: '',
    orcDatSol: new Date(),
    orcDtaPrevEnt: '',
    orcDimTam: '',
    usuId: 1,
    orcEtap: 1,
    orcDatEntPro: new Date().toISOString().split('T')[0],
    orcQtdDiaResEnt: 0,
    orcValPed: 0.00,
    orcSalNeg: 0.00,
    orcPesOrc: 0.00,
    orcPesExe: 0.00,
    orcSalPes: 0.00,
    orcIncPor: 1,
    orcIncEm: new Date().toISOString(),
    orcAltEm: new Date().toISOString(),
    empId: 1,
    descricaoEtapaProcesso:'',
  });

  const location = useLocation();

  const navigate = useNavigate();

  const queryParams = new URLSearchParams(location.search);

  const paramId = queryParams.get('paramId');

  const paramModo = queryParams.get('paramModo');

  const isDesabilita = paramModo === 'DSP' ? true : false;



  //Inicio: Carrega dados do banco
  useEffect(() => {
    if (paramModo !== 'DSP') {
      OrcamentoComunicaApi.getById(Number(paramId))
        .then((response) => setOrcamento(response.data))
        .catch((error) => console.error('Erro ao buscar orçamento de pedido', error));

    }
  }, [paramModo]);
  //Fim


  const capturaAlteracao = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setOrcamento((prevOrcamento) => ({
      ...prevOrcamento,
      [name]: value,
    }));
  };


  const enviar = (e: React.FormEvent) => {
    e.preventDefault();
    if (paramId) {
      OrcamentoComunicaApi.update(Number(paramId), Orcamento)
        .then(() => navigate(`/orcamentoprodutocadastro?paramId=${paramId}&paramModo=${paramModo}&paramOrcNumProEmp=${Orcamento.orcNumProEmp!}&paramDescricaoEtapaProcesso=${Orcamento.descricaoEtapaProcesso}`))
        .catch((error) => {
          if (error.response) {
            const errorMessage = error.response.data?.message || 'Erro desconhecido.';
            alert(`Erro ao atualizar orçamento de pedido: ${errorMessage}`);
          } else if (error.request) {
            alert('Erro ao conectar com o servidor. Verifique sua conexão.');
          } else {
            alert('Erro inesperado. Por favor, tente novamente.');
          }
        });
    } else {
      OrcamentoComunicaApi.create(Orcamento)
        .then(() => navigate(`/Orcamentoprodutocadastro?paramId=${paramId}&paramModo=${paramModo}`))
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

  const voltar = () => {
    navigate('/orcamentolista');
  };

  const abrirPopupcliente = () => {
    window.open(
      `/clienteconsulta`,
      "popupcliente",
      "width=600,height=400"
    );

    // Listener para capturar a resposta do popup
    window.addEventListener("message", (event) => {
      if (event.origin !== window.location.origin) return;

      const { cliId, pesNom } = event.data;
      if (cliId && pesNom) {
        setOrcamento((prev) => ({
          ...prev,
          cliId,
          pesNom,
        }));
      }
    });
  };

  //Ao sair do campo cliId, carregar a descrição...
  //inicio
  const buscarcliente = async (id: number) => {
    try {
      const response = await clienteComunicaApi.getById(id);
      if (response.data && response.data.pesNom) {
        setOrcamento((prev) => ({ ...prev, pesNom: response.data.pesNom }));
      }
    } catch (error) {
      setOrcamento((prev) => ({ ...prev, pesNom: 'cliente não existe' })); // Caso não encontre o nome
    }
  };

  const handleBlur = () => {
    const cliId = Orcamento.cliente.cliId;  // Pega o valor diretamente de Orcamento
    if (cliId) {
      buscarcliente(cliId);
    }
  };
  //fim

  return (
    <div>

      <Cabecalho />
      <table className="tabela-centralizada">
        <div>
          <span>Número do Processo: {Orcamento.orcNumProEmp} {'>'} Etapa: {Orcamento.descricaoEtapaProcesso}</span>
        </div>

        <div className="tabs">
          <div
            className="tab-ativa"
          >
            Obra
          </div>
          <div
            className="tab"
            onClick={() => navigate(`/orcamentoprodutocadastro?paramId=${paramId}&paramModo=${paramModo}&paramOrcNumProEmp=${Orcamento.orcNumProEmp!}&paramDescricaoEtapaProcesso=${Orcamento.descricaoEtapaProcesso}`)}

          >
            Produtos/Serviços
          </div>
          <div
            className="tab"
          >
            Engenharia
          </div>
          <div
            className="tab"
          >
            Fabricação
          </div>
          <div
            className="tab"
          >
            Tranporte
          </div>
          <div
            className="tab"
          >
            Montagem
          </div>
        </div>
        <div>
          <form onSubmit={enviar}>
            <table className="tabela-sem-borda">
              <tr>
                <td><label>Cód. Cliente:</label>
                  <input
                    type="number"
                    name="cliId"
                    value={Orcamento.cliente.cliId}
                    onChange={capturaAlteracao}
                    required
                    disabled={isDesabilita} // Desabilita os campos no modo 'DSP'
                    onBlur={handleBlur} // Chama ao sair do campo
                  />

                  <img
                    src={ImagemProcurar}
                    alt="Consultar cliente"
                    width="32"
                    height="32"
                    onClick={abrirPopupcliente}
                    style={{ cursor: "pointer" }}
                  />


                  <label>
                    {Orcamento.cliente.pessoa.pesNom}
                  </label>
                </td>
              </tr>

              <tr>
                <td><label>Nome da Obra:</label>
                  <input
                    type="text"
                    name="orcNomObr"
                    value={Orcamento.orcNomObr}
                    onChange={capturaAlteracao}
                    required
                    disabled={isDesabilita} // Desabilita os campos no modo 'DSP'
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label>Data Solicitação:</label>
                  <input
                    type="date"
                    name="orcDatSol"
                    value={String(Orcamento.orcDatSol)}
                    onChange={capturaAlteracao}
                    disabled={isDesabilita} // Desabilita os campos no modo 'DSP'
                  />
                </td>
              </tr>

              <tr>
                <td><label>Data Prevista de Entrega:</label>
                  <input
                    type="date"
                    name="orcDtaPrevEnt"
                    value={Orcamento.orcDtaPrevEnt}
                    onChange={capturaAlteracao}
                    disabled={isDesabilita} // Desabilita os campos no modo 'DSP'
                  />
                </td>
              </tr>

              <tr>
                <td className="centro-container">
                  {/* Botões de Voltar e Salvar */}
                  <BotaoPadrao type="button" onClick={voltar}>Voltar</BotaoPadrao>
                  <BotaoPadrao type="submit">Salvar</BotaoPadrao>
                </td>
              </tr>
            </table>
          </form>
        </div>
      </table>
    </div>

  );
};

export default OrcamentoCadastro; 
