package com.breadeightn.panaderias.empleados.application.usecases;

import com.breadeightn.panaderias.empleados.domain.dto.EmpleadoLoginDto;
import com.breadeightn.panaderias.empleados.domain.model.LoginEmpleado;
import com.breadeightn.panaderias.empleados.domain.ports.in.AutenticarEmpleado;
import com.breadeightn.panaderias.empleados.domain.ports.out.EmpleadosRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class AutenticarEmpleadoImpl implements AutenticarEmpleado {
    private final EmpleadosRepositoryPort empleadosRepositoryPort;
    @Override
    public Optional<LoginEmpleado> autenticarEmpleado(EmpleadoLoginDto loginInfo) {
        return empleadosRepositoryPort.autenticar(loginInfo);
    }
}
