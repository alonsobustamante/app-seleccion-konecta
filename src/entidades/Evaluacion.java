package entidades;

public class Evaluacion {
    private String codigo;
    private String link;
    private String fechaEvaluacion;
    private Entrevista entrevista;
    private Usuario selector;
    private Perfil perfil;
    private int nota1;
    private int nota2;
    private int nota3;
    private int notaFinal;
    private String estado;


    public Evaluacion() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(String fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Entrevista getEntrevista() {
        return entrevista;
    }

    public void setEntrevista(Entrevista entrevista) {
        this.entrevista = entrevista;
    }

    public Usuario getSelector() {
        return selector;
    }

    public void setSelector(Usuario selector) {
        this.selector = selector;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    public int getNotaFinal() {
        if (nota1 != 0 && nota2 != 0 && nota3 != 0) {
            notaFinal = (nota1 + nota2 + nota3) ;
        }
        return notaFinal;
    }


    public String getEstado() {
        if(getNotaFinal() == 0) {
            return "Sin Estado";
        }

        if (getNotaFinal() <= perfil.getNotaInicial()){
            return "Desaprobado";
        }else if (getNotaFinal() > perfil.getNotaInicial() && getNotaFinal() < perfil.getNotaFinal()){
            return "Normal";
        }else{
            return "Destacado";
        }
    }
}
