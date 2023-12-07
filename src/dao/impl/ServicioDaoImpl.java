package dao.impl;

import dao.ServicioDao;
import entidades.Cuenta;
import entidades.Servicio;

import java.util.ArrayList;
import java.util.List;

public class ServicioDaoImpl implements ServicioDao {

    private List<Servicio> servicios;

    public ServicioDaoImpl() {
        this.servicios = new ArrayList<>();
    }

    @Override
    public List<Servicio> obtenerServicios() {
        return this.servicios;
    }

    @Override
    public void agregarServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }


}
