package com.breadeightn.panaderias.empleados.domain.ports.in;

import com.breadeightn.panaderias.empleados.domain.dto.EmpleadoLoginDto;
import com.breadeightn.panaderias.empleados.domain.model.SesionInfo;

import java.util.Optional;

public interface AutenticarEmpleado {
    Optional<SesionInfo> autenticarEmpleado(EmpleadoLoginDto loginInfo);
}
