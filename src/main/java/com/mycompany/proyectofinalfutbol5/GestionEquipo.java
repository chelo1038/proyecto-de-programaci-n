package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class GestionEquipo {

    private static Equipos[] equipos = new Equipos[10];
    private static int cantidadEquipos = 0;

    public static void gestionEquipos() {
        boolean equipoGestion = true;
        while (equipoGestion) {
            int manuEquipo = Integer.parseInt(JOptionPane.showInputDialog(
                    "╔══════════════ Gestión de Equipos ═════════════════╗\n"
                    + "      1- Mostrar Equipos. \n"
                    + "      2- Agregar Equipo.\n"
                    + "      3- Agregar Jugador a un Equipo. \n"
                    + "      4- Eliminar Jugador de un Equipo. \n"
                    + "      5- Volver al menu. 🔚\n"
                    + "╚═════════════════════════════════════════════════╝"));
            switch (manuEquipo) {
                case 1:
                    mostrarEquipos();
                    break;
                case 2:
                    agregarEquipo();
                    break;
                case 3:
                    agregarJugadorEquipo();
                    break;
                case 4:
                    eliminarJugadorEquipo();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Volviendo al menu principal.");
                    equipoGestion = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Número incorrecto, intente nuevamente.");
            }
        }
    }

    public static void mostrarEquipos() {

    // Verificar si el arreglo equipos está inicializado
    if (equipos == null) {
        System.out.println("No hay equipos inicializados.");
        return;
    }

    // Recorrer el arreglo equipos usando un bucle for tradicional
    System.out.println("Lista de equipos:");
    for (int i = 0; i < equipos.length; i++) {
        if (equipos[i] != null) {
            System.out.println("ID: " + equipos[i].getIdEquipo() + " | Nombre: " + equipos[i].getNombreEquipo());
        }
    }}
    public static void agregarEquipo() {
        if (cantidadEquipos < equipos.length) {
            String nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del equipo: ");
            if (nombreEquipo != null) {
                Equipos nuevoEquipo = new Equipos(nombreEquipo);
                equipos[cantidadEquipos] = nuevoEquipo;
                cantidadEquipos++;
                JOptionPane.showMessageDialog(null, "El equipo se agregó correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El nombre del equipo no puede estar vacío.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más de " + equipos.length + " equipos.");
        }
    }

    public static void agregarJugadorEquipo() {
        int idEquipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del equipo al que se va agregar el jugador: "));
        String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador: ");
        int idJugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del jugador: "));

        String[] opcionesPosicion = {"Portero", "Mediocampista", "Defensa", "Delantero"};
        int seleccionPosicion = JOptionPane.showOptionDialog(
                null,
                "Seleccione la posición",
                "Posición jugador",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesPosicion,
                opcionesPosicion[0]);

        Posicion posicion = null;
        switch (seleccionPosicion) {
            case 0 -> posicion = Posicion.Portero;
            case 1 -> posicion = Posicion.MedioCampista;
            case 2 -> posicion = Posicion.Defensa;
            case 3 -> posicion = Posicion.Delantero;
        }

        String[] estados = {"Titular", "Suplente", "Libre"};
        int estadoSelecion = JOptionPane.showOptionDialog(
                null,
                "Seleccione el estado del jugador",
                "Estado",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                estados,
                estados[0]);

        Estado estado = null;
        switch (estadoSelecion) {
            case 0: estado = Estado.Titular; break;
            case 1: estado = Estado.Suplente; break;
            case 2: estado = Estado.Libre; break;
        }

        for (int i = 0; i < cantidadEquipos; i++) {
            if (equipos[i].getIdEquipo() == idEquipo) {
                Jugadores jugador = new Jugadores(nombreJugador, posicion, equipos[i], estado);
                if (equipos[i].getCantidadJugadores() < 7) {
                    equipos[i].agregarJugador(jugador);
                    JOptionPane.showMessageDialog(null, "Jugador agregado con éxito al equipo " + equipos[i].getNombreEquipo());
                } else {
                    JOptionPane.showMessageDialog(null, "El equipo ya tiene 7 jugadores.");
                }
                return;
            }
        }
    }

    public static void eliminarJugadorEquipo() {
        int idEquipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del equipo donde se va a eliminar el jugador: "));
        int idJugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del jugador a eliminar: "));

        for (int i = 0; i < cantidadEquipos; i++) {
            if (equipos[i].getIdEquipo() == idEquipo) {
                if (equipos[i].eliminarJugador(idJugador)) {
                    JOptionPane.showMessageDialog(null, "Jugador eliminado con éxito del equipo " + equipos[i].getNombreEquipo());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el jugador con el ID dado.");
                }
                return;
            }
        }
    }
}
