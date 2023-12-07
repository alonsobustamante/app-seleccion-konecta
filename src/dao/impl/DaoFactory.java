package dao.impl;

import dao.*;

public class DaoFactory {

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    private static class DaoFactoryHolder {
        private static final DaoFactory INSTANCE = new DaoFactory();
    }

    public CuentaDao getCuentaDao(int tipo){
        switch(tipo){
           case 1: return new CuentaDaoImpl();
           default: return null;
        }
    }

    public ServicioDao getServicioDao(int tipo){
        switch(tipo){
            case 1: return new ServicioDaoImpl();
            default: return null;
        }
    }

    public UsuarioDao getUsuarioDao(int tipo){
        switch(tipo){
            case 1: return new UsuarioDaoImpl();
            default: return null;
        }
    }

    public PostulanteDao getPostulanteDao(int tipo){
        switch(tipo){
            case 1: return new PostulanteDaoImpl();
            default: return null;
        }
    }

    public ConvocatoriaDao getConvocatoriaDao(int tipo){
        switch(tipo){
            case 1: return new ConvocatoriaDaoImpl();
            default: return null;
        }
    }

    public PostulacionDao getPostulacionDao(int tipo){
        switch(tipo){
            case 1: return new PostulacionDaoImpl();
            default: return null;
        }
    }

    public EntrevistaDao getEntrevistaDao(int tipo){
        switch(tipo){
            case 1: return new EntrevistaDaoImpl();
            default: return null;
        }
    }

    public PerfilDao getPerfilDao(int tipo){
        switch(tipo){
            case 1: return new PerfilDaoImpl();
            default: return null;
        }
    }

    public EvaluacionDao getEvaluacionDao(int tipo){
        switch(tipo){
            case 1: return new EvaluacionDaoImpl();
            default: return null;
        }
    }
}
