package servicios;

import entidades.Cuenta;

import java.util.List;

public interface CuentaServicio {
    public void grabarCuenta(Cuenta cuenta);

    public List<Cuenta> obtenerCuentas();
}
