package com.breadeightn.panaderias.empleados.infrastructure.uicontrollers;

import com.breadeightn.panaderias.PanaderiasApplication;
import com.breadeightn.panaderias.empleados.application.services.EmpleadosServicio;
import com.breadeightn.panaderias.empleados.domain.dto.EmpleadoLoginDto;
import com.breadeightn.panaderias.empleados.domain.model.SesionInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.breadeightn.panaderias.PanaderiasApplication.context;

@Component
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

    public void onLoginSuccess(SesionInfo sesionInfo) {
            // Cargar la vista de la pantalla principal
        FXMLLoader loader = new FXMLLoader(PanaderiasApplication.class.getResource("/views/ventasVendedor.fxml"));
        Parent root = null;
        try {
            loader.setControllerFactory(context::getBean);
            root = loader.load();
            VentasVendedorCtrl ventaController = loader.getController();
            ventaController.initializeSessionInfo(sesionInfo);
        // Crear la escena
            Scene scene = new Scene(root);
        // Obtener el escenario actual
            Stage stage = (Stage) loginButton.getScene().getWindow();
        // Establecer la nueva escena
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
