package co.edu.uniquindio.inventario.inventarioapp.strategy;

import co.edu.uniquindio.inventario.inventarioapp.service.EstrategiaPago;

public class TarjetaCreditoPago implements EstrategiaPago {
    @Override
    public String pagar(double monto) {
        return "Pago de " + monto + " pesos, realizado con Tarjeta de Crédito";
    }
}
