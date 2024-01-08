package com.breadeightn.panaderias.ventas.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleVenta {
    private ProductoVenta pan;
    private Double totalVenta;
}
