package com.breadeightn.panaderias.fxcontrollers;

import com.breadeightn.panaderias.PanaderiasApplication;
import com.breadeightn.panaderias.areas.domain.Area;
import com.breadeightn.panaderias.empleados.application.services.EmpleadosServicio;
import com.breadeightn.panaderias.empleados.domain.dto.EmpleadoLoginDto;
import com.breadeightn.panaderias.empleados.domain.model.LoginEmpleado;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.breadeightn.panaderias.PanaderiasApplication.context;

@Controller
public class LoginCtrl implements Initializable {
    @FXML
    private TextField rfcField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginButton;

    private final EmpleadosServicio empleadosServicio;

    public LoginCtrl(EmpleadosServicio empleadosServicio) {
        this.empleadosServicio = empleadosServicio;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleLogin() {
        String rfc = rfcField.getText();
        String password = passwordField.getText();
        var login = empleadosServicio.autenticarEmpleado(EmpleadoLoginDto.builder()
                .rfc(rfc)
                .password(password)
                .build());
        if (login.isEmpty()) {
            System.out.println("Error en login");
            return;
        }
        onLoginSuccess(login.get());
    }

    public void onLoginSuccess(LoginEmpleado loginEmpleado) {
            // Cargar la vista de la pantalla principal
        FXMLLoader loader = getView(loginEmpleado.getArea());
        Parent root = null;
        try {
            loader.setControllerFactory(context::getBean);
            root = loader.load();
            PanaderiaViewController controller = loader.getController();
            controller.initializeSessionInfo(loginEmpleado);
            Scene scene = new Scene(root);
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private FXMLLoader getView(Area area) {
        String vista = switch (area) {
            case VENTAS -> "ventasVendedor";
            case INVENTARIO -> "inventario";
        };
        return new FXMLLoader(PanaderiasApplication.class.getResource("/views/" + vista + ".fxml"));
    }
}
