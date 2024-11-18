package com.example.magic.beans;


public class ArticuloPedido {
    private int idArticuloPedido;
    private int idPedido;
    private int idCarta;
    private int cantidad;
    private float precioPorUnidad;

    // Constructor
    public ArticuloPedido(int idArticuloPedido, int idPedido, int idCarta, int cantidad,float precioPorUnidad) {
        this.idArticuloPedido = idArticuloPedido;
        this.idPedido = idPedido;
        this.idCarta = idCarta;
        this.cantidad = cantidad;
        this.precioPorUnidad = precioPorUnidad;
    }

    // Getters and setters
    public int getIdArticuloPedido() {
        return idArticuloPedido;
    }

    public void setIdArticuloPedido(int idArticuloPedido) {
        this.idArticuloPedido = idArticuloPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public float getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(float precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }
}