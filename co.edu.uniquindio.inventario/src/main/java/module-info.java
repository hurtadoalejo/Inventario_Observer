module co.edu.uniquindio.inventario.inventarioapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.inventario.inventarioapp to javafx.fxml;
    exports co.edu.uniquindio.inventario.inventarioapp;
}