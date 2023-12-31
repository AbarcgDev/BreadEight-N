package com.breadeightn.panaderias.empleados.domain.ports.in;

import com.breadeightn.panaderias.empleados.domain.model.Empleado;

import java.util.Optional;

public interface ActualizarEmpleado {
    Optional<Empleado> actualizarEmpleado(String rfcEmpleado, Empleado empleadoActualizado);
}
