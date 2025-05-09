package co.edu.uniquindio.inventario.inventarioapp.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.inventario.inventarioapp.model.HistorialPagos;
import co.edu.uniquindio.inventario.inventarioapp.model.Producto;
import co.edu.uniquindio.inventario.inventarioapp.service.InventarioObserver;
import co.edu.uniquindio.inventario.inventarioapp.service.PagoObserver;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class NotificacionInventarioUnoViewController implements InventarioObserver, PagoObserver {

    private Producto producto;

    private HistorialPagos historialPagos;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl_stock;

    @FXML
    private TextArea txtArea;

    @FXML
    void initialize() {
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        producto.agregarObservador(this);
        lbl_stock.setText(String.valueOf(producto.getStock()));
    }

    public void setHistorialPagos(HistorialPagos historialPagos) {
        this.historialPagos = historialPagos;
        historialPagos.agregarObservador(this);
    }

    @Override
    public void actualizar(int stock) {
        lbl_stock.setText(String.valueOf(stock));
    }

    @Override
    public void registrarPago(String mensajePago) {
        txtArea.appendText(mensajePago + "\n");
    }
}