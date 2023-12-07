package entidades;

public class Convocatoria {
    private String codigo;
    private String nombre;
    private String categoria;
    private Cuenta cuenta;
    private String fechaInicio;
    private String fechaFin;
    private String estado;
    private Servicio servicio;
    private String tipoTrabajo;
    private String formador;
    private int numParticipantes;

    public Convocatoria(String codigo, String nombre, String categoria, Cuenta cuenta, String fechaInicio, String fechaFin, String estado, Servicio servicio, String tipoTrabajo, String formador, int numParticipantes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cuenta = cuenta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.servicio = servicio;
        this.tipoTrabajo = tipoTrabajo;
        this.formador = formador;
        this.numParticipantes = numParticipantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public String getFormador() {
        return formador;
    }

    public int getNumParticipantes() {
        return numParticipantes;
    }
}
