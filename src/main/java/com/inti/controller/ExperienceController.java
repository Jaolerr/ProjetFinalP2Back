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
import com.inti.model.Utilisateur;
import com.inti.model.Ville;
import com.inti.repository.ICompagnieRepository;
import com.inti.repository.IExperienceRepository;
import com.inti.repository.IUtilisateurRepository;
import com.inti.repository.IVilleRepository;

@RestController
@RequestMapping("experience")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {
	
	@Autowired
	IExperienceRepository ier;
	@Autowired
	IVilleRepository ivr;
	@Autowired 
	ICompagnieRepository icr;
	
	@Autowired
	IUtilisateurRepository iur;
	
	@GetMapping("listeExperience")
	public List<Experience> listeExperience()
	{
		return ier.findAll();
	}
	
	@PostMapping("saveExperience")
	public Experience saveExperience(@RequestBody Experience e)
	{
		System.out.println(e);
		System.out.println(e.getU());
		
		//e.setU(iur.findById(e.getU().getId_U()).get());

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
	
	
	@GetMapping("experienceId/{id}")
	public Experience experienceId(@PathVariable("id") int id)

	{	
		System.out.println(id);
		return ier.getExperienceById(id);
	}
	
	@GetMapping("experienceIdU/{idU}")
	public List<Experience> getEparUtilisateur(@PathVariable int idU)
	{
		return ier.getExperienceByUtilisateur(idU);
	}
	@GetMapping("experienceIdV/{idV}")
	public List<Experience> getEparVille(@PathVariable int idV)
	{
		return ivr.findById(idV).get().getListExp();
	}

	@GetMapping("VilleExperience/{idE}")
	public String getVbyExp(@PathVariable int idE)
	{
		return ier.getDestiByIdExp(idE);
	}

	@GetMapping("experienceIdC/{idC}")
	public List<Experience> getEparCompagnie(@PathVariable int idC)
	{
		return icr.findById(idC).get().getListeExperience();
	}
	
	

	
}
