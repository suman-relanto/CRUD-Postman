package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entities.Employee;
import com.crud.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/create")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee saveEmployee = employeeService.savEmployee(employee);
		return new ResponseEntity<Employee>(saveEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/getalldata")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> all = employeeService.getAll();
		return new ResponseEntity<List<Employee>>(all, HttpStatus.OK);
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Employee> getById(@PathVariable long id) {
		Employee byId = employeeService.getById(id);
		return new ResponseEntity<Employee>(byId, HttpStatus.OK);
	}

	@GetMapping("/getbyname/{name}")
	public ResponseEntity<Employee> getByName(@PathVariable String name) {
		Employee byName = employeeService.getByName(name);
		return new ResponseEntity<Employee>(byName, HttpStatus.OK);
	}

	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Employee> updateById(@RequestBody Employee employee, @PathVariable long id) {
		Employee updateById = employeeService.updateById(employee, id);
		return new ResponseEntity<Employee>(updateById, HttpStatus.OK);
	}

	@PutMapping("/updatebyname/{name}")
	public ResponseEntity<Employee> updateByName(@RequestBody Employee employee, @PathVariable String name) {
		Employee byName = employeeService.updateByName(employee, name);
		return new ResponseEntity<Employee>(byName, HttpStatus.OK);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable long id) {
		employeeService.deleteById(id);
		return new ResponseEntity<String>("Id is deleted succesfully", HttpStatus.OK);
	}
}
