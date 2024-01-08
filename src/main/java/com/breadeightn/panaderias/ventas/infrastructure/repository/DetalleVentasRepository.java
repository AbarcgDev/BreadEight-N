package com.breadeightn.panaderias.ventas.infrastructure.repository;

import com.breadeightn.panaderias.ventas.infrastructure.persistence.DetalleVentaEntity;
import org.springframework.data.repository.CrudRepository;

public interface DetalleVentasRepository extends CrudRepository<DetalleVentaEntity, Integer> {
}
