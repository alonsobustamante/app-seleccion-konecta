package dao.impl;

import dao.CuentaDao;
import entidades.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class CuentaDaoMemory implements CuentaDao {

    private List<Cuenta> cuentas;

    public CuentaDaoMemory() {
        this.cuentas = new ArrayList<>();
    }

    @Override
    public List<Cuenta> findAll() {
        return this.cuentas;
    }

    @Override
    public void create(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }
}
