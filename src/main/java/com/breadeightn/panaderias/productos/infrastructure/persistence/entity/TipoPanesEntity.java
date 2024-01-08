package com.breadeightn.panaderias.productos.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
}
