package com.gestion.canteen.service;

import java.util.List;

import com.gestion.canteen.modal.Student;

public interface StudentService {
	
	Student addStudent(Student student, long id);
	
	Student updateStudent(Student student, long id);
	
	void deleteStudent(long id);
	
	Student findStudent(long id);
	
	List<Student> findStudents(long id);

}
