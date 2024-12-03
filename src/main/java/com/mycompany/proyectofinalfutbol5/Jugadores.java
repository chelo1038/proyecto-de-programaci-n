package com.mycompany.proyectofinalfutbol5;

public class Jugadores {

    private static Jugadores[] jugadores = new Jugadores[70]; // Arreglo estático de 70 jugadores
    private static int contadorID = 10; // El ID de los jugadores comienza en 10
    private static int cantidadJugadores = 0; // Contador de jugadores añadidos

    private int ID;
    private String nombre;
    private Posicion posicion;
    private Equipos equipo;
    private Estado estado;
    private int golesAnotados;
    private int accionesTotales;

    // Constructor
    public Jugadores(String nombre, Posicion posicion, Equipos equipo, Estado estado) {
        this.ID = contadorID++; // El ID se incrementa a partir de 10
        this.nombre = nombre;
        this.posicion = posicion;
        this.equipo = equipo;
        this.estado = estado;
        this.golesAnotados = 0;
        this.accionesTotales = 0;
    }

    // Métodos getter y setter
    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public int getAccionesTotales() {
        return accionesTotales;
    }

    public void setAccionesTotales(int accionesTotales) {
        this.accionesTotales = accionesTotales;
    }

    // Método para inicializar los jugadores con nombres predeterminados
    public static void inicializarJugadores() {
        if (cantidadJugadores == 0) { // Solo inicializamos si aún no lo hemos hecho
            System.out.println("Inicializando jugadores...");  // Mensaje de inicialización

            jugadores[0] = new Jugadores("Juan Pérez", Posicion.Defensa, null, Estado.Titular);
            jugadores[1] = new Jugadores("Carlos García", Posicion.Delantero, null, Estado.Titular);
            jugadores[2] = new Jugadores("Alberto Fernández", Posicion.Portero, null, Estado.Titular);
            jugadores[3] = new Jugadores("Luis Rodríguez", Posicion.MedioCampista, null, Estado.Titular);
            jugadores[4] = new Jugadores("Pablo Martínez", Posicion.Defensa, null, Estado.Titular);
            jugadores[5] = new Jugadores("Mario Torres", Posicion.Delantero, null, Estado.Suplente);
            jugadores[6] = new Jugadores("José Ramírez", Posicion.Portero, null, Estado.Suplente);
            jugadores[7] = new Jugadores("Andrés Castro", Posicion.MedioCampista, null, Estado.Suplente);
            jugadores[8] = new Jugadores("Felipe Méndez", Posicion.Defensa, null, Estado.Suplente);
            jugadores[9] = new Jugadores("Javier Solano", Posicion.Delantero, null, Estado.Suplente);

            cantidadJugadores = 10; // Ya hemos agregado 10 jugadores predeterminados

            // Asignando nombres personalizados para los jugadores 10 a 69
            for (int i = 10; i < 70; i++) {
                jugadores[i] = new Jugadores("Jugador " + (i + 1), Posicion.values()[i % 4], null, Estado.Libre);
                cantidadJugadores++;
            }
        }
    }

    // Método para obtener un jugador por su ID
    public static Jugadores getJugadorPorID(int ID) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] != null && jugadores[i].getID() == ID) {
                return jugadores[i];
            }
        }
        return null;
    }

    // Método para agregar un jugador al arreglo de jugadores
    public static void agregarJugador(Jugadores jugador) {
        if (cantidadJugadores < jugadores.length) {
            jugadores[cantidadJugadores++] = jugador; // Añadir jugador al arreglo
        } else {
            System.out.println("No se puede agregar más jugadores, el arreglo está lleno.");
        }
    }
    
}
