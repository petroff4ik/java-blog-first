/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.controller;

import com.blog.blog.service.EmployeeService;
import com.blog.blog.service.UserService;
import com.blog.blog.service.impl.UserServiceImpl;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author petroff
 */
@Controller
public class Main {
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String printHello(ModelMap model, HttpSession session) {
		UserService us = new UserServiceImpl();

		return "hello";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printMain(ModelMap model, HttpSession session) {
		model.addAttribute("message", "Client");
		return "hello";
	}
}
