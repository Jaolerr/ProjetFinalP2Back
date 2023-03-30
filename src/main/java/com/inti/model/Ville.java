package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Table(name="a_villep2")
@Data@NoArgsConstructor@AllArgsConstructor
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ville;
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="id_pays")
	private Pays pays;
	
	public Ville(String nom) {
		super();
		this.nom = nom;
	}
	
	

}
