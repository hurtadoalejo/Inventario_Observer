package co.edu.uniquindio.inventario.inventarioapp.model;

import co.edu.uniquindio.inventario.inventarioapp.service.Observer;

import java.util.LinkedList;

public class Producto {
    private LinkedList<Observer> observers = new LinkedList<>();
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        notificarObservadores();
    }

    public void agregarObservador(Observer observer) {
        observers.add(observer);
    }

    public void eliminarObservador(Observer observer) {
        observers.remove(observer);
    }

    private void notificarObservadores() {
        for (Observer observer : observers) {
            observer.actualizar(stock);
        }
    }
}