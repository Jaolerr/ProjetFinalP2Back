package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Trajet;

@Repository
public interface ITrajetRepository extends JpaRepository<Trajet, Integer> {

}
