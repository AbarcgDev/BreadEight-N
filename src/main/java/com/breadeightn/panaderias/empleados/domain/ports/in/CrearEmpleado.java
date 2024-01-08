package com.breadeightn.panaderias.empleados.domain.ports.in;

import com.breadeightn.panaderias.empleados.domain.model.InfoEmpleado;

public interface CrearEmpleado {
    InfoEmpleado crearEmpleado(InfoEmpleado infoEmpleadoNuevo);
}
