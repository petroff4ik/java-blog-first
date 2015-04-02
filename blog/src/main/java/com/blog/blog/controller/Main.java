/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.controller;

import com.blog.blog.entity.UserRole;
import com.blog.blog.service.UserService;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.apache.log4j.ConsoleAppender;
import org.slf4j.Logger;

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
	UserService us;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String printHello(ModelMap model, HttpSession session) {
		List<com.blog.blog.entity.User> lu = us.getAll();
		com.blog.blog.entity.User u = us.getByUserName("petroff");
		Set<UserRole> userRoles = u.getUserRole();
		org.apache.log4j.Logger.getRootLogger().addAppender(new ConsoleAppender());
		Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);
		logger.info("sdfsd");
		//logger.error("Error!");
		return "hello";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printMain(ModelMap model, HttpSession session) {
		model.addAttribute("message", "Client");

		return "hello";
	}
}
