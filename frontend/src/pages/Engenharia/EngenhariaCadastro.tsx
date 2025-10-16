import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import OrcamentoProdutoComunicaApi from '../../services/OrcamentoProdutoServices/OrcamentoProdutoComunicaApi';
import Cabecalho from '../../components/Cabecalho/Cabecalho';
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
  orcProdQtdPronta: number;
  orcProdIncPor: number;
  orcProdIncEm: string;
  orcProdAltPor?: number;
  orcProdAltEm?: string;
  orcProdQtdASerEnviada?: number;
  orcProdQtdSetorArm?: number;
  orcProdQtdSetorForma?: number;
  orcProdQtdSetorAcaba?: number;
  orcProdQtdEnvAFazer?: number;
  orcProdQtdFaltaEnviar?: number;
}

function EngenhariaCadastro() {
  const location = useLocation();
  const navigate = useNavigate();

  const [orcamentoProduto, setOrcamentoProduto] = useState<OrcamentoProduto>({
    orcProdId: 0,
    orcId: 0,
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
    orcProdQtdPronta: 0,
    orcProdIncPor: 1,
    orcProdIncEm: new Date().toISOString(),
    orcProdQtdASerEnviada: 0,
    orcProdQtdSetorArm: 0,
    orcProdQtdSetorForma: 0,
    orcProdQtdSetorAcaba: 0,
    orcProdQtdEnvAFazer: 0,
    orcProdQtdFaltaEnviar: 0,
  });

  const [produtosAdicionados, setProdutosAdicionados] = useState<OrcamentoProduto[]>([]);
  const [paramDescricaoEtapaProcesso, setparamDescricaoEtapaProcesso] = useState<string>("");
  const queryParams = new URLSearchParams(location.search);
  const paramId = queryParams.get('paramId');
  const paramModo = queryParams.get('paramModo');
  const auxDescricaoEtapaProcesso = queryParams.get('paramDescricaoEtapaProcesso');
  const paramOrcNumProEmp = queryParams.get('paramOrcNumProEmp');

  useEffect(() => {
    if (paramId) {
      setOrcamentoProduto((prevState) => ({
        ...prevState,
        orcId: Number(paramId),
      }));

      if (paramModo !== 'DSP') {
        OrcamentoProdutoComunicaApi.getAll(Number(paramId))
          .then((response) => {
            const produtos = response.data;

            // Verificar se a etapa de processo é Engenharia e, se for, atualizar orcProdQtdEnvAFazer
            if (auxDescricaoEtapaProcesso === "Engenharia") {
              const produtosAtualizados = produtos.map((produto: OrcamentoProduto) => ({
                ...produto,
                orcProdQtdEnvAFazer: produto.orcProdQtdEnvAFazer,
                orcProdQtdFaltaEnviar: produto.orcProdQtd - produto.orcProdQtdEnvAFazer!,
                orcProdQtdASerEnviada: produto.orcProdQtd - produto.orcProdQtdEnvAFazer!
              }));
              setProdutosAdicionados(produtosAtualizados);
            } else {
              setProdutosAdicionados(produtos);
            }
          })
          .catch((error) => console.error('Erro ao buscar orçamento do produto', error));
      }
    }

    if (auxDescricaoEtapaProcesso) {
      setparamDescricaoEtapaProcesso(auxDescricaoEtapaProcesso);
    }

  }, [location.search, auxDescricaoEtapaProcesso, paramId, paramModo]);




  const capturaAlteracao = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;

    // Verifica se o valor do campo está vazio e define como null
    const valorAlterado = value === '0' ? '0' : Number(value);//para conseguir apagar 0

    // Atualizando o estado de 'produtosAdicionados'
    setProdutosAdicionados((prevProdutos) =>
      prevProdutos.map((produtoItem) => {
        // Verifica se o produto correspondente é o que estamos alterando
        if (produtoItem.orcProdId === Number(e.target.closest("tr")?.getAttribute("data-id"))) {
          return {
            ...produtoItem,
            // Para os campos específicos, converte o valor para número ou null
            [name]: name === 'orcProdQtdASerEnviada' ? valorAlterado : value,
          };
        }

        // Retorna o produto sem alterações se não for o correto
        return produtoItem;
      })
    );
  };



  const enviarFabricacao = (id: number) => {
    if (window.confirm('Tem certeza que deseja enviar para fabricação?')) {
      //  if (id=1){
      OrcamentoComunicaApi.atualizarEtapaProcessoEmpresa(id, 3)
        .then(() => {
          setparamDescricaoEtapaProcesso("Fabricação");

          // Para cada produto, envie uma atualização individual
          const updatePromises = produtosAdicionados.map((produto) => {
            // Garantir que o produto tenha o ID correto e os campos necessários
            //console.log("Enviando produto para atualização:", produto);

            // Verifique se a API espera todos os campos que estão sendo enviados
            return OrcamentoProdutoComunicaApi.update(produto.orcProdId!, produto);
          });

          // Espera todas as promessas se resolverem
          Promise.all(updatePromises)
            .then((response) => {
              console.log("Respostas das atualizações:", response);
              alert('Todos os produtos foram enviados para fabricação com sucesso.');
            })
            .catch((error) => {
              console.error('Erro ao atualizar os produtos:', error);
              alert(`Aviso: ${error.response?.data || 'Erro desconhecido.'}`);
            });
        })
        .catch((error) => {
          // console.error('Erro ao atualizar a etapa do processo:', error);
          alert(`Aviso: ${error.response?.data || 'Erro desconhecido.'}`);
        });
      // };
    }
  };


  return (
    <div>
      <Cabecalho />
      <table className="tabela-centralizada">
        <div>
          <span>Número do Processo: {paramOrcNumProEmp} {'>'} Etapa: {paramDescricaoEtapaProcesso}</span>
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

                  <div
                    className="tab"
                    onClick={() => navigate(`/orcamentoprodutocadastro?paramId=${paramId}&paramModo=${paramModo}&paramOrcNumProEmp=${paramOrcNumProEmp}&paramDescricaoEtapaProcesso=${paramDescricaoEtapaProcesso}`)}
                  >
                    Produtos/Serviços
                  </div>

                  <div className="tab-ativa">Engenharia</div>
                  <div className="tab"
                    onClick={() => navigate(`/fabricacaocadastro?paramId=${paramId}&paramModo=${paramModo}&paramOrcNumProEmp=${paramOrcNumProEmp}&paramDescricaoEtapaProcesso=${paramDescricaoEtapaProcesso}`)}
                  >
                    Fabricação
                  </div>

                  <div className="tab">Transporte</div>
                  <div className="tab">Montagem</div>
                </div>
                <form>
                  <table className="tabela-sem-borda">
                    <tbody>
                      <tr>
                        <td colSpan={2} style={{ textAlign: 'center' }}>
                          <BotaoGrande type="button" onClick={() => enviarFabricacao(orcamentoProduto.orcId!)}>Enviar para Fabricação</BotaoGrande>
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
                      <th>Qtd. Original</th>
                      <th>Qtd. já Enviada para Fabricação</th>
                      <th>Qtd. que Falta ser Enviada</th>
                      <th>Digite a Qtd. à Enviar</th>
                      <th>Ação</th>
                    </tr>
                  </thead>
                  <tbody>
                    {produtosAdicionados.length > 0 ? (
                      produtosAdicionados.map((produtoItem) => (
                        <tr key={produtoItem.orcProdId} data-id={produtoItem.orcProdId}> {/* Adicionando data-id */}
                          <td>{produtoItem.produto?.prodId}</td>
                          <td>{produtoItem.produto?.prodDsc || 'Descrição não encontrada'}</td>
                          <td>{produtoItem.unidade?.uniNom || 'Unidade não encontrada'}</td>
                          <td>{produtoItem.orcProdQtd}</td>
                          <td>
                            <input
                              type="number"
                              name="orcProdQtdEnvAFazer"
                              value={produtoItem.orcProdQtdEnvAFazer ?? 0}
                              disabled={true}
                              required
                            />
                          </td>
                          <td>
                            <input
                              type="number"
                              name="orcProdQtdFaltaEnviar"
                              value={produtoItem.orcProdQtdFaltaEnviar ?? 0}
                              disabled={true}
                              required
                            />
                          </td>
                          <td>
                            <input
                              type="number"
                              name="orcProdQtdASerEnviada"
                              value={produtoItem.orcProdQtdASerEnviada || ''}
                              onChange={capturaAlteracao}
                              required
                            />
                          </td>
                          <td>
                          <BotaoGrande>
                              <button onClick={() => navigate(`/orcamentocadastro?paramId=${produtoItem.orcId}&paramModo=UPD`)}>Programação</button>
                          </BotaoGrande>
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

export default EngenhariaCadastro;
