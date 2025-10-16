import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import PaisLista from './pages/PaisPages/PaisLista';
import PaisCadastro from './pages/PaisPages/PaisCadastro';
import OrcamentoLista from './pages/OrcamentoPages/OrcamentoLista';
import OrcamentoCadastro from './pages/OrcamentoPages/OrcamentoCadastro';
import EngenhariaCadastro from './pages/Engenharia/EngenhariaCadastro';
import OrcamentoProdutoCadastro from './pages/OrcamentoProdutoPages/OrcamentoProdutoCadastro';
import './styles/GlobalStyles.css';
import ClienteConsulta from  './pages/ClientePages/ClienteConsulta';
import ProdutoConsulta from './pages/ProdutoPages/ProdutoConsulta';
import FabricacaoCadastro from './pages/Fabricacao/FabricacaoCadastro';

const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path="pais/listar" element={<PaisLista />} /> 
        <Route path="pais/criar" element={<PaisCadastro />} />
        <Route path="pais/editar/:id" element={<PaisCadastro />} />

        <Route path="/orcamentolista" element={<OrcamentoLista />} /> 
        <Route path="/orcamentocadastro" element={<OrcamentoCadastro />} />

        <Route path="orcamentoprodutocadastro" element={<OrcamentoProdutoCadastro />} />

        <Route path="engenhariacadastro" element={<EngenhariaCadastro />} />

        <Route path="fabricacaocadastro" element={<FabricacaoCadastro />} />
        
        <Route path="/clienteconsulta" element={<ClienteConsulta />} /> 

        <Route path="/produtoconsulta" element={<ProdutoConsulta />} /> 
      </Routes>
    </Router>
  ); 
}; 

export default App;

