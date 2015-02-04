/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.repositories;

import com.blog.blog.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author petroff
 */

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select b from  Employee as b where b.firstName = :firstName")
	Employee findByName(@Param("firstName") String name);

}
