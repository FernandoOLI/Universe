package com.project.universe.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.universe.model.dto.GeneralResponseDTO;
import com.project.universe.service.impl.GeneralServiceImpl;

/** Controller responsible for handling Example operations. */
@RestController
@RequestMapping("/general")
public class GeneralController {

//  @Autowired private TabelaServiceImpl tabelaService;
	@Autowired private GeneralServiceImpl generalServiceImpl;

//  @GetMapping(value = "")
//  public ResponseEntity<List<TabelaResponseDTO>> listarValoresProduto() throws SQLException {
//    List<TabelaResponseDTO> produtos = tabelaService.getAll();
//    return ResponseEntity.ok().body(produtos);
//  }

	@GetMapping(value = "/values")
	public ResponseEntity<List<GeneralResponseDTO>> listar() throws SQLException {
		List<GeneralResponseDTO> produtos = generalServiceImpl.getAll();
		return ResponseEntity.ok().body(produtos);
	}
	
	@GetMapping(value = "/get")
	public ResponseEntity<List<GeneralResponseDTO>> listarAll() throws SQLException {
		List<GeneralResponseDTO> produtos = generalServiceImpl.getAll();
		return ResponseEntity.ok().body(produtos);
	}

	@GetMapping(value = "")
	public void teste() {
		System.out.println("entrou");
	}

}
