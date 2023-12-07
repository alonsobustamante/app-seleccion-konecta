package entidades;

public class Cuenta {
    private int codigo;
    private String nombre;

    public Cuenta(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }
}
