import axios from 'axios';
import BaseURL from '../GlobalBaseUrl';

const api = axios.create({
 //baseURL: 'https://premolexpertcom.br/api/orcamentoPedido',
 //baseURL: 'http://localhost:8080/orcamentopedido',
  baseURL: BaseURL.baseURL +'/unidade',
            
});

const UnidadeComunicaApi = {
  getAll: () => api.get(''),
  getById: (id: number) => api.get(`/${id}`),
  create: (data: any) => api.post('/', data),
  update: (id: number, data: any) => api.put(`/${id}`, data),
  delete: (id: number) => api.delete(`/${id}`),
};

export default UnidadeComunicaApi;
 