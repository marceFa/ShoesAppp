package com.example.shoesapp.modelo;

import java.util.Date;

public class Cuota {
    private int idCuota;
    private int nroCuota;
    private Date fecha;
    private Double monto;
    private String estado;
    private int idPago;
    private Pago pago;

    public Cuota() {
    }

    public Cuota(int idCuota, int nroCuota, Date fecha, Double monto, String estado, int idPago, Pago pago) {
        this.idCuota = idCuota;
        this.nroCuota = nroCuota;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
        this.idPago = idPago;
        this.pago = pago;
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public int getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(int nroCuota) {
        this.nroCuota = nroCuota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Cuota{" +
                "idCuota=" + idCuota +
                ", nroCuota=" + nroCuota +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", estado='" + estado + '\'' +
                ", idPago=" + idPago +
                ", pago=" + pago +
                '}';
    }

}
