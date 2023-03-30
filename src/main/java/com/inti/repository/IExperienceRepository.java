package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Experience;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Integer>{

	
}
