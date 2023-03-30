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

@Entity @Table (name="lieuxP2")
@Data @NoArgsConstructor @AllArgsConstructor
public class Lieux {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_l;
	private double prix_l;
	private String nom_L;
	
	@ManyToOne
	@JoinColumn(name="id_ville")
	private Ville ville;
}
