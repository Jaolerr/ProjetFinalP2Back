package com.inti.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name="Compagnieaeriennep2")
@Data @NoArgsConstructor @AllArgsConstructor
public class CompagnieAerienne extends Compagnie {
	
	
	protected int id_ca;
	
	
}
