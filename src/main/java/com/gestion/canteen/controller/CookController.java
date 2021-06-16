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

import com.gestion.canteen.modal.Cook;
import com.gestion.canteen.service.CookService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CookController {

	@Autowired
	CookService cookService;	

	@PostMapping("/addCook/{id}")
	Cook addCook(@RequestBody Cook cook, @PathVariable long id) {
		return cookService.addCook(cook, id);
	}
	
	@PutMapping("/updateCook/{id}")
	Cook updateCook(@RequestBody Cook cook, @PathVariable long id) {
		return cookService.updateCook(cook, id);
	}
	@DeleteMapping("/deleteCook/{id}")
	void deleteCook(@PathVariable long id) {
		cookService.deleteCook(id);
	}
	@GetMapping("/findCook/{id}")
	Cook findCook(@PathVariable long id) {
		return cookService.findCook(id);
	}
	@GetMapping("/findCooks/{id}")
	List<Cook> findCooks(@PathVariable long id) {
		return cookService.findCooks(id);
	}
}
