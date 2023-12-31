package com.breadeightn.panaderias.productos.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name="producto")
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity {
    @Id
    @Column(name = "clave")
    private Long clave;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private Double precio;
}
