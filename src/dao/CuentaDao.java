package dao;

import entidades.Cuenta;

import java.util.List;

public interface CuentaDao {
    public List<Cuenta> findAll();

    public void create(Cuenta cuenta);
}
