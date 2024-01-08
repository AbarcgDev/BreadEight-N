package com.breadeightn.panaderias.fxcontrollers;

import com.breadeightn.panaderias.empleados.domain.model.LoginEmpleado;
import javafx.fxml.Initializable;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class RecursosHumanosCtrl implements Initializable, PanaderiaViewController {
    private LoginEmpleado loginEmpleado;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initializeSessionInfo(LoginEmpleado loginEmpleado) {
        this.loginEmpleado = loginEmpleado;
    }
}
