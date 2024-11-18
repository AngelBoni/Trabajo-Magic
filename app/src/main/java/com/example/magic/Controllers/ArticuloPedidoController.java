package com.example.magic.Controllers;

import com.example.magic.beans.ArticuloPedido;

import java.util.ArrayList;
import java.util.List;

public class ArticuloPedidoController {
    private List<ArticuloPedido> articulosPedido;

    public ArticuloPedidoController() {
        this.articulosPedido = new ArrayList<>();
    }

    public void agregarArticuloPedido(ArticuloPedido articuloPedido) {
        articulosPedido.add(articuloPedido);
    }

    public ArticuloPedido obtenerArticuloPedido(int idArticuloPedido) {
        for (ArticuloPedido articulo : articulosPedido) {
            if (articulo.getIdArticuloPedido() == idArticuloPedido) {
                return articulo;
            }
        }
        return null;
    }

    public List<ArticuloPedido> obtenerTodosArticulosPedido() {
        return new ArrayList<>(articulosPedido);
    }

    public List<ArticuloPedido> obtenerArticulosPorPedido(int idPedido) {
        List<ArticuloPedido> articulosPorPedido = new ArrayList<>();
        for (ArticuloPedido articulo : articulosPedido) {
            if (articulo.getIdPedido() == idPedido) {
                articulosPorPedido.add(articulo);
            }
        }
        return articulosPorPedido;
    }

    public boolean actualizarArticuloPedido(ArticuloPedido articuloPedido) {
        for (int i = 0; i < articulosPedido.size(); i++) {
            if (articulosPedido.get(i).getIdArticuloPedido() == articuloPedido.getIdArticuloPedido()) {
                articulosPedido.set(i, articuloPedido);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarArticuloPedido(int idArticuloPedido) {
        return articulosPedido.removeIf(articulo -> articulo.getIdArticuloPedido() == idArticuloPedido);
    }

    public void eliminarArticulosPorPedido(int idPedido) {
        articulosPedido.removeIf(articulo -> articulo.getIdPedido() == idPedido);
    }
}