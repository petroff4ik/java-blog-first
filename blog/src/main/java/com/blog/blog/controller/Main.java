/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.controller;

import com.blog.blog.entity.Employee;
import com.blog.blog.service.EmployeeService;
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
		Employee e = new Employee();
		e.setFirstName("andrey");
		e.setLastName("petroff");
		e.setDept("sd");
		employeeService.addEmployee(e);
		model.addAttribute("message", "Client");
		return "hello";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printMain(ModelMap model, HttpSession session) {
		model.addAttribute("message", "Client");
		return "hello";
	}
}
