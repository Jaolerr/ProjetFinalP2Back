package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Compagnie;

@Repository
public interface ICompagnieRepository extends JpaRepository<Compagnie, Integer>{

}
