package com.aeroBlasters.flightManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.aeroBlasters.flightManagementSystem.bean.Route;


@Repository

public interface RouteRepository extends JpaRepository<Route, Long> {
	
	@Query("select max(routeId) from Route")
	public Long findLastRouteId();
	
	/*@Query("select routeId from Route where sourceAirportCode = ?1 And destinationAirportCode= ?2")
	public Long findRouteBySourceAndDestination(String sourceAirportCode,String destinationAirportCode);
	*/
	
	@Query("select a from Route a where sourceAirportCode = ?1 And destinationAirportCode= ?2")
	public Route findRouteBySourceAndDestination(String sourceAirportCode,String destinationAirportCode);
	
	@Query("Select routeId from Route")
	public List<Long> findAllRoutesId();
}
