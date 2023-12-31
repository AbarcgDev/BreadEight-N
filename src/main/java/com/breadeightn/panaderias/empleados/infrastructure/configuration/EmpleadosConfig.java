package com.breadeightn.panaderias.empleados.infrastructure.configuration;

import com.breadeightn.panaderias.empleados.application.services.EmpleadosServicio;
import com.breadeightn.panaderias.empleados.application.usecases.AutenticarEmpleadoImpl;
import com.breadeightn.panaderias.empleados.domain.ports.out.EmpleadosRepositoryPort;
import com.breadeightn.panaderias.empleados.infrastructure.persistence.repository.adapters.EmpleadosRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpleadosConfig {
    @Bean
    public EmpleadosServicio empleadosServicio(EmpleadosRepositoryPort empleadosRepositoryPort) {
        return new EmpleadosServicio(
                new AutenticarEmpleadoImpl(empleadosRepositoryPort)
        );
    }

    @Bean
    public EmpleadosRepositoryPort empleadosRepositoryPort(EmpleadosRepositoryAdapter empleadosRepositoryAdapter) {
        return empleadosRepositoryAdapter;
    }

}
