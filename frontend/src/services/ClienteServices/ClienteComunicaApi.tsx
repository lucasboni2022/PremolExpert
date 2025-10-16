import axios from 'axios';
import BaseURL from '../GlobalBaseUrl';

baseURL:String;

const api = axios.create({
  baseURL: BaseURL.baseURL+'/cliente',
  
});


const ClienteComunicaApi = {
  getAll: () => api.get(''),
  getById: (id: number) => api.get(`/${id}`),
  create: (data: any) => api.post('/', data),
  update: (id: number, data: any) => api.put(`/${id}`, data),
  delete: (id: number) => api.delete(`/${id}`),
};

export default ClienteComunicaApi;