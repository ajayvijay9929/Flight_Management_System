package com.aeroBlasters.flightManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aeroBlasters.flightManagementSystem.bean.Airport;

@Repository
@EnableJpaRepositories

public interface AirportRepository extends JpaRepository<Airport, String> {
	@Query("select airportCode from Airport")
	public List<String> findAllAirportCodes();

 	@Query("select airportCode from Airport where airportLocation= ?1")
	public String findAirportCodeByLocation(String airportLocation);
}

