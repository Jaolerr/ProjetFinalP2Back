package com.inti.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="a_experienceP2")
@Data @AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"listeVilleExp", "compagnie"})
public class Experience {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_voyage;
	private String description;
	private String photo;
	private double depense;
	private double rating_moyen;
	
	@ManyToOne(targetEntity = Utilisateur.class,cascade = {CascadeType.MERGE})
	@JoinColumn(name="idu")
	private Utilisateur u;
	
	@ManyToOne(cascade ={CascadeType.MERGE} )
	@JoinColumn (name="id_ville")
	private Ville Ville;
	
	@ManyToOne(cascade ={CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH} )
	@JoinColumn(name="id_trajet")
	private Trajet trajet;
	
	@ManyToMany(cascade ={CascadeType.MERGE} )
	@JoinTable(name="a_exp_lieux")
	private List<Lieux> listeLieux;
	
	@ManyToMany(cascade ={CascadeType.MERGE} )
	@JoinTable(name="a_exp_restaurant")
	private List<Restaurant> listeResto;
	
	@ManyToMany
	@JoinTable(name="a_exp_compagnie")
	private List<Compagnie> listeCompagnie;
	
	
	public Experience(String description, String photo, double depense, double rating_moyen) {
		super();
		this.description = description;
		this.photo = photo;
		this.depense = depense;
		this.rating_moyen = rating_moyen;
	}
	
	
	private double calcul_depense(double prix_r, double prix_t, double prix_l) {
		
		return prix_r + prix_t + prix_l;
	}

}
