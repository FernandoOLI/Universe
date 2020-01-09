package com.project.universe.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.universe.model.General;

/** Database repository interface responsible for handling operations provided for Example. */
@Repository
public interface GeneralRepository extends JpaRepository<General, Long> {

  List<General> findAll();
  
  List<General> findByUsername(String Username);

}
