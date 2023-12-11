import React, { useState, useEffect } from 'react';

const RouteOptimale = () => {
  const [clientsData, setClientsData] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/getClients')
      .then(response => response.json())
      .then(data => {
        setClientsData(data[0].clients);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
      <h1>Route Optimale</h1>
      <ul>
        {clientsData.map((client, index) => (
          <li key={index}>
            <h3>{client.nom}</h3>
            <p>{client.adresse}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default RouteOptimale;
