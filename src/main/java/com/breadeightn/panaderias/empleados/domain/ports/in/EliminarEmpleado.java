package com.breadeightn.panaderias.empleados.domain.ports.in;

import com.breadeightn.panaderias.empleados.domain.model.Empleado;

import java.util.Optional;

public interface EliminarEmpleado {
    Optional<Empleado> eliminarEmpleado(String rfcEmpleado);
}
