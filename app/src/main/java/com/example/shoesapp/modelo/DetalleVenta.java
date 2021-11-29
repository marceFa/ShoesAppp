package com.example.shoesapp.modelo;

public class DetalleVenta {
    private int idDetalleVenta;
    private double precio;
    private int cantidad;
    private int idVenta;
    private int idZapato;
    private Venta venta;
    private Zapato zapato;

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta, double precio, int cantidad, int idVenta, int idZapato, Venta venta, Zapato zapato) {
        this.idDetalleVenta = idDetalleVenta;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idVenta = idVenta;
        this.idZapato = idZapato;
        this.venta = venta;
        this.zapato = zapato;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdZapato() {
        return idZapato;
    }

    public void setIdZapato(int idZapato) {
        this.idZapato = idZapato;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Zapato getZapato() {
        return zapato;
    }

    public void setZapato(Zapato zapato) {
        this.zapato = zapato;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "idDetalleVenta=" + idDetalleVenta +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", idVenta=" + idVenta +
                ", idZapato=" + idZapato +
                ", venta=" + venta +
                ", zapato=" + zapato +
                '}';
    }
}
