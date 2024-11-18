package com.example.magic.Controllers;

import com.example.magic.beans.CarritoCompra;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompraController {
    private List<CarritoCompra> itemsCarrito;

    public CarritoCompraController() {
        this.itemsCarrito = new ArrayList<>();
    }

    public void agregarAlCarrito(CarritoCompra item) {
        itemsCarrito.add(item);
    }

    public CarritoCompra obtenerItemCarrito(int idCarrito) {
        for (CarritoCompra item : itemsCarrito) {
            if (item.getIdCarrito() == idCarrito) {
                return item;
            }
        }
        return null;
    }

    public List<CarritoCompra> obtenerTodosItemsCarrito() {
        return new ArrayList<>(itemsCarrito);
    }

    public List<CarritoCompra> obtenerCarritoPorUsuario(int idUsuario) {
        List<CarritoCompra> carritoUsuario = new ArrayList<>();
        for (CarritoCompra item : itemsCarrito) {
            if (item.getIdUsuario() == idUsuario) {
                carritoUsuario.add(item);
            }
        }
        return carritoUsuario;
    }

    public boolean actualizarItemCarrito(CarritoCompra item) {
        for (int i = 0; i < itemsCarrito.size(); i++) {
            if (itemsCarrito.get(i).getIdCarrito() == item.getIdCarrito()) {
                itemsCarrito.set(i, item);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarItemCarrito(int idCarrito) {
        return itemsCarrito.removeIf(item -> item.getIdCarrito() == idCarrito);
    }

    public void vaciarCarritoPorUsuario(int idUsuario) {
        itemsCarrito.removeIf(item -> item.getIdUsuario() == idUsuario);
    }
}