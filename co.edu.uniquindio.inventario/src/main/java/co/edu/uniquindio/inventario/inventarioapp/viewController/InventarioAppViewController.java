package co.edu.uniquindio.inventario.inventarioapp.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.inventario.inventarioapp.model.HistorialPagos;
import co.edu.uniquindio.inventario.inventarioapp.model.Producto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

public class InventarioAppViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab tab_NotificacionInventarioDos;

    @FXML
    private Tab tab_administradorInventario;

    @FXML
    private Tab tab_NotificacionInventarioUno;

    @FXML
    void initialize() throws IOException {
        Producto producto = new Producto();
        HistorialPagos historialPagos = new HistorialPagos();

        FXMLLoader gestionInventarioLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/inventario/inventarioapp/GestionInventario.fxml"));
        tab_administradorInventario.setContent(gestionInventarioLoader.load());
        GestionInventarioViewController gestionInventarioViewController = gestionInventarioLoader.getController();
        gestionInventarioViewController.setProducto(producto);
        gestionInventarioViewController.setHistorialPagos(historialPagos);

        FXMLLoader notificacionInventarioUnoLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/inventario/inventarioapp/InventarioUno.fxml"));
        tab_NotificacionInventarioUno.setContent(notificacionInventarioUnoLoader.load());
        NotificacionInventarioUnoViewController notificacionInventarioUnoViewController = notificacionInventarioUnoLoader.getController();
        notificacionInventarioUnoViewController.setProducto(producto);
        notificacionInventarioUnoViewController.setHistorialPagos(historialPagos);

        FXMLLoader notificacionInventarioDosLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/inventario/inventarioapp/InventarioUno.fxml"));
        tab_NotificacionInventarioDos.setContent(notificacionInventarioDosLoader.load());
        NotificacionInventarioUnoViewController notificacionInventarioDosViewController = notificacionInventarioDosLoader.getController();
        notificacionInventarioDosViewController.setProducto(producto);
        notificacionInventarioDosViewController.setHistorialPagos(historialPagos);
    }
}