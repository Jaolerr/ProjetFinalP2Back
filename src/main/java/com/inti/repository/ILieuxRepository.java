package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Lieux;


@Repository
public interface ILieuxRepository extends JpaRepository<Lieux, Integer> {

	@Query(value="Select * from a_lieuxp2 where a_lieuxp2.id_ville =?",nativeQuery = true)
	List<Lieux> getLieuxByVille(Integer idV);
	
}
