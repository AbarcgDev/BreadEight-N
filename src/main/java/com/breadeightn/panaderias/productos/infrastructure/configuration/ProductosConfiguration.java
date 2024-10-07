package com.breadeightn.panaderias.productos.infrastructure.configuration;

import com.breadeightn.panaderias.productos.application.services.ProductoService;
import com.breadeightn.panaderias.productos.application.usecases.BuscarProductoImpl;
import com.breadeightn.panaderias.productos.application.usecases.GuardarProductoImpl;
import com.breadeightn.panaderias.productos.domain.ports.out.PanesRepositoryPort;
import com.breadeightn.panaderias.productos.infrastructure.persistence.repository.PanesRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductosConfiguration {
    @Bean
    ProductoService productoService(PanesRepositoryPort panesRepositoryPort) {
        return new ProductoService(
                new BuscarProductoImpl(panesRepositoryPort),
                new GuardarProductoImpl(panesRepositoryPort)
        );
    }
}
