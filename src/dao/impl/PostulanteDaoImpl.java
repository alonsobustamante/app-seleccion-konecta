package dao.impl;

import dao.PostulanteDao;
import entidades.Postulante;

import java.util.ArrayList;
import java.util.List;

public class PostulanteDaoImpl implements PostulanteDao {

        private List<Postulante> postulantes;

        public PostulanteDaoImpl() {
            this.postulantes = new ArrayList<>();
        }

        @Override
        public void grabarPostulante(Postulante postulante) {
            this.postulantes.add(postulante);
        }

        @Override
        public Postulante obtenerPostulante(String dni) {
            for(Postulante p : postulantes) {
                if (p.getDni().equals(dni)) {
                    return p;
                }
            }
            return null;
        }

        @Override
        public Postulante obtenerPostulantePorUsuario(String usuario) {
            for(Postulante p : postulantes) {
                if (p.getUsuario().getUsuario().equals(usuario)) {
                    return p;
                }
            }
            return null;
        }

        @Override
        public void agregarPostulante(Postulante postulante) {
            this.postulantes.add(postulante);
        }
}
