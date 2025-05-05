package co.edu.uniquindio.inventario.inventarioapp.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.inventario.inventarioapp.model.Producto;
import co.edu.uniquindio.inventario.inventarioapp.service.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NotificacionInventarioUnoViewController implements Observer {

    private Producto producto;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl_stock;

    @FXML
    void initialize() {
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        producto.agregarObservador(this);
        lbl_stock.setText(String.valueOf(producto.getStock()));
    }

    @Override
    public void actualizar(int stock) {
        lbl_stock.setText(String.valueOf(stock));
    }
}