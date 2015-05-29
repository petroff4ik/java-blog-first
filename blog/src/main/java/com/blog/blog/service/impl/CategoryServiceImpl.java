/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.service.impl;

import com.blog.blog.entity.Category;
import com.blog.blog.repositories.CategoryRepository;
import com.blog.blog.service.CategoryService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author petroff
 */
@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private CategoryRepository categoryRepository;
	
//	@Autowired
//	private ContextRepository contextRepository;

	public List<Category> getAll() {
		org.hibernate.Session session = (Session)entityManager.getDelegate();
		session.enableFilter("currentLang").setParameter("lang", "en");
		return categoryRepository.findAll();
	}
}
