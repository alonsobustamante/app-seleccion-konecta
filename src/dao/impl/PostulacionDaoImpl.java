package dao.impl;

import dao.PostulacionDao;
import entidades.Postulacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;
import java.util.UUID;

public class PostulacionDaoImpl implements PostulacionDao {
    private List<Postulacion> postulaciones;

    public PostulacionDaoImpl() {
        this.postulaciones = new ArrayList<>();
    }

    @Override
    public void grabarPostulacion(Postulacion postulacion) {
        postulacion.setCodigo(UUID.randomUUID().toString());
        postulacion.setFechaPostulacion(LocalDate.now().toString());
        postulacion.setEstado("Pendiente");

        this.postulaciones.add(postulacion);
    }

    @Override
    public Postulacion obtenerPostulacionPorCodigo(String codigo) {
        for (Postulacion p : postulaciones) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Postulacion> obtenerPostulacionesPorPostulante(String dni) {
        List<Postulacion> postulacionesPorPostulante = new ArrayList<>();
        for (Postulacion p : postulaciones) {
            if (p.getPostulante().getDni().equals(dni)) {
                postulacionesPorPostulante.add(p);
            }
        }
        return postulacionesPorPostulante;
    }

    @Override
    public boolean validarPostulacionActiva(String dni) {
        for (Postulacion p : postulaciones) {
            if (p.getPostulante().getDni().equals(dni)) {
                LocalDate date = LocalDate.now();
                LocalDate dateBD = LocalDate.parse(p.getFechaPostulacion());

                Period period = Period.between(dateBD, date);

                int days = period.getDays();

                return (days > 90);
            }
        }
        return true;
    }

    @Override
    public List<Postulacion> obtenerPostulacionesPorEstadoYFechaPostulacion(String estado, String fechaPostulacion) {
        List<Postulacion> postulacionesPorEstadoYFechaPostulacion = new ArrayList<>();
        for (Postulacion p : postulaciones) {
            if (p.getEstado().equals(estado) && p.getFechaPostulacion().equals(fechaPostulacion)) {
                postulacionesPorEstadoYFechaPostulacion.add(p);
            }
        }
        return postulacionesPorEstadoYFechaPostulacion;
    }

    @Override
    public Postulacion obtenerPostulacionPorDniYEstado(String dni, String estado) {
        for (Postulacion p : postulaciones) {
            if (p.getPostulante().getDni().equals(dni) && p.getEstado().equals(estado)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void actualizarEstadoPostulacion(String codigo, String estado) {
        for (Postulacion p : postulaciones) {
            if (p.getCodigo().equals(codigo)) {
                p.setEstado(estado);
            }
        }
    }

    @Override
    public List<Postulacion> obtenerPostulacionesFechaPostulacion(String fechaPostulacion) {
        List<Postulacion> postulacionesPorFechaPostulacion = new ArrayList<>();
        for (Postulacion p : postulaciones) {
            if (p.getFechaPostulacion().equals(fechaPostulacion)) {
                postulacionesPorFechaPostulacion.add(p);
            }
        }
        return postulacionesPorFechaPostulacion;
    }
}
