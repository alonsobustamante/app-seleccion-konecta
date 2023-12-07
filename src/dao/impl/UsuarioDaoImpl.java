package dao.impl;

import dao.UsuarioDao;
import entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {
    private List<Usuario> usuarios;

    public UsuarioDaoImpl() {
        this.usuarios = new ArrayList<>();
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
}
