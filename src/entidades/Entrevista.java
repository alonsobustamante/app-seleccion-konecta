package entidades;

public class Entrevista {
    private String codigo;
    private Usuario entrevistador;
    private Postulacion postulacion;
    private String fechaEntrevista;
    private String horaEntrevista;
    private String meetLink;
    private String fechaRegistro;

    private String detalle;

    public Entrevista() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Usuario getEntrevistador() {
        return entrevistador;
    }

    public void setEntrevistador(Usuario entrevistador) {
        this.entrevistador = entrevistador;
    }

    public Postulacion getPostulacion() {
        return postulacion;
    }

    public void setPostulacion(Postulacion postulacion) {
        this.postulacion = postulacion;
    }

    public String getFechaEntrevista() {
        return fechaEntrevista;
    }

    public void setFechaEntrevista(String fechaEntrevista) {
        this.fechaEntrevista = fechaEntrevista;
    }

    public String getHoraEntrevista() {
        return horaEntrevista;
    }

    public void setHoraEntrevista(String horaEntrevista) {
        this.horaEntrevista = horaEntrevista;
    }

    public String getMeetLink() {
        return meetLink;
    }

    public void setMeetLink(String meetLink) {
        this.meetLink = meetLink;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }
}
