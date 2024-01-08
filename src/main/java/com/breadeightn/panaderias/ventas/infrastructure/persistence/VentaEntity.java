package com.breadeightn.panaderias.ventas.infrastructure.persistence;

import com.breadeightn.panaderias.ventas.domain.model.Venta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentaEntity {
    @Id
    @Column(name = "ticket")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noTicket;

    @Column(name = "total_venta")
    private Double totalVenta;

    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "venta")
    private List<DetalleVentaEntity> detalles;

    public static VentaEntity fromModel(Venta venta) {
        return VentaEntity.builder()
                .totalVenta(venta.getTotalVenta())
                .timestamp(venta.getTimestamp())
                .detalles(venta.getProductos()
                        .stream()
                        .map(DetalleVentaEntity::fromModel)
                        .toList())
                .build();
    }
}
