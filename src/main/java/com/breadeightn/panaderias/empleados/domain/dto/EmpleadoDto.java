package com.breadeightn.panaderias.empleados.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class EmpleadoDto {
    @NotEmpty
    @Size(min = 13, message = "Utilice RFC con Homoclave, 13 caracteres")
    @Pattern(regexp = "^[A-Z&Ñ]{4}\\d{6}[A-V1-9][0-9A-Z]$", message = "Formato de RFC no válido")
    private String rfc;
    @NotEmpty
    private String password;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private Integer area;
    @NotEmpty
    private LocalDateTime fechaNacimiento;
    @NotEmpty
    private LocalDateTime fechaContrato;
    private Integer nivel;
    private Integer sucursal;
}
