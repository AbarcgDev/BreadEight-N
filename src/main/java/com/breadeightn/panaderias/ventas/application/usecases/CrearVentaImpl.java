package com.breadeightn.panaderias.ventas.application.usecases;


import com.breadeightn.panaderias.ventas.domain.model.Venta;
import com.breadeightn.panaderias.ventas.domain.ports.in.CrearVenta;
import com.breadeightn.panaderias.ventas.domain.ports.out.VentasRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CrearVentaImpl implements CrearVenta {
    private final VentasRepositoryPort ventasRepositoryPort;

    @Override
    public void crearVenta(Venta venta) {
        ventasRepositoryPort.crearVenta(venta);
    }
}
