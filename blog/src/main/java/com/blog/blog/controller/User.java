/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.controller;

import com.blog.blog.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author petroff
 */
@Controller
@RequestMapping("/user")
public class User {

	@Autowired
	UserService userService;
	
	@Value("${config.salt}") 
	private String salt;
	

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationFormShow(@ModelAttribute("user") com.blog.blog.entity.User user, ModelMap model) {
		model.addAttribute("user", user);
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@Valid @ModelAttribute("user") com.blog.blog.entity.User user, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		user.setSalt(salt);
		userService.addUser(user);
		return "registration_succeful";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String userEditProfile(@ModelAttribute("user") com.blog.blog.entity.User user, ModelMap model) {
		model.addAttribute("user", user);
		return "profile";
	}
	
	
}
