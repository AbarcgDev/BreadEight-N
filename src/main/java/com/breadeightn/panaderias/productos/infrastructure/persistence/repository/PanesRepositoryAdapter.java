package com.breadeightn.panaderias.productos.infrastructure.persistence.repository;

import com.breadeightn.panaderias.productos.domain.model.Producto;
import com.breadeightn.panaderias.productos.domain.ports.out.PanesRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class PanesRepositoryAdapter implements PanesRepositoryPort {
    private final PanesRepository panesRepository;

    @Override
    public Optional<Producto> buscarPorClave(String clave) {
        var entity = panesRepository.findById(clave);
        Optional<Producto> producto = Optional.empty();
        if (entity.isPresent()) {
            producto = Optional.of(Producto.builder()
                    .idPan(entity.get().getIdPan())
                    .nombre(entity.get().getNombre())
                    .precio(entity.get().getPrecio())
                    .build()
            );
        }
        return producto;
    }
}
