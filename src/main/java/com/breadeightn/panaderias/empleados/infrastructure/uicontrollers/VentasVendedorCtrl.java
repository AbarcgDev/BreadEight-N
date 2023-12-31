package com.breadeightn.panaderias.empleados.infrastructure.uicontrollers;

import com.breadeightn.panaderias.productos.application.services.ProductoService;
import com.breadeightn.panaderias.productos.domain.model.Producto;
import com.breadeightn.panaderias.empleados.domain.model.ProductoVenta;
import com.breadeightn.panaderias.empleados.domain.model.SesionInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Function;

@Component
public class VentasVendedorCtrl implements Initializable {
    @FXML
    private Label nombreEmpleado;
    @FXML
    private Label nombreSucursal;
    @FXML
    private Label fecha;
    @FXML
    private TextField nombreProductoForm;
    @FXML
    private TextField claveProductoForm;
    @FXML
    private TextField cantidadProductoForm;
    @FXML
    private TableView<ProductoVenta> ventaTable;
    @FXML
    private TableColumn<ProductoVenta, String> nombreProductoTable;
    @FXML
    private TableColumn<ProductoVenta, Long> claveProductoTable;
    @FXML
    private TableColumn<ProductoVenta, Integer> cantidadProductoTable;
    @FXML
    private TableColumn<ProductoVenta, Double> precioProductoTable;
    private SesionInfo sesionInfo;
    private ObservableList<ProductoVenta> productos = FXCollections.observableArrayList();
    private Producto productoActual;
    private final ProductoService productoService;

    public VentasVendedorCtrl(ProductoService productoService) {
        this.productoService = productoService;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        claveProductoTable.setCellFactory(crearCeldaPersonalizada(Producto::getClave));
        cantidadProductoTable.setCellFactory(crearCeldaPersonalizadaCantidad(ProductoVenta::getCantidad));
        nombreProductoTable.setCellFactory(crearCeldaPersonalizada(Producto::getNombre));
        precioProductoTable.setCellFactory(crearCeldaPersonalizada(Producto::getPrecio));
    }

    private <T> Callback<TableColumn<ProductoVenta, T>, TableCell<ProductoVenta, T>> crearCeldaPersonalizada(
            Function<Producto, T> propiedad) {
        return (TableColumn<ProductoVenta, T> param) -> {
            final TableCell<ProductoVenta, T> cell = new TableCell<ProductoVenta, T>() {
                @Override
                public void updateItem(T item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        ProductoVenta productoVenta = getTableView().getItems().get(getIndex());
                        Producto producto = productoVenta.getProducto();
                        setText(propiedad.apply(producto).toString());
                    }
                }
            };
            return cell;
        };
    }

    private <T> Callback<TableColumn<ProductoVenta, T>, TableCell<ProductoVenta, T>> crearCeldaPersonalizadaCantidad(
            Function<ProductoVenta, T> propiedad) {
        return (TableColumn<ProductoVenta, T> param) -> {
            final TableCell<ProductoVenta, T> cell = new TableCell<ProductoVenta, T>() {
                @Override
                public void updateItem(T item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        ProductoVenta productoVenta = getTableView().getItems().get(getIndex());
                        setText(propiedad.apply(productoVenta).toString());
                    }
                }
            };
            return cell;
        };
    }



    public void initializeSessionInfo(SesionInfo sesionInfo) {
        nombreEmpleado.setText(sesionInfo.getNombre());
        nombreSucursal.setText("Central");
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        fecha.setText(today.format(formatter));
        this.sesionInfo = sesionInfo;
    }

    public void buscarProducto() {
        Optional<Producto> producto = productoService
                .buscarProductoPorClave(Long.parseLong(claveProductoForm.getText()));
        if (producto.isEmpty()) {
            System.out.println("Producto no encontrado");
            return;
        }
        this.productoActual = producto.get();
        nombreProductoForm.setText(productoActual.getNombre());
    }

    public void agregarProducto() {
        Producto producto = Producto.builder()
                .clave(Long.parseLong(claveProductoForm.getText()))
                .nombre(nombreProductoForm.getText())
                .precio(productoActual.getPrecio())
                .build();
        ProductoVenta productoVenta= ProductoVenta.builder()
                .producto(producto)
                .cantidad(Integer.parseInt(cantidadProductoForm.getText()))
                .build();
        productos.add(productoVenta);
        ventaTable.setItems(productos);
        claveProductoForm.clear();
        nombreProductoForm.clear();
        cantidadProductoForm.clear();
    }
}
