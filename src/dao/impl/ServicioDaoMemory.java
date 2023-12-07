package dao.impl;

import dao.ServicioDao;
import entidades.Cuenta;
import entidades.Servicio;

import java.util.ArrayList;
import java.util.List;

public class ServicioDaoMemory implements ServicioDao {

    private List<Servicio> servicios;

    public ServicioDaoMemory() {
        this.servicios = new ArrayList<>();
    }

    @Override
    public List<Servicio> findAll() {
        return this.servicios;
    }

    @Override
    public void create(Servicio servicio) {
        this.servicios.add(servicio);
    }
}
