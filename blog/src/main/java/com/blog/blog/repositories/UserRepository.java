
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.repositories;

import com.blog.blog.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author petroff
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select b from  User as b where b.username = :username")
	User findByUserName(@Param("username") String name);
	
}
