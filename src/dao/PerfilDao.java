package dao;

import entidades.Perfil;

import java.util.List;

public interface PerfilDao {

    public void agregarPerfil(Perfil perfil);

    public Perfil obtenerPerfilPorCodigo(String codigo);

    public List<Perfil> obtenerPerfiles();
}
