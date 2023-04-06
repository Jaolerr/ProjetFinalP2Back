package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Experience;


@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Integer>{

	@Query(value="Select * from a_experiencep2 where a_experiencep2.idu =?",nativeQuery = true)
	List<Experience> getExperienceByUtilisateur(Integer idu);
	
	@Query(value="select * from a_experiencep2 where a_experiencep2.id_voyage=?", nativeQuery = true)
	Experience getExperienceById(Integer id_voyage);
	

	
}
