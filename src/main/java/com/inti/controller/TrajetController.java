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


import com.inti.model.Trajet;
import com.inti.repository.ICompagnieRepository;
import com.inti.repository.ITrajetRepository;

@RestController
@RequestMapping("trajet")
@CrossOrigin(origins = "http://localhost:4200")
public class TrajetController {

	@Autowired
	ITrajetRepository itr;
	@Autowired 
	ICompagnieRepository icr;
	
	@GetMapping("listeTrajet")
	public List<Trajet> listeTrajet()
	{
		return itr.findAll();
	}
	@PostMapping("saveTrajet")
	public Trajet saveTrajet (@RequestBody Trajet t)
	{
		
		System.out.println(t);
		return itr.save(t);
	}
	@DeleteMapping("deleteTrajet/{id}")
	public boolean deleteTrajet (@PathVariable("id") int id)
	{
		boolean b = false;
		itr.deleteById(id);
		try {
			itr.findById(id);
		}
		catch (Exception e) {
			b=true;
		}
		
		return b;
	}
	@PutMapping("updateTrajet")
	public Trajet updateTrajet(@RequestBody Trajet t)
	{
		return itr.save(t);
	}
	@GetMapping("trajetIdC/{idC}")
	public List<Trajet> getTparCompagnie(@PathVariable int idC)
	{
		return icr.findById(idC).get().getListeTrajet();
	}
	
	@GetMapping("trajetParExp/{id_voyage}")
	public Trajet getTrajetByExp(@PathVariable int id_voyage)
	{
		return itr.getTrajetByExp(id_voyage);
	}
	
	
}
