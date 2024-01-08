package com.breadeightn.panaderias.empleados.infrastructure.persistence.repository;

import com.breadeightn.panaderias.empleados.infrastructure.persistence.entity.InfoEmpleadoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends CrudRepository<InfoEmpleadoEntity,String> {

}
