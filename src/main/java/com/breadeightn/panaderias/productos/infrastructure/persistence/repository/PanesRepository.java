package com.breadeightn.panaderias.productos.infrastructure.persistence.repository;

import com.breadeightn.panaderias.productos.infrastructure.persistence.entity.PanesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanesRepository extends CrudRepository<PanesEntity, String> {
}
