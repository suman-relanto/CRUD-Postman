package com.crud.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entities.Employee;
import com.crud.repository.EmployeeReository;
import com.crud.service.EmployeeService;

@Service
public class EmployeeImpl implements EmployeeService {
	@Autowired
	private EmployeeReository employeeReository;

	@Override
	public Employee savEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee save = employeeReository.save(employee);
		return save;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		List<Employee> findAll = employeeReository.findAll();
		return findAll.stream().collect(Collectors.toList());
	}

	@Override
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		Employee employee = employeeReository.findById(id).get();
		return employee;
	}

	@Override
	public Employee getByName(String name) {
		// TODO Auto-generated method stub
		Employee findByName = employeeReository.findByName(name);
		return findByName;
	}

	@Override
	public Employee updateById(Employee employee, long id) {
		// TODO Auto-generated method stub
		Employee employee2 = employeeReository.findById(id).get();
		employee2.setName(employee.getName());
		employee2.setAge(employee.getAge());
		employee2.setSalary(employee.getSalary());
		Employee save = employeeReository.save(employee2);
		return save;
	}

	@Override
	public Employee updateByName(Employee employee, String name) {
		// TODO Auto-generated method stub
		Employee findByName = employeeReository.findByName(name);
		findByName.setAge(employee.getAge());
		findByName.setName(employee.getName());
		findByName.setSalary(employee.getSalary());
		Employee save = employeeReository.save(findByName);
		return save;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		employeeReository.deleteById(id);

	}

}
