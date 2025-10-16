import axios from 'axios';
import BaseURL from '../GlobalBaseUrl';

const api = axios.create({
  baseURL: BaseURL.baseURL+'/pais',
});

export const PaisComunicaApi = {
  getAll: () => api.get(''), // Obter todos os países
  getById: (id: number) => api.get(`/${id}`), // Obter um país por ID
  create: (data: any) => api.post('/', data), // Criar um novo país
  update: (id: number, data: any) => api.put(`/${id}`, data), // Atualizar um país
  delete: (id: number) => api.delete(`/${id}`), // Deletar um país
};

 
