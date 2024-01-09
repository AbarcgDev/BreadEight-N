package com.breadeightn.panaderias.productos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Producto {
    private String idPan;
    private String nombre;
    private String tipo;
    private Double precio;

}
