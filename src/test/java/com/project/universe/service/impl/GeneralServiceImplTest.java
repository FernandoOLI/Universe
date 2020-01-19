package com.project.universe.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.universe.UniverseApplicationTests;
import com.project.universe.model.General;
import com.project.universe.model.dto.GeneralRequestDTO;
import com.project.universe.model.dto.GeneralResponseDTO;
import com.project.universe.repository.GeneralRepository;

@ExtendWith(MockitoExtension.class)
class GeneralServiceImplTest extends UniverseApplicationTests {

	@InjectMocks
	GeneralServiceImpl service;

	@Mock
	private GeneralRepository repository;

	@Mock
	private GeneralRequestDTO generalDto;

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

	@Test
	void should_bring_one() {
		when(repository.findByUsername("testeName")).thenReturn(lista);
		List<GeneralResponseDTO> response = service.getByTabela("testeName");
		assertThat(response.get(0).getUsername(), is(equalTo("testeName")));
		assertThat(response.size(), is(equalTo(1)));
		verify(repository).findByUsername("testeName");
	}

	@Test
	void should_update() {
		when(repository.findByUserId(general.getUserId())).thenReturn(lista);
		assertEquals(service.update(generalDto,1).getStatusCode(),HttpStatus.OK);
	}

}
