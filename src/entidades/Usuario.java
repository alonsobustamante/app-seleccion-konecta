package entidades;

public class Usuario extends Persona{
    private String usuario;
    private String password;
    private String rol;

    public Usuario(String dni, String nombres, String apellidos, String direccion, String telefono, String usuario, String password, String rol) {
        super(dni, nombres, apellidos, direccion, telefono);
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }
}
