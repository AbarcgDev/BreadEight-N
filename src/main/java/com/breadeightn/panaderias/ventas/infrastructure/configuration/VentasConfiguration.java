package com.breadeightn.panaderias.ventas.infrastructure.configuration;


import com.breadeightn.panaderias.ventas.application.services.VentasService;
import com.breadeightn.panaderias.ventas.application.usecases.CrearVentaImpl;
import com.breadeightn.panaderias.ventas.domain.ports.out.VentasRepositoryPort;
import com.breadeightn.panaderias.ventas.infrastructure.repository.VentasRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VentasConfiguration {
    @Bean
    public VentasService ventasService(VentasRepositoryPort ventasRepositoryPort) {
        return new VentasService(
                new CrearVentaImpl(ventasRepositoryPort)
        );
    }

    @Bean
    public VentasRepositoryPort ventasRepositoryPort(VentasRepositoryAdapter ventasRepositoryAdapter) {
        return ventasRepositoryAdapter;
    }
}
