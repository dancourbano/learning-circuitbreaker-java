package com.api.devcam.usuariosdev.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class HelloServiceTest {

    @Mock
    private Throwable throwable;

    @InjectMocks
    private HelloService helloService;

    @Test
    public void testFallback() {
        String fallbackResult = helloService.fallback(throwable);
        assertEquals("Saludo no disponible en este momento", fallbackResult);
    }

    @Test
    public void testGetHello_Success() {
        String result = helloService.getHello();
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testGetHello_Failure() {
        // Simulando un error
        doThrow(new RuntimeException("Error simulado")).when(throwable).getMessage();

        String fallbackResult = helloService.getHello();
        assertEquals("Saludo no disponible en este momento", fallbackResult);
    }
}
