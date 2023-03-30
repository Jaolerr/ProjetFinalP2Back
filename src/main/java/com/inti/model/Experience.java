package com.inti.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="a_experienceP2")
@Data @AllArgsConstructor @NoArgsConstructor
public class Experience {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_voyage;
	private String destination;
	private String description;
	private String photo;
	private double depense;
	private double rating_moyen;
	
	
	public Experience(String destination, String description, String photo, double depense, double rating_moyen) {
		super();
		this.destination = destination;
		this.description = description;
		this.photo = photo;
		this.depense = depense;
		this.rating_moyen = rating_moyen;
	}
	
	
	private double calcul_depense(double prix_r, double prix_t, double prix_l) {
		
		return prix_r + prix_t + prix_l;
	}

}
