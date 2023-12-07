package dao;

import entidades.Cuenta;
import entidades.Servicio;

import java.util.List;

public interface ServicioDao {
    public List<Servicio> obtenerServicios();

    public void agregarServicio(Servicio servicio);

}
