package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Lieux;

@Repository
public interface ILieuxRepository extends JpaRepository<Lieux, Integer> {

}
