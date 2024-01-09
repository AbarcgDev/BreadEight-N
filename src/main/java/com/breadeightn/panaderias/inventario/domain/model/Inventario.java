package com.breadeightn.panaderias.inventario.domain.model;

import com.breadeightn.panaderias.productos.domain.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventario {
    private Integer idInventario;
    private Producto pan;
    private Integer cantidadCorte;
    private Integer unidadesVendidas;
    private Integer inventario;
}
