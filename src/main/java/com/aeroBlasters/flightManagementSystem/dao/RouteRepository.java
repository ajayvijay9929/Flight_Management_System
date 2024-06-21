package com.aeroBlasters.flightManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aeroBlasters.flightManagementSystem.bean.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
	
	@Query("select max(routeId) from Route")
	public Long findLastRouteId();
	
	@Query("select routeId from Route where sourceAirportCode = ?1 And destinationAirportCode= ?2")
	public Long findRouteBySourceAndDestination(String sourceAirportCode,String destinationAirportCode);
	

}