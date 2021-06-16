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

import com.gestion.canteen.modal.Canteen;
import com.gestion.canteen.service.CanteenService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CanteenController {

	@Autowired
	CanteenService canteenService;
	
	@PostMapping("/addCanteen")
	Canteen addCanteen(@RequestBody Canteen canteen) {
		return canteenService.addCanteen(canteen);
	}
	
	@PutMapping("/updateCanteen/{id}")
	Canteen updateCanteen(@RequestBody Canteen canteen, @PathVariable long id) {
		return canteenService.updateCanteen(canteen, id);
	}
	
	@DeleteMapping("/deleteCanteen/{id}")
	void deleteCanteen(@PathVariable long id) {
		canteenService.deleteCanteen(id);
	}
	
	@GetMapping("/findCanteen/{id}")
	Canteen findCanteen(@PathVariable long id) {
		return canteenService.findCanteen(id);
	}
	
	@GetMapping("/findCanteens")
	List<Canteen> findCanteens() {
		return canteenService.findCanteens();
	}
}
