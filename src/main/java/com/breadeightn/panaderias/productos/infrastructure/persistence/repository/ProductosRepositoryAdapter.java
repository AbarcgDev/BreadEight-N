package com.breadeightn.panaderias.productos.infrastructure.persistence.repository;

import com.breadeightn.panaderias.productos.domain.model.Producto;
import com.breadeightn.panaderias.productos.domain.ports.out.ProductosRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class ProductosRepositoryAdapter implements ProductosRepositoryPort {
    private final ProductosRepository productosRepository;

    @Override
    public Optional<Producto> buscarPorClave(Long clave) {
        var entity = productosRepository.findById(clave);
        Optional<Producto> producto = Optional.empty();
        if (entity.isPresent()) {
            producto = Optional.of(Producto.builder()
                    .clave(entity.get().getClave())
                    .nombre(entity.get().getNombre())
                    .precio(entity.get().getPrecio())
                    .build()
            );
        }
        return producto;
    }
}
