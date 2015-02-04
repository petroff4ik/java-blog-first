/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.service;

import com.blog.blog.entity.User;
import java.util.List;

/**
 *
 * @author petroff
 */
public interface UserService {

	User addUser(User u);

	void delete(Integer id);

	User editUser(User u);

	List<User> getAll();
}
