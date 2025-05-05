package co.edu.uniquindio.inventario.inventarioapp.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.inventario.inventarioapp.model.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GestionInventarioViewController {

    private Producto producto;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_actualizarStock;

    @FXML
    private TextField txt_stock;

    @FXML
    void onActualizarStock() {
        actualizarStock();
    }

    @FXML
    void initialize() {
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    private void actualizarStock() {
        try {
            int stock = Integer.parseInt(txt_stock.getText());
            producto.setStock(stock);
        } catch (NumberFormatException e) {
            mostrarMensaje("Stock invalido", "Ingrese un número de stock valido", Alert.AlertType.WARNING);
        }
    }

    public void mostrarMensaje(String titulo, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText("Notificación");
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}