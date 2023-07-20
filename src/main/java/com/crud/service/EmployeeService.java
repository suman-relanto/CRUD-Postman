package com.crud.service;

import java.util.List;

import com.crud.entities.Employee;

public interface EmployeeService {
	public Employee savEmployee(Employee employee);

	public List<Employee> getAll();

	public Employee getById(long id);

	public Employee getByName(String name);

	public Employee updateById(Employee employee, long id);

	public Employee updateByName(Employee employee, String name);

	public void deleteById(long id);
}
