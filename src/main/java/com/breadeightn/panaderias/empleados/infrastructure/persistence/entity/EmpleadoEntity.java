package com.breadeightn.panaderias.empleados.infrastructure.persistence.entity;

import com.breadeightn.panaderias.empleados.domain.model.Empleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name="empleado")
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {
    @Id
    @Column(name = "rfc")
    private String rfc;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "area")
    private Integer area;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaNacimiento;

    @Column(name = "fecha_contrato")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaContrato;

    @Column(name = "rol")
    private int rol;

    @Column(name = "sucursal")
    private int sucursal;

    @Column(name = "password")
    private String password;

    public static EmpleadoEntity fromModel(Empleado empleadoModel) {
        return EmpleadoEntity.builder()
                .rfc(empleadoModel.getRfc())
                .nombre(empleadoModel.getNombre())
                .fechaNacimiento(empleadoModel.getFechaNacimiento())
                .fechaContrato(empleadoModel.getFechaContrato())
                .area(empleadoModel.getArea())
                .rol(empleadoModel.getNivel())
                .sucursal(empleadoModel.getSucursal())
                .build();
    }
}
