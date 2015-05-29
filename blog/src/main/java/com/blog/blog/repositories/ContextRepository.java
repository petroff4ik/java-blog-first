
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.repositories;

import com.blog.blog.entity.Context;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author petroff
 */
public interface ContextRepository extends JpaRepository<Context, Integer> {
	
}
