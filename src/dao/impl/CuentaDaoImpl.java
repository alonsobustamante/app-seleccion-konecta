package dao.impl;

import dao.CuentaDao;
import entidades.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class CuentaDaoImpl implements CuentaDao {

    private List<Cuenta> cuentas;

    public CuentaDaoImpl() {
        this.cuentas = new ArrayList<>();
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        return this.cuentas;
    }

    @Override
    public void agregarCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }
}
