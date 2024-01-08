package com.breadeightn.panaderias.empleados.domain.model;

import com.breadeightn.panaderias.areas.domain.Area;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LoginEmpleado {
    private Area area;
    private String rol;
    private InfoEmpleado infoEmpleado;
}
