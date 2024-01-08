package com.breadeightn.panaderias.empleados.domain.ports.out;

import com.breadeightn.panaderias.empleados.domain.dto.EmpleadoLoginDto;
import com.breadeightn.panaderias.empleados.domain.model.InfoEmpleado;
import com.breadeightn.panaderias.empleados.domain.model.LoginEmpleado;

import java.util.Optional;

public interface EmpleadosRepositoryPort {
    InfoEmpleado guardar(InfoEmpleado infoEmpleado);
    Optional<InfoEmpleado> encontrarPorRFC(String rfc);
    Optional<InfoEmpleado> actualizar(InfoEmpleado infoEmpleadoActualizado);
    Optional<InfoEmpleado> eliminarPorRFC(String rfc);
    Optional<LoginEmpleado> autenticar(EmpleadoLoginDto loginInfo);
}
