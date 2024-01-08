package com.breadeightn.panaderias.empleados.domain.model;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class InfoEmpleado {
    private String rfc;
    private String nombre_completo;
    private LocalDate fecha_nacimiento;
    private LocalDate fecha_contratacion;
    private String direccion;
}
