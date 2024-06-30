package com.aeroBlasters.flightManagementSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.aeroBlasters.flightManagementSystem.bean.Airport;
import com.aeroBlasters.flightManagementSystem.dao.AirportDao;

@RestController
public class AirportController {
	
	@Autowired
	private AirportDao airportDao;
	

	@GetMapping("/airport")
	public ModelAndView showAirportEntryPage() {
		Airport airport = new Airport();
		ModelAndView mv=new ModelAndView("airportAdd");
		mv.addObject("airport_data", airport);
		return mv;	 
	}
	
	@PostMapping("/airport")
	public ModelAndView saveAirport(@ModelAttribute("airport_data") Airport airport) {
		String stg =airport.getAirportLocation().toUpperCase();		
		airport.setAirportLocation(stg);
		String str = airport.getAirportCode().toUpperCase();
		airport.setAirportCode(str);
		airportDao.addAirport(airport);
		return new ModelAndView("index");
	}
	
	@GetMapping("/airports")
	public ModelAndView showAirport() {
		List<Airport> airportList = airportDao.showAllAirports();
		ModelAndView mv=new ModelAndView("airportAll");
		mv.addObject("airportList", airportList);
		return mv;
	}
	
	@GetMapping("/airport-select")
	public ModelAndView showSelectedOne() {
		List<String> codeList = airportDao.findAllAirportCodes();
		ModelAndView mv=new ModelAndView("airportSelected");
		mv.addObject("codeList", codeList);
		return mv;
	}
	
	@PostMapping("/airport-select")
	public ModelAndView selectedAirport(@RequestParam("airport-code")String id) {
		Airport airport = airportDao.findAirportById(id);
		ModelAndView mv=new ModelAndView("airportDisplay");
		mv.addObject("airport", airport);
		return mv;
	}
	
	@GetMapping("/airport/{id}")
	public ModelAndView showSingleAirportPage(@PathVariable("id") String id) {
		Airport airport=airportDao.findAirportById(id);
		ModelAndView mv=new ModelAndView("airportShowPage");
		mv.addObject("airport",airport);
		return mv;
	}


}