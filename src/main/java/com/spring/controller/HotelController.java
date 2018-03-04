package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Hotel;
import com.spring.model.Person;
import com.spring.service.HotelService;
/**
 * http://localhost:8080/?username=kirti
 * @author kirti gupta
 *
 */
@Controller

public class HotelController {
	 @RequestMapping("/demo")
	public String helloWorld(@RequestParam(value = "username", required = false, defaultValue = "World") String username, Model model) {
    	
	return "index";
	}
}
