package com.aeroBlasters.flightManagementSystem.dao;

import java.util.List;

import com.aeroBlasters.flightManagementSystem.bean.Airport;
import com.aeroBlasters.flightManagementSystem.bean.Route;

public interface RouteDao {
   public void save(Route route);
   public List<Route> findAllRoutes();
   public Route findRouteById(Long id);
   public Long findRouteBySourceAndDestination(String source,String Destination);
   public Long generateRouteId();
		}

