package entidades;

public class Perfil {
    private String codigo;
    private String nombre;
    private int notaInicial;
    private int notaFinal;

    public Perfil(String codigo, String nombre, int notaInicial, int notaFinal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.notaInicial = notaInicial;
        this.notaFinal = notaFinal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNotaInicial() {
        return notaInicial;
    }

    public void setNotaInicial(int notaInicial) {
        this.notaInicial = notaInicial;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }
}
