package com.crud.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entities.Student;
import com.crud.repository.StudentRepository;
import com.crud.service.StudentService;
@Service
public class StudentImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		Student save = studentRepository.save(student);
		return save;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> findAll = studentRepository.findAll();
		return findAll.stream().collect(Collectors.toList());
	}

	@Override
	public Student getStudentById(long id) {
		Student student = studentRepository.findById(id).get();
		return student;
	}

	@Override
	public Student updateStudent(Student student, long id) {
		Student student1 = studentRepository.findById(id).get();
		student1.setName(student.getName());
		student1.setAge(student.getAge());
		student1.setMail(student.getMail());
		Student updatedStudent = studentRepository.save(student1);
		return updatedStudent;
	}

	@Override
	public void deleteById(long id) {
		Student st = studentRepository.findById(id).get();
		studentRepository.deleteById(id);
		
	}

}
