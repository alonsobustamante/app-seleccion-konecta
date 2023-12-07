package dao.impl;

import dao.PerfilDao;
import entidades.Perfil;

import java.util.ArrayList;
import java.util.List;

public class PerfilDaoImpl implements PerfilDao {

    private List<Perfil> perfiles;

    public PerfilDaoImpl() {
        this.perfiles = new ArrayList<>();
    }

    @Override
    public void agregarPerfil(Perfil perfil) {
        this.perfiles.add(perfil);
    }

    @Override
    public List<Perfil> obtenerPerfiles() {
        return this.perfiles;
    }

    @Override
    public Perfil obtenerPerfilPorCodigo(String codigo) {
        for (Perfil p : perfiles) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }
}
