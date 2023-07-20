package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.entities.Employee;

@Repository
public interface EmployeeReository extends JpaRepository<Employee, Long>, CustomRepo<Employee, String> {

}
