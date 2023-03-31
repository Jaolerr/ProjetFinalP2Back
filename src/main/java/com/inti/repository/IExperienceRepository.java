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
	
	@Query(value="Select * from a_experiencep2 where a_experiencep2.id_voyage in (select list_exp_id_voyage from a_exp_ville where list_ville_exp_id_ville=?)",nativeQuery = true)
	List<Experience> getExperienceByVille(Integer list_ville_exp_id_ville);
}
