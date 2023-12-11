import React, { useState, useEffect } from 'react';

const RouteOptimale = () => {
  const [routeOptimale, setRouteOptimale] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/getRoute')
      .then(response => response.json())
      .then(data => {
        setRouteOptimale(data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
      <h1>Route Optimale</h1>

      <h3>{routeOptimale}</h3>
    </div>
  );
};

export default RouteOptimale;
