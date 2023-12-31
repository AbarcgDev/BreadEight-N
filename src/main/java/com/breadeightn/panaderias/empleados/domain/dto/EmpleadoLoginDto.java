package com.breadeightn.panaderias.empleados.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmpleadoLoginDto {
    @NotEmpty
    @Size(min = 13, message = "Utilice RFC con Homoclave, 13 caracteres")
    @Pattern(regexp = "^[A-Z&Ñ]{4}\\d{6}[A-V1-9][0-9A-Z]$", message = "Formato de RFC no válido")
    private String rfc;
    @NotEmpty
    private String password;

}
