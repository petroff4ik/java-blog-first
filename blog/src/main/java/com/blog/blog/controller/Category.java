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
public class Category {

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String CategoryM(ModelMap model, HttpSession session) {
		model.addAttribute("message", "Client");

		return "category";
	}
}
