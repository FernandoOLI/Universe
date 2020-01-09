package com.project.universe.service;

import com.project.universe.model.dto.GeneralRequestDTO;
import com.project.universe.model.dto.GeneralResponseDTO;

/**
 * Service interface responsible for handling operations provided for Examples.
 */
public interface GeneralService {

	public GeneralResponseDTO insert(GeneralRequestDTO log);

}
