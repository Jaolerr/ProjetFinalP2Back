package com.inti.model;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;



@Entity @Inheritance(strategy = InheritanceType.SINGLE_TABLE) @Table(name = "a_users")

@DiscriminatorColumn(name="user_discrim",discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
//@JsonIgnoreProperties({"listeExperience","listeUtilisateur"})

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
	
	@OneToMany(mappedBy = "u", cascade = CascadeType.REMOVE,orphanRemoval =true)
	@Exclude
	private List<Experience> listeExperience;
	
	@ManyToMany(mappedBy = "listeUtilisateur", cascade = CascadeType.REMOVE) 
	@Exclude
    private List<Guide> listeGuide;

	public Utilisateur(String nom, String prenom, String mail, String telephone, String login, String mdp,
			boolean abonne_nl) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.login = login;
		this.mdp = mdp;
		this.abonne_nl = abonne_nl;
	}
	
	
    
}
