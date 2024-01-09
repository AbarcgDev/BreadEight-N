package com.breadeightn.panaderias.inventario.application.usecases;

import com.breadeightn.panaderias.inventario.domain.model.Inventario;
import com.breadeightn.panaderias.inventario.domain.ports.in.ActualizarEntradaInventario;
import com.breadeightn.panaderias.inventario.domain.ports.out.InventarioRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ActualizarEntradaInventarioImpl implements ActualizarEntradaInventario {
    private final InventarioRepositoryPort inventarioRepositoryPort;
    @Override
    public void actualizarEntradaInventario(Inventario nuevaEntrada) {
        inventarioRepositoryPort.actualizarEntradaInventario(nuevaEntrada);
    }
}
