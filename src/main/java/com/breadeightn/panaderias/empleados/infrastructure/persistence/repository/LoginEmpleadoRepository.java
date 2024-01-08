package com.breadeightn.panaderias.empleados.infrastructure.persistence.repository;

import com.breadeightn.panaderias.empleados.infrastructure.persistence.entity.LoginEmpleadoEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoginEmpleadoRepository extends CrudRepository<LoginEmpleadoEntity, Long> {
}
