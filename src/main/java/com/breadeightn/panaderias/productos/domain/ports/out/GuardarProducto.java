package com.breadeightn.panaderias.productos.domain.ports.out;

import com.breadeightn.panaderias.productos.domain.model.Producto;

public interface GuardarProducto {
    public void guardarProducto(Producto producto);
}
