/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.service.impl;

import com.blog.blog.entity.User;
import com.blog.blog.repositories.UserRepository;
import com.blog.blog.service.UserService;
import java.util.List;
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
}
