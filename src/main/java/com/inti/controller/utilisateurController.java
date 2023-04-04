package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Utilisateur;
import com.inti.repository.IUtilisateurRepository;

@RestController
@RequestMapping("utilisateur")
@CrossOrigin(origins = "http://localhost:4200")
public class utilisateurController {

	@Autowired
	IUtilisateurRepository iur;
	
	@GetMapping("listeUtilisateur")
	public List<Utilisateur> listeUtilisateur() {
		return iur.findAll();
	}
	@PostMapping("saveUtilisateur")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur u ) { 		//requestbody: comme le modeleAttribute
		return iur.save(u);
	}
	
	@DeleteMapping("deleteUtilisateur/{id}")
	public void deleteUtilisateur(@PathVariable("id")int id)
	{
		iur.deleteById(id);
	}
	@GetMapping("utilisateurId/{id}")
	public Utilisateur utilisateurId(@PathVariable("id") int id)
	{
		return iur.getReferenceById(id);
	}
	@PutMapping("updateUtilisateur")
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur u)
	{
		return iur.save(u);
	}
}
