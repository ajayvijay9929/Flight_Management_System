package com.aeroBlasters.flightManagementSystem.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.aeroBlasters.flightManagementSystem.bean.Flight;

@Repository
@EnableJpaRepositories
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("Select a from Flight a where routeId = ?1")
	public List<Flight> findFlightsByRouteId(Long routeId);
}
