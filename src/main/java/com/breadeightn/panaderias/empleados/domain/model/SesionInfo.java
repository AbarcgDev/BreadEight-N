package com.breadeightn.panaderias.empleados.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SesionInfo {
    private String rfc;
    private String nombre;
    private int area;
    private int rol;
}
