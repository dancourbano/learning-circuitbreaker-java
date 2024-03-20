package com.api.devcam.usuariosdev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenDTO {
    private int id;
    private String nombre;
    private String categoria;

    private double precio;
}
