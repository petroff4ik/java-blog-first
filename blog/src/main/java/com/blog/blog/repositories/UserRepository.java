/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.repositories;

import com.blog.blog.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author petroff
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
