package ejecutora;

import entidades.Cuenta;
import servicios.CuentaServicio;
import servicios.impl.CuentaServicioImpl;

public class App {
    public static void main(String[] args) {
        CuentaServicio cuentaServicio = new CuentaServicioImpl();

        for (Cuenta cuenta : cuentaServicio.obtenerCuentas())
            System.out.println(cuenta.getNombre());
    }
}
