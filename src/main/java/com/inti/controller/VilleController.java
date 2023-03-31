package com.inti.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("topVille")
	public List<Ville> topVille(){
		List<Ville> lv = ivr.findAll();
		Collections.sort(lv,(o1,o2)->o1.getListGuide().size()-o2.getListGuide().size());
		return lv;
		
			
		}
			
	
	}
	
	


