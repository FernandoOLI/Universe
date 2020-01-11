package com.project.universe.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.project.universe.model.dto.GeneralRequestDTO;
import com.project.universe.model.dto.GeneralResponseDTO;
import com.project.universe.service.GeneralService;
import com.project.universe.service.impl.GeneralServiceImpl;

/** Controller responsible for handling Example operations. */
@RestController
@RequestMapping(path = "/general")
public class GeneralController {

//  @Autowired private TabelaServiceImpl tabelaService;
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
	public boolean Save(@RequestBody GeneralRequestDTO general) {
		System.out.println(general.getUsername());
		generalService.insert(general);
		return true;
	}

	@DeleteMapping(value = { "/delete/{user_id}" })
	public ResponseEntity<Boolean> delete(@PathVariable int user_id) {
		generalServiceImpl.delete(user_id);
		return ResponseEntity.ok().body(true);
	}

}
