package com.breadeightn.panaderias.inventario.infrastructure.persistence.repository;

import com.breadeightn.panaderias.inventario.domain.model.Inventario;
import com.breadeightn.panaderias.inventario.domain.ports.out.InventarioRepositoryPort;
import com.breadeightn.panaderias.inventario.infrastructure.persistence.entity.InventarioEntity;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class InventarioRepositoryAdapter implements InventarioRepositoryPort {
    private final InventarioRepository inventarioRepository;

    @Override
    @Transactional
    public List<Inventario> obtenerInventario() {
        List<Inventario> inventario = new ArrayList<>();
        inventarioRepository.findAll().forEach((inventarioEntity -> inventario.add(inventarioEntity.toModel())));
        return inventario;
    }

    @Override
    @Transactional
    public void actualizarEntradaInventario(Inventario nuevaEntrada) {
        inventarioRepository.save(InventarioEntity.fromModel(nuevaEntrada));
    }
}