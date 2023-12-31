package com.breadeightn.panaderias.empleados.domain.ports.in;

import com.breadeightn.panaderias.empleados.domain.model.Empleado;

public interface CrearEmpleado {
    Empleado crearEmpleado(Empleado empleadoNuevo);
}
