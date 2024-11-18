package com.example.magic.Controllers;

import com.example.magic.beans.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaController {
    private List<Categoria> categorias;

    public CategoriaController() {
        this.categorias = new ArrayList<>();
        // Inicializar con las categorías predefinidas
        categorias.add(new Categoria(1, "Rojo"));
        categorias.add(new Categoria(2, "Azul"));
        categorias.add(new Categoria(3, "Verde"));
        categorias.add(new Categoria(4, "Blanco"));
        categorias.add(new Categoria(5, "Negro"));
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public Categoria obtenerCategoria(int idCategoria) {
        for (Categoria categoria : categorias) {
            if (categoria.getIdCategoria() == idCategoria) {
                return categoria;
            }
        }
        return null;
    }

    public List<Categoria> obtenerTodasCategorias() {
        return new ArrayList<>(categorias);
    }

    public boolean actualizarCategoria(Categoria categoria) {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getIdCategoria() == categoria.getIdCategoria()) {
                categorias.set(i, categoria);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCategoria(int idCategoria) {
        return categorias.removeIf(categoria -> categoria.getIdCategoria() == idCategoria);
    }
}