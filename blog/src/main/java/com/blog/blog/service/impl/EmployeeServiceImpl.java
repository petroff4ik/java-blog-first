/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.service.impl;

import com.blog.blog.entity.Employee;
import com.blog.blog.repositories.EmployeeRepository;
import com.blog.blog.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author petroff
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.saveAndFlush(employee);

		return savedEmployee;
	}

	@Override
	public void delete(Integer id) {
		employeeRepository.delete(id);
	}

	@Override
	public Employee getByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public Employee editEmployee(Employee bank) {
		return employeeRepository.saveAndFlush(bank);
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
}
