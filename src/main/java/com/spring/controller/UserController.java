package com.spring.controller;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.User;
import com.spring.service.PersonService;
/**
 * https://github.com/kishanjavatrainer/SpringMVCDataBindingWebApp/tree/master/SpringMVCDataBindingWebApp
 * binding result
 * https://github.com/kishanjavatrainer/SpringMVCExcepHandlingWebApp_1/blob/master/SpringMVCExcepHandlingWebApp_1/src/com/infotech/controller/MyController.java
 * @author GuptaK1
 *
 */
@Controller
public class UserController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public String registerPage()
	{
		return "register";
	}
	
	
	
	
@RequestMapping(value="/registerSuccess",method=RequestMethod.POST)
	public String submitPage(@Valid @ModelAttribute("user") User user)
	{

		/*if(user.getName().isEmpty())
		{
			throw new RuntimeException();
		}*/
		personService.createUser(user);
		return "redirect:/showListOfUser" ;
		
	}
	
/*	@ExceptionHandler(value=RuntimeException.class)
	public String exceptionHanlder(){
		return "RuntimeException";
	} */
	
	@RequestMapping(value="/showListOfUser",method= RequestMethod.GET)
	public ModelAndView showListOfUser(ModelAndView modelAndView)
	{	modelAndView.setViewName("userList");
		List<User> userList = personService.getUserList();
		modelAndView.addObject("userList",userList);
		return modelAndView;
		
	}
	/*@RequestMapping(value="/registerSuccess",method=RequestMethod.POST)
	public String submitPage(@RequestParam("name") String userName,@RequestParam("country") String country,@RequestParam(required=false,name="email") String email,@RequestParam(name="age") int age)
	{
//		if(bindingResult.hasErrors())
//		{
//			return "register";
//		}
		User user = new User(userName, age, email, country);
		personService.createUser(user);
		return "redirect:/showListOfUser" ;
		
	}*/
}