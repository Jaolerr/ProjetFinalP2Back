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

import org.springframework.boot.context.properties.bind.Name;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity@Table(name="a_villep2")
@Data@NoArgsConstructor@AllArgsConstructor
@JsonIgnoreProperties({"listExp","listGuide","listResto","listLieux"})
//@JsonIdentityInfo(
		  //generator = ObjectIdGenerators.PropertyGenerator.class, 
		  //property ="id_ville",scope=Ville.class)

public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ville;
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="id_pays")
	@Exclude
	private Pays pays;
	
	
	
	@ManyToMany(mappedBy = "Ville")
	@Exclude
	private List<Experience> listExp;
	
	
	@OneToMany(mappedBy ="ville" )
	@Exclude
	private List<Guide> listGuide;
	
	
	@OneToMany(mappedBy = "ville")
	@Exclude
	private List<Restaurant> listResto;
	
	
	@OneToMany(mappedBy = "ville")
	@Exclude
	private List<Lieux> listLieux;

	
	public Ville(String nom) {
		super();
		this.nom = nom;
	}
	
	

}
