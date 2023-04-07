package com.inti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Entity @Table(name = "a_restaurantP2")
@Data
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_r;
	private double prix_l; 
	private String nom;
	private String adresse;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_ville")
	@Exclude
	private Ville ville;
	
	@ManyToMany(mappedBy = "listRestaurantexp")
	private List<Experience> listeExperience;
	
	
	
}
