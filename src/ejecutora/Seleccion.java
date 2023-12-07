package ejecutora;

import dao.*;
import dao.impl.DaoFactory;
import entidades.*;

public class Seleccion {
    private CuentaDao cuentaDao;
    private ServicioDao servicioDao;
    private UsuarioDao usuarioDao;
    private PostulanteDao postulanteDao;
    private ConvocatoriaDao convocatoriaDao;
    private PostulacionDao postulacionDao;
    private EntrevistaDao entrevistaDao;
    private PerfilDao perfilDao;

    private EvaluacionDao evaluacionDao;

    private Usuario usuarioLogueado;

    DaoFactory daoFactory = DaoFactory.getInstance();

    public Seleccion() {
        int tipo = 1;

        cuentaDao = daoFactory.getCuentaDao(tipo);
        servicioDao = daoFactory.getServicioDao(1);
        usuarioDao = daoFactory.getUsuarioDao(1);
        postulanteDao = daoFactory.getPostulanteDao(1);
        convocatoriaDao = daoFactory.getConvocatoriaDao(1);
        postulanteDao = daoFactory.getPostulanteDao(1);
        postulacionDao = daoFactory.getPostulacionDao(1);
        entrevistaDao = daoFactory.getEntrevistaDao(1);
        perfilDao = daoFactory.getPerfilDao(1);
        evaluacionDao = daoFactory.getEvaluacionDao(1);

        inicializarBD();
    }

    public CuentaDao getCuentaDao() {
        return cuentaDao;
    }

    public ServicioDao getServicioDao() {
        return servicioDao;
    }

    public PostulanteDao getPostulanteDao() {
        return postulanteDao;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public ConvocatoriaDao getConvocatoriaDao() {
        return convocatoriaDao;
    }

    public PostulacionDao getPostulacionDao() {
        return postulacionDao;
    }

    public EntrevistaDao getEntrevistaDao() {
        return entrevistaDao;
    }

    public PerfilDao getPerfilDao() {
        return perfilDao;
    }

    public EvaluacionDao getEvaluacionDao() {
        return evaluacionDao;
    }
    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }



    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public void inicializarBD() {
        Cuenta cuenta1 = new Cuenta(1, "Falabella.com");
        Cuenta cuenta2 = new Cuenta(2, "Diners");
        Cuenta cuenta3 = new Cuenta(3, "Movistar Peru");

        Servicio servicio1 = new Servicio(1, "E-commerce");
        Servicio servicio2 = new Servicio(2, "Retencion de Seguros");
        Servicio servicio3 = new Servicio(3, "WHATSAPP CROSSELING");
        Servicio servicio4 = new Servicio(4, "SERVICIO DE VENTA TELEFONICA PARA CHILE Y PERÚ");

        cuenta1.agregarServicio(servicio1);
        cuenta2.agregarServicio(servicio2);
        cuenta3.agregarServicio(servicio3);
        cuenta1.agregarServicio(servicio4);

        cuentaDao.agregarCuenta(cuenta1);
        cuentaDao.agregarCuenta(cuenta2);
        cuentaDao.agregarCuenta(cuenta3);

        servicio1.setCuenta(cuentaDao.obtenerCuenta(1));
        servicio2.setCuenta(cuentaDao.obtenerCuenta(2));
        servicio3.setCuenta(cuentaDao.obtenerCuenta(3));
        servicio4.setCuenta(cuentaDao.obtenerCuenta(1));

        servicioDao.agregarServicio(servicio1);
        servicioDao.agregarServicio(servicio2);
        servicioDao.agregarServicio(servicio3);
        servicioDao.agregarServicio(servicio4);

        Usuario usuario1 = new Usuario("11111111", "Alonso", "Bustamante", "SJL", "999999999", "jbustamante", "12345678", "POS");
        Usuario usuario2 = new Usuario("22222222", "Alberto", "Rengifo", "Miraflores", "88888888", "arengifo", "12345678", "ENT");
        Usuario usuario3 = new Usuario("33333333", "Yeffer", "Portal", "Surco", "777777777", "yportal", "12345678", "SEL");

        usuarioDao.agregarUsuario(usuario1);
        usuarioDao.agregarUsuario(usuario2);
        usuarioDao.agregarUsuario(usuario3);

        Convocatoria convocatoria1 = new Convocatoria("CO001", "Entel Ch. Atencion al cliente/Turno Mañana/Presencial", "Atención al Cliente", cuenta1, "2023-12-13",
                                              "2023-12-25", "activo", servicio1, "Presencial", "Eloy Rojas", 10);
        Convocatoria convocatoria2 = new Convocatoria("CO002", "ASESORES/AS DE VENTAS", "Ventas", cuenta2, "2023-12-08",
                                              "2023-12-15", "activo", servicio2, "Remoto", "Jose Castro", 15);
        Convocatoria convocatoria3 = new Convocatoria("CO003", "EJECUTIVO DE VENTAS", "Ventas", cuenta3, "2023-12-01",
                                                "2023-12-10", "activo", servicio3, "Presencial", "Martina Sosa", 20);

        convocatoriaDao.agregarConvocatoria(convocatoria1);
        convocatoriaDao.agregarConvocatoria(convocatoria2);
        convocatoriaDao.agregarConvocatoria(convocatoria3);

        Perfil perfil1 = new Perfil("P001", "Ventas", 70, 90);
        Perfil perfil2 = new Perfil("P002", "ATC", 74, 87);
        Perfil perfil3 = new Perfil("P003", "Cobranzas", 75, 85);

        perfilDao.agregarPerfil(perfil1);
        perfilDao.agregarPerfil(perfil2);
        perfilDao.agregarPerfil(perfil3);

//        Postulante postulante = new Postulante("46756591", "Juan", "Perez", 33, "Ingeniero", "UPC", "2024", "Analista", "Konecta", "2020-2022", "Trabajo en equipo", "jbustamante@gmail.com", "912345678", "https://alonso.com", "2023-12-07");
//        postulante.setUsuario(usuario1);
//
//        postulanteDao.agregarPostulante(postulante);
//
//        Postulacion postulacion = new Postulacion();
//        postulacion.setPostulante(postulante);
//        postulacion.setConvocatoria(convocatoria1);
//
//        postulacionDao.grabarPostulacion(postulacion);


    }
}
