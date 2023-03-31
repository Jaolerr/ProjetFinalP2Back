package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Guide;


@Repository
public interface IGuideRepository extends JpaRepository<Guide, Integer> {
	@Query(value="select * from a_guidep2 where id_guide in (select idg from a_utilisateur_guide where idu=?)",nativeQuery = true)
	List<Guide> afficherGuide(Integer idU);
		
	

	@Query(value="Select * from a_guidep2 where a_guidep2.idv =?",nativeQuery = true)
	List<Guide> getGuideByVille(Integer idV);
	
}
