package com.example.shoesapp.modelo;

public class Pago {
    private int idPago;
    private int cantidadCuotas;
    private String Estado;
    private int idVenta;
    private Venta venta;

    public Pago() {
    }

    public Pago(int idPago, int cantidadCuotas, String estado, int idVenta, Venta venta) {
        this.idPago = idPago;
        this.cantidadCuotas = cantidadCuotas;
        Estado = estado;
        this.idVenta = idVenta;
        this.venta = venta;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "idPago=" + idPago +
                ", cantidadCuotas=" + cantidadCuotas +
                ", Estado='" + Estado + '\'' +
                ", idVenta=" + idVenta +
                ", venta=" + venta +
                '}';
    }
}


