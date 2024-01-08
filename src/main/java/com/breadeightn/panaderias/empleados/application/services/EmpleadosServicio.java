package com.breadeightn.panaderias.empleados.application.services;

import com.breadeightn.panaderias.empleados.application.usecases.AutenticarEmpleadoImpl;
import com.breadeightn.panaderias.empleados.domain.dto.EmpleadoLoginDto;
import com.breadeightn.panaderias.empleados.domain.model.LoginEmpleado;
import com.breadeightn.panaderias.empleados.domain.ports.in.AutenticarEmpleado;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class EmpleadosServicio implements AutenticarEmpleado {
    private final AutenticarEmpleadoImpl autenticarEmpleadoImpl;
    @Override
    public Optional<LoginEmpleado> autenticarEmpleado(EmpleadoLoginDto loginInfo) {
        return autenticarEmpleadoImpl.autenticarEmpleado(loginInfo);
    }
}
