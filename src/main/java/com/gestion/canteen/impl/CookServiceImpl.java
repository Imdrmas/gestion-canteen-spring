package com.gestion.canteen.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.canteen.dao.CanteenDao;
import com.gestion.canteen.dao.CookDao;
import com.gestion.canteen.modal.Canteen;
import com.gestion.canteen.modal.Cook;
import com.gestion.canteen.service.CookService;

@Transactional
@Component
public class CookServiceImpl implements CookService {

	@Autowired
	CanteenDao canteenDao;
	
	@Autowired
	CookDao cookDao;

	@Override
	public Cook addCook(Cook cook, long id) {
		Canteen canteen = canteenDao.getById(id);
		canteen.addCook(cook);
		return cookDao.save(cook);
	}

	@Override
	public Cook updateCook(Cook cook, long id) {
		Cook existCook = cookDao.getById(id);
		existCook.setFirstname(cook.getFirstname());
		existCook.setLastname(cook.getLastname());
		return cookDao.save(existCook);
	}

	@Override
	public void deleteCook(long id) {
		cookDao.deleteById(id);
	}

	@Override
	public Cook findCook(long id) {
		return cookDao.findById(id).get();
	}

	@Override
	public List<Cook> findCooks(long id) {
		Canteen canteen = canteenDao.getById(id);
		return canteen.getCooks();
	}
}
