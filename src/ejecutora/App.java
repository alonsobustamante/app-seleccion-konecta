package ejecutora;

import entidades.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static Seleccion seleccion;

    public static void main(String[] args) {
        seleccion = new Seleccion();

        int opcion = 0;
        do {
            System.out.println("===================== Bienvenido al Sistema de Seleccion Konecta =====================");
            System.out.println("(1) Iniciar Sesion");
            System.out.println("(2) Salir de la aplicacion");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    inicioSesion();
                    break;
                case 2:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (opcion != 2);

    }

    private static void inicioSesion() {
        UsuarioDTO usuario = new UsuarioDTO();

        boolean credencialesCorrectas = false;

        while(!credencialesCorrectas) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("========================== Inicio de Sesión ==========================");
            System.out.print("Tipo de Rol (Postulante: POS, Entrevistador: ENT, Selector: SEL): ");
            usuario.setRol(sc.nextLine());
            System.out.print("Usuario: ");
            usuario.setUsuario(sc.nextLine());
            System.out.print("Contraseña: ");
            usuario.setPassword(sc.nextLine());

            System.out.println("======================================================================");

            seleccion.setUsuarioLogueado(seleccion.getUsuarioDao().iniciarSesion(usuario));

            credencialesCorrectas = seleccion.getUsuarioLogueado() != null;

            if (!credencialesCorrectas) {
                System.out.println("Credenciales incorrectas. Por favor intente de nuevo.");
                System.out.println("======================================================");
                sc.nextLine();
            }
        }

        //seleccion.setUsuarioLogueado(seleccion.getUsuarioDao().iniciarSesion(new UsuarioDTO("jbustamante", "12345678", "POS")));
        //seleccion.setUsuarioLogueado(seleccion.getUsuarioDao().iniciarSesion(new UsuarioDTO("arengifo", "12345678", "ENT")));

        System.out.println("");
        System.out.println("Bienvenido al Sistema: " + seleccion.getUsuarioLogueado().getRol() + " - " + seleccion.getUsuarioLogueado().getNombres() + " " + seleccion.getUsuarioLogueado().getApellidos());

        switch (seleccion.getUsuarioLogueado().getRol()){
            case "POS":
                mostrarMenuPostulante();
                break;
            case "ENT":
                mostrarMenuEntrevistador();
                break;
            case "SEL":
                mostrarMenuSelector();
                break;
        }
    }

    private static void mostrarMenuEntrevistador() {
        int opcion = 0;
        do {
            System.out.println("===================== Menú Principal Entrevistador =====================");
            System.out.println("(1)\tLista de postulaciones por día");
            System.out.println("(2)\tLista de postulaciones pendientes por día");
            System.out.println("(3)\tPostulantes con entrevista programada");
            System.out.println("(4)\tAgendar entrevista");
            System.out.println("(5)\tActualizar estado de postulacion");
            System.out.println("(6)\tIngresar detalles de entrevista realizada");
            System.out.println("(7)\tAsignar evaluacion a postulante");
            System.out.println("(8) Cerrar Sesion");
            System.out.print("Seleccione la pantalla donde desea ingresar: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    listarPostulaciones();
                    break;
                case 2:
                    listarPostulantesFaltaEntrevistar();
                    break;
                case 3:
                    listarPostulantesConEntrevistaProgramada();
                    break;
                case 4:
                    agendarEntrevista();
                    break;
                case 5:
                    actualizarEstadoPorPostulacion();
                    break;
                case 6:
                    ingresarDetallesEntrevistaRealizada();
                    break;
                case 7:
                    asignarEvaluacionAPostulante();
                    break;
                case 8:
                    System.out.println("Cerrando Sesion...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (opcion != 8);
    }

    private static void asignarEvaluacionAPostulante() {
        System.out.println("");
        String dni = "";
        int opcion = 0;
        String detalle = "";

        System.out.println("====================== Asignar Evaluacion a Postulante ======================");
        System.out.print("Ingrese el dni del postulante: ");
        dni = sc.nextLine();

        Entrevista entrevista = seleccion.getEntrevistaDao().obtenerEntrevistaPorDniYEstado(dni,"Entrevistado");

        if (entrevista == null){
            System.out.println("======================================================================");
            System.out.println("No existe el postulante con el dni ingresado o no se encuentra entrevistado.");
            System.out.println("======================================================================");
            return;
        }

        Evaluacion evaluacion = new Evaluacion();

        System.out.println("====================== Asignar Evaluacion a Postulante ======================");
        System.out.print("Codigo: ");
        evaluacion.setCodigo(sc.nextLine());
        System.out.print("Link: ");
        evaluacion.setLink(sc.nextLine());
        System.out.print("Fecha de Evaluacion (yyyy-mm-dd): ");
        evaluacion.setFechaEvaluacion(sc.nextLine());
        System.out.print("Perfil: ");
        evaluacion.setPerfil(seleccion.getPerfilDao().obtenerPerfilPorCodigo(sc.nextLine()));

        System.out.print("¿Desea asignar la evaluacion? (1) Si (2) No: ");
        opcion = sc.nextInt();

        if(opcion == 1){
            evaluacion.setEntrevista(entrevista);
            evaluacion.setSelector(seleccion.getUsuarioLogueado());
            seleccion.getEvaluacionDao().agregarEvaluacion(evaluacion);

            seleccion.getPostulacionDao().actualizarEstadoPostulacion(entrevista.getPostulacion().getCodigo(), "En Evaluacion");

            System.out.println("====================================");
            System.out.println("Evaluacion asignada correctamente");
            System.out.println("====================================");
        }
    }

    private static void ingresarDetallesEntrevistaRealizada() {
        System.out.println("");
        String dni = "";
        int opcion = 0;
        String detalle = "";

        System.out.println("====================== Ingresar Detalles de Entrevista Realizada ======================");
        System.out.print("Ingrese el dni del postulante: ");
        dni = sc.nextLine();

        Entrevista entrevista = seleccion.getEntrevistaDao().obtenerEntrevistaPorDniYEstado(dni,"Agendado");

        if (entrevista == null){
            System.out.println("======================================================================");
            System.out.println("No existe el postulante con el dni ingresado o no se encuentra agendado para entrevista.");
            System.out.println("======================================================================");
            return;
        }

        System.out.println("====================== Ingresar Detalles de Entrevista Realizada ======================");

        System.out.println("Codigo: " + entrevista.getPostulacion().getCodigo());
        System.out.println("Dni: " + entrevista.getPostulacion().getPostulante().getDni());
        System.out.println("Nombres: " + entrevista.getPostulacion().getPostulante().getNombres());
        System.out.println("Apellidos: " + entrevista.getPostulacion().getPostulante().getApellidos());
        System.out.println("Convocatoria :" + entrevista.getPostulacion().getConvocatoria().getNombre());
        System.out.println("Fecha de Postulacion: " + entrevista.getPostulacion().getFechaPostulacion());
        System.out.println("Estado: " + entrevista.getPostulacion().getEstado());
        System.out.print("Detalle: ");
        detalle = sc.nextLine();

        System.out.println("");
        System.out.println("======================================================================");

        System.out.print("¿Desea ingresar los detalles de la entrevista? (1) Si (2) No: ");
        opcion = sc.nextInt();

        if(opcion == 1){

            seleccion.getEntrevistaDao().actualizarDetalleEntrevista(entrevista.getCodigo(), detalle);

            seleccion.getPostulacionDao().actualizarEstadoPostulacion(entrevista.getPostulacion().getCodigo(), "Entrevistado");

            System.out.println("====================================");
            System.out.println("Detalles de entrevista ingresados correctamente");
            System.out.println("====================================");
        }
    }

    private static void listarPostulaciones() {
        System.out.println("");
        String fechaPostulacion = "";


        System.out.println("====================== Lista de Postulaciones por dia ======================");
        System.out.print("Ingresa Fecha de postulacion (yyyy-mm-dd): ");
        fechaPostulacion = sc.nextLine();

        System.out.println("");
        seleccion.getPostulacionDao().obtenerPostulacionesFechaPostulacion(fechaPostulacion).stream().forEach(
                postulacion -> {
                    System.out.println("- " + postulacion.getPostulante().getDni() + " | " + postulacion.getPostulante().getNombres() + " " + postulacion.getPostulante().getApellidos()
                            + " | " + postulacion.getPostulante().getTelefono() + " | " + postulacion.getConvocatoria().getNombre() + " | " + postulacion.getFechaPostulacion() + " | " + postulacion.getEstado()
                    );
                }
        );
        System.out.println("");
    }

    private static void actualizarEstadoPorPostulacion() {
        System.out.println("");
        String dni = "";
        int opcion = 0;
        String estado = "";

        System.out.println("====================== Actualizar Estado de Postulacion ======================");
        System.out.print("Ingrese el dni de la postulacion: ");
        dni = sc.nextLine();

        Postulacion postulacion = seleccion.getPostulacionDao().obtenerPostulacionPorDniYEstado(dni, "Pendiente");

        if (postulacion == null){
            System.out.println("======================================================================");
            System.out.println("No existe la postulacion con el dni ingresado.");
            System.out.println("======================================================================");
            return;
        }

        System.out.println("====================== Actualizar Estado de Postulacion ======================");

        System.out.println("Codigo: " + postulacion.getCodigo());
        System.out.println("Dni: " + postulacion.getPostulante().getDni());
        System.out.println("Nombres: " + postulacion.getPostulante().getNombres());
        System.out.println("Apellidos: " + postulacion.getPostulante().getApellidos());
        System.out.println("Convocatoria :" + postulacion.getConvocatoria().getNombre());
        System.out.println("Fecha de Postulacion: " + postulacion.getFechaPostulacion());
        System.out.print("Estado: " );
        estado = sc.nextLine();

        System.out.println("");
        System.out.println("======================================================================");

        System.out.print("¿Desea actualizar el estado de la postulacion? (1) Si (2) No: ");
        opcion = sc.nextInt();

        if(opcion == 1){
            seleccion.getPostulacionDao().actualizarEstadoPostulacion(postulacion.getCodigo(), estado);

            System.out.println("====================================");
            System.out.println("Estado actualizado correctamente");
            System.out.println("====================================");
        }
    }

    private static void agendarEntrevista() {
        System.out.println("");
        String dni = "";
        int opcion = 0;

        System.out.println("====================== Agendar Entrevista ======================");
        System.out.print("Ingrese el dni del postulante: ");
        dni = sc.nextLine();

        Postulacion postulacion = seleccion.getPostulacionDao().obtenerPostulacionPorDniYEstado(dni,"Disponible para Entrevista");

        if (postulacion == null){
            System.out.println("======================================================================");
            System.out.println("No existe el postulante con el dni ingresado o no se encuentra disponible para entrevista.");
            System.out.println("======================================================================");
            return;
        }

        Entrevista entrevista = new Entrevista();

        System.out.println("====================== Agendar Entrevista ======================");

        System.out.println("Codigo: " + postulacion.getCodigo());
        System.out.println("Dni: " + postulacion.getPostulante().getDni());
        System.out.println("Nombres: " + postulacion.getPostulante().getNombres());
        System.out.println("Apellidos: " + postulacion.getPostulante().getApellidos());
        System.out.println("Convocatoria :" + postulacion.getConvocatoria().getNombre());
        System.out.println("Fecha de Postulacion: " + postulacion.getFechaPostulacion());
        System.out.println("Estado: " + postulacion.getEstado());
        System.out.print("Fecha de Entrevista (yyyy-mm-dd): ");
        entrevista.setFechaEntrevista(sc.nextLine());
        System.out.println("Hora de Entrevista (hh:mm): ");
        entrevista.setHoraEntrevista(sc.nextLine());
        System.out.println("Meet Link: ");
        entrevista.setMeetLink(sc.nextLine());

        System.out.println("");
        System.out.println("======================================================================");

        System.out.print("¿Desea agendar la entrevista? (1) Si (2) No: ");
        opcion = sc.nextInt();

        if(opcion == 1){

            entrevista.setCodigo(UUID.randomUUID().toString());
            entrevista.setEntrevistador(seleccion.getUsuarioLogueado());
            entrevista.setPostulacion(postulacion);

            seleccion.getEntrevistaDao().grabarEntrevista(entrevista);

            seleccion.getPostulacionDao().actualizarEstadoPostulacion(postulacion.getCodigo(), "Agendado");

            System.out.println("====================================");
            System.out.println("Entrevista agendada correctamente");
            System.out.println("====================================");
        }
    }

    private static void listarPostulantesFaltaEntrevistar() {
        System.out.println("");
        String fechaPostulacion = "";


        System.out.println("====================== Lista de Postulantes por Entrevistar ======================");
        System.out.print("Ingresa Fecha de postulacion (yyyy-mm-dd): ");
        fechaPostulacion = sc.nextLine();

        List<Postulacion> postulacions = seleccion.getPostulacionDao().obtenerPostulacionesPorEstadoYFechaPostulacion("Pendiente", fechaPostulacion);

        if (postulacions.size() == 0){
            System.out.println("======================================================================");
            System.out.println("No hay postulantes pendientes por entrevistar para la fecha ingresada");
            System.out.println("======================================================================");
            return;
        }

        System.out.println("");
        postulacions.stream().forEach(
                postulacion -> {
                    System.out.println("- " + postulacion.getPostulante().getDni() + " | " + postulacion.getPostulante().getNombres() + " " + postulacion.getPostulante().getApellidos()
                        + " | " + postulacion.getPostulante().getTelefono() + " | " + postulacion.getConvocatoria().getNombre() + " | " + postulacion.getFechaPostulacion()
                    );
                }
        );
        System.out.println("");

    }

    public static void listarPostulantesConEntrevistaProgramada() {
        System.out.println("");
        String fechaEntrevista = "";

        System.out.println("====================== Lista de Postulantes con Entrevista Programada ======================");
        System.out.print("Ingresa Fecha de entrevistad (yyyy-mm-dd): ");
        fechaEntrevista = sc.nextLine();

        List<Entrevista> entrevistasPorFecha = seleccion.getEntrevistaDao().obtenerEntrevistasPorFechaEntrevista(fechaEntrevista);

        if (entrevistasPorFecha.size() == 0){
            System.out.println("======================================================================");
            System.out.println("No hay entrevistas programadas para la fecha ingresada");
            System.out.println("======================================================================");
            return;
        }

        entrevistasPorFecha.stream().forEach(
                entrevista -> {
                    System.out.println("- " + entrevista.getPostulacion().getPostulante().getDni() + " | " + entrevista.getPostulacion().getPostulante().getNombres() + " " + entrevista.getPostulacion().getPostulante().getApellidos()
                        + " | " + entrevista.getFechaEntrevista() + " | " + entrevista.getHoraEntrevista() + " | " + entrevista.getMeetLink()
                    );
                }
        );

        System.out.println("");
    }

    private static void mostrarMenuSelector() {
        int opcion = 0;
        do {
            System.out.println("===================== Menú Principal Selector =====================");
            System.out.println("(1) Evaluaciones pendientes");
            System.out.println("(2) Evaluaciones por dia");
            System.out.println("(3) Registrar notas de evaluacion");
            System.out.println("(4) Postulantes aptos en el proceso de seleccion");
            System.out.println("(5) Cerrar Sesion");
            System.out.print("Seleccione la pantalla donde desea ingresar: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    listarEvaluacionesPendientes();
                    break;
                case 2:
                    listarEvaluacionesPorDia();
                    break;
                case 3:
                    registrarNotasEvaluacion();
                    break;
                case 4:
                    postulantesAptosProcesoSeleccion();
                    break;
                case 5:
                    System.out.println("Cerrando Sesion...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (opcion != 5);
    }

    private static void postulantesAptosProcesoSeleccion() {
        System.out.println("");

        System.out.println("====================== Lista de Postulantes Aptos en el Proceso de Seleccion ======================");

        List<Evaluacion> evaluaciones = seleccion.getEvaluacionDao().obtenerEvaluacionesPorEstadoDestacado();

        if (evaluaciones.size() == 0){
            System.out.println("======================================================================");
            System.out.println("No hay postulantes aptos en el proceso de seleccion");
            System.out.println("======================================================================");
            return;
        }

        System.out.println("");
        evaluaciones.stream().forEach(
                evaluacion -> {
                    System.out.println("- " + evaluacion.getEntrevista().getPostulacion().getPostulante().getDni() + " | " + evaluacion.getEntrevista().getPostulacion().getPostulante().getNombres() + " " + evaluacion.getEntrevista().getPostulacion().getPostulante().getApellidos()
                            + " | " + evaluacion.getNotaFinal() + " | " + evaluacion.getEstado()
                    );
                }
        );
        System.out.println("");
    }

    private static void registrarNotasEvaluacion() {
        System.out.println("");
        String dni = "";
        int opcion = 0;

        System.out.println("====================== Registrar Notas de Evaluacion ======================");
        System.out.print("Ingrese el dni del postulante: ");
        dni = sc.nextLine();

        Evaluacion evaluacion = seleccion.getEvaluacionDao().obtenerEvaluacionesPorDniYEstado(dni,"En Evaluacion");

        if (evaluacion == null){
            System.out.println("======================================================================");
            System.out.println("No existe el postulante con el dni ingresado o no se encuentra en evaluacion.");
            System.out.println("======================================================================");
            return;
        }

        System.out.println("====================== Registrar Notas de Evaluacion ======================");

        System.out.println("Codigo: " + evaluacion.getCodigo());
        System.out.println("Dni: " + evaluacion.getEntrevista().getPostulacion().getPostulante().getDni());
        System.out.println("Nombres: " + evaluacion.getEntrevista().getPostulacion().getPostulante().getNombres());
        System.out.println("Apellidos: " + evaluacion.getEntrevista().getPostulacion().getPostulante().getApellidos());
        System.out.print("Nota 1: ");
        evaluacion.setNota1(sc.nextInt());
        System.out.print("Nota 2: ");
        evaluacion.setNota2(sc.nextInt());
        System.out.print("Nota 3: ");
        evaluacion.setNota3(sc.nextInt());

        System.out.println("");
        System.out.println("======================================================================");

        System.out.print("¿Desea registrar las notas de la evaluacion? (1) Si (2) No: ");
        opcion = sc.nextInt();

        if(opcion == 1){

            seleccion.getEvaluacionDao().actualizarEvaluacion(evaluacion);

            seleccion.getPostulacionDao().actualizarEstadoPostulacion(evaluacion.getEntrevista().getPostulacion().getCodigo(), "Terminado");

            System.out.println("====================================");
            System.out.println("Notas registrada correctamente");
            System.out.println("====================================");
        }
    }

    private static void listarEvaluacionesPorDia() {
        System.out.println("");
        String fechaEvaluacion = "";


        System.out.println("====================== Lista de Evaluaciones por dia ======================");
        System.out.print("Ingresa Fecha de evaluacion (yyyy-mm-dd): ");
        fechaEvaluacion = sc.nextLine();

        List<Evaluacion> evaluacions = seleccion.getEvaluacionDao().obtenerEvaluacionesPorFechaEvaluacion(fechaEvaluacion);

        if (evaluacions.size() == 0){
            System.out.println("======================================================================");
            System.out.println("No hay evaluaciones para la fecha ingresada");
            System.out.println("======================================================================");
            return;
        }

        System.out.println("");
        evaluacions.stream().forEach(
                evaluacion -> {
                    System.out.println("- " + evaluacion.getEntrevista().getPostulacion().getPostulante().getDni() + " | " + evaluacion.getEntrevista().getPostulacion().getPostulante().getNombres() + " " + evaluacion.getEntrevista().getPostulacion().getPostulante().getApellidos()
                            + " | " + evaluacion.getLink() + " | " + evaluacion.getFechaEvaluacion() + " | " + evaluacion.getPerfil().getNombre() + " | " + evaluacion.getNotaFinal() + " | " + evaluacion.getEstado()
                    );
                }
        );
    }

    private static void listarEvaluacionesPendientes() {
        System.out.println("");
        String fechaEvaluacion = "";

        System.out.println("====================== Lista de Evaluaciones Pendientes ======================");

        List<Evaluacion> evaluaciones = seleccion.getEvaluacionDao().obtenerEvaluacionesPorEstado("En Evaluacion");

        if (evaluaciones.size() == 0){
            System.out.println("======================================================================");
            System.out.println("No hay evaluaciones pendientes");
            System.out.println("======================================================================");
            return;
        }

        System.out.println("");
        evaluaciones.stream().forEach(
                evaluacion -> {
                    System.out.println("- " + evaluacion.getEntrevista().getPostulacion().getPostulante().getDni() + " | " + evaluacion.getEntrevista().getPostulacion().getPostulante().getNombres() + " " + evaluacion.getEntrevista().getPostulacion().getPostulante().getApellidos()
                            + " | " + evaluacion.getLink() + " | " + evaluacion.getFechaEvaluacion() + " | " + evaluacion.getPerfil().getNombre()
                    );
                }
        );
        System.out.println("");
    }

    private static void mostrarMenuPostulante() {
        int opcion = 0;
        do {
            System.out.println("===================== Menú Principal Postulante =====================");
            System.out.println("(1) Registro de información");
            System.out.println("(2) Convocatorias de trabajo");
            System.out.println("(3) Historial Postulaciones");
            System.out.println("(4) Cerrar Sesion");
            System.out.print("Seleccione la pantalla donde desea ingresar: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    registroInformacion();
                    break;
                case 2:
                    convocatoriasTrabajo();
                    break;
                case 3:
                    historialPostulaciones();
                    break;
                case 4:
                    System.out.println("Cerrando Sesion...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (opcion != 4);
    }

    private static void historialPostulaciones() {
        String codigo = "";
        System.out.println("");
        int opcion = 0;

        Postulante postulante = seleccion.getPostulanteDao().obtenerPostulantePorUsuario(seleccion.getUsuarioLogueado().getUsuario());

        if(postulante == null){
            System.out.println("======================================================================");
            System.out.println("Debe registrar su información antes de postular a una convocatoria.");
            System.out.println("======================================================================");
            return;
        }

        System.out.println("====================== Historial de Postulaciones ======================");
        seleccion.getPostulacionDao().obtenerPostulacionesPorPostulante(postulante.getDni()).stream().forEach(
                postulacion -> {
                    System.out.println("-("+postulacion.getConvocatoria().getCodigo()+") "+postulacion.getConvocatoria().getNombre()+" - "+postulacion.getEstado() + " - " + postulacion.getFechaPostulacion());
                }
        );
        System.out.println("");

    }

    private static void convocatoriasTrabajo() {
        String codigo = "";
        System.out.println("");
        int opcion = 0;

        System.out.println("====================== Convocatorias de Trabajo ======================");
        seleccion.getConvocatoriaDao().obtenerConvocatorias().stream().forEach(
                convocatoria -> {
                    System.out.println("-("+convocatoria.getCodigo()+") "+convocatoria.getNombre());
                }
        );
        System.out.println("");
        System.out.print("Digite el código de la convocatoria que desea postular: ");
        codigo = sc.nextLine();

        Convocatoria convocatoria = seleccion.getConvocatoriaDao().obtenerConvocatoriaPorCodigo(codigo);
        if(convocatoria == null){
            System.out.println("No existe la convocatoria con el código ingresado. Vuelva al menu principal");
            return;
        }

        System.out.println("====================== Ver detalle de la oferta ======================");

        System.out.println("Código: " + convocatoria.getCodigo());
        System.out.println("Nombre: " + convocatoria.getNombre());
        System.out.println("Categoría: " + convocatoria.getCategoria());
        System.out.println("Cuenta: " + convocatoria.getCuenta().getNombre());
        System.out.println("Fecha de Inicio: " + convocatoria.getFechaInicio());
        System.out.println("Fecha de Fin: " + convocatoria.getFechaFin());
        System.out.println("Estado: " + convocatoria.getEstado());
        System.out.println("Servicio: " + convocatoria.getServicio().getNombre());
        System.out.println("Tipo de Trabajo: " + convocatoria.getTipoTrabajo());
        System.out.println("Formador: " + convocatoria.getFormador());
        System.out.println("Número de Participantes: " + convocatoria.getNumParticipantes());

        System.out.println("");
        System.out.println("======================================================================");

        System.out.print("¿Desea postular a esta convocatoria? (1) Si (2) No: ");
        opcion = sc.nextInt();

        if(opcion == 1){

            Postulante postulante = seleccion.getPostulanteDao().obtenerPostulantePorUsuario(seleccion.getUsuarioLogueado().getUsuario());

            if(postulante == null){
                System.out.println("======================================================================");
                System.out.println("Debe registrar su información antes de postular a una convocatoria.");
                System.out.println("======================================================================");
                return;
            }

            if(!seleccion.getPostulacionDao().validarPostulacionActiva(postulante.getDni())){
                System.out.println("==============================================================================================================");
                System.out.println("Ya tiene una postulación activa. No puede postular a otra convocatoria o esperar a que se cumplan los 90 días.");
                System.out.println("==============================================================================================================");
                return;
            }

            Postulacion postulacion = new Postulacion();
            postulacion.setPostulante(postulante);
            postulacion.setConvocatoria(convocatoria);

            seleccion.getPostulacionDao().grabarPostulacion(postulacion);

            System.out.println("====================================");
            System.out.println("Postulación registrada correctamente");
            System.out.println("====================================");
        }
    }

    private static void registroInformacion() {
        Postulante postulante = seleccion.getPostulanteDao().obtenerPostulantePorUsuario(seleccion.getUsuarioLogueado().getUsuario());

        if(postulante != null){
            System.out.println("==================================================");
            System.out.println("Ya se ha registrado la información del postulante.");
            System.out.println("==================================================");
            return;
        }

        postulante = new Postulante();

        System.out.println("===================== Registro de Información =====================");
        System.out.print("DNI: ");
        postulante.setDni(sc.nextLine());
        System.out.print("Nombres: ");
        postulante.setNombres(sc.nextLine());
        System.out.print("Apellidos: ");
        postulante.setApellidos(sc.nextLine());
        System.out.print("Edad: ");
        postulante.setEdad(sc.nextInt());
        sc.nextLine();
        System.out.print("Profesión: ");
        postulante.setProfesion(sc.nextLine());
        System.out.print("Institución Educativa: ");
        postulante.setInstitucionEducativa(sc.nextLine());
        System.out.print("Año de Graduación: ");
        postulante.setAnioGraduacion(sc.nextLine());
        System.out.print("Puesto anterior: ");
        postulante.setPuestoAnterior(sc.nextLine());
        System.out.print("Empresa anterior: ");
        postulante.setEmpresaAnterior(sc.nextLine());
        System.out.print("Periodo trabajo anterior: ");
        postulante.setPeriodoTrabajoAnterior(sc.nextLine());
        System.out.print("Habilidades: ");
        postulante.setHabilidades(sc.nextLine());
        System.out.print("Email: ");
        postulante.setEmail(sc.nextLine());
        System.out.print("Teléfono: ");
        postulante.setTelefono(sc.nextLine());
        System.out.print("Enlace web: ");
        postulante.setEnlaceWeb(sc.nextLine());

        postulante.setUsuario(seleccion.getUsuarioLogueado());

        seleccion.getPostulanteDao().grabarPostulante(postulante);

        System.out.println("======================================================================");
        System.out.println("Datos registrados correctamente");
        System.out.println("======================================================================");

    }


}
