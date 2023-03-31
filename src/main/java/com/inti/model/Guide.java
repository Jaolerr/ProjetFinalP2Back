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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "a_guideP2")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guide {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_guide;
	private String pays;
	

	@ManyToMany
    @JoinTable(name="a_Utilisateur_Guide",
    joinColumns = @JoinColumn(name = "idG"), 
	inverseJoinColumns = @JoinColumn(name = "idU"))
    private List<Utilisateur> listeUtilisateur;
	

	
	@ManyToOne
	@JoinColumn(name="idv")
	private Ville ville;

}
