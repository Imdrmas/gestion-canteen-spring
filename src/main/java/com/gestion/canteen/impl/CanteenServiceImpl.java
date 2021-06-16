package com.gestion.canteen.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.canteen.dao.CanteenDao;
import com.gestion.canteen.modal.Canteen;
import com.gestion.canteen.service.CanteenService;

@Transactional
@Component
public class CanteenServiceImpl implements CanteenService {
	
	@Autowired
	CanteenDao canteenDao;

	@Override
	public Canteen addCanteen(Canteen canteen) {
		return canteenDao.save(canteen);
	}

	@Override
	public Canteen updateCanteen(Canteen canteen, long id) {
		Canteen existCanteen = canteenDao.getById(id);
		existCanteen.setOpen(canteen.getOpen());
		existCanteen.setClose(canteen.getClose());
		existCanteen.setCapacity(canteen.getCapacity());
		return canteenDao.save(existCanteen);
	}

	@Override
	public void deleteCanteen(long id) {
		canteenDao.deleteById(id);		
	}

	@Override
	public Canteen findCanteen(long id) {
		return canteenDao.findById(id).get();
	}

	@Override
	public List<Canteen> findCanteens() {
		return canteenDao.findAll();
	}

}
