package com.breadeightn.panaderias.empleados.domain.ports.out;

import com.breadeightn.panaderias.empleados.domain.dto.EmpleadoLoginDto;
import com.breadeightn.panaderias.empleados.domain.model.Empleado;
import com.breadeightn.panaderias.empleados.domain.model.SesionInfo;

import java.util.Optional;

public interface EmpleadosRepositoryPort {
    Empleado guardar(Empleado empleado);
    Optional<Empleado> encontrarPorRFC(String rfc);
    Optional<Empleado> actualizar(Empleado empleadoActualizado);
    Optional<Empleado> eliminarPorRFC(String rfc);
    Optional<SesionInfo> autenticar(EmpleadoLoginDto loginInfo);
}
