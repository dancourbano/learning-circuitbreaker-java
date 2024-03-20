package com.pi.devcam.ordenesdev.repository;

import com.pi.devcam.ordenesdev.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden,Integer> {

    List<Orden> findByCategoria(String categoria);


}