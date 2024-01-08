package com.breadeightn.panaderias.productos.infrastructure.persistence.repository;

import com.breadeightn.panaderias.productos.infrastructure.persistence.entity.TipoPanesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPanesRepositor extends CrudRepository<TipoPanesEntity, String>  {
}
