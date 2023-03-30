package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Table
@Data@NoArgsConstructor@AllArgsConstructor
public class Pays {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pays;
	private String nom;
	
	public Pays(String nom) {
		super();
		this.nom = nom;
	}
	
	

}
