package com.breadeightn.panaderias.fxcontrollers;

import com.breadeightn.panaderias.productos.application.services.ProductoService;
import com.breadeightn.panaderias.productos.domain.model.Producto;
import com.breadeightn.panaderias.ventas.application.services.VentasService;
import com.breadeightn.panaderias.ventas.domain.model.DetalleVenta;
import com.breadeightn.panaderias.ventas.domain.model.ProductoVenta;
import com.breadeightn.panaderias.empleados.domain.model.LoginEmpleado;
import com.breadeightn.panaderias.ventas.domain.model.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Function;

@Component
public class VentasVendedorCtrl implements Initializable, PanaderiaViewController {
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
    private TableColumn<ProductoVenta, String> claveProductoTable;
    @FXML
    private TableColumn<ProductoVenta, Integer> cantidadProductoTable;
    @FXML
    private TableColumn<ProductoVenta, Double> precioProductoTable;
    private LoginEmpleado loginEmpleado;
    private ObservableList<ProductoVenta> productos = FXCollections.observableArrayList();
    private Producto productoActual;
    private final ProductoService productoService;
    private final VentasService ventasService;
    public VentasVendedorCtrl(ProductoService productoService, VentasService ventasService) {
        this.productoService = productoService;
        this.ventasService = ventasService;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        claveProductoTable.setCellFactory(crearCeldaPersonalizada(Producto::getIdPan));
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



    @Override
    public void initializeSessionInfo(LoginEmpleado loginEmpleado) {
        nombreEmpleado.setText(loginEmpleado.getInfoEmpleado().getNombre_completo());
        nombreSucursal.setText("Central");
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        fecha.setText(today.format(formatter));
        this.loginEmpleado = loginEmpleado;
    }

    public void buscarProducto() {
        Optional<Producto> producto = productoService
                .buscarProductoPorClave(claveProductoForm.getText());
        if (producto.isEmpty()) {
            System.out.println("Producto no encontrado");
            return;
        }
        this.productoActual = producto.get();
        nombreProductoForm.setText(productoActual.getNombre());
    }

    public void agregarProducto() {
        Producto producto = Producto.builder()
                .idPan(claveProductoForm.getText())
                .nombre(nombreProductoForm.getText())
                .precio(productoActual.getPrecio())
                .build();
        ProductoVenta productoVenta = ProductoVenta.builder()
                .producto(producto)
                .cantidad(Integer.parseInt(cantidadProductoForm.getText()))
                .build();
        productos.add(productoVenta);
        ventaTable.setItems(productos);
        claveProductoForm.clear();
        nombreProductoForm.clear();
        cantidadProductoForm.clear();
    }

    public void crearVenta() {
        Venta venta = Venta.builder()
                .productos(productos
                        .stream()
                        .map((productoVenta -> {
                            return DetalleVenta.builder()
                                    .pan(productoVenta)
                                    .totalVenta(productoVenta.getProducto().getPrecio() * productoVenta.getCantidad())
                                    .build();
                        })).toList())
                .timestamp(LocalDateTime.now())
                .build();
        venta.setTotalVenta(venta.getProductos()
                .stream()
                .map(DetalleVenta::getTotalVenta)
                .reduce(Double::sum)
                .orElse(0.0)
        );
        ventasService.crearVenta(venta);
    }
}
