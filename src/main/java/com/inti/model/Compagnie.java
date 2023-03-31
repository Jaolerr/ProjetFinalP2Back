package com.inti.model;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Inheritance(strategy = InheritanceType.SINGLE_TABLE) @Table(name = "a_compagnies")
@DiscriminatorColumn(name="type_compagnie",discriminatorType = DiscriminatorType.INTEGER)
@JsonIgnoreProperties({"listeTrajet","experience"})
@Data @NoArgsConstructor @AllArgsConstructor
public class Compagnie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToMany(mappedBy = "listeCompagnie")
	private List<Trajet> listeTrajet;
	
	
	@OneToMany(mappedBy = "compagnie")
	private List<Experience> experience;
	
}
