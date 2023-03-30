package com.inti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table (name = "UtilisateurP2")
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id_U;
	protected String nom;
	protected String prenom;
	protected String mail;
	protected String telephone;
	protected String login;
	protected String mdp;
	protected boolean abonne_nl;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Experience> listeExperience;
	
	@ManyToMany
    @JoinTable(name="Utilisateur_Guide",
    joinColumns = @JoinColumn(name = "idU"), 
	inverseJoinColumns = @JoinColumn(name = "idG"))
    private List<Guide> listeGuide;
    
}
