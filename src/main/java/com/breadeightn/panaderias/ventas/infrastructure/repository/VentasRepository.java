package com.breadeightn.panaderias.ventas.infrastructure.repository;


import com.breadeightn.panaderias.ventas.infrastructure.persistence.VentaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends CrudRepository<VentaEntity, Integer> {
}
