package com.breadeightn.panaderias.inventario.infrastructure.persistence.entity;


import com.breadeightn.panaderias.inventario.domain.model.Inventario;
import com.breadeightn.panaderias.productos.infrastructure.persistence.entity.PanesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "inventario")
public class InventarioEntity {
    @Id
    @Column(name = "id_inventario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInventario;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_pan", referencedColumnName = "id_pan")
    private PanesEntity pan;

    @Column(name = "cantidad_corte")
    private Integer cantidadCorte;

    @Column(name = "unidades_vendidas")
    private Integer unidadesVendidas;

    @Column(name = "inventario")
    private Integer inventario;

    public Inventario toModel() {
        return Inventario.builder()
                .idInventario(idInventario)
                .pan(pan.toModel())
                .cantidadCorte(cantidadCorte)
                .unidadesVendidas(unidadesVendidas)
                .inventario(inventario)
                .build();
    }

    public static InventarioEntity fromModel(Inventario model) {
        return InventarioEntity.builder()
        .cantidadCorte(model.getCantidadCorte())
        .idInventario(model.getIdInventario())
        .inventario(model.getInventario())
        .pan(PanesEntity.fromModel(model.getPan()))
        .unidadesVendidas(model.getUnidadesVendidas())
        .build();
        }
}
