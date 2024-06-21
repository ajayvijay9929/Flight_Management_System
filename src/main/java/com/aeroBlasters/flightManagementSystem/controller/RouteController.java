package com.aeroBlasters.flightManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.aeroBlasters.flightManagementSystem.bean.Route;
import com.aeroBlasters.flightManagementSystem.dao.AirportDao;
import com.aeroBlasters.flightManagementSystem.dao.RouteDao;
import com.aeroBlasters.flightManagementSystem.service.RouteService;

@RestController
public class RouteController {

	@Autowired
	private RouteDao routeDao;
	@Autowired
	private RouteService routeService;
	@Autowired
	private AirportDao airportDao;
	
	@GetMapping("/routeEntryPage")
	public ModelAndView showRouteEntryPage() {
		Long newRouteId = routeDao.generateRouteId();
		Route route = new Route();
		route.setRouteId(newRouteId);
		ModelAndView mv = new ModelAndView("routeEntryPage");
		mv.addObject("routeRecord", route);
		return mv;
	}
	
	@PostMapping("/route")
	public ModelAndView saveRoutes(@ModelAttribute("routeRecord") Route route1) {
		String source = route1.getSourceAirportCode().toUpperCase();
		String destination = route1.getDestinationAirportCode().toUpperCase();
		route1.setSourceAirportCode(source);
		route1.setDestinationAirportCode(destination);
		String sourceCode = airportDao.findAirportCodeByLocation(route1.getSourceAirportCode());
		String destinationCode = airportDao.findAirportCodeByLocation(route1.getDestinationAirportCode());
		route1.setSourceAirportCode(sourceCode);
		route1.setDestinationAirportCode(destinationCode);
		Route route2 = routeService.createReturnRoute(route1);
		routeDao.save(route1);
		routeDao.save(route2);
		return new ModelAndView("index_2");
	}
	
	@GetMapping("/routes")
	public ModelAndView showRouteReportPage() {
		List<Route> routeList = routeDao.findAllRoutes();
		ModelAndView mv = new ModelAndView("routeReportPage");
		mv.addObject("routeList", routeList);
		return mv;
	}
	
}












