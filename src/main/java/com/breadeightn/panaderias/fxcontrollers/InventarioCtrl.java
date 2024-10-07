package com.breadeightn.panaderias.fxcontrollers;

import com.breadeightn.panaderias.PanaderiasApplication;
import com.breadeightn.panaderias.empleados.domain.model.LoginEmpleado;
import com.breadeightn.panaderias.inventario.application.service.InventarioService;
import com.breadeightn.panaderias.inventario.domain.model.Inventario;
import com.breadeightn.panaderias.productos.application.services.ProductoService;
import com.breadeightn.panaderias.productos.domain.model.Producto;
import com.breadeightn.panaderias.productos.domain.model.TipoProducto;

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

    @FXML
    private TableView<Inventario> actualizacionTable;

    @FXML
    private TableColumn<Inventario, String> claveProductoColumn1;

    @FXML
    private TableColumn<Inventario, String> tipoProductoColumn1;

    @FXML
    private TableColumn<Inventario, String> nombreProductoColumn1;

    @FXML
    private TableColumn<Inventario, Double> precioProductoColumn1;

    @FXML
    private TableColumn<Inventario, Integer> productosVendidosColumn1;

    @FXML
    private TableColumn<Inventario, Integer> cantidadProductoColumn1;

    private ObservableList<Inventario> listaInventario;

    private ObservableList<Inventario> listaActualizacion;

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
        inicializarTablaNuevosProductos();
    }

    @Override
    public void initializeSessionInfo(LoginEmpleado loginEmpleado) {
    }

    public void initializeInventario() {
        listaInventario = FXCollections.observableArrayList(inventarioService.obtenerInventario());
        listaActualizacion = FXCollections.observableArrayList();

    }

    public void inicializarTablaNuevosProductos() {
        // Inicializa la lista de actualización
        listaActualizacion = FXCollections.observableArrayList();

        // Configura las celdas de la tabla de actualización
        claveProductoColumn1
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPan().getIdPan()));
        tipoProductoColumn1.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getPan().getTipo().getNombreTipo()));
        nombreProductoColumn1
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPan().getNombre()));
        precioProductoColumn1
                .setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPan().getPrecio()));
        productosVendidosColumn1
                .setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getUnidadesVendidas()));
        cantidadProductoColumn1
                .setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getInventario()));

        // Hacer todas las columnas editables
        claveProductoColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
        claveProductoColumn1.setOnEditCommit(event -> {
            Inventario inventario = event.getRowValue();
            inventario.getPan().setIdPan(event.getNewValue());
            inventario.getPan().getTipo().setIdTipo(event.getNewValue().substring(0, 2));
        });

        tipoProductoColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
        tipoProductoColumn1.setOnEditCommit(event -> {
            Inventario inventario = event.getRowValue();
            inventario.getPan().getTipo().setNombreTipo(event.getNewValue()); // Asegúrate de tener un setter adecuado
        });

        nombreProductoColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
        nombreProductoColumn1.setOnEditCommit(event -> {
            Inventario inventario = event.getRowValue();
            inventario.getPan().setNombre(event.getNewValue()); // Asegúrate de tener un setter adecuado
        });

        precioProductoColumn1.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        precioProductoColumn1.setOnEditCommit(event -> {
            Inventario inventario = event.getRowValue();
            inventario.getPan().setPrecio(event.getNewValue());
        });

        productosVendidosColumn1.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        productosVendidosColumn1.setOnEditCommit(event -> {
            Inventario inventario = event.getRowValue();
            inventario.setUnidadesVendidas(event.getNewValue());
        });

        cantidadProductoColumn1.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        cantidadProductoColumn1.setOnEditCommit(event -> {
            Inventario inventario = event.getRowValue();
            inventario.setInventario(event.getNewValue());
        });

        actualizacionTable.setEditable(true);
        ;
        claveProductoColumn1.setEditable(true);
        tipoProductoColumn1.setEditable(true);
        nombreProductoColumn1.setEditable(true);
        precioProductoColumn1.setEditable(true);
        productosVendidosColumn1.setEditable(true);
        cantidadProductoColumn1.setEditable(true);

        // Asignar los datos a la tabla
        actualizacionTable.setItems(listaActualizacion);
    }

    public void inicializarTabla() {
        // Configurar las celdas de la tabla
        claveProductoColumn
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPan().getIdPan()));
        tipoProductoColumn
                .setCellValueFactory(
                        cellData -> new SimpleStringProperty(cellData.getValue().getPan().getTipo().getNombreTipo()));
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

    @FXML
    private void nuevo() {
        Inventario nuevoInventario = Inventario.builder()
                .cantidadCorte(0)
                .inventario(0)
                .pan(Producto.builder()
                        .idPan("")
                        .nombre("")
                        .precio(0.0)
                        .tipo(TipoProducto.builder()
                                .idTipo("")
                                .nombreTipo("").build())
                        .build())
                .unidadesVendidas(0).build();
        listaActualizacion.add(nuevoInventario);
        actualizacionTable.setItems(listaActualizacion);
    }

    @FXML
    private void confirmar() {
        // Validar y guardar en la base de datos
        for (Inventario inventario : listaActualizacion) {
            // Asegúrate de que todos los campos estén llenos
            if (validarInventario(inventario)) {
                // Guardar el inventario en la base de datos
                inventarioService.actualizarEntradaInventario(inventario);
            } else {
                // Manejar la validación que falló (puedes mostrar un mensaje de error)
            }
        }
        listaActualizacion.clear(); // Limpia la lista después de confirmar
        actualizacionTable.refresh(); // Refresca la tabla
        ObservableList<Inventario> listaInventarioActualizada = FXCollections.observableArrayList(inventarioService.obtenerInventario());
        inventarioTable.getItems().clear();
        inventarioTable.getItems().addAll(listaInventarioActualizada);
    }

    private boolean validarInventario(Inventario inventario) {
        // Verificar que el producto no sea nulo
        if (inventario.getPan() == null || inventario.getPan().getIdPan() == null
                || inventario.getPan().getNombre() == null) {
            System.out.println("El producto es nulo o no tiene un ID o nombre válido.");
            return false; // Producto debe ser válido
        }

        // Verificar que la cantidad de corte sea mayor o igual a cero
        if (inventario.getCantidadCorte() == null || inventario.getCantidadCorte() < 0) {
            System.out.println("La cantidad de corte debe ser un número mayor o igual a cero.");
            return false; // Validación de cantidad de corte
        }

        // Verificar que las unidades vendidas sean mayor o igual a cero
        if (inventario.getUnidadesVendidas() == null || inventario.getUnidadesVendidas() < 0) {
            System.out.println("Las unidades vendidas deben ser un número mayor o igual a cero.");
            return false; // Validación de unidades vendidas
        }

        // Verificar que el inventario sea mayor o igual a cero
        if (inventario.getInventario() == null || inventario.getInventario() < 0) {
            System.out.println("El inventario debe ser un número mayor o igual a cero.");
            return false; // Validación de inventario
        }

        // Si todas las validaciones pasan, devuelve true
        return true;
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
