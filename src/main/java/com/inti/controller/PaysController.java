package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.inti.model.Pays;

import com.inti.repository.IPaysRepository;

@RestController
@RequestMapping("pays")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PaysController {
	@Autowired
	IPaysRepository ipr;
	
	@GetMapping("listePays")
	public List<Pays> listePays()
	{
		return ipr.findAll();
	}
	
	@PostMapping("savePays")
	public Pays savePays(@RequestBody Pays p)
	{
		return ipr.save(p);
	}
	
	@DeleteMapping("deletePays/{id}")
	public void deletePays(@PathVariable("id") int id_pays)
	{
		ipr.deleteById(id_pays);
	}
	
	@GetMapping("paysId/{id}")
	public Pays PaysId(@PathVariable("id_pays") int id_pays)
	{
		return ipr.getReferenceById(id_pays);
	}

}
