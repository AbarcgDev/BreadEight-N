package com.breadeightn.panaderias.inventario.infrastructure.persistence.repository;

import com.breadeightn.panaderias.inventario.infrastructure.persistence.entity.InventarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface InventarioRepository extends CrudRepository<InventarioEntity, Integer> {

}
