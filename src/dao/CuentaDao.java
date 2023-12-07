package dao;

import entidades.Cuenta;

import java.util.List;

public interface CuentaDao {
    public List<Cuenta> obtenerCuentas();
    public void agregarCuenta(Cuenta cuenta);

    public Cuenta obtenerCuenta(int i);
}
