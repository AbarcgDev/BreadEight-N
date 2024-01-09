package com.breadeightn.panaderias.areas.domain;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
@Getter
public enum Area {
    VENTAS("VT","VENTAS"),
    INVENTARIO("IV","INVENTARIO");

    private String nombre;
    private String clave;

    Area(String clave, String nombre) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public static Area get(String clave) {
        return Arrays.stream(Area.values())
                .filter((area -> area.getNombre().equals(clave)))
                .findFirst().orElse(Area.VENTAS);
    }
}
