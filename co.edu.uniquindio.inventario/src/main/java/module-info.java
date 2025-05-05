module co.edu.uniquindio.inventario.inventarioapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.inventario.inventarioapp to javafx.fxml;
    exports co.edu.uniquindio.inventario.inventarioapp;

    opens co.edu.uniquindio.inventario.inventarioapp.viewController to javafx.fxml;
    exports co.edu.uniquindio.inventario.inventarioapp.viewController;

    /*opens co.edu.uniquindio.inventario.inventarioapp.controller to javafx.fxml;
    exports co.edu.uniquindio.inventario.inventarioapp.controller;*/
}