/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.controller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author petroff
 */
@Controller
public class Auth {

	@Autowired
	private MessageSource messageSource;

	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Locale locale,HttpServletRequest request,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			String msg = messageSource.getMessage("login.fail", null, locale);
			model.addObject("error", msg);
		}

		if (logout != null) {
			//request.logout();
			String msg = messageSource.getMessage("logout.done", null, locale);
			model.addObject("msg", msg);
		}
		model.setViewName("login");

		return model;

	}
	

}
