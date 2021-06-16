package com.gestion.canteen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.canteen.modal.Cook;

public interface CookDao extends JpaRepository<Cook, Long> {

}
