package com.example.magic.Controllers;

import com.example.magic.beans.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {
    private List<Pedido> pedidos;

    public PedidoController() {
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Pedido obtenerPedido(int idPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                return pedido;
            }
        }
        return null;
    }

    public List<Pedido> obtenerTodosPedidos() {
        return new ArrayList<>(pedidos);
    }

    public boolean actualizarPedido(Pedido pedido) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getIdPedido() == pedido.getIdPedido()) {
                pedidos.set(i, pedido);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPedido(int idPedido) {
        return pedidos.removeIf(pedido -> pedido.getIdPedido() == idPedido);
    }
}