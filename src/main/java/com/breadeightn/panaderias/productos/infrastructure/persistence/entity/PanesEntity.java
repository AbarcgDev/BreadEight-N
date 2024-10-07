package com.breadeightn.panaderias.productos.infrastructure.persistence.entity;

import com.breadeightn.panaderias.productos.domain.model.Producto;
import com.breadeightn.panaderias.ventas.domain.model.ProductoVenta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name="panes")
@NoArgsConstructor
@AllArgsConstructor
public class PanesEntity {
    @Id
    @Column(name = "id_pan")
    private String idPan;

    @Column(name = "producto")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    private TipoPanesEntity tipo;

    public static PanesEntity fromModel(Producto producto) {
        return PanesEntity.builder()
                .precio(producto.getPrecio())
                .idPan(producto.getIdPan())
                .nombre(producto.getNombre())
                .tipo(TipoPanesEntity.fromModel(producto.getTipo()))
                .build();
    }

    public Producto toModel() {
        return Producto.builder()
                .idPan(idPan)
                .nombre(nombre)
                .precio(precio)
                .tipo(tipo.toModel())
                .build();
    }
}
