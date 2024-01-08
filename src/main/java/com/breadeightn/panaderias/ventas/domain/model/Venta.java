package com.breadeightn.panaderias.ventas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Venta {
    private List<DetalleVenta> productos;
    private Double totalVenta;
    private LocalDateTime timestamp;
}
