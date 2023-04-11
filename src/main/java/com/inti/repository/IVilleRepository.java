package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Experience;
import com.inti.model.Ville;

@Repository
public interface IVilleRepository extends JpaRepository<Ville, Integer>{

	@Query(value="Select * from a_villep2 where a_villep2.id_pays =?",nativeQuery = true)
	List<Ville> getVilleByPays(Integer id_pays);
	
	
	
}
