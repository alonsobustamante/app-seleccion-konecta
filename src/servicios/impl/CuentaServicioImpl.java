package servicios.impl;

import dao.CuentaDao;
import dao.impl.DaoFactory;
import entidades.Cuenta;
import servicios.CuentaServicio;

import java.util.List;

public class CuentaServicioImpl implements CuentaServicio {

    private CuentaDao cuentaDao;

    public CuentaServicioImpl() {
        this.cuentaDao = DaoFactory.getInstance().getCuentaDao(1);
    }

    @Override
    public void grabarCuenta(Cuenta cuenta) {
        this.cuentaDao.create(cuenta);
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        return this.cuentaDao.findAll();
    }
}
