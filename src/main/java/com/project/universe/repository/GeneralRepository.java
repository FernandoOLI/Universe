package com.project.universe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.universe.model.General;

@Repository
public interface GeneralRepository extends JpaRepository<General, Long> {

	List<General> findAll();

	List<General> findByUsername(String Username);
	
	@Query("select e from General e where user_id = 1")
	List<General> find();

}
