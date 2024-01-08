package com.breadeightn.panaderias.productos.domain.ports.in;

import com.breadeightn.panaderias.productos.domain.model.Producto;

import java.util.Optional;

public interface BuscarProducto {
    Optional<Producto> buscarProductoPorClave(String clave);
}
