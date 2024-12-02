package com.mycompany.proyectofinalfutbol5;

public class Jugadores {

    private static Jugadores[] jugadores = new Jugadores[70];  // Arreglo de 70 jugadores

    private int ID = 10;  // ID único para cada jugador
    private String nombre;
    private Posicion posicion;
    private Equipos equipo;
    private Estado estado;
    private int golesAnotados = 0;
    private int accionesTotales = 0;

    public Jugadores(String nombre, Posicion posicion, Equipos equipo, Estado estado) {
        this.ID = ID++;  // Asigna el ID y lo incrementa
        this.nombre = nombre;
        this.posicion = posicion;
        this.equipo = equipo;
        this.estado = estado;
    }

    // Métodos getter y setter
    public int getID() {
        return ID++;
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

    public static void inicializarJugadores() {
    
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
    jugadores[10] = new Jugadores("Cristian Vargas", Posicion.Portero, null, Estado.Libre);
    jugadores[11] = new Jugadores("Héctor Gómez", Posicion.Defensa, null, Estado.Libre);
    jugadores[12] = new Jugadores("Manuel Ortega", Posicion.MedioCampista, null, Estado.Libre);
    jugadores[13] = new Jugadores("Emilio Navarro", Posicion.Delantero, null, Estado.Libre);
    jugadores[14] = new Jugadores("Ricardo León", Posicion.Defensa, null, Estado.Libre);
    jugadores[15] = new Jugadores("David Soto", Posicion.Portero, null, Estado.Libre);
    jugadores[16] = new Jugadores("Miguel Campos", Posicion.Delantero, null, Estado.Libre);
    jugadores[17] = new Jugadores("Sebastián Vega", Posicion.MedioCampista, null, Estado.Libre);
    jugadores[18] = new Jugadores("Tomás Rivera", Posicion.Defensa, null, Estado.Libre);
    jugadores[19] = new Jugadores("Álvaro Ruiz", Posicion.Portero, null, Estado.Libre);
    jugadores[20] = new Jugadores("Lucas Morales", Posicion.Delantero, null, Estado.Libre);
    jugadores[21] = new Jugadores("Santiago Blanco", Posicion.MedioCampista, null, Estado.Libre);
    jugadores[22] = new Jugadores("Jorge Ramírez", Posicion.Defensa, null, Estado.Libre);
    jugadores[23] = new Jugadores("Gabriel Díaz", Posicion.Portero, null, Estado.Libre);
    jugadores[24] = new Jugadores("Pedro Torres", Posicion.Defensa, null, Estado.Libre);
    // Jugadores 25-69
    for (int i = 25; i < 70; i++) {
        jugadores[i] = new Jugadores("Jugador " + (i + 1), Posicion.values()[i % 4], null, Estado.Libre);
    }
}

    public static Jugadores getJugadorPorID(int ID) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] != null && jugadores[i].getID() == ID) {
                return jugadores[i];
            }
        }
        return null;
    }

    public static void mostrarJugadores() {
        String listaJugadores = "Lista de jugadores:\n";
        for (int i = 0; i < 30; i++) {  // Suponiendo que has inicializado 30 jugadores
            Jugadores jugador = jugadores[i]; // Usando getJugadorPorID para obtener el jugador
            if (jugador != null) {
                String equipoNombre = "Libre";
                if (jugador.getEquipo() != null) {
                    equipoNombre = jugador.getEquipo().getNombreEquipo();
                }
                listaJugadores += "ID: " + jugador.getID() +
                        " | Nombre: " + jugador.getNombre() +
                        " | Posición: " + jugador.getPosicion() +
                        " | Estado: " + jugador.getEstado() +
                        " | Equipo: " + equipoNombre + "\n";
            }
        }
        System.out.println(listaJugadores);
    }
}
