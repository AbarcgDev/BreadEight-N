package com.breadeightn.panaderias.productos.application.usecases;

import com.breadeightn.panaderias.productos.domain.model.Producto;
import com.breadeightn.panaderias.productos.domain.ports.out.PanesRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GuardarProductoImpl implements com.breadeightn.panaderias.productos.domain.ports.out.GuardarProducto
{
    private final PanesRepositoryPort panesRepositoryPort;
    @Override
    public void guardarProducto(Producto producto) {
        panesRepositoryPort.guardarProducto(producto);
    }
}
