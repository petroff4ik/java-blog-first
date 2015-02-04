/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.service;

import com.blog.blog.entity.Employee;
import java.util.List;

/**
 *
 * @author petroff
 */
public interface EmployeeService {

	Employee addEmployee(Employee e);

	void delete(Integer id);

	Employee getByName(String name);

	Employee editEmployee(Employee e);

	List<Employee> getAll();
}
