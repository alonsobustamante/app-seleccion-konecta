package dao;

import entidades.Usuario;
import entidades.UsuarioDTO;

import java.util.List;

public interface UsuarioDao {

    public void agregarUsuario(Usuario usuario);

    public List<Usuario> obtenerUsuarios();

    public Usuario obtenerUsuario(String usuario, String password, String rol);

    public Usuario obtenerUsuario(String dni);

    public Usuario iniciarSesion(UsuarioDTO usuarioDTO);
}
