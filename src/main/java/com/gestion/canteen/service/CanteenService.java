package com.gestion.canteen.service;

import java.util.List;

import com.gestion.canteen.modal.Canteen;

public interface CanteenService {
	
	Canteen addCanteen(Canteen canteen);
	
	Canteen updateCanteen(Canteen canteen, long id);
	
	void deleteCanteen(long id);
	
	Canteen findCanteen(long id);
	
	List<Canteen> findCanteens();

}
