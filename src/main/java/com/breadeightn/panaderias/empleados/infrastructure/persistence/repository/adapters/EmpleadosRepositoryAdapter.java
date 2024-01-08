package com.breadeightn.panaderias.empleados.infrastructure.persistence.repository.adapters;

import com.breadeightn.panaderias.areas.domain.Area;
import com.breadeightn.panaderias.empleados.domain.dto.EmpleadoLoginDto;
import com.breadeightn.panaderias.empleados.domain.model.InfoEmpleado;
import com.breadeightn.panaderias.empleados.domain.model.LoginEmpleado;
import com.breadeightn.panaderias.empleados.domain.ports.out.EmpleadosRepositoryPort;
import com.breadeightn.panaderias.empleados.infrastructure.persistence.entity.InfoEmpleadoEntity;
import com.breadeightn.panaderias.empleados.infrastructure.persistence.entity.LoginEmpleadoEntity;
import com.breadeightn.panaderias.empleados.infrastructure.persistence.repository.EmpleadosRepository;
import com.breadeightn.panaderias.empleados.infrastructure.persistence.repository.LoginEmpleadoRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Data
@Component
public class EmpleadosRepositoryAdapter implements EmpleadosRepositoryPort {
    private final EmpleadosRepository empleadosRepository;
    private final LoginEmpleadoRepository loginRepository;
    @Override
    public InfoEmpleado guardar(InfoEmpleado infoEmpleado) {
        return null;
    }

    @Override
    public Optional<InfoEmpleado> encontrarPorRFC(String rfc) {
        return Optional.empty();
    }

    @Override
    public Optional<InfoEmpleado> actualizar(InfoEmpleado infoEmpleadoActualizado) {
        return Optional.empty();
    }

    @Override
    public Optional<InfoEmpleado> eliminarPorRFC(String rfc) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<LoginEmpleado> autenticar(EmpleadoLoginDto loginInfo) {
        Optional<InfoEmpleadoEntity> user = empleadosRepository.findById(loginInfo.getRfc());
        Optional<LoginEmpleado> result = Optional.empty();
        if (user.isPresent()) {
            Optional<LoginEmpleadoEntity> login = user.get()
                    .getLoginEmpleadoEntities()
                    .stream()
                    .filter(loginEmpleadoEntity -> loginEmpleadoEntity.getPass().equals(loginInfo.getPassword()))
                    .findFirst();
            if (login.isPresent()) {
                result = Optional.of(LoginEmpleado
                        .builder()
                        .rol(user.get().getRol())
                        .area(Area.get(user.get().getArea()))
                        .infoEmpleado(login.get().getInfoEmpleado().toModel())
                        .build());
            }
        }
        return result;
    }
}
