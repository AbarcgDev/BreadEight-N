package com.breadeightn.panaderias.empleados.infrastructure.persistence.entity;

import com.breadeightn.panaderias.empleados.domain.model.InfoEmpleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
    @Entity
    @Builder
    @Table(name="info_empleado")
    @NoArgsConstructor
    @AllArgsConstructor
    public class InfoEmpleadoEntity {
        @Id
        @Column(name = "rfc")
        private String rfc;

        @Column(name = "nombre_completo")
        private String nombre_completo;

        @Column(name = "fecha_nacimiento")
        @Temporal(TemporalType.DATE)
        private LocalDate fechaNacimiento;

        @Column(name = "fecha_contratacion")
        @Temporal(TemporalType.DATE)
        private LocalDate fechaContratacion;

        @Column(name = "direccion")
        private String direccion;

        @Column(name = "rol")
        private String rol;

        @Column(name="area")
        private String area;

        @Column(name = "sueldo_hora")
        private Double sueldo;

        @OneToMany(mappedBy = "infoEmpleado")
        private List<LoginEmpleadoEntity> loginEmpleadoEntities;


        public static InfoEmpleadoEntity fromModel(InfoEmpleado infoEmpleadoModel) {
            return InfoEmpleadoEntity.builder()
                    .rfc(infoEmpleadoModel.getRfc())
                    .nombre_completo(infoEmpleadoModel.getNombre_completo())
                    .fechaNacimiento(infoEmpleadoModel.getFecha_nacimiento())
                    .fechaContratacion(infoEmpleadoModel.getFecha_contratacion())
                    .direccion(infoEmpleadoModel.getDireccion())
                    .build();
        }
        public InfoEmpleado toModel() {
            return InfoEmpleado.builder()
                    .rfc(this.rfc)
                    .nombre_completo(this.nombre_completo)
                    .direccion(this.direccion)
                    .fecha_nacimiento(this.fechaNacimiento)
                    .fecha_contratacion(this.fechaContratacion)
                    .build();
        }
    }
