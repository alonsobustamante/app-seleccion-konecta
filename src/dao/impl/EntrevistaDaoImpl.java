package dao.impl;

import dao.EntrevistaDao;
import entidades.Entrevista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EntrevistaDaoImpl implements EntrevistaDao {

    private List<Entrevista> entrevistas;

    public EntrevistaDaoImpl() {
        this.entrevistas = new ArrayList<>();
    }

    @Override
    public void grabarEntrevista(Entrevista entrevista) {
        entrevista.setCodigo(UUID.randomUUID().toString());
        this.entrevistas.add(entrevista);
    }

    @Override
    public List<Entrevista> obtenerEntrevistas() {
        return this.entrevistas;
    }

    @Override
    public List<Entrevista> obtenerEntrevistasPorFechaEntrevista(String fechaEntrevista) {
        List<Entrevista> entrevistasPorFechaEntrevista = new ArrayList<>();
        for (Entrevista e : entrevistas) {
            if (e.getFechaEntrevista().equals(fechaEntrevista)) {
                entrevistasPorFechaEntrevista.add(e);
            }
        }
        return entrevistasPorFechaEntrevista;
    }

    @Override
    public Entrevista obtenerEntrevistaPorDniYEstado(String dni, String estado) {
        for (Entrevista e : entrevistas) {
            if (e.getPostulacion().getPostulante().getDni().equals(dni) && e.getPostulacion().getEstado().equals(estado)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void actualizarDetalleEntrevista(String codigo, String detalle) {
        for (Entrevista e : entrevistas) {
            if (e.getCodigo().equals(codigo)) {
                e.setDetalle(detalle);
            }
        }
    }
}
