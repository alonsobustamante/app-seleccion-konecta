package dao.impl;

import dao.EvaluacionDao;
import entidades.Evaluacion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EvaluacionDaoImpl implements EvaluacionDao {
    private List<Evaluacion> evaluaciones;

    public EvaluacionDaoImpl() {
        this.evaluaciones = new ArrayList<>();
    }

    @Override
    public void agregarEvaluacion(Evaluacion evaluacion) {
        evaluacion.setCodigo(UUID.randomUUID().toString());
        this.evaluaciones.add(evaluacion);
    }

    @Override
    public void actualizarEvaluacion(Evaluacion evaluacion) {
        for (Evaluacion e : evaluaciones) {
            if (e.getCodigo().equals(evaluacion.getCodigo())) {
                e.setNota1(evaluacion.getNota1());
                e.setNota2(evaluacion.getNota2());
                e.setNota3(evaluacion.getNota3());
                break;
            }
        }
    }

    @Override
    public Evaluacion obtenerEvaluacionPorCodigo(String codigo) {
        for (Evaluacion e : evaluaciones) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Evaluacion> obtenerEvaluacionesPorDniYEstado(String dni, String estado) {
        List<Evaluacion> evaluacionesPorDniYEstado = new ArrayList<>();
        for (Evaluacion e : evaluaciones) {
            if (e.getEntrevista().getPostulacion().getPostulante().getDni().equals(dni) && e.getEntrevista().getPostulacion().getEstado().equals(estado)) {
                evaluacionesPorDniYEstado.add(e);
            }
        }
        return evaluacionesPorDniYEstado;
    }

    @Override
    public List<Evaluacion> obtenerEvaluacionesPorEstado(String estado) {
        List<Evaluacion> evaluacionesPorEstado = new ArrayList<>();
        for (Evaluacion e : evaluaciones) {
            if (e.getEntrevista().getPostulacion().getEstado().equals(estado)) {
                evaluacionesPorEstado.add(e);
            }
        }
        return evaluacionesPorEstado;
    }

    @Override
    public List<Evaluacion> obtenerEvaluacionesPorFechaEvaluacion(String fechaEvaluacion) {
        List<Evaluacion> evaluacionesPorFechaEvaluacion = new ArrayList<>();
        for (Evaluacion e : evaluaciones) {
            if (e.getFechaEvaluacion().equals(fechaEvaluacion)) {
                evaluacionesPorFechaEvaluacion.add(e);
            }
        }
        return evaluacionesPorFechaEvaluacion;
    }

}
