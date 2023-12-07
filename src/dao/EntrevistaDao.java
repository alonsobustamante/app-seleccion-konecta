package dao;

import entidades.Entrevista;

import java.util.List;

public interface EntrevistaDao {
    public void grabarEntrevista(Entrevista entrevista);

    public List<Entrevista> obtenerEntrevistas();

    public List<Entrevista> obtenerEntrevistasPorFechaEntrevista(String fechaEntrevista);

    public Entrevista obtenerEntrevistaPorDniYEstado(String dni, String estado);

    public void actualizarDetalleEntrevista(String codigo, String detalle);
}
