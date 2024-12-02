package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class Equipos {
    private static Equipos[] equipos = new Equipos[10]; // Arreglo de 10 equipos
    private static int contadorEquipos = 100;

    private int idEquipo;
    private String nombreEquipo;
    private Jugadores[] jugadores = new Jugadores[7]; // Cada equipo tiene 7 jugadores
    private int cantidadJugadores = 0;

    public Equipos(String nombreEquipo) {
        this.idEquipo = contadorEquipos++;
        this.nombreEquipo = nombreEquipo;
    }

    // Métodos Getter y Setter
    public int getIdEquipo() {
        return idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public Jugadores[] getJugadores() {
        return jugadores;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void agregarJugador(Jugadores jugador) {
        if (cantidadJugadores < jugadores.length) {
            jugadores[cantidadJugadores++] = jugador;
        }
    }

    // Método para eliminar jugadores de un equipo
    public boolean eliminarJugador(int idJugador) {
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getID() == idJugador) {
                // Desplazar jugadores
                for (int j = i; j < cantidadJugadores - 1; j++) {
                    jugadores[j] = jugadores[j + 1];
                }
                jugadores[--cantidadJugadores] = null;
                return true;
            }
        }
        return false;
    }

    // Método estático para inicializar jugadores y asignarlos a los equipos
    public static void inicializarJugadoresYAsignarEquipos() {
        // Inicializamos los jugadores
        Jugadores.inicializarJugadores();

        // Crear los equipos
        Equipos equipo1 = new Equipos("Liga Deportiva");
        Equipos equipo2 = new Equipos("Saprissa");
        Equipos equipo3 = new Equipos("Heredia");

        // Asignamos jugadores a los equipos
        equipo1.agregarJugador(Jugadores.getJugadorPorID(0));
        equipo1.agregarJugador(Jugadores.getJugadorPorID(1));
        equipo1.agregarJugador(Jugadores.getJugadorPorID(2));
        equipo1.agregarJugador(Jugadores.getJugadorPorID(3));
        equipo1.agregarJugador(Jugadores.getJugadorPorID(4));

        equipo2.agregarJugador(Jugadores.getJugadorPorID(5));
        equipo2.agregarJugador(Jugadores.getJugadorPorID(6));
        equipo2.agregarJugador(Jugadores.getJugadorPorID(7));
        equipo2.agregarJugador(Jugadores.getJugadorPorID(8));
        equipo2.agregarJugador(Jugadores.getJugadorPorID(9));

        equipo3.agregarJugador(Jugadores.getJugadorPorID(10));
        equipo3.agregarJugador(Jugadores.getJugadorPorID(11));
        equipo3.agregarJugador(Jugadores.getJugadorPorID(12));
        equipo3.agregarJugador(Jugadores.getJugadorPorID(13));
        equipo3.agregarJugador(Jugadores.getJugadorPorID(14));

        // Agregar los equipos al arreglo de equipos
        equipos[0] = equipo1;
        equipos[1] = equipo2;
        equipos[2] = equipo3;

        // Mostrar los jugadores
        Jugadores.mostrarJugadores();
    }

   public void mostrarDetalles() {
    String listaJugadores = "Equipo: " + nombreEquipo + "\nJugadores:\n";
    for (int i = 0; i < cantidadJugadores; i++) {
        Jugadores jugador = jugadores[i];
        String equipoNombre;
        
        if (jugador.getEquipo() != null) {
            equipoNombre = jugador.getEquipo().getNombreEquipo();
        } else {
            equipoNombre = "Libre";
        }

        listaJugadores += "ID: " + jugador.getID() + " | Nombre: " + jugador.getNombre() +
                " | Posición: " + jugador.getPosicion() + " | Estado: " + jugador.getEstado() +
                " | Equipo: " + equipoNombre + "\n";
    }
    JOptionPane.showMessageDialog(null, listaJugadores);
   }
}