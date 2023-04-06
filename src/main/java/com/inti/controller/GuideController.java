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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Guide;
import com.inti.model.Ville;
import com.inti.repository.IGuideRepository;
import com.inti.repository.IUtilisateurRepository;
import com.inti.repository.IVilleRepository;

@RestController
@RequestMapping("guide")
@CrossOrigin(origins = "http://localhost:4200")
public class GuideController {

	@Autowired
	IGuideRepository igr;
	@Autowired
	IUtilisateurRepository iur;
	@Autowired
	IVilleRepository ivr;

	@GetMapping("listeGuide")
	public List<Guide> listeGuide() {
		return igr.findAll();
	}

	@PostMapping("saveGuide")
	public Guide saveGuide(@RequestBody Guide g) {
//		System.out.println(g.getVille().getId_ville());
		
		return igr.save(g);
	}

	@DeleteMapping("deleteGuide/{id}")
	public void deleteGuide(@PathVariable("id") int id) {
		igr.deleteById(id);
	}

	@GetMapping("guideIdVille/{idVille}")
	public List<Guide> getGparVille(@PathVariable int idVille){
		
		return igr.getGuideByVille(idVille);
	}

	@PutMapping("updateGuide")
	public Guide updateGuide(@RequestBody Guide g) {
		return igr.save(g);
	}

	
	@GetMapping("findbyuser/{idU}")
	public List<Guide> getGuideFromUser(@PathVariable Integer idU) {
		
		return iur.findById(idU).get().getListeGuide();
	}

}
