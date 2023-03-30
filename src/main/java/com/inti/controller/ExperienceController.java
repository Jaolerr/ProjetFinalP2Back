package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
