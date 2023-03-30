package com.inti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "guideP2")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guide {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_guide;
	private String pays;
	private String ville;

	@ManyToMany
    @JoinTable(name="Utilisateur_Guide",
    joinColumns = @JoinColumn(name = "idG"), 
	inverseJoinColumns = @JoinColumn(name = "idU"))
    private List<Utilisateur> listeUtilisateur;
	
	@ManyToMany
	@JoinTable(name="Guide_Ville",
	joinColumns = @JoinColumn(name = "idG"),
	inverseJoinColumns = @JoinColumn(name = "idV"))
	private List<Ville> listeVille;
}
