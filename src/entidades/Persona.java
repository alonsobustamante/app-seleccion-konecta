package entidades;

public class Persona {
    private String dni;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;

    public Persona(String dni, String nombres, String apellidos, String direccion, String telefono) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
}
