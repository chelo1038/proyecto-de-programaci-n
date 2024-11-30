package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class Equipos {
    
    private static Equipos[] equipos = new Equipos[10];
    private static int contadorEquipos = 100;

    private int idEquipo;
    private String nombreEquipo; //null
    private Jugadores[] jugadores = new Jugadores[7];
    private int cantidadJugadores = 0;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesFavor;
    private int golesEnContra;
    private int posesionBalon;


    public Equipos(String nombreEquipo) {

        this.idEquipo = contadorEquipos++;
        this.nombreEquipo = nombreEquipo;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
        this.golesFavor = 0;
        this.golesEnContra = 0;
        this.posesionBalon = 0;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Jugadores[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugadores[] jugadores) {
        this.jugadores = jugadores;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    public int getPosesionBalon() {
        return posesionBalon;
    }

    public void setPosesionBalon(int posesionBalon) {
        this.posesionBalon = posesionBalon;
    }

    public void mostrarDetalles() {
        JOptionPane.showMessageDialog(null, """
      DATOS DEL EQUIPO:
      ID: """ + idEquipo
                + "\nNombre: " + nombreEquipo
                + "\nJugadores: " + jugadores.length
                + "\nPartidos Jugados: " + partidosJugados
                + "\nPartidos Ganados: " + partidosGanados
                + "\nPartidos Empatados: " + partidosEmpatados
                + "\nPartidos Perdidos: " + partidosPerdidos
                + "\nGoles a Favor: " + golesFavor
                + "\nGoles en Contra: " + golesEnContra
                + "\nPosesion del balon: " + posesionBalon);
    }

    public void agregarJugador(Jugadores jugador) {
        if (cantidadJugadores < jugadores.length) {
            jugadores[cantidadJugadores++] = jugador;
        }
    }

    public boolean eliminarJugador(int idJugador) {
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getID() == idJugador) {
                for (int j = i; j < cantidadJugadores - 1; j++) {
                    jugadores[j] = jugadores[j + 1];
                }
                jugadores[--cantidadJugadores] =  null;
                return true;
            }

        }
        return false;
    }

    public static void inicializarJugadoresYAsignarEquipos() {
        Jugadores.inicializarJugadores();  

        Equipos equipo1 = new Equipos("Liga Deportiva");
        Equipos equipo2 = new Equipos("Saprissa");
        Equipos equipo3 = new Equipos("Heredia");

       
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

       
        Jugadores.mostrarJugadores();
    }

}

