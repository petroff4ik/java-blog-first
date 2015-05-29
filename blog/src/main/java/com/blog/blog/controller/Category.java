/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.controller;

import com.blog.blog.service.CategoryService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Autowired
	CategoryService categoryService;
	@Value("#{'${lang}'.split(',')}")
	private List<String> langs;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String CategoryM(ModelMap model, HttpSession session) {
		model.addAttribute("message", "Client");
		List<com.blog.blog.entity.Category> categories = categoryService.getAll();
		com.blog.blog.entity.Category category = categories.get(0);

		org.apache.log4j.Logger.getRootLogger().addAppender(new ConsoleAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN)));
		Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
		logger.info(category.getEnable());
		logger.info(category.getContext().getText());
		return "category/category";
	}

	@RequestMapping(value = "/category/create", method = RequestMethod.GET)
	public String CategoryCreate(ModelMap model, HttpSession session) {
		model.addAttribute("langs", langs);
		return "category/create";
	}
}
