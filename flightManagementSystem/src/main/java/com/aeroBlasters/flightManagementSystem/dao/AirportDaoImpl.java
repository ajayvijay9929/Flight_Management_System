package com.aeroBlasters.flightManagementSystem.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.aeroBlasters.flightManagementSystem.bean.Airport;

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
	 public List<String> findAllAirportCodes(){
			// TODO Auto-generated method stub
			return repository.findAllAirportCodes();
	    }

	@Override
		public List<String> findAllAirportLocations() {
			return repository.findAllAirportLocations();
		}
	 
	@Override
	public Airport findAirportById(String id) {
	    // Handle Optional to avoid NoSuchElementException
	    return repository.findById(id).orElse(null);
	}

	@Override
	public String findAirportCodeByLocation(String airportLocation) {
		// TODO Auto-generated method stub
		return repository.findAirportCodeByLocation(airportLocation);
	}
	
}




	

