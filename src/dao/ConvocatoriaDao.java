package dao;

import entidades.Convocatoria;

import java.util.List;

public interface ConvocatoriaDao {
    public List<Convocatoria> obtenerConvocatorias();

    public void agregarConvocatoria(Convocatoria convocatoria);

    public Convocatoria obtenerConvocatoriaPorCodigo(String codigo);
}
