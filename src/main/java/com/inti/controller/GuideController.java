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

import com.inti.model.Guide;
import com.inti.repository.IGuideRepository;


@RestController
@RequestMapping("guide")
@CrossOrigin(origins = "http://localhost:4200")
public class GuideController {

	@Autowired
	IGuideRepository igr;
	
	@GetMapping("listeGuide")
	public List<Guide> listeGuide()
	{
		return igr.findAll();
	}
	@PostMapping("saveGuide")
	public Guide saveGuide(@RequestBody Guide g) {
		return igr.save(g);
	}
	@DeleteMapping("deleteGuide/{id}")
	public void deleteGuide(@PathVariable("id")int id)
	{
		igr.deleteById(id);
	}
	@GetMapping("guideId/{id}")
	public Guide guideId(@PathVariable("id") int id)
	{
		return igr.getReferenceById(id);
	}
	@PutMapping("updateGuide")
	public Guide updateGuide(@RequestBody Guide g)
	{
		return igr.save(g);
	}
	
}
