package com.example.magic.beans;

import java.util.Date;

public class CarritoCompra {
    private int idCarrito;
    private int idUsuario;
    private int idCarta;
    private int cantidad;
    private Date fechaAgregado;

    // Constructor
    public CarritoCompra(int idCarrito, int idUsuario, int idCarta, int cantidad, Date fechaAgregado) {
        this.idCarrito = idCarrito;
        this.idUsuario = idUsuario;
        this.idCarta = idCarta;
        this.cantidad = cantidad;
        this.fechaAgregado = fechaAgregado;
    }

    // Getters and setters
    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(Date fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }
}