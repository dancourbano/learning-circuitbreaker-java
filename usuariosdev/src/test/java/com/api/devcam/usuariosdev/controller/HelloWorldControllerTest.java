package com.api.devcam.usuariosdev.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HelloWorldControllerTest {

	@Autowired
	private UsuarioController helloWorldController;

	@Test
	public void testSayHello() {
		String result = helloWorldController.sayHello().block();
		assertEquals("Hello, World!", result);
	}
}
