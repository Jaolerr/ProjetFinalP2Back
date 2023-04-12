package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table (name="a_lieuxP2")
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Lieux {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_L;
	private double prix_L;
	private String nom_L;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="id_ville")
	
	private Ville ville;
	
	@ManyToMany(mappedBy = "listeLieux")
	private List<Experience> listeExperience;
}
