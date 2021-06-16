package com.gestion.canteen.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.canteen.dao.MealDao;
import com.gestion.canteen.dao.StudentDao;
import com.gestion.canteen.modal.Meal;
import com.gestion.canteen.modal.Student;
import com.gestion.canteen.service.StudentService;

@Transactional
@Component
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	MealDao mealDao;

	@Override
	public Student addStudent(Student student, long id) {
        Meal meal = mealDao.findById(id).get();
		student.setAddedAt(new Date());
		meal.addStudent(student);
		return studentDao.save(student);
	}

	@Override
	public Student updateStudent(Student student, long id) {
		Student existudent = studentDao.getById(id);
		existudent.setFirstname(student.getFirstname());
		existudent.setLastname(student.getLastname());
		return studentDao.save(existudent);
	}

	@Override
	public void deleteStudent(long id) {
		studentDao.deleteById(id);
	}

	@Override
	public Student findStudent(long id) {
		return studentDao.findById(id).get();
	}

	@Override
	public List<Student> findStudents(long id) {
		Meal meal = mealDao.findById(id).get();
		return meal.getStudents();
	}

}
