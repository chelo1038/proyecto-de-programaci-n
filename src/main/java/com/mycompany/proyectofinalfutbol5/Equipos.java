package com.mycompany.proyectofinalfutbol5;

public class Equipos {

    private static Equipos[] equipos = new Equipos[10]; // Arreglo de 10 equipos
    private static int contadorEquipos = 100; // El ID de los equipos comienza en 100

    private int idEquipo;
    private String nombreEquipo;
    private Jugadores[] jugadores = new Jugadores[7]; // Cada equipo tiene 7 jugadores
    private int cantidadJugadores = 0;

    // Constructor de Equipos
    public Equipos(String nombreEquipo) {
        this.idEquipo = contadorEquipos++; // El ID se incrementa a partir de 100
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

    // Agregar un jugador al equipo
    public void agregarJugador(Jugadores jugador) {
        if (cantidadJugadores < jugadores.length) {
            jugadores[cantidadJugadores++] = jugador;
        }
    }

    // Eliminar un jugador del equipo
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
        Jugadores.inicializarJugadores();  // Inicializa los jugadores

        // Crear los equipos
        Equipos equipo1 = new Equipos("Liga Deportiva");
        Equipos equipo2 = new Equipos("Saprissa");
        Equipos equipo3 = new Equipos("Heredia");

        // Asignamos jugadores a los equipos
        for (int i = 0; i < 5; i++) {
            equipo1.agregarJugador(Jugadores.getJugadorPorID(i + 10));  // Se asegura de que los jugadores empiezan en ID 10
        }

        for (int i = 5; i < 10; i++) {
            equipo2.agregarJugador(Jugadores.getJugadorPorID(i + 10));  // Se asegura de que los jugadores empiezan en ID 10
        }

        for (int i = 10; i < 15; i++) {
            equipo3.agregarJugador(Jugadores.getJugadorPorID(i + 10));  // Se asegura de que los jugadores empiezan en ID 10
        }

        // Agregar los equipos al arreglo de equipos
        equipos[0] = equipo1;
        equipos[1] = equipo2;
        equipos[2] = equipo3;

        // Mostrar los jugadores asignados a los equipos
        mostrarJugadores();
    }

    // Método estático para mostrar los jugadores asignados a los equipos
    public static void mostrarJugadores() {
        String listaEquipos = "Jugadores asignados a equipos:\n";

        for (Equipos equipo : equipos) {
            if (equipo != null) {
                listaEquipos += "Equipo: " + equipo.getNombreEquipo() + " (ID: " + equipo.getIdEquipo() + ")\n";
                for (int i = 0; i < equipo.getCantidadJugadores(); i++) {
                    Jugadores jugador = equipo.getJugadores()[i];
                    if (jugador != null) {
                        listaEquipos += "  - ID: " + jugador.getID()
                                + " | Nombre: " + jugador.getNombre()
                                + " | Posición: " + jugador.getPosicion()
                                + " | Estado: " + jugador.getEstado() + "\n";
                    }
                }
                listaEquipos += "\n"; // Separador entre equipos
            }
        }

        // Mostrar en consola
        System.out.println(listaEquipos);
    }

    // Método estático para obtener la cantidad de equipos
    public static int getCantidadEquipos() {
        int cantidad = 0;
        for (Equipos equipo : equipos) {
            if (equipo != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Método estático para obtener un equipo por su índice
    public static Equipos getEquipo(int index) {
        if (index >= 0 && index < equipos.length) {
            return equipos[index];
        }
        return null;
    }

    // Método estático para buscar un equipo por su ID
    public static Equipos buscarEquipoPorId(int id) {
        for (Equipos equipo : equipos) {
            if (equipo != null && equipo.getIdEquipo() == id) {
                return equipo;
            }
        }
        return null;
    }
}

