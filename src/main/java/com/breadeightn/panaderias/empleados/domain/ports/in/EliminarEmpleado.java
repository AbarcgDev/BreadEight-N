package com.breadeightn.panaderias.empleados.domain.ports.in;

import com.breadeightn.panaderias.empleados.domain.model.InfoEmpleado;

import java.util.Optional;

public interface EliminarEmpleado {
    Optional<InfoEmpleado> eliminarEmpleado(String rfcEmpleado);
}
