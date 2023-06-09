package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Experience;
import com.inti.model.Restaurant;

@Repository
public interface IRestaurantRepo extends JpaRepository<Restaurant, Integer>{
	
	@Query(value="Select * from a_restaurantp2 where a_restaurantp2.id_ville =?",nativeQuery = true)
	List<Restaurant> getRestoByVille(Integer idV);
	
	@Query(value="select * from a_experiencep2 where a_experiencep2.id_voyage=?", nativeQuery = true)
	Experience getRestaurantById(Integer id_r);
	
	

}
