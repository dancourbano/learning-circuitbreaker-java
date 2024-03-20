package com.pi.devcam.ordenesdev.controller;

import com.pi.devcam.ordenesdev.model.Orden;
import com.pi.devcam.ordenesdev.repository.OrdenRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/orden")
public class OrdenController {

    @Autowired
    private OrdenRepository orderRepository;

    @PostConstruct
    public void iniciadorTabla() {
        orderRepository.saveAll(Stream.of(
                        new Orden("Lentes", "accesorios", 300),
                        new Orden("Brazalete", "accesorios",  200),
                        new Orden("Gorra", "accesorios",  100),
                        new Orden("Anillos", "accesorios", 200),
                        new Orden("Pantalon Corto Azul", "ropa",  100),
                        new Orden("Sandalias", "ropa",  50)
                ).
                collect(Collectors.toList()));
    }

    @GetMapping
    public List<Orden> getOrdenes(){
        return orderRepository.findAll();
    }
    @GetMapping("/{categoria}")
    public List<Orden> getOrdenByCategoria(@PathVariable String categoria){
        return orderRepository.findByCategoria(categoria);
    }

}
