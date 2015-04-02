
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.repositories;


import com.blog.blog.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author petroff
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
	
	
}
