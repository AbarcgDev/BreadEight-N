package com.breadeightn.panaderias.productos.application.usecases;

import com.breadeightn.panaderias.productos.domain.model.Producto;
import com.breadeightn.panaderias.productos.domain.ports.in.BuscarProducto;
import com.breadeightn.panaderias.productos.domain.ports.out.PanesRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.Optional;
@AllArgsConstructor
public class BuscarProductoImpl implements BuscarProducto {
    private final PanesRepositoryPort panesRepositoryPort;
    @Override
    public Optional<Producto> buscarProductoPorClave(String clave) {
        return panesRepositoryPort.buscarPorClave(clave);
    }
}
