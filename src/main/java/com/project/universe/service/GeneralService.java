package com.project.universe.service;

import org.springframework.http.ResponseEntity;

import com.project.universe.model.dto.GeneralRequestDTO;

/**
 * Service interface responsible for handling operations provided for Examples.
 */
public interface GeneralService {

	public ResponseEntity<String> insert(GeneralRequestDTO general);

}
