import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import OrcamentoProdutoComunicaApi from '../../services/OrcamentoProdutoServices/OrcamentoProdutoComunicaApi';
import UnidadeComunicaApi from '../../services/UnidadeServices/UnidadeComunicaApi';
import BotaoPadrao from '../../components/BotaoPadrao/BotaoPadrao';
import BotaoLista from '../../components/BotaoLista/BotaoLista';
import Cabecalho from '../../components/Cabecalho/Cabecalho';
import ImagemProcurar from "../../imagens/procurar.gif";
import ProdutoComunicaApi from '../../services/ProdutoServices/ProdutoComunicaApi';
import BotaoGrande from '../../components/BotaoGrande/BotaoGrande';
import OrcamentoComunicaApi from '../../services/OrcamentoServices/OrcamentoComunicaApi';

interface Produto {
  prodId: number;
  prodDsc: string;
  prodIncPor: number;
  prodIncEm: string;
  prodAltPor: number | null;
  prodAltEm: string | null;
  gruId: number;
  empId: number;
}

interface Unidade {
  uniId: number;
  uniNom: string;
}

interface OrcamentoProduto {
  orcProdId?: number;
  orcId: number;
  produto: Produto;
  unidade: Unidade;
  orcProdQtd: number;
  orcProdVlrUnit: number;
  orcProdPron: number;
  orcProdQtdEnvAFazer: number;
  orcProdSta: number;
  orcProdIncPor: number;
  orcProdIncEm: string;
  orcProdAltPor?: number;
  orcProdAltEm?: string;
}

function OrcamentoProdutoCadastro() {
  const location = useLocation();
  const navigate = useNavigate();

  const [orcamentoProduto, setOrcamentoProduto] = useState<OrcamentoProduto>({
    orcProdId: 0,
    orcId: 0,
    produto: {  // Inicializando o objeto produto com valores padrão
      prodId: 0,
      prodDsc: '',
      prodIncPor: 1,
      prodIncEm: new Date().toISOString(),
      prodAltPor: null,
      prodAltEm: null,
      gruId: 0,
      empId: 0,
    },
    unidade: {
      uniId: 0,
      uniNom: "",
    },
    orcProdQtd: 0,
    orcProdVlrUnit: 0.00,
    orcProdPron: 1,
    orcProdQtdEnvAFazer: 0,
    orcProdSta: 1,
    orcProdIncPor: 1,
    orcProdIncEm: new Date().toISOString(),
  });
  const [produtosAdicionados, setProdutosAdicionados] = useState<OrcamentoProduto[]>([]);
  const [unidades, setUnidades] = useState<Unidade[]>([]);


  let isDesabilita = false;
  const [paramDescricaoEtapaProcesso, setparamDescricaoEtapaProcesso] = useState<string>("");
  const queryParams = new URLSearchParams(location.search);
  const paramId = queryParams.get('paramId');
  const paramModo = queryParams.get('paramModo');
  const auxDescricaoEtapaProcesso = queryParams.get('paramDescricaoEtapaProcesso');
  const paramOrcNumProEmp = queryParams.get('paramOrcNumProEmp');



  if (paramModo === 'DSP') {
    isDesabilita = true;
  }

  useEffect(() => {

    if (paramId) {
      setOrcamentoProduto((prevState) => ({
        ...prevState,
        orcId: Number(paramId),
      }));

      if (paramModo !== 'DSP') {
        OrcamentoProdutoComunicaApi.getAll(Number(paramId))
          .then((response) => {
            setProdutosAdicionados(response.data);
            console.log('Produtos recebidos:', response.data);
          })
          .catch((error) => console.error('Erro ao buscar orçamento do produto', error));
      }
    }

    UnidadeComunicaApi.getAll()
      .then((response) => setUnidades(response.data))
      .catch((error) => console.error('Erro ao buscar unidades', error));

    // Atualizando a descrição da etapa do processo
    if (auxDescricaoEtapaProcesso) {
      setparamDescricaoEtapaProcesso(auxDescricaoEtapaProcesso);
    }

  }, [location.search]);


  const capturaAlteracao = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    //console.log('capturaAlteracao_ANTES:', orcamentoProduto); 
    setOrcamentoProduto((prev) => ({
      ...prev,
      [name]: name === 'orcProdQtd' ? Number(value) : value, // Atualiza orcProdQtd se for esse campo, ao digitar
      [name]: name === 'orcProdVlrUnit' ? Number(value) : value, // Atualiza orcProdVlrUnit se for esse campo, ao digitar
      produto: {
        ...prev.produto,
        [name]: value, // Atualiza a propriedade correspondente dentro de produto
      },

    }));
    //console.log('capturaAlteracao_DEPOIS:', orcamentoProduto); 
  };


  const capturaAlteracaoComboBox = (e: React.ChangeEvent<HTMLSelectElement>) => {
    const { name, value } = e.target;
    //const produtoItem = produtosAdicionados[1];//0=primeiro campo 1=segundo campo
    //console.log('capturaAlteracaoComboBox_ANTES:', orcamentoProduto); 
    // console.log('produtosAdicionados.map.name:', produtosAdicionados.map.name); 

    setOrcamentoProduto((prev) => ({
      ...prev,
      unidade: {
        ...prev.unidade,
        //uniNom: produtoItem.unidade.uniNom,
        [name]: value, // Atualiza a propriedade correspondente dentro da unidade
      }
    }));
    console.log('capturaAlteracaoComboBox_DEPOIS:', orcamentoProduto); 
  };

  const excluir = (id: number) => {
    if (window.confirm('Tem certeza que deseja excluir?')) {
      OrcamentoProdutoComunicaApi.delete(id)
        .then(() => {
          setProdutosAdicionados((prevProdutos) =>
            prevProdutos.filter((produto) => produto.orcProdId !== id)
          );
          alert('Produto excluído com sucesso.');
        })
        .catch((error) => {
          if (error.response) {
            const errorMessage = error.response.data?.message || 'Erro desconhecido.';
            alert(`Erro ao excluir: ${errorMessage}`);
          } else if (error.request) {
            alert('Erro ao conectar com o servidor. Verifique sua conexão.');
          } else {
            console.error('Erro inesperado:', error);
            alert('Erro inesperado. Por favor, tente novamente.');
          }
        });
    }
  };


  const aprovarOrcamento = (id: number) => {
    if (window.confirm('Tem certeza que deseja aprovar o orçamento?')) {
      OrcamentoComunicaApi.atualizarEtapaProcessoEmpresa(id, 1)//1=Etapa Orçamento Aprovado
        .then(() => {
          // Atualiza o estado corretamente usando a função set
          setparamDescricaoEtapaProcesso("Orçamento Aprovado");

          alert('Orçamento aprovado com sucesso.');
        })
        .catch((error) => {
          // Log do erro para ver como ele está estruturado
          console.error('Detalhes do erro:', error);

          if (error.response) {
            // Verifica a estrutura da resposta de erro
            const errorMessage = error.response.data || 'Erro desconhecido.';
            alert(`Aviso: ${errorMessage}`);
          } else if (error.request) {
            // Caso o erro seja na requisição (sem resposta)
            alert('Erro ao conectar com o servidor. Verifique sua conexão.');
          } else {
            // Caso seja um erro inesperado
            console.error('Erro inesperado:', error);
            alert('Erro inesperado. Por favor, tente novamente.');
          }
        });
    }
  };

  const enviarEngenharia = (id: number) => {
    if (window.confirm('Tem certeza que deseja enviar para engenharia?')) {
      //Etapas: 0=Orçamento; 1=Orçamento Aprovado; 2=Engenharia; 3=Fabricação; 4=Transporte; 5=Montagem.
      OrcamentoComunicaApi.atualizarEtapaProcessoEmpresa(id, 2)//2=Etapa Engenharia
        .then(() => {
          // Atualiza o estado corretamente usando a função set
          setparamDescricaoEtapaProcesso("Engenharia");

          alert('Enviado sucesso.');
        })
        .catch((error) => {
          // Log do erro para ver como ele está estruturado
          console.error('Detalhes do erro:', error);

          if (error.response) {
            // Verifica a estrutura da resposta de erro
            const errorMessage = error.response.data || 'Erro desconhecido.';
            alert(`Aviso: ${errorMessage}`);
          } else if (error.request) {
            // Caso o erro seja na requisição (sem resposta)
            alert('Erro ao conectar com o servidor. Verifique sua conexão.');
          } else {
            // Caso seja um erro inesperado
            console.error('Erro inesperado:', error);
            alert('Erro inesperado. Por favor, tente novamente.');
          }
        });
    }
  };


  const abrirPopupProduto = () => {
    window.open(`/produtoconsulta`, "popupProduto", "width=600,height=400");
  };

  //caputurar retorno após PopupFechar
  window.addEventListener("message", (event) => {
    if (event.origin !== window.location.origin) return;

    const { prodId, prodDsc } = event.data;
    if (prodId && prodDsc) {
      setOrcamentoProduto((prev) => ({
        ...prev,
        produto: {
          ...prev.produto,
          prodId: prodId,
          prodDsc: prodDsc,
        },
      }));
    }
  });

  // Define o estado para gerenciar o erro
  const [erroProduto, setErroProduto] = useState(false);

  const buscarProduto = async (id: number) => {
    try {
      const response = await ProdutoComunicaApi.getById(id);
      if (response.data && response.data.prodDsc) {
        setOrcamentoProduto((prev) => ({
          ...prev,
          produto: {
            ...prev.produto,
            prodId: response.data.prodId,
            prodDsc: response.data.prodDsc,
          },
        }));
        setErroProduto(false); // Produto encontrado, sem erro
      }
    } catch (error) {
      setOrcamentoProduto((prev) => ({
        ...prev,
        produto: {
          ...prev.produto,
          prodDsc: 'Produto não encontrado',
        },
      }));
      setErroProduto(true); // Produto não encontrado, marca erro
      alert('Produto não encontrado');
    }
  };

  const verificaProduto = () => {
    const prodId = orcamentoProduto.produto.prodId;
    if (prodId) {
      buscarProduto(prodId); // Faz a busca do produto
    }
    return !erroProduto; // Retorna true se não houver erro, senão false
  };

  const enviar = (e: React.FormEvent) => {
    e.preventDefault();

    // Chama a função de verificação
    if (!verificaProduto()) {
      // Se erroProduto for true, significa que houve um erro ao buscar o produto
      return; // Interrompe o envio
    }

    const { orcProdId, ...orcamentoProdutoSemId } = orcamentoProduto;

    OrcamentoProdutoComunicaApi.create(orcamentoProdutoSemId)
      .then(() => {
        setProdutosAdicionados((prevProdutos) => [
          ...prevProdutos,
          orcamentoProduto,
        ]);
      })
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

    // Limpa o formulário após o envio
    setOrcamentoProduto({
      orcProdId: 0,
      orcId: Number(orcamentoProduto.orcId),
      produto: {
        prodId: 0,
        prodDsc: '',
        prodIncPor: 1,
        prodIncEm: new Date().toISOString(),
        prodAltPor: null,
        prodAltEm: null,
        gruId: 0,
        empId: 0,
      },
      unidade: {
        uniId: 0,
        uniNom: "",
      },
      orcProdQtd: 0,
      orcProdVlrUnit: 0.00,
      orcProdPron: 1,
      orcProdQtdEnvAFazer: 0,
      orcProdSta: 1,
      orcProdIncPor: 1,
      orcProdIncEm: new Date().toISOString(),
    });
  };


  return (
    <div>
      <Cabecalho />

      <table className="tabela-centralizada">
        <div>
          <span>Número do Proceso: {paramOrcNumProEmp} {'>'} Etapa: {paramDescricaoEtapaProcesso}</span>
        </div>
        <tbody>
          <tr>
            <td className="tirar-espaco-interno">
              <div>
                <div className="tabs">
                  <div
                    className="tab"
                    onClick={() => navigate(`/orcamentocadastro?paramId=${orcamentoProduto.orcId}&paramModo=UPD`)}
                  >
                    Obra
                  </div>
                  <div className="tab-ativa">Produtos/Serviços</div>
                  <div
                    className="tab"
                    onClick={() => navigate(`/engenhariacadastro?paramId=${paramId}&paramModo=${paramModo}&paramOrcNumProEmp=${paramOrcNumProEmp}&paramDescricaoEtapaProcesso=${paramDescricaoEtapaProcesso}`)}
                  >
                    Engenharia
                  </div>

                  <div className="tab">Fabricação</div>
                  <div className="tab">Transporte</div>
                  <div className="tab">Montagem</div>
                </div>
                <form onSubmit={enviar}>
                  <table className="tabela-sem-borda">
                    <tbody>
                      <tr>
                        <td><label>Código:</label></td>
                        <td>
                          <input
                            type="number"
                            name="prodId"
                            value={orcamentoProduto.produto.prodId}
                            onChange={capturaAlteracao}
                            required
                            onBlur={verificaProduto}
                          />
                          <img
                            src={ImagemProcurar}
                            alt="Consultar Produto"
                            width="32"
                            height="32"
                            onClick={abrirPopupProduto}
                          />
                          {orcamentoProduto.produto.prodDsc}
                        </td>
                      </tr>

                      <tr>
                        <td><label>Unidade:</label></td>
                        <td>
                          <select
                            name="uniId"
                            value={orcamentoProduto.unidade.uniId}
                            onChange={capturaAlteracaoComboBox}
                            disabled={isDesabilita}
                            required

                          >

                            <option value="">Selecione</option>
                            {unidades.map((unidadeItem) => (
                              <option key={unidadeItem.uniId} value={unidadeItem.uniId}>
                                {unidadeItem.uniNom}
                              </option>
                            ))}
                          </select>
                        </td>
                      </tr>
                      <tr>
                        <td><label>Quantidade:</label></td>
                        <td><input type="number" name="orcProdQtd" value={orcamentoProduto.orcProdQtd} onChange={capturaAlteracao} required /></td>
                      </tr>
                      <tr>
                        <td><label>Valor Unitário:</label></td>
                        <td><input type="number" name="orcProdVlrUnit" value={orcamentoProduto.orcProdVlrUnit} onChange={capturaAlteracao} required /></td>
                      </tr>
                      <tr>
                        <td colSpan={2} style={{ textAlign: 'center' }}>
                          <BotaoPadrao type="submit">Adicionar</BotaoPadrao>
                          <BotaoGrande type="button" onClick={() => aprovarOrcamento(orcamentoProduto.orcId!)}>Aprovar Orçamento</BotaoGrande>
                          <BotaoGrande type="button" onClick={() => enviarEngenharia(orcamentoProduto.orcId!)}>Enviar para Engenharia</BotaoGrande>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </form>

                <table className="tabela-sem-borda">
                  <thead>
                    <tr>
                      <th>Cód.</th>
                      <th>Descrição</th>
                      <th>Unidade</th>
                      <th>Quantidade</th>
                      <th>Valor Unitário</th>
                      <th>Ação</th>
                    </tr>
                  </thead>
                  <tbody>

                    {
                      produtosAdicionados.length > 0 ? (
                        produtosAdicionados.map((produtoItem) => (
                          <tr key={produtoItem.orcProdId}>
                            <td>{produtoItem.produto?.prodId}</td>
                            <td>{produtoItem.produto?.prodDsc || 'Descrição não encontrada'}</td>
                            <td>{produtoItem.unidade?.uniNom || 'Unidada não encontrada'}</td>
                            <td>{produtoItem.orcProdQtd}</td>
                            <td>{produtoItem.orcProdVlrUnit}</td>
                            <td>
                              <BotaoLista onClick={() => excluir(produtoItem.orcProdId!)}>Excluir</BotaoLista>
                            </td>
                          </tr>
                        ))
                      ) : (
                        <tr>
                          <td colSpan={5}>Nenhum produto adicionado.</td>
                        </tr>
                      )}
                  </tbody>
                </table>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default OrcamentoProdutoCadastro;
