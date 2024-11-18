package com.example.magic.Controllers;

import com.example.magic.beans.Calificacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalificacionController {
    private List<Calificacion> calificaciones;

    public CalificacionController() {
        this.calificaciones = new ArrayList<>();
    }

    public void agregarCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }

    public List<Calificacion> obtenerCalificacionesPorCarta(int idCarta) {
        return calificaciones.stream()
                .filter(c -> c.getIdCarta() == idCarta)
                .collect(Collectors.toList());
    }

    public float obtenerCalificacionPromedio(int idCarta) {
        List<Calificacion> calificacionesCarta = obtenerCalificacionesPorCarta(idCarta);
        if (calificacionesCarta.isEmpty()) {
            return 0;
        }
        int sumaCalificaciones = calificacionesCarta.stream()
                .mapToInt(Calificacion::getPuntuacion)
                .sum();
        return (float) sumaCalificaciones / calificacionesCarta.size();
    }

    public boolean actualizarCalificacion(Calificacion calificacion) {
        for (int i = 0; i < calificaciones.size(); i++) {
            if (calificaciones.get(i).getIdCalificacion() == calificacion.getIdCalificacion()) {
                calificaciones.set(i, calificacion);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCalificacion(int idCalificacion) {
        return calificaciones.removeIf(c -> c.getIdCalificacion() == idCalificacion);
    }
}