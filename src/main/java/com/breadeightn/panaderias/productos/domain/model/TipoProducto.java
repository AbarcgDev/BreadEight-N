package com.breadeightn.panaderias.productos.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoProducto {
    private String idTipo;
    private String nombreTipo;
}


