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
import org.springframework.web.bind.annotation.RestController;

import com.crud.entities.Student;
import com.crud.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentContoller {
	@Autowired
	private StudentService studentService;

// To save the data
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student saveStudent = studentService.saveStudent(student);
		return new ResponseEntity<Student>(saveStudent, HttpStatus.CREATED);
	}

//To get all the data
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> allStudents = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
	}

//To get the data by id
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id) {
		Student studentById = studentService.getStudentById(id);
		return new ResponseEntity<Student>(studentById, HttpStatus.OK);
	}

//To update the data 
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudentByID(@RequestBody Student student, @PathVariable long id) {
		Student updateStudent = studentService.updateStudent(student, id);
		return new ResponseEntity<Student>(updateStudent, HttpStatus.OK);
	}

//To delete the data
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable long id) {
		studentService.deleteById(id);
		return new ResponseEntity<String>("Student data deleted Successfully", HttpStatus.OK);
	}
}
