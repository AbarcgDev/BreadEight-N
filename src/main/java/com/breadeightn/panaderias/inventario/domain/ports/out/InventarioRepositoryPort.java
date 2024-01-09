package com.breadeightn.panaderias.inventario.domain.ports.out;

import com.breadeightn.panaderias.inventario.domain.model.Inventario;

import java.util.List;

public interface InventarioRepositoryPort {
    List<Inventario> obtenerInventario();
    void actualizarEntradaInventario(Inventario nuevaEntrada);
}
