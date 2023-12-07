package dao;

import entidades.Postulante;

public interface PostulanteDao {
    public void grabarPostulante(Postulante postulante);

    public Postulante obtenerPostulante(String dni);

    public Postulante obtenerPostulantePorUsuario(String usuario);

    public void agregarPostulante(Postulante postulante);
}
