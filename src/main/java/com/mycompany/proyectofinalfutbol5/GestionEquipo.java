package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class GestionEquipo {

    private static Equipos[] equipos = new Equipos[3];
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
                    JOptionPane.showMessageDialog(null,
                            "volviendo al menu principal  ");
                    equipoGestion = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "numero incorrecto, intente nuevamente ");

            }

        }

    }

    public static void mostrarEquipos() {
        String listaEquipos = "Equipos registrados";
        for (int i = 0; i < cantidadEquipos; i++) {
            Equipos equipo = equipos[i];
            listaEquipos += "ID Equipo: " + equipo.getIdEquipo() + "Nombre: " + equipo.getNombreEquipo();
            listaEquipos += "Jugadores:";
                    
             for (int j = 0; j < equipo.getCantidadJugadores(); j++) {
                 Jugadores jugador = equipo.getJugadores()[j];
                 listaEquipos += "ID: " + jugador.getID() + "Nombre: " + jugador.getNombre() +
                         "Posicion: " + jugador.getPosicion() + "Estado: " + jugador.getEstado();
            }
             listaEquipos += "\n";
            
        }
        JOptionPane.showMessageDialog(null, listaEquipos);

    }

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

        String[] opcionesPosicion = {"Portero", "Medicampista", "Defensa", "Delantero"};
        int seleccionPosicion = JOptionPane.showOptionDialog(
                null,
                "Selecione la posicion",
                "Posicion jugador",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesPosicion,
                opcionesPosicion[0]);

        Posicion posicion = null;
        switch (seleccionPosicion) {
            case 1:
                posicion = Posicion.Portero;
                break;
            case 2:
                posicion = Posicion.MedioCampista;
                break;
            case 3:
                posicion = Posicion.Defensa;
                break;
            case 4:
                posicion = Posicion.Delantero;
                break;
        }

        String[] estados = {"Titular", "Suplente", "Libre"};
        int estadoSelecion = JOptionPane.showOptionDialog(
                null,
                "Selecione el estado del jugador",
                "Estado",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                estados,
                estados[0]);

        Estado estado = null;
        switch (estadoSelecion) {
            case 1:
                estado = Estado.Titular;
                break;
            case 2:
                estado = Estado.Suplente;
                break;
            case 3:
                estado = Estado.Libre;
                break;

        }

        for (int i = 0; i < cantidadEquipos; i++) {
            if (equipos[i].getIdEquipo() == idEquipo) {
                Jugadores jugador = new Jugadores(nombreJugador, posicion, equipos[i], estado);
                if (equipos[i].getCantidadJugadores() < 7) {
                    equipos[i].agregarJugador(jugador);
                    JOptionPane.showMessageDialog(null, "Jugador agregado con exito al equipo."
                            + equipos[i].getNombreEquipo());
                } else {
                    JOptionPane.showMessageDialog(null, "El equipo ya tiene 7 jugadores.");

                }
                return;
            }
        }
    }

    public static void eliminarJugadorEquipo() {
        int idEquipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del equipo que se va a eliminar: "));
        int idJugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del jugador que se va a eliminar: "));

        for (int i = 0; i < cantidadEquipos; i++) {
            if (equipos[i].getIdEquipo() == idEquipo) {
                if (equipos[i].eliminarJugador(idJugador)) {
                    JOptionPane.showMessageDialog(null, "Jugador eliminado con exito."
                            + equipos[i].getNombreEquipo());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro el jugador con el ID dado."
                            + equipos[i].getNombreEquipo());
                }
                return;
            }
        }

    }

}
