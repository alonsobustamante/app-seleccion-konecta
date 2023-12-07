package servicios;

import entidades.Servicio;

import java.util.List;

public interface ServicioServicio {
    public void grabarServicio(Servicio servicio);

    public List<Servicio> obtenerServicios();
}
