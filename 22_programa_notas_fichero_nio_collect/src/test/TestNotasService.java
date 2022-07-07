package test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.NotasService;

class TestNotasService {
	NotasService service;

	@BeforeEach
	void setUp() throws Exception {
		service=new NotasService();
		service.guardarNota(10);
		service.guardarNota(5);
		service.guardarNota(2);
		service.guardarNota(8);
		service.guardarNota(4);
	}

	@Test
	void testMedia() {
		assertEquals(5.8, service.media().getAsDouble(),0.1);
	}

	@Test
	void testAprobados() {
		assertEquals(3,service.aprobados());
	}

	@Test
	void testNotaMayor() {
		assertEquals(10.0, service.notaMayor().getAsDouble(),0);
	}

	@Test
	void testNotaMenor() {
		assertEquals(2.0, service.notaMenor().getAsDouble(),0);
	}

}
