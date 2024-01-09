package com.breadeightn.panaderias.inventario.application.service;

import com.breadeightn.panaderias.inventario.application.usecases.ActualizarEntradaInventarioImpl;
import com.breadeightn.panaderias.inventario.application.usecases.ObtenerInventarioImpl;
import com.breadeightn.panaderias.inventario.domain.model.Inventario;
import com.breadeightn.panaderias.inventario.domain.ports.out.InventarioRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class InventarioService implements InventarioRepositoryPort {
    private final ActualizarEntradaInventarioImpl actualizarEntradaInventario;
    private final ObtenerInventarioImpl obtenerInventario;

    @Override
    public List<Inventario> obtenerInventario() {
        return obtenerInventario.obtenerInventario();
    }

    @Override
    public void actualizarEntradaInventario(Inventario nuevaEntrada) {
        actualizarEntradaInventario.actualizarEntradaInventario(nuevaEntrada);
    }
}
