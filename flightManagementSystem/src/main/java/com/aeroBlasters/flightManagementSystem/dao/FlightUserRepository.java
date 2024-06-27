package com.aeroBlasters.flightManagementSystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeroBlasters.flightManagementSystem.bean.flightUser;

public interface FlightUserRepository extends JpaRepository<flightUser, String> {
	Optional<flightUser> findByUsername(String username);
	
}
