import axios from 'axios';
import BaseURL from '../GlobalBaseUrl';

const api = axios.create({
  baseURL: BaseURL.baseURL +'/produto',          
});

const ProdutoComunicaApi = {
  getAll: () => api.get(''),
  getById: (id: number) => api.get(`/${id}`),
  create: (data: any) => api.post('', data),
  update: (id: number, data: any) => api.put(`/${id}`, data),
  delete: (id: number) => api.delete(`/${id}`),
  getProximoOrcNumProEmp: (empId: number) => api.get(`/proximo-numero-processo-emp/${empId}`),
};

export default ProdutoComunicaApi;