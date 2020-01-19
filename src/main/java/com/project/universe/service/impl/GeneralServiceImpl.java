package com.project.universe.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public List<GeneralResponseDTO> getByUsername(String username) {
		return repository.findByUsername(username).stream().map(General::toDTO).collect(Collectors.toList());
	}
	@CachePut("general")
	public List<GeneralResponseDTO> getAll() {
		return repository.findAll().stream().map(General::toDTO).collect(Collectors.toList());
	}

	@CachePut("general")
	public ResponseEntity<String> insert(GeneralRequestDTO generalDto) {
		if (validateCreate(General.fromDTO(generalDto))) {
			General generais = General.fromDTO(generalDto);
			General.toDTO(repository.save(generais));
			return new ResponseEntity<>("Dados inseridos com sucesso!", HttpStatus.OK);
		}
		return new ResponseEntity<>("Dados já existentes!", HttpStatus.OK);
	}
	@CachePut("general")
	public ResponseEntity<String> delete(int user_id) {
		if (!repository.findByUserId(user_id).isEmpty()) {
			repository.deleteByUserId(user_id);
			return new ResponseEntity<>("Dados deletados com sucesso!", HttpStatus.OK);
		}
		return new ResponseEntity<>("Dados não existentes!", HttpStatus.OK);
	}
	
	@CachePut("general")
	public ResponseEntity<String> update(GeneralRequestDTO generalDto, int id) {
		if (!repository.findByUserId(id).isEmpty()) {
			if(id==generalDto.getuserId()) {
			General generais = General.fromDTO(generalDto);
			General.toDTO(repository.save(generais));
			return new ResponseEntity<>("Dados atualizados com sucesso!", HttpStatus.OK);
			}
			else return new ResponseEntity<>("Dados não atualizados! Id inserido diferente do dado a ser atualizado", HttpStatus.OK);
		}
		return new ResponseEntity<>("Dados não existentes!", HttpStatus.OK);
	}

	private boolean validateCreate(General general) {
		return repository.findByUserId(general.getUserId()).isEmpty();
	}
	
	
}
