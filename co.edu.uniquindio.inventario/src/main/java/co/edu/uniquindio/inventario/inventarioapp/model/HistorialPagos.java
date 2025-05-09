package co.edu.uniquindio.inventario.inventarioapp.model;

import co.edu.uniquindio.inventario.inventarioapp.service.PagoObserver;

import java.util.ArrayList;
import java.util.List;

public class HistorialPagos {
    private List<PagoObserver> observadores = new ArrayList<>();

    public void agregarObservador(PagoObserver observador){
        observadores.add(observador);
    }

    public void eliminarObservador(PagoObserver observador){
        observadores.remove(observador);
    }

    public void registrarPago(String mensajePago){
        notificarObservadores(mensajePago);
    }

    public void notificarObservadores(String mensajePago){
        for (PagoObserver observador : observadores) {
            observador.registrarPago(mensajePago);
        }
    }
}