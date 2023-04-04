package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Utilisateur;

@Repository
public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	
	@Query(value = "select * from a_users where a_users.login =?",nativeQuery = true )
	Utilisateur getUserbyLogin(String login);

}
