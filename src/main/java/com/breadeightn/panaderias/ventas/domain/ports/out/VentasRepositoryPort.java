package com.breadeightn.panaderias.ventas.domain.ports.out;


import com.breadeightn.panaderias.ventas.domain.model.Venta;

public interface VentasRepositoryPort {
    void crearVenta(Venta  venta);
}
