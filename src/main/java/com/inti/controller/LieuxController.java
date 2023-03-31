package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.inti.model.Lieux;
import com.inti.repository.ILieuxRepository;


public class LieuxController {

	@Autowired
	ILieuxRepository ilr;
	
	@GetMapping("listeLieux")
	public List<Lieux> listeLieux() {
		return ilr.findAll();
	}
	@PostMapping("saveUtilisateur")
	public Lieux saveLieux (@RequestBody Lieux l ) {
		return ilr.save(l);
	}
	@DeleteMapping("deleteLieux/{id}")
	public boolean deleteLieux(@PathVariable("id")int id)
	{
		boolean b = false;
		ilr.deleteById(id);
		try {
			ilr.findById(id);
		}
		catch (Exception e) {
			b=true;
		}
		
		return b;
	}
	@GetMapping("lieuxId/{id}")
	public Lieux lieuxId(@PathVariable("id") int id)
	{
		return ilr.getReferenceById(id);
	}
	@PutMapping("updateLieux")
	public Lieux updateLieux(@RequestBody Lieux l)
	{
		return ilr.save(l);
	}
}
