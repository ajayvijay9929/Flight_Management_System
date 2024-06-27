package com.aeroBlasters.flightManagementSystem.dao;

import java.util.List;

import com.aeroBlasters.flightManagementSystem.bean.Flight;


public interface FlightDao {

	public void save(Flight flight1);
	public List<Flight>  findAllFlights();
	public void addFlight(Flight flight);
	public List<Flight> findFlightsByRouteId(Long routeId);


}
