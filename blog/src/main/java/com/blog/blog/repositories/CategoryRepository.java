
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.repositories;

import com.blog.blog.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author petroff
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
