package com.api.devcam.usuariosdev.controller;

import com.api.devcam.usuariosdev.dto.OrdenDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;
    public static final String USER_DEV="userDev";

    private static final String URL = "http://localhost:9081/orden";

    private int attempt=1;
    @GetMapping("/hello")
    public Mono<String> sayHello() {
        return Mono.just("Hello, World!");
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/orden")
    @CircuitBreaker(name = USER_DEV,fallbackMethod = "getOrdenesDisponibles")
    public List<OrdenDTO> showOrders(@RequestParam("categoria") String category) {
        String url = category == null ? URL : URL + "/" + category;
        System.out.println("llamada al metodo despues de "+attempt++ +" vez "+" en "+new Date());
        return restTemplate.getForObject(url, ArrayList.class);
    }

    public List<OrdenDTO> getOrdenesDisponibles(Exception e){
        return Stream.of(
                new OrdenDTO(2, "Bey Blade Dranzer X2", "juquetes", 40),
                new OrdenDTO(3, "Power Ranger Rojo SPD", "juquetes",  100),
                new OrdenDTO(4, "Piano Bebes", "juquetes",  100),
                new OrdenDTO(5, "Polo Nike V3", "Ropa",  80),
                new OrdenDTO(6, "Pantalon Adidas At2", "Ropa", 200),
                new OrdenDTO(7, "Camisa cuadros John Holden", "Ropa",  100)
        ).collect(Collectors.toList());
    }
}