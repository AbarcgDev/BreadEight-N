package com.breadeightn.panaderias.productos.application.services;

import com.breadeightn.panaderias.productos.application.usecases.BuscarProductoImpl;
import com.breadeightn.panaderias.productos.domain.model.Producto;
import com.breadeightn.panaderias.productos.domain.ports.in.BuscarProducto;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class ProductoService implements BuscarProducto {
    private final BuscarProductoImpl buscarProductoImpl;
    @Override
    public Optional<Producto> buscarProductoPorClave(String clave) {
        return buscarProductoImpl.buscarProductoPorClave(clave);
    }
}
