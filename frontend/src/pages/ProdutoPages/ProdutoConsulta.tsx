import React, { useEffect, useState } from 'react';
import ProdutoComunicaApi from '../../services/ProdutoServices/ProdutoComunicaApi';
import BotaoPadrao from '../../components/BotaoPadrao/BotaoPadrao';

interface Produto {
    prodId: number;
    prodDsc: string;
    empId: number
}

const ProdutoConsulta: React.FC = () => {
  const [Produtos, setProdutos] = useState<Produto[]>([]);
  const [filtroProdDsc, setFiltroProdDsc] = useState<string>('');


  useEffect(() => {
    ProdutoComunicaApi.getAll()
      .then((response) => setProdutos(response.data))
      .catch((error) => console.error('Erro ao buscar Produtos', error));
  }, []);

  const filteredProdutos = Produtos.filter((Produto) => {
    return filtroProdDsc ? Produto.prodDsc.toLowerCase().includes(filtroProdDsc.toLowerCase()) : true;
  });

  const voltar = () => {
    window.close();
  };

  const enviarProdutoselecionado = (prodId: number, prodDsc: string) => {
    window.opener?.postMessage({ prodId, prodDsc }, window.location.origin);
    window.close(); // Fecha o popup
};
  
  return ( 
    <div>
      <h1>Consulta de Produtos</h1>
      <div>
        <label>Filtro por Nome:</label>
        <input
          type="text"
          value={filtroProdDsc}
          onChange={(e) => setFiltroProdDsc(e.target.value)}
        />
      </div>

      <BotaoPadrao type="button" onClick={voltar}>Voltar</BotaoPadrao>

      <table>
        <thead>
          <tr>
            <th>Código</th>
            <th>Descrição</th>
          </tr>
        </thead>
        <tbody>
        {filteredProdutos.map((produto) => (
          <tr key={produto.prodId} onClick={() => enviarProdutoselecionado(produto.prodId, produto.prodDsc)} style={{ cursor: "pointer" }}>
            <td>{produto.prodId}</td>
            <td>{produto.prodDsc}</td>
          </tr>
        ))}

        </tbody>
      </table>
    </div>
  );
};

export default ProdutoConsulta;
