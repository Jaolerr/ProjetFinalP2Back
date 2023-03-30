package com.inti.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@DiscriminatorValue("1")
@Data @NoArgsConstructor @AllArgsConstructor
public class Administrateur extends Utilisateur {

	
	private int id_A;
}
