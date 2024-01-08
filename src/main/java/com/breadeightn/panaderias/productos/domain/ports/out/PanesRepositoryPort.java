package com.breadeightn.panaderias.productos.domain.ports.out;

import com.breadeightn.panaderias.productos.domain.model.Producto;

import java.util.Optional;

public interface PanesRepositoryPort {
    Optional<Producto> buscarPorClave(String clave);
}
