package com.crud.repository;

public interface CustomRepo<Employee, String> {
	public Employee findByName(String name);
}
