import React, { useState, useEffect } from 'react';

const RouteOptimale = () => {
  const [routeOptimale, setRouteOptimale] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/getRoute')
      .then(response => response.json())
      .then(data => {
        const routeArray = data[0].split(' & ');
        setRouteOptimale(routeArray);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
      <h1>Route Optimale</h1>
      {routeOptimale.map((item, index) => (
        <p key={index}>{index + 1}. {item}</p>
      ))}
    </div>
  );
};

export default RouteOptimale;
