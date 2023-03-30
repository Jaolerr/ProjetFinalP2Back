package com.inti.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@DiscriminatorValue("0")
@Data @NoArgsConstructor 
public class CompagnieMaritime extends Compagnie {


	
	
	
	
}
