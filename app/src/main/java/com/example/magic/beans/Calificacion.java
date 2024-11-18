package com.example.magic.beans;

import java.util.Date;

public class Calificacion {
    private int idCalificacion;
    private int idUsuario;
    private int idCarta;
    private int calificacion;
    private String comentario;
    private Date fechaCreacion;

    // Constructor
    public Calificacion(int idCalificacion, int idUsuario, int idCarta, int calificacion, String comentario, Date fechaCreacion) {
        this.idCalificacion = idCalificacion;
        this.idUsuario = idUsuario;
        this.idCarta = idCarta;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters and setters
    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}