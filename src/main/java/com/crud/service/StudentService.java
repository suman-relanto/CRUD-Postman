package com.crud.service;

import java.util.List;

import com.crud.entities.Student;

public interface StudentService {
	
	public Student saveStudent(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(long id);
	
	public Student updateStudent(Student student,long id);

	public void deleteById(long id);
}
