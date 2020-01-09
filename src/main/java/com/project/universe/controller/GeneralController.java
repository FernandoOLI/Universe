package com.project.universe.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Controller responsible for handling Example operations. */
@RestController
@RequestMapping("/general")
public class GeneralController {

//  @Autowired private TabelaServiceImpl tabelaService;

//  @GetMapping(value = "")
//  public ResponseEntity<List<TabelaResponseDTO>> listarValoresProduto() throws SQLException {
//    List<TabelaResponseDTO> produtos = tabelaService.getAll();
//    return ResponseEntity.ok().body(produtos);
//  }
  
  @GetMapping(value = "")
  public void teste() {
	  System.out.println("entrou");
  }

}
