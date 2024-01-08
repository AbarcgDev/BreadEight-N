package com.breadeightn.panaderias.empleados.infrastructure.persistence.entity;

import com.breadeightn.panaderias.empleados.domain.model.InfoEmpleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "login_empleado")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginEmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;

    @Column(name = "password")
    private String pass;

    @ManyToOne
    @JoinColumn(name = "rfc", referencedColumnName = "rfc", updatable = false, insertable = false)
    private InfoEmpleadoEntity infoEmpleado;

}
