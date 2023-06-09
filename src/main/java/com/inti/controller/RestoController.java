package com.inti.controller;

import java.util.Collection;
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

import com.inti.model.Experience;
import com.inti.model.Restaurant;
import com.inti.repository.IRestaurantRepo;

@RestController
@RequestMapping("restaurants")
@CrossOrigin(origins = "http://localhost:4200")
public class RestoController {
	
	@Autowired IRestaurantRepo irr;
	
	@GetMapping("afficher")
	public List<Restaurant> afficher(){
		
		return irr.findAll();
		
		
	}
	
	@PostMapping("save")
	public Restaurant save(@RequestBody Restaurant r) {
		return irr.save(r);
	}
	
	@PutMapping("update")
	public Restaurant update(@RequestBody Restaurant r) {
		
		return irr.save(r);
	}
	
	@DeleteMapping("delete/{id}")
	public boolean delete(@PathVariable("id") int id) {
		
		Boolean b=false;
		irr.deleteById(id);
		try {
			irr.findById(id);
		}
		catch (Exception e) {
			b=true;
		}
		
		return b;
	}
	

	@GetMapping("restaurantId/{id}")
	public Experience experienceId(@PathVariable("id") int id)
	{	
		System.out.println(id);
		return irr.getRestaurantById(id);
	}
	
	
	@GetMapping("rechercher/{idVille}")
	public List<Restaurant> getRparVille(@PathVariable int idVille){
		
		return irr.getRestoByVille(idVille);
		
	}

}
