package entidades;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private int codigo;
    private String nombre;

    private List<Servicio> servicios;

    public Cuenta(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.servicios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void agregarServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }
}
