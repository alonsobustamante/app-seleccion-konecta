package ejecutora;

import entidades.Cuenta;
import servicios.CuentaServicio;
import servicios.impl.CuentaServicioImpl;

public class App {
    public static void main(String[] args) {
        System.out.println("Hola Mundo! Esta es la modificación de Alberto.");

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla de inicio de sesion

        System.out.println(
            """
                ========================== Inicio de Sesión ==========================
                - Usuario: _
                - Contraseña: _
                - Tipo de Rol (Postulante: P, Entrevistador: E, Selector: S): _
                ======================================================================
                                        
                """
        );

        System.out.println("\n-------------------------------------------------\n");

        // Pantallas del postulante

        // Menu principal de la aplicacion para el postulante

        System.out.println(
            """
                ===================== Menú Principal Postulante =====================
                (1) Registro de información
                (2) Convocatorias de trabajo
                (3) Postulaciones pendientes
                                
                Seleccione la pantalla donde desea ingresar: _
                                
                * Escriba $ para salir de la aplicación
                ======================================================================
                        
                """
        );

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla de Registro de Información para el CV virtual

        System.out.println("""
                ====================== Registro de Información ======================
                ----------------------- Información personal -----------------------
                - Nombre y apellidos: \s
                - Edad:
                ----------------------------- Educación -----------------------------
                - Ultimo título académico:
                - Institución educativa:
                - Año de graduación:
                ------------------------ Experiencia laboral ------------------------
                - Puestos anteriores, fechas y empresas (uno o dos): \s
                - Breve descripción del trabajo:
                - Referencias:
                ---------------------- Habilidades y proyectos ----------------------
                - Lista de habilidades clave (técnicas, idiomas):
                - Proyectos relevantes:
                - Certificaciones:
                ---------------------- Información de Contacto ----------------------
                - Correo:\s
                - Número de teléfono:\s
                - Enlaces (LinkedIn, GitHub, etc.):
                ====================================================================== \s
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla de lista las convocatorias de trabajo

        System.out.println("""
                ====================== Convocatorias de Trabajo ======================
                -(C001) Ejecutivo de ventas telefónicas\s
                -(C002) Supervisor de ventas\s
                -(C003) Supervisor de datos de ventas\s
                -(C004) Representante de servicio al cliente\s
                -(C005) Especialista de soporte técnico
                -(C006) Analista de calidad
                                
                Digite el código de la convocatoria que desea postular: _
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        //	Pantalla de buscar convocatoria por código para ver detalle de la oferta laboral

        System.out.println("""
                ====================== Ver detalle de la oferta ======================
                
                - Oferta laboral: (C001) “Ejecutivo de ventas telefónicas”
                
                - Detalle de la oferta:
                
                    Estamos en la búsqueda de un Ejecutivo de ventas telefónicas para 
                    nuestro call center que se encargue de realizar llamadas a los 
                    clientes principales, identificar oportunidades de venta, presentar 
                    productos, y cumplir con objetivos trazados. Las funciones claves 
                    son las siguientes:
                    
                        - Realizar llamadas proactivas
                        - Presentar productos de manera efectiva
                        - Manejar objeciones con habilidad
                        - Mantener un registro detallado de las interacciones
                        - Cumplir con objetivos de ventas
                                
                (1) Postular a la oferta – (2) Volver a la lista de convocatorias: _ \s
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        // Pantalla de registro de postulaciones

        System.out.println("\n-------------------------------------------------\n");

        System.out.println("""
                ===================== Registro de Postulaciones =====================
                -(C001) Ejecutivo de ventas telefónicas – En proceso
                -(C002) Supervisor de ventas – Terminada
                                
                Digite el código de la postulación: _
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        // Diseño de pantallas para el entrevistador

        // Menú principal de la aplicación para el entrevistador

        System.out.println("\n-------------------------------------------------\n");

        System.out.println("""
                ==================== Menú Principal Entrevistador ====================
                (1)	Lista de postulantes que faltan entrevistar por día
                (2)	Postulantes con entrevista programada
                (3)	Postulantes que están dando evaluaciones
                (4)	Ventana postulante\s
                                
                Digite la pantalla donde desea ingresar: _
                * Escriba $ para salir de la aplicación
                ======================================================================
                """);

        // Pantalla de lista de postulantes que faltan entrevistar por día

        System.out.println("\n-------------------------------------------------\n");

        System.out.println("""
                ================ Lista de Postulantes por Entrevistar ================
                 Ingresa Fecha de Inscripción(dd/mm/yyyy): 11/11/2023
                                
                - U5738 | María Del Carmen Hernández Salazar........  (11/11/2023)
                - U1947 | Juan Eliseo Contreras García........ (11/11/2023)
                - U8265 | Oscar Martín Valle Flores........  (11/11/2023)
                - U3094 | Carolina Madai Beltrán López........  (11/11/2023)
                - U6781 | Ernesto Francisco Portillo Méndez........  (11/11/2023)
                - U4329 | Lucia Abigail Pérez Sosa........ (11/11/2023)
                - U5176 | Michael Valeria Tobar López........ (11/11/2023)
                - U8902 | Guadalupe Del Rosario Álvarez Espinoza........  (11/11/2023)
                - U3567 | Nelson Vladimir Pineda Peña........  (11/11/2023)
                - U1248 | Roberto Javier Paz Valencia) ........ (11/11/2023)
                                
                Ingrese el usuario del postulante: _
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla de lista de postulantes con entrevista programada

        System.out.println("""
                =========== Lista de Postulantes con Entrevista Programada ===========
                 Ingresa Fecha de Entrevista(dd/mm/yyyy): 15/11/2023
                                
                - U2345 | Alejandra Guadalupe Ramírez González........ (15/11/2023)
                - U7890 | Ricardo Alberto Jiménez Martínez........ (15/11/2023)
                - U4521 | Gabriela Estefanía Torres García........ (15/11/2023)
                - U8765 | Andrés Eduardo Sánchez Rodríguez........ (15/11/2023)
                - U1098 | Paola Alejandra Mendoza Montes........ (15/11/2023)
                - U5678 | Sergio Alejandro Vargas Jiménez........ (15/11/2023)
                - U3210 | Verónica Patricia Hernández Silva........ (15/11/2023)
                - U6543 | José Luis Gómez Martínez........ (15/11/2023)
                - U9876 | Ana Karen Torres Torres........ (15/11/2023)
                - U2134 | Eduardo Antonio Reyes Soto........ (15/11/2023)
                                
                Ingrese el usuario del postulante: _
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Ventana postulante (Entrevistador)

        System.out.println("""
                ========================= Ventana postulante =========================
                Ingrese el usuario del postulante:  U5738 /* En caso se haya ingresado desde el menú principal */
                                
                - Postulante: U5738 | María Del Carmen Hernández Salazar
                - Estado: Falta entrevistar / Falta evaluación
                - Evaluaciones pendientes: Si / No
                                
                (1) Agendar entrevista
                (2) Ingresar detalles de entrevista realizada
                (3) Asignar evaluación a postulante
                (4) Actualizar estado de postulante
                                
                Digite la pantalla donde desea ingresar: _
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla de agendar entrevista

        System.out.println("""
                ========================= Agendar Entrevista =========================
                - Postulante: U5738 | María Del Carmen Hernández Salazar
                - Ingrese fecha de entrevista (dd/mm/yyyy): _
                - Ingrese hora de entrevista (00:00): _
                                
                Siguiente acción: _
                * Escriba ? para volver a la ventana postulante
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla de ingresar detalles de entrevista realizada (ingresar detalles)

        System.out.println("""
                ==================== Ingresar Detalles Entrevista ====================
                - Postulante: U5738 | María Del Carmen Hernández Salazar
                - Fecha y hora de entrevista (dd/mm/yyyy): 11/11/2023 – 16:30
                                
                Ingrese detalles de la entrevista: _
                                
                Siguiente acción: _
                * Escriba ? para volver a la ventana postulante
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla de actualizar estado de postulante (perfil de entrevistador)

        System.out.println("""
                ========================= Estado Postulante =========================
                - Postulante: U5738 | María Del Carmen Hernández Salazar
                                
                (1)	En proceso de entrevista (Etapa 1)
                (2)	En evaluación (Etapa 1)
                                
                Seleccione el estado del postulante: _
                * Escriba ? para volver a la ventana postulante
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla de asignar evaluación

        System.out.println("""
                ========================= Asignar Evaluación =========================
                                
                - Postulante: U5738 | María Del Carmen Hernández Salazar
                                
                (1) Habilidades técnicas en ventas
                (2) Prueba de casuística de servicio al cliente
                (3) Cuestionario de adaptabilidad y habilidades psicométricas
                (4) Examen de habilidades matemáticas y razonamiento numérico
                (5) Prueba de resolución de problemas y habilidades lógicas
                                
                Seleccione la evaluación asignada al postulante: _
                ¿Desea asignar otra evaluación? Sí (1) No (2): _
                                
                Siguiente acción: _
                                
                * Escriba ? para volver a la ventana postulante
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Diseño de pantallas para el selector

        // Menú principal de la aplicación para el selector

        System.out.println("""
                ====================== Menú Principal Selector ======================
                (1)	Postulantes con evaluaciones pendientes
                (2)	Ventana postulante\s
                                
                Digite la pantalla donde desea ingresar: _
                * Escriba $ para salir de la aplicación
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla de lista de postulantes con evaluaciones pendientes

        System.out.println("""
                =========== Lista de Postulantes con Entrevista Programada ===========
                * A la derecha se muestra la fecha de su entrevista
                                
                - U2109 | Ricardo Antonio Hernández Castro) ........ (01/11/2023)
                - U1234 | María José Rodríguez Torres........ (03/11/2023)
                - U8901 | Carolina Isabel Vargas Martínez........ (05/11/2023)
                - U6789 | Juan Carlos Gómez García........ (07/11/2023)
                - U4567 | Sebastián Eduardo Méndez Ortiz........ (09/11/2023)
                - U2345 | Alejandro Fernando González Silva........ (11/11/2023)
                - U7890 | Laura Estefanía Ramírez Morales........ (11/11/2023)
                - U5678 | Paola Andrea Martínez Torres........ (11/11/2023)
                - U9012 | Andrés Felipe Sánchez Rodríguez........ (11/11/2023)
                - U3456 | Valeria Alejandra Guzmán Pérez........ (11/11/2023)
                                
                Ingrese el usuario del postulante: _
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Ventana postulante (perfil de selector)

        System.out.println("""
                ========================= Ventana postulante =========================
                Ingrese el usuario del postulante:  U5738 /* En caso se haya ingresado desde el menú principal */
                                
                - Postulante: U5738 | María Del Carmen Hernández Salazar
                - Estado: Falta entrevistar / Falta evaluación
                - Evaluaciones pendientes: Si / No
                                
                (1) Ver detalles de entrevista realizada
                (2) Ver resultado de evaluaciones
                (3) Actualizar estado de postulante
                                
                Digite la pantalla donde desea ingresar: _
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla para ver detalles de entrevista realizada

        System.out.println("""
                ===================== Ver Detalles Entrevista ======================
                - Postulante: U5738 | María Del Carmen Hernández Salazar
                - Fecha y hora de entrevista: 11/11/2023 – 16:30
                                
                Detalles de la entrevista:\s
                La entrevista fue bien, la postulante mostró una buena disposición, 
                proactividad. Además, se ve que tiene experiencia en la materia. 
                Comentó que en experiencias pasadas había llevado adelante proyectos 
                de innovación en cuanto a técnicas de ventas por teléfono, lo cual 
                es prometedor.
                                
                Siguiente acción: _
                * Escriba ? para volver a la ventana postulante
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla para ver el resultado de las evaluaciones del postulante

        System.out.println("""
                ===================== Resultado de evaluaciones =====================
                                
                - Postulante: U5738 | María Del Carmen Hernández Salazar
                                
                - Habilidades técnicas en ventas: 87/100
                - Prueba de casuística de servicio al cliente: 75/100
                - Prueba de resolución de problemas y habilidades lógicas: 65/100
                                
                Puntaje final: 15/20
                                
                Siguiente acción: _
                                
                * Escriba ? para volver a la ventana postulante
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

        // Pantalla de actualizar estado de postulante (perfil de selector)

        System.out.println("""
                ========================= Estado Postulante =========================
                - Postulante: U5738 | María Del Carmen Hernández Salazar
                                
                (1)	Pasa a capacitación
                (2)	No continúa el proceso
                                
                Seleccione el estado del postulante: _
                * Escriba ? para volver a la ventana postulante
                * Escriba 0 para volver al menú principal
                ======================================================================
                """);

        System.out.println("\n-------------------------------------------------\n");

    }


}
