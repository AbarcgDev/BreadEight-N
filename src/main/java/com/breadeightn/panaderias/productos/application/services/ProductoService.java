package com.breadeightn.panaderias.productos.application.services;

import com.breadeightn.panaderias.productos.application.usecases.BuscarProductoImpl;
import com.breadeightn.panaderias.productos.application.usecases.GuardarProductoImpl;
import com.breadeightn.panaderias.productos.domain.model.Producto;
import com.breadeightn.panaderias.productos.domain.ports.in.BuscarProducto;
import com.breadeightn.panaderias.productos.domain.ports.out.GuardarProducto;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class ProductoService implements BuscarProducto, GuardarProducto{
    private final BuscarProductoImpl buscarProductoImpl;
    private final GuardarProductoImpl guardarProductoImpl;
    @Override
    public Optional<Producto> buscarProductoPorClave(String clave) {
        return buscarProductoImpl.buscarProductoPorClave(clave);
    }
    @Override
    public void guardarProducto(Producto producto) {
        guardarProductoImpl.guardarProducto(producto);
    }
}
