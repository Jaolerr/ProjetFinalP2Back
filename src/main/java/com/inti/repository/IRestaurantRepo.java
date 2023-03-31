package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Restaurant;

@Repository
public interface IRestaurantRepo extends JpaRepository<Restaurant, Integer>{
	

}
