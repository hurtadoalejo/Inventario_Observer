package co.edu.uniquindio.inventario.inventarioapp.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.inventario.inventarioapp.model.HistorialPagos;
import co.edu.uniquindio.inventario.inventarioapp.model.Producto;
import co.edu.uniquindio.inventario.inventarioapp.service.EstrategiaPago;
import co.edu.uniquindio.inventario.inventarioapp.strategy.PSEPago;
import co.edu.uniquindio.inventario.inventarioapp.strategy.PayPalPago;
import co.edu.uniquindio.inventario.inventarioapp.strategy.TarjetaCreditoPago;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class GestionInventarioViewController {

    private Producto producto;

    private HistorialPagos historialPagos;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cb_metodosPago;

    @FXML
    private Button btn_actualizarStock;

    @FXML
    private Button btn_pagar;

    @FXML
    private TextField txt_monto;

    @FXML
    private TextField txt_stock;

    @FXML
    void onActualizarStock() {
        actualizarStock();
    }

    @FXML
    void onPagar() {
        pagar();
    }

    private void pagar() {
        String metodoPago = cb_metodosPago.getValue();
        if (metodoPago != null) {
            if (!txt_monto.getText().isEmpty()) {
                double monto = Double.parseDouble(txt_monto.getText());
                EstrategiaPago estrategiaPago = obtenerEstrategia(metodoPago);
                if (estrategiaPago != null) {
                    historialPagos.registrarPago(estrategiaPago.pagar(monto));
                }
            } else {
                mostrarMensaje("Monto invalido", "Ingrese un monto valido", Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje("Método de pago sin seleccionar", "Seleccione un método de pago para continuar", Alert.AlertType.WARNING);
        }
    }

    private EstrategiaPago obtenerEstrategia(String metodoPago) {
        if (metodoPago.equalsIgnoreCase("PSE")) {
            return new PSEPago();
        } else if (metodoPago.equalsIgnoreCase("PayPal")) {
            return new PayPalPago();
        } else if (metodoPago.equalsIgnoreCase("Tarjeta de crédito")) {
            return new TarjetaCreditoPago();
        } else {
            return null;
        }
    }

    @FXML
    void initialize() {
        cb_metodosPago.getItems().addAll("PSE", "PayPal", "Tarjeta de crédito");
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setHistorialPagos(HistorialPagos historialPagos) {
        this.historialPagos = historialPagos;
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