/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.service.impl;

import com.blog.blog.entity.User;
import com.blog.blog.repositories.UserRepository;
import com.blog.blog.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author petroff
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User addUser(User u) {
		User savedUser = userRepository.saveAndFlush(u);
		return savedUser;
	}

	@Override
	public void delete(Integer id) {
		userRepository.delete(id);
	}

	@Override
	public User editUser(User u) {
		return userRepository.saveAndFlush(u);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getByUserName(String name) {
		return userRepository.findByUserName(name);
	}
//	@Override
//	public User getByUserName(String username) {
//
//		List<User> users = new ArrayList<User>();
//
//		users = entityManager
//				.createQuery("from User where username = :username",  User.class)
//				.setParameter("username", username).getResultList();
//
//		if (users.size() > 0) {
//			return users.get(0);
//		} else {
//			return null;
//		}
//	}
}
