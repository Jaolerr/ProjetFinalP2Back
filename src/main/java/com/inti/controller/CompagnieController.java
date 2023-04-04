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

import com.inti.model.Compagnie;
import com.inti.model.CompagnieAerienne;
import com.inti.model.CompagnieMaritime;
import com.inti.repository.ICompagnieRepository;
import com.inti.repository.IExperienceRepository;
import com.inti.repository.ITrajetRepository;

@RestController
@RequestMapping("compagnie")
@CrossOrigin(origins = "http://localhost:4200")
public class CompagnieController {

	@Autowired
	ICompagnieRepository icr;
	@Autowired
	ITrajetRepository itr;
	@Autowired
	IExperienceRepository ier;
	
	@GetMapping("listeCompagnie")
	public List<Compagnie> listeCompagnie()
	{
		return icr.findAll();
	}
	@PostMapping("saveCompagnieA")
	public Compagnie saveCompagnieA(@RequestBody CompagnieAerienne c )
	{		
		System.out.println(c);
		
		
		return icr.save(c);
	}
	
	@PostMapping("saveCompagnieM")
	public Compagnie saveCompagnieM(@RequestBody CompagnieMaritime c )
	{		
		
		System.out.println(c);
		
		return icr.save(c);
	}
	
	@DeleteMapping("deleteCompagnie/{id}")
	public boolean deleteCompagnie(@PathVariable("id") int id)
	{
		boolean b = false;
				icr.deleteById(id);
		try {
			icr.findById(id);
		}
		catch (Exception e) {
			b=true;
		}
		
		return b;
	}
	@PutMapping("updateCompagnie")
	public Compagnie updateCompagnie(@RequestBody Compagnie c)
	{
		return icr.save(c);
	}
	@GetMapping("compagnieIdT/{idT}")
	public List<Compagnie> getCparTrajet(@PathVariable int idT)
	{
		return itr.findById(idT).get().getListeCompagnie();
	}
	
	@GetMapping("compagnieIdE/{idE}")
	public List<Compagnie> getCparExperience(@PathVariable int idE)
	{
		return ier.findById(idE).get().getListeCompagnie();
	}
		
}
