package com.breadeightn.panaderias.inventario.application.usecases;

import com.breadeightn.panaderias.inventario.domain.model.Inventario;
import com.breadeightn.panaderias.inventario.domain.ports.in.ObtenerInventario;
import com.breadeightn.panaderias.inventario.domain.ports.out.InventarioRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ObtenerInventarioImpl implements ObtenerInventario {
    private final InventarioRepositoryPort inventarioRepositoryPort;

    @Override
    public List<Inventario> obtenerInventario() {
        return inventarioRepositoryPort.obtenerInventario();
    }
}
