package dao;

import entidades.Postulacion;

import java.util.List;

public interface PostulacionDao {
    public void grabarPostulacion(Postulacion postulacion);

    public Postulacion obtenerPostulacionPorCodigo(String codigo);

    public Postulacion obtenerPostulacionPorDniYEstado(String dni, String estado);

    public boolean validarPostulacionActiva(String dni);

    public List<Postulacion> obtenerPostulacionesPorPostulante(String dni);

    public List<Postulacion> obtenerPostulacionesPorEstadoYFechaPostulacion(String estado, String fechaPostulacion);

    public List<Postulacion> obtenerPostulacionesFechaPostulacion(String fechaPostulacion);

    public void actualizarEstadoPostulacion(String codigo, String estado);
}
