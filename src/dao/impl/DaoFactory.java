package dao.impl;

import dao.CuentaDao;
import dao.ServicioDao;
import dao.UsuarioDao;

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
}
