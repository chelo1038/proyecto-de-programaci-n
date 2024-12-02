package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;


public class GestionJugadores {

    private static Jugadores[] jugadores = new Jugadores[70];
    private static int cantidadJugadores = 0;

    public static void gestionJugadores() {
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
                    break;
                case 3:
                    editarJugador();
                    break;
                case 4:
                    eliminarJugador();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Volviendo al menu principal.");
                    jugadorGestion = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Número incorrecto, intente nuevamente.");
            }
        }
    }

    private static void mostrarJugadores() {
        Jugadores.mostrarJugadores();
    }

    private static void agregarJugador() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador: ");
        Posicion posicion = seleccionPosicion();
        Equipos equipo = seleccionEquipo();
        Estado estado = seleccionEstado();

        Jugadores jugador = new Jugadores(nombre, posicion, equipo, estado);
        jugadores[cantidadJugadores] = jugador;
        cantidadJugadores++;

        JOptionPane.showMessageDialog(null,
                "Jugador agregado con éxito: "
                + "\nID: " + jugador.getID()
                + "\nNombre: " + jugador.getNombre()
                + "\nPosición: " + jugador.getPosicion()
                + "\nEquipo: " + jugador.getEquipo().getNombreEquipo()
                + "\nEstado: " + jugador.getEstado());
    }

    private static void editarJugador() {
        int idJugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del jugador a editar: "));
        boolean jugadorEncontrado = false;

        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getID() == idJugador) {
                jugadorEncontrado = true;
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
                jugadores[i].setNombre(nuevoNombre);

                Posicion nuevaPosicion = seleccionPosicion();
                jugadores[i].setPosicion(nuevaPosicion);

                Estado nuevoEstado = seleccionEstado();
                jugadores[i].setEstado(nuevoEstado);

                Equipos nuevoEquipo = seleccionEquipo();
                jugadores[i].setEquipo(nuevoEquipo);

                JOptionPane.showMessageDialog(null, "Jugador editado con éxito.");
                return;
            }
        }

        if (!jugadorEncontrado) {
            JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
        }
    }

    private static void eliminarJugador() {
        int idJugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del jugador a eliminar: "));
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getID() == idJugador) {
                jugadores[i] = jugadores[--cantidadJugadores];
                jugadores[cantidadJugadores] = null;
                JOptionPane.showMessageDialog(null, "Jugador eliminado con éxito.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
    }

    private static Posicion seleccionPosicion() {
        String[] opciones = {"Portero", "Defensa", "Mediocampista", "Delantero"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione la posición del jugador:", "Posición",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        switch (seleccion) {
            case 0: return Posicion.Portero;
            case 1: return Posicion.Defensa;
            case 2: return Posicion.MedioCampista;
            case 3: return Posicion.Delantero;
            default: return null;
        }
    }

    private static Estado seleccionEstado() {
        String[] opciones = {"Titular", "Suplente", "Libre"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el estado del jugador:", "Estado",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        switch (seleccion) {
            case 0: return Estado.Titular;
            case 1: return Estado.Suplente;
            case 2: return Estado.Libre;
            default: return null;
        }
    }

    private static Equipos seleccionEquipo() {
        String[] opciones = {"Liga Deportiva", "Saprissa", "Heredia"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el equipo del jugador:", "Equipo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        Equipos equipo = null;
        switch (seleccion) {
            case 0: equipo = new Equipos("Liga Deportiva"); break;
            case 1: equipo = new Equipos("Saprissa"); break;
            case 2: equipo = new Equipos("Heredia"); break;
        }
        return equipo;
    }
}