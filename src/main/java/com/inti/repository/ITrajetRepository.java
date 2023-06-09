package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Trajet;

@Repository
public interface ITrajetRepository extends JpaRepository<Trajet, Integer> {

	
	@Query(value="select t.*  from intiformation_lab.a_trajetp2 t, intiformation_lab.a_compagnies c, intiformation_lab.a_experiencep2 e\r\n"
			+ "where t.id_c=c.id and e.idc=c.id and t.ville_arrivee=e.destination and e.id_voyage=id_voyage", nativeQuery = true)
	Trajet getTrajetByExp(Integer id_voyage);
	
}
