package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class Equipos {

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

    public Equipos(int idEquipo, String nombreEquipo, int partidosJugados, int partidosGanados,
            int partidosEmpatados, int partidosPerdidos, int golesFavor, int golesEnContra, int posesionBalon) {

        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
        this.golesFavor = 0;
        this.golesEnContra = 0;
        this.posesionBalon = 0;
    }

    Equipos(int idEquipo, String nombreEquipo) {

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

    public boolean agregarJugador(Jugadores jugador) {
        if (cantidadJugadores < 7) {
            jugadores[cantidadJugadores] = jugador;
            cantidadJugadores++;
            return true;
        }
        return false;
    }

    public boolean eliminarJugador(int idJugador) {
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getID() == idJugador) {
                jugadores[i] = jugadores[--cantidadJugadores];
                jugadores[cantidadJugadores] = null;
                return true;
            }

        }
        return false;
    }

    public static Equipos[] EquiposPredeterminados() {
        Equipos libre = new Equipos(0, "Libre");
        Equipos ligaDeportiva = new Equipos(1, "LigaDeportiva");
        Equipos saprissa = new Equipos(2, "Saprissa");
        Equipos heredia = new Equipos(3, "Heredia");

        return new Equipos[]{libre, ligaDeportiva, saprissa, heredia};

    }

}
