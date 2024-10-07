package com.breadeightn.panaderias.productos.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.breadeightn.panaderias.productos.domain.model.TipoProducto;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tipo_panes")
public class TipoPanesEntity {
    @Id
    @Column(name = "id_tipo")
    private String idTipo;

    @Column(name = "tipo")
    private String nombreTipo;

    @OneToMany(mappedBy = "tipo")
    private List<PanesEntity> panes;

    public TipoProducto toModel() {
        return TipoProducto.builder()
        .idTipo(idTipo)
        .nombreTipo(nombreTipo)
        .build();
    }

    public static TipoPanesEntity fromModel(TipoProducto model) {
        return TipoPanesEntity.builder()
        .idTipo(model.getIdTipo())
        .nombreTipo(model.getNombreTipo())
        .build();
    }
}
