package servicios.impl;

import dao.CuentaDao;
import dao.ServicioDao;
import dao.impl.DaoFactory;
import entidades.Cuenta;
import entidades.Servicio;
import servicios.ServicioServicio;

import java.util.List;

public class ServicioServicioImpl implements ServicioServicio{
    private ServicioDao servicioDao;

    public ServicioServicioImpl() {
        this.servicioDao = DaoFactory.getInstance().getServicioDao(1);
    }

    @Override
    public void grabarServicio(Servicio servicio) {
        this.servicioDao.create(servicio);
    }

    @Override
    public List<Servicio> obtenerServicios() {
        return this.servicioDao.findAll();
    }
}
