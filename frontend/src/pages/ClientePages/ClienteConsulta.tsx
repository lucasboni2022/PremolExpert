import React, { useEffect, useState } from 'react';
import ClienteComunicaApi from '../../services/ClienteServices/ClienteComunicaApi';
import BotaoPadrao from '../../components/BotaoPadrao/BotaoPadrao';

interface Cliente {
  cliId: number;
  pesNom: string;
}

const ClienteConsulta: React.FC = () => {
  const [Clientes, setClientes] = useState<Cliente[]>([]);
  const [filtroCliNom, setFiltroCliNom] = useState<string>('');


  useEffect(() => {
    ClienteComunicaApi.getAll()
      .then((response) => setClientes(response.data))
      .catch((error) => console.error('Erro ao buscar clientes', error));
  }, []);

  const filteredClientes = Clientes.filter((Cliente) => {
    return filtroCliNom ? Cliente.pesNom.toLowerCase().includes(filtroCliNom.toLowerCase()) : true;
  });

  const voltar = () => {
    window.close();
  };

  const enviarClienteSelecionado = (cliId: number, pesNom: string) => {
    window.opener?.postMessage({ cliId, pesNom }, window.location.origin);
    window.close(); // Fecha o popup
};
  
  return ( 
    <div>
      <h1>Consulta de Clientes</h1>
      <div>
        <label>Filtro por Nome:</label>
        <input
          type="text"
          value={filtroCliNom}
          onChange={(e) => setFiltroCliNom(e.target.value)}
        />
      </div>

      <BotaoPadrao type="button" onClick={voltar}>Voltar</BotaoPadrao>

      <table>
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome</th>
          </tr>
        </thead>
        <tbody>
        {filteredClientes.map((cliente) => (
          <tr key={cliente.cliId} onClick={() => enviarClienteSelecionado(cliente.cliId, cliente.pesNom)} style={{ cursor: "pointer" }}>
            <td>{cliente.cliId}</td>
            <td>{cliente.pesNom}</td>
          </tr>
        ))}

        </tbody>
      </table>
    </div>
  );
};

export default ClienteConsulta;
