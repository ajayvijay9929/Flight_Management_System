package com.aeroBlasters.flightManagementSystem.dao;

import java.util.List;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.aeroBlasters.flightManagementSystem.bean.Airport;
import com.aeroBlasters.flightManagementSystem.dao.AirportDao;

@Repository
@Service
public class AirportDaoImpl implements AirportDao {
    @Autowired
    private AirportRepository repository;

	@Override
	public void addAirport(Airport airport) {
		repository.save(airport);
	}

	@Override
	public List<Airport> showAllAirports() {
		return repository.findAll();
	}

	@Override
	public Airport showAirport(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	 @Override
	 public List<String> findAllAirportCodes(){
			// TODO Auto-generated method stub
			return repository.findAllAirportCodes();
	    }

	@Override
	public String findAirportCodeByLocation(String airportLocation) {
		// TODO Auto-generated method stub
		return repository.findAirportCodeByLocation(airportLocation);
	}
 
	
		//return repository.findAirportCodeByLocation(sourceAirportLocation);
	
}
//AirportRepository.findAirportCodeByLocation(String airportLocation) 
