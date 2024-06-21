package com.aeroBlasters.flightManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aeroBlasters.flightManagementSystem.bean.Flight;
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
