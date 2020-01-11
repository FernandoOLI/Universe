package com.project.universe.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.project.universe.model.dto.GeneralRequestDTO;
import com.project.universe.model.dto.GeneralResponseDTO;
import com.project.universe.service.GeneralService;
import com.project.universe.service.impl.GeneralServiceImpl;

@RestController
@Transactional
@RequestMapping(path = "/general")
public class GeneralController {

	@Autowired
	private GeneralServiceImpl generalServiceImpl;
	@Autowired
	private GeneralService generalService;

	@GetMapping(value = "/values")
	public ResponseEntity<List<GeneralResponseDTO>> listar() throws SQLException {
		List<GeneralResponseDTO> produtos = generalServiceImpl.getAll();
		return ResponseEntity.ok().body(produtos);
	}

	@PostMapping(path = "/save")
	public ResponseEntity<String> Save(@RequestBody GeneralRequestDTO general) {
		System.out.println(general.getUsername());
		return generalService.insert(general);

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		return generalServiceImpl.delete(id);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<String> update(@RequestBody GeneralRequestDTO general,@PathVariable int id) {
		return generalServiceImpl.update(general,id);
	}

}
