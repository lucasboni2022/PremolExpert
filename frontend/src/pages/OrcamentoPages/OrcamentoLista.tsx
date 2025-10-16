import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';  // Importar o hook useNavigate
import OrcamentoComunicaApi from '../../services/OrcamentoServices/OrcamentoComunicaApi';
import BotaoLista from '../../components/BotaoLista/BotaoLista';
import BotaoPadrao from '../../components/BotaoPadrao/BotaoPadrao';
import Cabecalho from '../../components/Cabecalho/Cabecalho';
import Titulo from '../../components/Titulo/Titulo';

interface Cliente {
  cliId: number;
  pesNom: string;
}

interface Orcamento {
  orcId: number;
  orcNumProEmp: number;
  cliente: Cliente;
  orcNomObr: string;
  orcDatSol: string;  // Data no formato 'YYYY-MM-DD'
  orcDtaPrevEnt: string; // Data no formato 'YYYY-MM-DD'
  orcDimTam: string;
  usuId: number;
}

function OrcamentoLista() {
  const [orcamentos, setOrcamentos] = useState<Orcamento[]>([]);
  const [filtroOrcNumProEmp, setFiltroOrcNumProEmp] = useState<number>(0); // Filtro OrcNumProEmp
  const [filtroOrcNomObr, setFiltroOrcNomObr] = useState<string>(''); // Filtro OrcNomObr
  const [filtroCliNom, setFiltroCliNom] = useState<string>('');
  const navigate = useNavigate(); // Hook useNavigate

  useEffect(() => {
    OrcamentoComunicaApi.getAll()
      .then((response) => setOrcamentos(response.data))
      .catch((error) => console.error('Erro ao buscar orçamentos de pedido', error));
  }, []);

  // Função para excluir um orçamento de pedido
  const excluir = (id: number) => {
    if (window.confirm('Tem certeza que deseja excluir?')) {
      OrcamentoComunicaApi.delete(id)
        .then(() => {
          setOrcamentos(orcamentos.filter((orcamento) => orcamento.orcId !== id));
          alert('Orçamento de pedido excluído com sucesso.');
        })
        .catch((error) => {
          if (error.response) {
            const errorMessage = error.response.data?.message || 'Erro desconhecido.';
            alert(`Erro ao excluir orçamento de pedido: ${errorMessage}`);
          } else if (error.request) {
            alert('Erro ao conectar com o servidor. Verifique sua conexão.');
          } else {
            console.error('Erro inesperado:', error);
            alert('Erro inesperado. Por favor, tente novamente.');
          }
        });
    }
  };

  // Função para filtrar os orçamentos de pedidos com base nos filtros
  const filteredOrcamentos = orcamentos.filter((orcamento) => {
    const matchesCliNom = filtroCliNom ? orcamento.cliente.pesNom.toLowerCase().includes(filtroCliNom.toLowerCase()) : true;
    const matchesNomObr = filtroOrcNomObr ? orcamento.orcNomObr.toLowerCase().includes(filtroOrcNomObr.toLowerCase()) : true;
    const matchesNumPro = filtroOrcNumProEmp ? orcamento.orcNumProEmp === filtroOrcNumProEmp : true;
    return matchesNumPro && matchesNomObr && matchesCliNom;
  });


  return (
    <div>
      <Cabecalho />
      <Titulo>Lista de Orçamentos/Processos</Titulo>

      <div className="tabela-centralizada">
        <div className="grupo-filtros" >
          <h2 className="titulo-filtros">Filtros</h2>

          <div className="campo-filtro">
            <label>Nome do Cliente:</label>
            <input
              type="text"
              value={filtroCliNom}
              onChange={(e) => setFiltroCliNom(e.target.value)}
            />
          </div>

          <div className="campo-filtro">
            <label>Nome da Obra:</label>
            <input
              type="text"
              value={filtroOrcNomObr}
              onChange={(e) => setFiltroOrcNomObr(e.target.value)}
            />
          </div>
          <div className="campo-filtro">
            <label>Número do Processo:</label>
            <input
              type="number"
              value={filtroOrcNumProEmp}
              onChange={(e) => setFiltroOrcNumProEmp(Number(e.target.value))}
            />
          </div>

        </div>
      </div>


      <div className='tabela-centralizada'>
        <BotaoPadrao onClick={() => navigate(`/orcamentocadastro?paramId=${0}&paramModo=INS`)}>Inserir
        </BotaoPadrao>
      </div>
      <table className='table-grid'>
        <thead>
          <tr>
            <th>Número do Processo</th>
            <th>Cliente</th>
            <th>Nome da Obra</th>
            <th>Data Solicitação</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {filteredOrcamentos.map((orcamento) => (
            <tr key={orcamento.orcId}>
              <td>{orcamento.orcNumProEmp}</td>
              <td>{orcamento.cliente.pesNom}</td>
              <td>{orcamento.orcNomObr}</td>
              <td>{orcamento.orcDatSol}</td>
              <td>
                {/* Usando navigate para navegar para as páginas de visualização e edição */}
                <BotaoLista onClick={() => navigate(`/orcamentocadastro?paramId=${orcamento.orcId}&paramModo=DSP`)}>Visualizar
                </BotaoLista>
                {' | '}
                <BotaoLista onClick={() => navigate(`/orcamentocadastro?paramId=${orcamento.orcId}&paramModo=UPD`)}>Editar
                </BotaoLista>
                {' | '}
                {/* Botão de Excluir */}
                <BotaoLista onClick={() => excluir(orcamento.orcId)} >
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

export default OrcamentoLista;
