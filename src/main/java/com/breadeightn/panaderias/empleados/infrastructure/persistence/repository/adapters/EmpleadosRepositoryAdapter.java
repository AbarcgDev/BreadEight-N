package com.breadeightn.panaderias.empleados.infrastructure.persistence.repository.adapters;

import com.breadeightn.panaderias.empleados.domain.dto.EmpleadoLoginDto;
import com.breadeightn.panaderias.empleados.domain.model.Empleado;
import com.breadeightn.panaderias.empleados.domain.model.SesionInfo;
import com.breadeightn.panaderias.empleados.domain.ports.out.EmpleadosRepositoryPort;
import com.breadeightn.panaderias.empleados.infrastructure.persistence.entity.EmpleadoEntity;
import com.breadeightn.panaderias.empleados.infrastructure.persistence.repository.EmpleadosRepository;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Data
@Component
public class EmpleadosRepositoryAdapter implements EmpleadosRepositoryPort {
    private final EmpleadosRepository empleadosRepository;
    @Override
    public Empleado guardar(Empleado empleado) {
        return null;
    }

    @Override
    public Optional<Empleado> encontrarPorRFC(String rfc) {
        return Optional.empty();
    }

    @Override
    public Optional<Empleado> actualizar(Empleado empleadoActualizado) {
        return Optional.empty();
    }

    @Override
    public Optional<Empleado> eliminarPorRFC(String rfc) {
        return Optional.empty();
    }

    @Override
    public Optional<SesionInfo> autenticar(EmpleadoLoginDto loginInfo) {
        Optional<EmpleadoEntity> user = empleadosRepository.findById(loginInfo.getRfc());
        Optional<SesionInfo> result = Optional.empty();
        if (user.isPresent() && user.get().getPassword().matches(loginInfo.getPassword())) {
            result = Optional.of(SesionInfo
                    .builder()
                    .nombre(user.get().getNombre())
                    .rol(user.get().getRol())
                    .rfc(user.get().getRfc())
                    .area(user.get().getArea())
                    .build());
        }
        return result;
    }
}
