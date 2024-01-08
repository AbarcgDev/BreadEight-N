package com.breadeightn.panaderias.ventas.application.services;

import com.breadeightn.panaderias.ventas.application.usecases.CrearVentaImpl;
import com.breadeightn.panaderias.ventas.domain.model.Venta;
import com.breadeightn.panaderias.ventas.domain.ports.in.CrearVenta;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VentasService implements CrearVenta {
    private final CrearVentaImpl crearVentaImpl;
    @Override
    public void crearVenta(Venta venta) {
        crearVentaImpl.crearVenta(venta);
    }
}
