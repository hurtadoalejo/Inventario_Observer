package co.edu.uniquindio.inventario.inventarioapp.model;

import co.edu.uniquindio.inventario.inventarioapp.service.InventarioObserver;

import java.util.LinkedList;

public class Producto {
    private LinkedList<InventarioObserver> inventarioObservers = new LinkedList<>();
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        notificarObservadores();
    }

    public void agregarObservador(InventarioObserver inventarioObserver) {
        inventarioObservers.add(inventarioObserver);
    }

    public void eliminarObservador(InventarioObserver inventarioObserver) {
        inventarioObservers.remove(inventarioObserver);
    }

    private void notificarObservadores() {
        for (InventarioObserver inventarioObserver : inventarioObservers) {
            inventarioObserver.actualizar(stock);
        }
    }
}