package com.algaworks.algafood;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.util.DatabaseCleaner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadastroCozinhaIT {
	@LocalServerPort
	private int port;

	@Autowired
	private DatabaseCleaner databaseCleaner;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Before
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";

		databaseCleaner.clearTables();
		prepararDados();
	}

	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

		RestAssured
			.given()
				.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void deveConter2Cozinhas_QuandoConsultarCozinhas() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

		RestAssured
			.given()
				.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.body("", Matchers.hasSize(2));
	}

	@Test
	public void deveRetornarNomeDasCozinhas_QuandoConsultarCozinhas() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

		RestAssured
			.given()
				.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.body("nome", Matchers.hasItems("Americana", "Tailandesa"));
	}

	@Test
	public void deveRetornarStatus201_QuandoCadastrarCozinha() {
		RestAssured
			.given()
				.body("{ \"nome\": \"Chinesa\" }")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.post()
			.then()
				.statusCode(HttpStatus.CREATED.value());
	}

	private void prepararDados() {
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Tailandesa");
		cozinhaRepository.save(cozinha1);

		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Americana");
		cozinhaRepository.save(cozinha2);
	}
}
