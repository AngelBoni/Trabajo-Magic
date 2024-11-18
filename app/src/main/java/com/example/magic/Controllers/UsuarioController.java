package com.example.magic.Controllers;

import com.example.magic.beans.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario obtenerUsuario(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public boolean actualizarUsuario(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario() == usuario.getIdUsuario()) {
                usuarios.set(i, usuario);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarUsuario(int idUsuario) {
        return usuarios.removeIf(usuario -> usuario.getIdUsuario() == idUsuario);
    }
}