package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class Jugadores {

  private static Jugadores[] jugadores = new Jugadores[70];
  private static int contadorID = 10;
   
    private int ID; //0
    private String nombre; //null
    private Posicion posicion; 
    private Equipos equipo; 
    private Estado estado;
    private int golesAnotados = 0;
    private int accionesTotales = 0;
  

    public Jugadores(String nombre, Posicion posicion, Equipos equipo, Estado estado) {
        this.ID = contadorID++;
        this.nombre = nombre;
        this.posicion = posicion;
        this.equipo = equipo;
        this.estado = estado;
  
    }

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

        
        for (int i = 10; i < 70; i++) {
            jugadores[i] = new Jugadores("Jugador " + (i + 1), Posicion.values()[i % 4], null, Estado.Libre);
        }
    }
        public static Jugadores getJugadorPorID(int id){
            for (int i = 0; i < jugadores.length; i++) {
                if(jugadores[i] != null && jugadores[i].getID()== id){
                 return jugadores[i];   
                }
                
            }
              return null;
        }
    public static void mostrarJugadores() {
        String listaJugadores = "Lista de jugadores:\n";
        for (int i = 0; i < 30; i++) {
            Jugadores jugador = jugadores[i];
            String equipoNombre = (jugador.getEquipo() == null) ? "Libre" : jugador.getEquipo().getNombreEquipo();
            listaJugadores += "ID: " + jugador.getID() +
                    " | Nombre: " + jugador.getNombre() +
                    " | Posición: " + jugador.getPosicion() +
                    " | Estado: " + jugador.getEstado() +
                    " | Equipo: " + equipoNombre + "\n";
        }
        JOptionPane.showMessageDialog(null, listaJugadores);
    
    }
}

    
  

