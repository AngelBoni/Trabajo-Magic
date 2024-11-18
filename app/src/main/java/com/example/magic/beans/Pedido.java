package com.example.magic.beans;


import java.util.Date;

public class Pedido {
    private int idPedido;
    private int idUsuario;
    private float Total;
    private String estado;
    private Date fechaCreacion;

    // Constructor
    public Pedido(int idPedido, int idUsuario, float Total, String estado, Date fechaCreacion) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.Total = Total;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters and setters
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(Float Total) {
        this.Total = Total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}