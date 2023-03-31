package com.inti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


import javax.persistence.JoinTable;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Table(name="a_villep2")
@Data@NoArgsConstructor@AllArgsConstructor
@JsonIgnoreProperties({"pays","listExp","listGuide","listResto","listLieux"})
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ville;
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="id_pays")
	private Pays pays;
	
	
	
	@ManyToMany(mappedBy = "listVilleExp")
	private List<Experience> listExp;
	
	
	@OneToMany(mappedBy ="ville" )
	private List<Guide> listGuide;
	
	
	@OneToMany(mappedBy = "ville")
	private List<Restaurant> listResto;
	
	
	@OneToMany(mappedBy = "ville")
	private List<Lieux> listLieux;

	
	public Ville(String nom) {
		super();
		this.nom = nom;
	}
	
	

}
