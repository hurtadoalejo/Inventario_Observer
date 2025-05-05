package co.edu.uniquindio.inventario.inventarioapp.model;

import co.edu.uniquindio.inventario.inventarioapp.service.Observer;

public class ClienteObserver implements Observer {
    private Producto producto;

    public ClienteObserver(Producto producto) {
        this.producto = producto;
        this.producto.agregarObservador(this);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public void actualizar(int stock) {
        System.out.println("Nuevo stock: " + stock);
    }
}