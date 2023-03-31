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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity
@Table(name = "a_guideP2")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property ="id_guide")

public class Guide {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_guide;
	private String pays;
	

	@ManyToMany
    @JoinTable(name="a_Utilisateur_Guide",
    joinColumns = @JoinColumn(name = "idG"), 
	inverseJoinColumns = @JoinColumn(name = "idU"))
	@Exclude
    private List<Utilisateur> listeUtilisateur;
	

	
	@ManyToOne
	@JoinColumn(name="idv")
	@Exclude
	private Ville ville;

}
