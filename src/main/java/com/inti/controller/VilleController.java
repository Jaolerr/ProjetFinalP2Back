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


import com.inti.model.Ville;

import com.inti.repository.IVilleRepository;

@RestController
@RequestMapping("ville")
@CrossOrigin(origins = "http://localhost:4200")
public class VilleController {
	
	@Autowired
	IVilleRepository ivr;
	@GetMapping("listeVille")
	public List<Ville> listeVille()
	{
		return ivr.findAll();
	}
	
	
	@PostMapping("saveVille")
	public Ville saveVille(@RequestBody Ville v)
	{
	    Ville vSaved = ivr.save(v);
		
		return v;
	}
	
	@DeleteMapping("deleteVille/{id}")
	public void deleteArticle(@PathVariable("id_ville") int id_ville)
	{
		ivr.deleteById(id_ville);
	}
	
	@GetMapping("villeId/{id}")
	public Ville villeId(@PathVariable("id_ville") int id_ville)
	{
		return ivr.getReferenceById(id_ville);
	}
	
	

}
