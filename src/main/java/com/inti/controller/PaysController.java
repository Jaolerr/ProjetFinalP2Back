package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Pays;
import com.inti.repository.IPaysRepository;

@RestController
@RequestMapping("pays")
public class PaysController {
	
	@Autowired
	IPaysRepository ipr;
	
	@GetMapping("all")
	public List<Pays> getAllPays(){
		
		return ipr.findAll();
	}

}
