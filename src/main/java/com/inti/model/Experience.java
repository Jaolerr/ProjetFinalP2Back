package com.inti.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="a_experienceP2")
@Data @AllArgsConstructor @NoArgsConstructor
public class Experience {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_voyage;
	private String destination;
	private String description;
	private String photo;
	private double depense;
	private double rating_moyen;
	
	@ManyToOne(targetEntity = Utilisateur.class)
	@JoinColumn(name="idu")
	private Utilisateur u;
	
	@ManyToMany
	@JoinTable(name="a_exp_ville")
	private List<Ville> listVilleExp;
	
	@ManyToOne(targetEntity = Compagnie.class)
	@JoinColumn(name="idc")
	private Compagnie compagnie;
	
	public Experience(String destination, String description, String photo, double depense, double rating_moyen) {
		super();
		this.destination = destination;
		this.description = description;
		this.photo = photo;
		this.depense = depense;
		this.rating_moyen = rating_moyen;
	}
	
	
	private double calcul_depense(double prix_r, double prix_t, double prix_l) {
		
		return prix_r + prix_t + prix_l;
	}

}
