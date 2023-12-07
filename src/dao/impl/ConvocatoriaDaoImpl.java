package dao.impl;

import dao.ConvocatoriaDao;
import entidades.Convocatoria;
import entidades.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class ConvocatoriaDaoImpl implements ConvocatoriaDao {
    private List<Convocatoria> convocatorias;

    public ConvocatoriaDaoImpl() {
        this.convocatorias = new ArrayList<>();
    }

    @Override
    public List<Convocatoria> obtenerConvocatorias() {
        return this.convocatorias;
    }

    @Override
    public void agregarConvocatoria(Convocatoria convocatoria) {
        this.convocatorias.add(convocatoria);
    }

    @Override
    public Convocatoria obtenerConvocatoriaPorCodigo(String codigo) {
        for (Convocatoria c : convocatorias) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }


}
