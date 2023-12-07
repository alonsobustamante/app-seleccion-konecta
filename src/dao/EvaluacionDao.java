package dao;

import entidades.Evaluacion;

import java.util.List;

public interface EvaluacionDao {
    public void agregarEvaluacion(Evaluacion evaluacion);

    public void actualizarEvaluacion(Evaluacion evaluacion);

    public Evaluacion obtenerEvaluacionPorCodigo(String codigo);

    public List<Evaluacion> obtenerEvaluacionesPorDniYEstado(String dni, String estado);

    public List<Evaluacion> obtenerEvaluacionesPorEstado(String estado);

    public List<Evaluacion> obtenerEvaluacionesPorFechaEvaluacion(String fechaEvaluacion);
}
