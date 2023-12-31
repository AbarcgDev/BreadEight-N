package com.breadeightn.panaderias.productos.infrastructure.configuration;

import com.breadeightn.panaderias.empleados.domain.ports.out.EmpleadosRepositoryPort;
import com.breadeightn.panaderias.productos.application.services.ProductoService;
import com.breadeightn.panaderias.productos.application.usecases.BuscarProductoImpl;
import com.breadeightn.panaderias.productos.domain.ports.out.ProductosRepositoryPort;
import com.breadeightn.panaderias.productos.infrastructure.persistence.repository.ProductosRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductosConfiguration {
    @Bean
    ProductoService productoService(ProductosRepositoryPort productosRepositoryPort) {
        return new ProductoService(
                new BuscarProductoImpl(productosRepositoryPort)
        );
    }

    @Bean
    ProductosRepositoryPort productosRepositoryPort(ProductosRepositoryAdapter productosRepositoryAdapter) {
        return productosRepositoryAdapter;
    }
}
