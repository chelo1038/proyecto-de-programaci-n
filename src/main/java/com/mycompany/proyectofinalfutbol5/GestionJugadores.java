package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class GestionJugadores {

    private static Jugadores[] jugadores = new Jugadores[70];
    private static int cantidadJugadores = 0;
    private static Equipos[] equipos = new Equipos[10];
    private static int cantidadEquipos = 0;

    public static void gestionJugadores() {
        //String jugador= JOptionPane.showInputDialog("ingrese el nombre del jugador  ");
        // JOptionPane.showMessageDialog(null,"el jugador: " + jugador + ", fue añadido con exito");
        boolean jugadorGestion = true;
        while (jugadorGestion) {

            int codigo1 = Integer.parseInt(JOptionPane.showInputDialog(
                    "╔══════════════ Gestión de Jugadores ═════════════════╗\n"
                    + "       1- Mostrar jugadores. 🏃🏃\n"
                    + "       2- Agregar nuevo jugador. +🏃\n"
                    + "       3- Editar jugador. 🏃🏼‍\n"
                    + "       4- Eliminar jugador. ⚠\n"
                    + "       5- Volver al menu. 🔚\n"
                    + "╚═══════════════════════════════════════════════════╝"));

            switch (codigo1) {
                case 1:
                    mostrarJugadores();

                    break;
                case 2:
                    agregarJugador();
                case 3:
                    editarJugador();
                    break;

                case 4:
                    eliminarJugador();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null,
                            "volviendo al menu principal  ");
                    jugadorGestion = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "numero incorrecto, intente nuevamente ");

            }

        }

    }

    private static void mostrarJugadores() {
         String listaJugadores = "Lista de jugadores:\n";
    for (int i = 0; i < 30; i++) {  // Suponiendo que has inicializado 30 jugadores
        Jugadores jugador = Jugadores.getJugadorPorID(i); // Usando getJugadorPorID para obtener el jugador
        if (jugador != null) {
            String equipoNombre = (jugador.getEquipo() == null) ? "Libre" : jugador.getEquipo().getNombreEquipo();
            System.out.println( "ID: " + jugador.getID() +
"                              \" | Nombre: \" + jugador.getNombre() +\n" +
"                              \" | Posición: \" + jugador.getPosicion() +\n" +
"                              \" | Estado: \" + jugador.getEstado() +\n" +
"                              \" | Equipo: \" + equipoNombre + \"\\n\";"); 
        }
    }
    JOptionPane.showMessageDialog(null, listaJugadores); 
    }

    private static void agregarJugador() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador: ");
        Posicion posicion = seleccionPosicion();
        Equipos equipos = seleccionEquipo();
        Estado estado = seleccionEstado();

        Jugadores jugador = new Jugadores(nombre, posicion, equipos, estado);
        jugadores[cantidadJugadores] = jugador;
        cantidadJugadores++;
       

        JOptionPane.showMessageDialog(null,
                "Jugador agregado con exito: "
                + " \n ID: " + jugador.getID()
                + " \n NOMBRE: " + jugador.getNombre()
                + " \n POSICION: " + jugador.getPosicion()
                + " \n EQUIPO: " + jugador.getEquipo().getNombreEquipo()
                + " \n ESTADO: " + jugador.getEstado());
    }

    private static void editarJugador() {
        if (cantidadJugadores == 0) {
            JOptionPane.showMessageDialog(null, "No hay jugadores para editar");
            return;
        }
        int idJugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del nuevo jugador: "));
        boolean jugadorEncontrado = false;

        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getID() == idJugador) {
                jugadorEncontrado = true;

                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del nuevo jugador");
                jugadores[i].setNombre(nuevoNombre);

                Posicion nuevaPosicion = seleccionPosicion();
                jugadores[i].setPosicion(nuevaPosicion);

                Estado nuevoEstado = seleccionEstado();
                jugadores[i].setEstado(nuevoEstado);

                Equipos equipos = seleccionEquipo();
                jugadores[i].setEquipo(equipos);

                JOptionPane.showMessageDialog(null, "Jugador editado con exito:"
                        + "\nID: " + jugadores[i].getID()
                        + "\n NOMBRE: " + jugadores[i].getNombre()
                        + "\n POSICION: " + jugadores[i].getPosicion()
                        + "\n EQUIPO: " + jugadores[i].getEquipo()
                        + "\n ESTADO: " + jugadores[i].getEstado());
                return;
            }
        }
        if (!jugadorEncontrado) {
            JOptionPane.showMessageDialog(null, "Jugador no encontrado");
        }
    }

    private static void eliminarJugador() {
        if (cantidadJugadores == 0) {
            JOptionPane.showMessageDialog(null, "No hay jugadores para eliminar");
            return;
        }
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del jugador: "));
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getID() == id) {
                if (jugadores[i].getEquipo() != null) {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar un jugador asignado a un equipo.");
                    return;
                }
                jugadores[i] = jugadores[--cantidadJugadores];
                jugadores[cantidadJugadores] = null;
                JOptionPane.showMessageDialog(null, "Jugador eliminado con exito.");
                return;
            }

        }
        JOptionPane.showMessageDialog(null, "Jugador no encontrado");
    }

    private static Posicion seleccionPosicion() {
        String[] opciones = {"Portero", "Defensa", "Mediocampista", "Delantero"
        };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Selecione la posicion del juagdor",
                "Posicion",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        Posicion posicion = null;
        switch (seleccion) {
            case 0:
                posicion = Posicion.Portero;
                break;
            case 1:
                posicion = Posicion.Defensa;
                break;
            case 2:
                posicion = Posicion.MedioCampista;
                break;
            case 3:
                posicion = Posicion.Delantero;
                break;

        }
        return posicion;
    }

    private static Estado seleccionEstado() {
        String[] opcionesEstado = {"Titular", "Suplente", "Libre"};
        int seleccionEstado = JOptionPane.showOptionDialog(
                null,
                "Seleccione el estado del jugador",
                "Estado",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesEstado,
                opcionesEstado[0]);

        Estado estado = null;
        switch (seleccionEstado) {
            case 0:
                estado = Estado.Titular;
                break;
            case 1:
                estado = Estado.Suplente;
                break;
            case 2:
                estado = Estado.Libre;
                break;

        }
        return estado;
    }

    private static Equipos seleccionEquipo() {
        String[] opciones = { "LigaDeportiva", "Saprissa", "Heredia"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione el equipo del jugador",
                "Equipo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        Equipos equipo = null;
        switch (seleccion) {
            case 1:
                equipo = new Equipos("LigaDeportiva");
                break;
            case 2:
                equipo = new Equipos("Saprissa");
                break;
            case 3:
                equipo = new Equipos("Heredia");
                break;
        }
        return equipo;
    }
}
