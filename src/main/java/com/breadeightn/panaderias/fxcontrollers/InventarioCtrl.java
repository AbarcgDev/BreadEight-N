package com.breadeightn.panaderias.fxcontrollers;

import com.breadeightn.panaderias.PanaderiasApplication;
import com.breadeightn.panaderias.empleados.domain.model.LoginEmpleado;
import com.breadeightn.panaderias.inventario.application.service.InventarioService;
import com.breadeightn.panaderias.inventario.domain.model.Inventario;
import com.breadeightn.panaderias.productos.application.services.ProductoService;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.breadeightn.panaderias.PanaderiasApplication.context;

@Controller
public class InventarioCtrl implements Initializable, PanaderiaViewController {
    @FXML
    private TableView<Inventario> inventarioTable;

    @FXML
    private TableColumn<Inventario, String> claveProductoColumn;

    @FXML
    private TableColumn<Inventario, String> tipoProductoColumn;

    @FXML
    private TableColumn<Inventario, String> nombreProductoColumn;

    @FXML
    private TableColumn<Inventario, Double> precioProductoColumn;

    @FXML
    private TableColumn<Inventario, Integer> productosVendidosColumn;

    @FXML
    private TableColumn<Inventario, Integer> cantidadProductoColumn;

    private ObservableList<Inventario> listaInventario;

    private final InventarioService inventarioService;

    private final ProductoService productoService;

    public InventarioCtrl(InventarioService inventarioService, ProductoService productoService) {
        this.inventarioService = inventarioService;
        this.productoService = productoService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeInventario();
        inicializarTabla();
    }

    @Override
    public void initializeSessionInfo(LoginEmpleado loginEmpleado) {
    }

    public void initializeInventario() {
        listaInventario = FXCollections.observableArrayList(inventarioService.obtenerInventario());
    }

    public void inicializarTabla() {
        // Configurar las celdas de la tabla
        claveProductoColumn
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPan().getIdPan()));
        tipoProductoColumn
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPan().getTipo().getNombreTipo()));
        nombreProductoColumn
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPan().getNombre()));
        precioProductoColumn.setCellValueFactory(
                cellData -> new SimpleObjectProperty<Double>(cellData.getValue().getPan().getPrecio()));
        productosVendidosColumn.setCellValueFactory(
                cellData -> new SimpleObjectProperty<Integer>(cellData.getValue().getUnidadesVendidas()));
        cantidadProductoColumn.setCellValueFactory(
                cellData -> new SimpleObjectProperty<Integer>(cellData.getValue().getInventario()));

        precioProductoColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        precioProductoColumn.setOnEditCommit(event -> {
            Inventario inventario = event.getRowValue();
            inventario.getPan().setPrecio(event.getNewValue());
            productoService.guardarProducto(inventario.getPan());
            inventarioTable.refresh();
        });

        cantidadProductoColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        cantidadProductoColumn.setOnEditCommit(event -> {
            Inventario inventario = event.getRowValue();
            inventario.setInventario(event.getNewValue());
            inventarioService.actualizarEntradaInventario(inventario);
            inventarioTable.refresh();
        });

        cantidadProductoColumn.setEditable(true);
        precioProductoColumn.setEditable(true);
        inventarioTable.setEditable(true);

        // Asignar los datos a la tabla
        inventarioTable.getItems().setAll(listaInventario);
    }

    public void salir() {
        FXMLLoader loader = new FXMLLoader(PanaderiasApplication.class.getResource("/views/login.fxml"));
        Parent root = null;
        try {
            loader.setControllerFactory(context::getBean);
            root = loader.load();
            LoginCtrl controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = (Stage) inventarioTable.getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
