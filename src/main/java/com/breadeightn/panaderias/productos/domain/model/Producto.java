package com.breadeightn.panaderias.productos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Producto {
    private Long clave;
    private String nombre;
    private Double precio;
}
