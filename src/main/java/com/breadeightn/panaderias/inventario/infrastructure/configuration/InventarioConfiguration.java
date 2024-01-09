package com.breadeightn.panaderias.inventario.infrastructure.configuration;

import com.breadeightn.panaderias.inventario.application.service.InventarioService;
import com.breadeightn.panaderias.inventario.application.usecases.ActualizarEntradaInventarioImpl;
import com.breadeightn.panaderias.inventario.application.usecases.ObtenerInventarioImpl;
import com.breadeightn.panaderias.inventario.domain.ports.out.InventarioRepositoryPort;
import com.breadeightn.panaderias.inventario.infrastructure.persistence.repository.InventarioRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventarioConfiguration {
    @Bean
    public InventarioService inventarioService(InventarioRepositoryPort inventarioRepositoryPort) {
        return new InventarioService(
                new ActualizarEntradaInventarioImpl(inventarioRepositoryPort),
                new ObtenerInventarioImpl(inventarioRepositoryPort)
        );
    }

    @Bean
    public InventarioRepositoryPort inventarioRepositoryPort(InventarioRepositoryAdapter inventarioRepositoryAdapter) {
        return inventarioRepositoryAdapter;
    }
}
