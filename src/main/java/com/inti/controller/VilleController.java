package com.inti.controller;

import java.util.Collection;
import java.util.Collections;
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

import com.inti.model.Lieux;
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
		return ivr.save(v);
	}
	@DeleteMapping("deleteVille/{id}")
	public boolean deleteVille(@PathVariable("id")int id)
	{
		boolean b = false;
		ivr.deleteById(id);
		try {
			ivr.findById(id);
		}
		catch (Exception e) {
			b=true;
		}
		
		return b;
	}
	
	@GetMapping("top")
	public List<Ville> topVille(){
		List<Ville> lv = ivr.findAll();
		Collections.sort(lv,(o1,o2)->o1.getListGuide().size()-o2.getListGuide().size());
		return lv;	
		}
	
	@GetMapping("villeIdPays/{idPays}")
	public List<Ville> getVparPays(@PathVariable int idPays){
		
		return ivr.getVilleByPays(idPays);
			
	}
	}
	
	


