import axios from 'axios';
import BaseURL from '../GlobalBaseUrl';

const api = axios.create({
 //baseURL: 'https://premolexpertcom.br/api/orcamentoPedido',
 //baseURL: 'http://localhost:8080/orcamentopedido',
  baseURL: BaseURL.baseURL +'/orcamento',
            
});

const OrcamentoComunicaApi = {
  getAll: () => api.get(''),
  getById: (id: number) => api.get(`/${id}`),
  create: (data: any) => api.post('', data),
  update: (id: number, data: any) => api.put(`/${id}`, data),
  delete: (id: number) => api.delete(`/${id}`),
  getProximoOrcNumProEmp: (empId: number) => api.get(`/proximo-numero-processo-emp/${empId}`),
  atualizarEtapaProcessoEmpresa: (orcId: number, orcEtap:number) => api.put(`/atualiza-etapa-processo-emp/${orcId}/${orcEtap}`),
};

export default OrcamentoComunicaApi;

/* 
export const OrcamentoComunicaApi = {
  getAll: () => api.get('/'),
  getById: (id: number) => api.get(`/${id}`),
  create: (data: any) => api.post('/', data),
  update: (id: number, data: any) => api.put(`/${id}`, data),
  delete: (id: number) => api.delete(`/${id}`),
};
*/
 