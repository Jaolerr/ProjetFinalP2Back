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

@Entity
@Table(name="a_trajetP2")
@Data @AllArgsConstructor @NoArgsConstructor
public class Trajet {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_t;
	private String ville_depart;
	private String ville_arrivee;
	private double prix_t;
	
	@ManyToOne
	@JoinColumn(name="id_c")
	private Compagnie compagnie;
	
}
