package com.api.devcam.usuariosdev.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @CircuitBreaker(name = "hello", fallbackMethod = "fallback")
    public String getHello() {
        // Simulación de una operación que puede fallar
        if (Math.random() > 0.5) {
            throw new RuntimeException("Error al obtener el saludo");
        }
        return "Hello, World!";
    }

    public String fallback(Throwable throwable) {
        return "Saludo no disponible en este momento";
    }
}