package com.aeroBlasters.flightManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.aeroBlasters.flightManagementSystem.bean.flightUser;
import com.aeroBlasters.flightManagementSystem.service.FlightUserService;


@Controller
public class LoginController {
	
	@Autowired
	private FlightUserService service;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@GetMapping("/register")
	public ModelAndView showUserRegisterPage() {
		flightUser user=new flightUser();
		ModelAndView mv=new ModelAndView("newUserEntry");
		mv.addObject("userRecord", user);
		return mv;
	}
	

	@GetMapping("/loginpage")
	public ModelAndView showloginPage() {
		
		return new ModelAndView("loginPage");
	}

	
	@GetMapping("/loginErrorPage")
	public ModelAndView showloginErrorPage() {
		return new ModelAndView("loginErrorPage");
	}

	@GetMapping("/index")
	public ModelAndView showIndexPage() {
		return new ModelAndView("index");
	}
	
	@PostMapping("/register")
	public ModelAndView saveUserRegistrationPage(@ModelAttribute("userRecord") flightUser user) {
		String encodedPassword = bCrypt.encode(user.getPassword()); // encryptes the password
		flightUser newUser=new flightUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encodedPassword);
        newUser.setType(user.getType());
         service.save(newUser);
		return new ModelAndView("loginPage");
	}

	
}
