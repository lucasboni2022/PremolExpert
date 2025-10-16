//Objeto...
const BaseURL = {
    baseURL: 'http://localhost:8080',
    //baseURL: 'https://premolexpertcom.br/api',
};


export  default BaseURL;



//Diferença de objeto e função:
//as duas podem ter duas formas de exportar: default ou {} mais de um export usa {}, {} tem 2 formas de usar

//Objeto...
//const BaseURL1 = {
 //   baseURL: 'http://localhost:5017/api/',
//};

//const BaseURL2 = {
 //   baseURL: 'http://localhost:5017/api/',
//};
//export  {BaseURL1,BaseURL2};

/* Objeto Exportando direto...
export const PaisComunicaApi = {
  getAll: () => api.get('/'), // Obter todos os países
  getById: (id: number) => api.get(`/${id}`), // Obter um país por ID
  create: (data: any) => api.post('/', data), // Criar um novo país
  update: (id: number, data: any) => api.put(`/${id}`, data), // Atualizar um país
  delete: (id: number) => api.delete(`/${id}`), // Deletar um país
};
*/

//Function...faz operacoes, retorna ou nao valores
// Função simples que soma dois números
/*
function somar(a, b) {
    return a + b;
}

export default somar;

function somar(a, b) {
    return a + b;
}

export {somar};

*/