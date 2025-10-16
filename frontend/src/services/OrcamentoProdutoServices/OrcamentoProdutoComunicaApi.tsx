import axios from 'axios';
import BaseURL from '../GlobalBaseUrl';

baseURL:String;

const api = axios.create({
  baseURL: BaseURL.baseURL+'/orcamento-produto',
});

const OrcamentoProdutoComunicaApi = {
  getAll: (idOrcamento: number) => api.get(`/lista-por-orcamento/${idOrcamento}`),
  getById: (id: number) => api.get(`/${id}`),
  create: (data: any) => api.post('', data),
  update: (id: number, data: any) => api.put(`/${id}`, data),
  delete: (id: number) => api.delete(`/${id}`),
  totalPorProdutoEngenharia: (orcProdId: number) => api.get(`/atualiza-etapa-processo-emp/${orcProdId}`),
};

export default OrcamentoProdutoComunicaApi;