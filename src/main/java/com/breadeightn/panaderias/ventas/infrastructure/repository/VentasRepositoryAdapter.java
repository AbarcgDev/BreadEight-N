package com.breadeightn.panaderias.ventas.infrastructure.repository;

import com.breadeightn.panaderias.productos.infrastructure.persistence.repository.PanesRepository;
import com.breadeightn.panaderias.ventas.domain.model.Venta;
import com.breadeightn.panaderias.ventas.domain.ports.out.VentasRepositoryPort;
import com.breadeightn.panaderias.ventas.infrastructure.persistence.VentaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class VentasRepositoryAdapter implements VentasRepositoryPort {
    private final DetalleVentasRepository detalleVentasRepository;
    private final VentasRepository ventasRepository;
    private final PanesRepository panesRepository;
    @Override
    public void crearVenta(Venta venta) {
        VentaEntity nuevaVenta = VentaEntity.fromModel(venta);
        VentaEntity nuevaVentaInsert = ventasRepository.save(nuevaVenta);
        nuevaVenta.getDetalles().forEach((detalleVentaEntity -> {
            detalleVentaEntity.setVenta(nuevaVentaInsert);
            detalleVentasRepository.save(detalleVentaEntity);
        }));
    }
}
