package com.example.magic.Controllers;

import com.example.magic.beans.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartaController {
    private List<Carta> cartas;
    private CalificacionController calificacionController;

    public CartaController() {
        this.cartas = new ArrayList<>();
        this.calificacionController = new CalificacionController();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public Carta obtenerCarta(int idCarta) {
        return cartas.stream()
                .filter(c -> c.getIdCarta() == idCarta)
                .findFirst()
                .orElse(null);
    }

    public List<Carta> obtenerTodasCartas() {
        return new ArrayList<>(cartas);
    }

    public List<Carta> obtenerCartasPorCategoria(int idCategoria) {
        return cartas.stream()
                .filter(c -> c.getIdCategoria() == idCategoria)
                .collect(Collectors.toList());
    }

    public List<Carta> buscarCartas(String query) {
        return cartas.stream()
                .filter(c -> c.getNombre().toLowerCase().contains(query.toLowerCase()) ||
                        c.getDescripcion().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Carta> obtenerCartasMasPuntuadas(int limite) {
        return cartas.stream()
                .sorted((c1, c2) -> Float.compare(
                        calificacionController.obtenerCalificacionPromedio(c2.getIdCarta()),
                        calificacionController.obtenerCalificacionPromedio(c1.getIdCarta())
                ))
                .limit(limite)
                .collect(Collectors.toList());
    }

    public boolean actualizarCarta(Carta carta) {
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).getIdCarta() == carta.getIdCarta()) {
                cartas.set(i, carta);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCarta(int idCarta) {
        return cartas.removeIf(c -> c.getIdCarta() == idCarta);
    }
}