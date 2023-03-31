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

import com.inti.model.Experience;
import com.inti.repository.IExperienceRepository;

@RestController
@RequestMapping("experience")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {
	
	@Autowired
	IExperienceRepository ier;
	
	@GetMapping("listeExperience")
	public List<Experience> listeExperience()
	{
		return ier.findAll();
	}
	
	@PostMapping("saveExperience")
	public Experience saveExperience(@RequestBody Experience e)
	{
		return ier.save(e);
	}
	
	@DeleteMapping("deleteExperience/{id}")
	public boolean deleteExperience (@PathVariable("id") int id)
	{
		boolean b = false;
		ier.deleteById(id);
		try {
			ier.findById(id);
		}
		catch (Exception e) {
			b=true;
		}
		
		return b;
	}
	
	@PutMapping("updateExperience")
	public Experience updateExperience (@RequestBody Experience e)
	{
		return ier.save(e);
	}
	@GetMapping("experienceIdU/{idU}")
	public List<Experience> getEparUtilisateur(@PathVariable int idU)
	{
		return ier.getExperienceByUtilisateur(idU);
	}
}
