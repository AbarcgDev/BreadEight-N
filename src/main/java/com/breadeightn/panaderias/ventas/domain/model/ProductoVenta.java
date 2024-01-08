package com.breadeightn.panaderias.ventas.domain.model;

import com.breadeightn.panaderias.productos.domain.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ProductoVenta {
    Producto producto;
    Integer cantidad;
}
