package entidades;

public class Servicio {
    private int codigo;
    private String nombre;
    private Cuenta cuenta;

    public Servicio(int codigo, String nombre, Cuenta cuenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
