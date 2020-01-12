package com.project.universe.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.universe.model.General;
import com.project.universe.model.dto.GeneralRequestDTO;
import com.project.universe.model.dto.GeneralResponseDTO;
import com.project.universe.repository.GeneralRepository;

@ExtendWith(MockitoExtension.class)
class GeneralServiceImplTest {

	@InjectMocks
	GeneralServiceImpl service;

	@Mock
	private GeneralRepository repository;

	private General general;

	private GeneralRequestDTO requestDto;

	private List<General> lista;
	private List<GeneralRequestDTO> requests;

	@BeforeEach
	void setUp() {
		int userId = 1;
		String userName = "testeName";
		String email = "teste@teste.com";
		String password = "email";
		Date createdOn = new Date(1l);
		general = new General(userId, userName, email, password, createdOn);
		lista = new ArrayList<General>();
		lista.add(general);
		requestDto = new GeneralRequestDTO(userId, userName, email, password, createdOn);
		requests = new ArrayList<GeneralRequestDTO>();
		requests.add(requestDto);
	}

	@Test
	void should_bring_all() {
		when(repository.findAll()).thenReturn(lista);
		List<GeneralResponseDTO> response = service.getAll();
		assertThat(response.get(0).getUsername(), is(equalTo("testeName")));
		assertThat(response.size(), is(equalTo(1)));
		verify(repository).findAll();
	}

//	@Test
//	void should_bring_email() {
//		when(repository.findAll()).thenReturn(lista);
//		List<GeneralResponseDTO> response = service.getAll();
//		assertThat(response.get(0).getUsername(), is(equalTo("testeName")));
//		assertThat(response.size(), is(equalTo(1)));
//		verify(repository).findByUserId(1);
//
//	}

//	@Test
//	void should_return_log() {
//		int userId = 1;
//		String userName = "testeName";
//		String email = "teste@teste.com";
//		String password = "email";
//		Date createdOn = new Date(1l);
//		List<General> generalTest = new ArrayList<General>();
//		General x = new General(userId, userName, email, password, createdOn);
//		
//		when(repository.save(generalTest)).thenReturn(general);
//		List<GeneralResponseDTO> gen = service.getAll();
//		assertThat(generalTest.equals(gen), is(equalTo(true)));
//	}
//
//	@Test
//	void should_bring_lista_converted_to_backup() {
//		List<CampoBackup> response = service.converteToBackup(listaCampo, 1);
//		assertThat(response.get(0).getIdLog(), is(equalTo(1L)));
//		assertThat(response.get(0).getId(), is(equalTo(0L)));
//	}
//
//	@Test
//	void should_backup() {
//		when(repository.findAll()).thenReturn(listaCampo);
//		when(backupRepository.saveAll(service.converteToBackup(listaCampo, 1)))
//				.thenReturn(service.converteToBackup(listaCampo, 1));
//		List<CampoBackupResponseDTO> response = service.backup(1);
//		assertThat(response.size(), is(equalTo(1)));
//		assertThat(response.get(0).getIdTabela(), is(equalTo(listaCampo.get(0).getIdTabela())));
//		assertThat(response.get(0).getNome(), is(equalTo(listaCampo.get(0).getNome())));
//		assertThat(response.get(0).getNullable(), is(equalTo(listaCampo.get(0).getNullable())));
//		assertThat(response.get(0).getBlank(), is(equalTo(listaCampo.get(0).getBlank())));
//		assertThat(response.get(0).getTipo(), is(equalTo(listaCampo.get(0).getTipo())));
//		assertThat(response.get(0).getDominio(), is(equalTo(listaCampo.get(0).getDominio())));
//		assertThat(response.get(0).getFormato(), is(equalTo(listaCampo.get(0).getFormato())));
//		assertThat(response.get(0).getTamanho(), is(equalTo(listaCampo.get(0).getTamanho())));
//		assertThat(response.get(0).isPossuidefault(), is(equalTo(listaCampo.get(0).isPossuidefault())));
//		assertThat(response.get(0).getPadrao(), is(equalTo(listaCampo.get(0).getPadrao())));
//		// assertThat(response.get(0).getId_log(), is(equalTo(1L)));
//		verify(repository).findAll();
//		verify(backupRepository).saveAll(service.converteToBackup(listaCampo, 1));
//	}
//
//	@Test
//	void should_delete() {
//		boolean delete = service.delete();
//		assertThat(delete, is(equalTo(true)));
//		verify(repository).deleteAll();
//	}
//
//	@Test
//	void should_insertNew() {
//		when(repository.saveAll(listaCampo)).thenReturn(listaCampo);
//		List<CampoResponseDTO> insert = service.insertNew(requests);
//		assertThat(insert.get(0).getIdTabela(), is(equalTo(requests.get(0).getIdTabela())));
//		assertThat(insert.get(0).getNome(), is(equalTo(requests.get(0).getNome())));
//		assertThat(insert.get(0).getNullable(), is(equalTo(requests.get(0).isNullable())));
//		assertThat(insert.get(0).getBlank(), is(equalTo(requests.get(0).isBlank())));
//		assertThat(insert.get(0).getTipo(), is(equalTo(requests.get(0).getTipo())));
//		assertThat(insert.get(0).getDominio(), is(equalTo(requests.get(0).getDominio())));
//		assertThat(insert.get(0).getFormato(), is(equalTo(requests.get(0).getFormato())));
//		assertThat(insert.get(0).getTamanho(), is(equalTo(requests.get(0).getTamanho())));
//		assertThat(insert.get(0).isPossuidefault(), is(equalTo(requests.get(0).isPossuidefault())));
//		assertThat(insert.get(0).getPadrao(), is(equalTo(requests.get(0).getPadrao())));
//		verify(repository).saveAll(listaCampo);
//	}
//
//	@SuppressWarnings("unlikely-arg-type")
//	@Test
//	void should_save_set() {
//		Campo campo2 = new Campo();
//		LogsParametrizacoes logs = new LogsParametrizacoes();
//		campo2.setIdTabela(campos.getIdTabela());
//		campo2.setNome(campos.getNome());
//		campo2.setNullable(campos.getNullable());
//		campo2.setBlank(campos.getBlank());
//		campo2.setTipo(campos.getTipo());
//		campo2.setDominio(campos.getDominio());
//		campo2.setFormato(campos.getFormato());
//		campo2.setTamanho(campos.getTamanho());
//		campo2.setPossuidefault(campos.isPossuidefault());
//		campo2.setPadrao(campos.getPadrao());
//		assertThat(campo2.equals(campos), is(equalTo(true)));
//		assertTrue(campo2.hashCode() == campos.hashCode());
//		assertThat(campo2.equals(null), is(equalTo(false)));
//		assertThat(campo2.equals(logs), is(equalTo(false)));
//	}
//
//	@SuppressWarnings("unlikely-arg-type")
//	@Test
//	void should_save_set_backup() {
//		CampoBackup campo2 = new CampoBackup();
//		LogsParametrizacoes logs = new LogsParametrizacoes();
//		campo2.setIdLog(1);
//		campo2.setIdTabela(campos.getIdTabela());
//		campo2.setNome(campos.getNome());
//		campo2.setNullable(campos.getNullable());
//		campo2.setBlank(campos.getBlank());
//		campo2.setTipo(campos.getTipo());
//		campo2.setDominio(campos.getDominio());
//		campo2.setFormato(campos.getFormato());
//		campo2.setTamanho(campos.getTamanho());
//		campo2.setPossuidefault(campos.isPossuidefault());
//		campo2.setPadrao(campos.getPadrao());
//
//		CampoBackup campo3 = new CampoBackup(1, campos.getIdTabela(), campos.getNome(), campos.getNullable(),
//				campos.getBlank(), campos.getTipo(), campos.getDominio(), campos.getFormato(), campos.getTamanho(),
//				campos.isPossuidefault(), campos.getPadrao());
//		assertThat(campo2.equals(campo3), is(equalTo(true)));
//		assertTrue(campo2.hashCode() == campo3.hashCode());
//		assertThat(campo2.equals(campos), is(equalTo(false)));
//		assertThat(campo2.equals(null), is(equalTo(false)));
//		assertThat(campo2.equals(logs), is(equalTo(false)));
//	}
}
