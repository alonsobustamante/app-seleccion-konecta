package entidades;

import java.time.LocalDate;

public class Postulante {
    private String dni;
    private String nombres;
    private String apellidos;
    private int edad;
    private String profesion;
    private String institucionEducativa;
    private String anioGraduacion;
    private String puestoAnterior;
    private String empresaAnterior;
    private String periodoTrabajoAnterior;
    private String habilidades;
    private String email;
    private String telefono;
    private String enlaceWeb;
    private String fechaRegistro;

    private Usuario usuario;

    public Postulante(String dni, String nombres, String apellidos, int edad, String profesion, String institucionEducativa, String anioGraduacion, String puestoAnterior, String empresaAnterior, String periodoTrabajoAnterior, String habilidades, String email, String telefono, String enlaceWeb, String fechaRegistro) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.profesion = profesion;
        this.institucionEducativa = institucionEducativa;
        this.anioGraduacion = anioGraduacion;
        this.puestoAnterior = puestoAnterior;
        this.empresaAnterior = empresaAnterior;
        this.periodoTrabajoAnterior = periodoTrabajoAnterior;
        this.habilidades = habilidades;
        this.email = email;
        this.telefono = telefono;
        this.enlaceWeb = enlaceWeb;
        this.fechaRegistro = LocalDate.now().toString();
    }

    public Postulante() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getInstitucionEducativa() {
        return institucionEducativa;
    }

    public void setInstitucionEducativa(String institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }

    public String getAnioGraduacion() {
        return anioGraduacion;
    }

    public void setAnioGraduacion(String anioGraduacion) {
        this.anioGraduacion = anioGraduacion;
    }

    public String getPuestoAnterior() {
        return puestoAnterior;
    }

    public void setPuestoAnterior(String puestoAnterior) {
        this.puestoAnterior = puestoAnterior;
    }

    public String getEmpresaAnterior() {
        return empresaAnterior;
    }

    public void setEmpresaAnterior(String empresaAnterior) {
        this.empresaAnterior = empresaAnterior;
    }

    public String getPeriodoTrabajoAnterior() {
        return periodoTrabajoAnterior;
    }

    public void setPeriodoTrabajoAnterior(String periodoTrabajoAnterior) {
        this.periodoTrabajoAnterior = periodoTrabajoAnterior;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEnlaceWeb() {
        return enlaceWeb;
    }

    public void setEnlaceWeb(String enlaceWeb) {
        this.enlaceWeb = enlaceWeb;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
