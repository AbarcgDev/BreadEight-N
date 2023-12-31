package com.breadeightn.panaderias.productos.infrastructure.persistence.repository;

import com.breadeightn.panaderias.productos.infrastructure.persistence.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends CrudRepository<ProductoEntity,Long> {
}
