package dao.impl;

import dao.UsuarioDao;
import entidades.Usuario;
import entidades.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {
    private List<Usuario> usuarios;

    public UsuarioDaoImpl() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    @Override
    public Usuario obtenerUsuario(String dni) {
        for(Usuario u : usuarios) {
            if (u.getDni().equals(dni)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Usuario obtenerUsuario(String usuario, String password, String rol) {
        for(Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Usuario iniciarSesion(UsuarioDTO usuario) {
        for(Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario.getUsuario()) && u.getPassword().equals(usuario.getPassword()) && u.getRol().equals(usuario.getRol())) {
                return u;
            }
        }
        return null;
    }
}
