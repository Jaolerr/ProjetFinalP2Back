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

import com.inti.model.Lieux;

import com.inti.repository.ILieuxRepository;

@RestController
@RequestMapping("lieux")
@CrossOrigin(origins = "http://localhost:4200")
public class LieuxController {

	@Autowired
	ILieuxRepository ilr;
	
	@GetMapping("listeLieux")
	public List<Lieux> listeLieux() {
		return ilr.findAll();
	}
	@PostMapping("saveLieux")
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
	@GetMapping("lieuxIdVille/{idVille}")
	public List<Lieux> getLparVille(@PathVariable int idVille){
		
		return ilr.getLieuxByVille(idVille);
	}
	@PutMapping("updateLieux")
	public Lieux updateLieux(@RequestBody Lieux l)
	{
		return ilr.save(l);
	}
	
}
