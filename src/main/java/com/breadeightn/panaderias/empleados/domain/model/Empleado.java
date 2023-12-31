package com.breadeightn.panaderias.empleados.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class Empleado {
    private String rfc;
    private String nombre;
    private Integer area;
    private LocalDateTime fechaNacimiento;
    private LocalDateTime fechaContrato;
    private Integer nivel;
    private Integer sucursal;
    private String password;
}
