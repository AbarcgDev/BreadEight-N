package com.breadeightn.panaderias.ventas.infrastructure.persistence;

import com.breadeightn.panaderias.productos.infrastructure.persistence.entity.PanesEntity;
import com.breadeightn.panaderias.ventas.domain.model.DetalleVenta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Entity
@Table(name = "detalle_venta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "ticket", referencedColumnName = "ticket")
    private VentaEntity venta;

    @ManyToOne
    @JoinColumn(name = "id_pan", referencedColumnName = "id_pan")
    private PanesEntity pan;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "total")
    private Double totalVenta;

    public static DetalleVentaEntity fromModel(DetalleVenta detalleVenta) {
        return DetalleVentaEntity.builder()
                .totalVenta(detalleVenta.getTotalVenta())
                .pan(PanesEntity
                        .fromModel(detalleVenta.getPan().getProducto()))
                .cantidad(detalleVenta.getPan().getCantidad())
                .build();
    }
}
