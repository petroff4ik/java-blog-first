/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.service.impl;

import com.blog.blog.entity.User;
import com.blog.blog.entity.UserRole;
import com.blog.blog.repositories.UserRepository;
import com.blog.blog.repositories.UserRoleRepository;
import com.blog.blog.service.UserService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author petroff
 */
@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {

	enum Role {

		ROLE_USER, ROLE_ADMIN
	}
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@PersistenceContext
	private EntityManager entityManager;
	@Value("${config.salt}")
	private String salt;//not neseary

	@Override
	public User addUser(User u) {
		String password = u.getPassword();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		u.setPassword(encodedPassword);
		User savedUser = userRepository.saveAndFlush(u);
		UserRole ur = new UserRole();
		ur.setRole(Role.ROLE_USER.toString());
		ur.setUser(u);
		userRoleRepository.saveAndFlush(ur);
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
		User u = userRepository.findByUserName(name);
		if (u != null) {
			Hibernate.initialize(u.getUserRole());
		}
		return u;
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
