package com.gestion.canteen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.canteen.modal.Student;
import com.gestion.canteen.service.StudentService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/addStudent/{id}")
	Student addStudent(@RequestBody Student student, @PathVariable long id) {
		return studentService.addStudent(student, id);
	}
	@PutMapping("/updateStudent/{id}")
	Student updateStudent(@RequestBody Student student, @PathVariable  long id) {
		return studentService.updateStudent(student, id);
	}
	@DeleteMapping("/deleteStudent/{id}")
	void deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
	}
	@GetMapping("/findStudent/{id}")
	Student findStudent(@PathVariable long id) {
		return studentService.findStudent(id);
	}
	@GetMapping("/findStudents/{id}")
	List<Student> findStudents(@PathVariable long id) {
		return studentService.findStudents(id);
	}
}
