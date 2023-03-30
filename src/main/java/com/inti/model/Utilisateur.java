package com.inti.model;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import java.util.List;
import javax.persistence.Entity;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity @Inheritance(strategy = InheritanceType.SINGLE_TABLE) @Table(name = "a_users")
@DiscriminatorColumn(name="user_discrim",discriminatorType = DiscriminatorType.INTEGER)
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
	
	@OneToMany(mappedBy = "u")
	private List<Experience> listeExperience;
	
	@ManyToMany(mappedBy = "listeUtilisateur")
    private List<Guide> listeGuide;
    
}
