package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Compagnie;


@Repository
public interface ICompagnieRepository extends JpaRepository<Compagnie, Integer>{

	@Query(value="select c.*  from intiformation_lab.a_compagnies c, intiformation_lab.a_experiencep2 e\r\n"
			+ "where e.idc=c.id and e.id_voyage=idE", nativeQuery = true)
	Compagnie getCompagnieByExp(Integer idE);
}
