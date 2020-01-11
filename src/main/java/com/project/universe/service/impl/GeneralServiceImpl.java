package com.project.universe.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.universe.model.General;
import com.project.universe.model.dto.GeneralRequestDTO;
import com.project.universe.model.dto.GeneralResponseDTO;
import com.project.universe.repository.GeneralRepository;
import com.project.universe.service.GeneralService;

@Service
public class GeneralServiceImpl implements GeneralService {

	@Autowired
	private GeneralRepository repository;

	public List<GeneralResponseDTO> getByTabela(String username) {
		return repository.findByUsername(username).stream().map(General::toDTO).collect(Collectors.toList());
	}

	public List<GeneralResponseDTO> getAll() {
		return repository.findAll().stream().map(General::toDTO).collect(Collectors.toList());
	}

	public GeneralResponseDTO insert(GeneralRequestDTO generalDto) {
		General logs = General.fromDTO(generalDto);
		return General.toDTO(repository.save(logs));
	}

	public boolean delete(long user_id) {
		repository.deleteById(user_id);
		return repository.findByUserId((int) user_id).isEmpty();
	}

}
