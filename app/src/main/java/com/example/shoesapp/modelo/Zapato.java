package com.example.shoesapp.modelo;

public class Zapato {
    private int idZapato;
    private String marca;
    private String modelo;
    private int talle;
    private int stock;
    private double precio;
    private byte estado;

    public Zapato() {
    }

    public Zapato(int idZapato, String marca, String modelo, int talle, int stock, double precio, byte estado) {
        this.idZapato = idZapato;
        this.marca = marca;
        this.modelo = modelo;
        this.talle = talle;
        this.stock = stock;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdZapato() {
        return idZapato;
    }

    public void setIdZapato(int idZapato) {
        this.idZapato = idZapato;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTalle() {
        return talle;
    }

    public void setTalle(int talle) {
        this.talle = talle;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Zapato{" +
                "idZapato=" + idZapato +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", talle=" + talle +
                ", stock=" + stock +
                ", precio=" + precio +
                ", estado=" + estado +
                '}';
    }
}
