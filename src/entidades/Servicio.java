package entidades;

public class Servicio {
    private int codigo;
    private String nombre;
    private Cuenta cuenta;

    public Servicio(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
