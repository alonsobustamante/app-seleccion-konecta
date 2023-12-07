package dao;

import entidades.Usuario;

public interface UsuarioDao {

    public Usuario obtenerUsuario(String usuario, String password, String rol);
}
