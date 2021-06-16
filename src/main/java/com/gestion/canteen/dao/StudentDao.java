package com.gestion.canteen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.canteen.modal.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}
