package com.example.magic.Controllers;


import com.example.magic.beans.UserRole;
import com.example.magic.beans.Usuario;

import java.util.Date;

public class AuthController {
    private UsuarioController usuarioController;
    private Usuario usuarioActual;

    public AuthController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public boolean registrar(String nombreUsuario, String contrasena, String correo, UserRole rol) {
        // Verificar si el usuario ya existe
        for (Usuario usuario : usuarioController.obtenerTodosUsuarios()) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) ||
                    usuario.getCorreo().equals(correo)) {
                return false;
            }
        }

        // Crear nuevo usuario
        Usuario nuevoUsuario = new Usuario(
                generarNuevoId(),
                nombreUsuario,
                hashPassword(contrasena),
                correo,
                rol,
                false,
                new Date()
        );

        usuarioController.agregarUsuario(nuevoUsuario);
        return true;
    }

    public boolean login(String correo, String contrasena) {
        for (Usuario usuario : usuarioController.obtenerTodosUsuarios()) {
            if (usuario.getCorreo().equals(correo) &&
                    verificarPassword(contrasena, usuario.getContrasena())) {
                usuarioActual = usuario;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        usuarioActual = null;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    private int generarNuevoId() {
        return usuarioController.obtenerTodosUsuarios().size() + 1;
    }

    private String hashPassword(String password) {
        // En una aplicación real, usar un algoritmo de hash seguro
        return password;
    }

    private boolean verificarPassword(String inputPassword, String storedPassword) {
        // En una aplicación real, verificar el hash
        return inputPassword.equals(storedPassword);
    }
}