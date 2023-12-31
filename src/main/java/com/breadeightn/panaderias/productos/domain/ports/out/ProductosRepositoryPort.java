package com.breadeightn.panaderias.productos.domain.ports.out;

import com.breadeightn.panaderias.productos.domain.model.Producto;

import java.util.Optional;

public interface ProductosRepositoryPort {
    Optional<Producto> buscarPorClave(Long clave);
}
