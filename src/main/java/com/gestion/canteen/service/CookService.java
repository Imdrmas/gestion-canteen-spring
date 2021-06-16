package com.gestion.canteen.service;

import java.util.List;

import com.gestion.canteen.modal.Cook;

public interface CookService {

	Cook addCook(Cook cook, long id);
	
	Cook updateCook(Cook cook, long id);
	
	void deleteCook(long id);
	
	Cook findCook(long id);
	
	List<Cook> findCooks(long id);
}
