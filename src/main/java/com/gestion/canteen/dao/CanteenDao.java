package com.gestion.canteen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.canteen.modal.Canteen;

public interface CanteenDao extends JpaRepository<Canteen, Long> {

}
