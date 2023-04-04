package com.inti.controller;

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

import com.inti.model.Pays;
import com.inti.repository.IPaysRepository;

@RestController
@RequestMapping("pays")
@CrossOrigin(origins = "http://localhost:4200")
public class PaysController {
	
	@Autowired
	IPaysRepository ipr;
	
	@GetMapping("all")
	public List<Pays> getAllPays(){
		
		return ipr.findAll();
	}
	@PostMapping("savePays")
	public Pays savePays(@RequestBody Pays p)
	{
		return ipr.save(p);
	}
	@DeleteMapping("deletePays/{id}")
	public boolean deletePays (@PathVariable("id")int id)
	{
		boolean b = false;
		ipr.deleteById(id);
		try {
			ipr.findById(id);
		}
		catch (Exception e) {
			b=true;
		}
		
		return b;
	}
	@PutMapping("updatePays")
	public Pays updatePays (@RequestBody Pays p)
	{
		return ipr.save(p);
	}
	


}
