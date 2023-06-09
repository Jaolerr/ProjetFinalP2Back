package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="a_trajetP2")
@Data @AllArgsConstructor @NoArgsConstructor
public class Trajet {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_t;
	@ManyToOne 
	@JoinColumn(name="idVD")
	private Ville ville_depart;
	@ManyToOne 
	@JoinColumn(name="idVA")
	private Ville ville_arrivee;
	private double prix_t;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="a_trajet_compagnie")
	private List<Compagnie> listeCompagnie;
	
	@OneToMany(mappedBy = "trajet", cascade = CascadeType.MERGE)
	private List<Experience> listeExperience;
	
	
	
}
