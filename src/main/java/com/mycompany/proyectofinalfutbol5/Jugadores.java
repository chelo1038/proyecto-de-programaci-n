package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class Jugadores {

   private int ID; //0
    private String nombre; //null
    private Posicion posicion; //null
    private Equipos equipo; //null
    private Estado estado;
    private int golesAnotados;
    private boolean activo; //false

    public Jugadores(int ID, String nombre, Posicion posicion, Equipos equipo, Estado estado, int golesAnotados) {
        this.ID = ID;
        this.nombre = nombre;
        this.posicion = posicion;
        this.equipo = equipo;
        this.estado = estado;
        this.golesAnotados = golesAnotados;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void mostrarDetalles() {
        String actividad;

        if (activo == true) {
            actividad = "activo";
        } else {
            actividad = "Inactivo";
        }
        
        
        String equipoNombre = "Libre";
        if (equipo != null){
            equipoNombre = equipo.getNombreEquipo();
        }

        JOptionPane.showMessageDialog(null, "DATOS DEL JUGADOR: " + nombre
                + "\nID: " + ID
                + "\nNOMBRE: " + nombre
                + "\nPOSICION: " + posicion
                + "\nEQUIPO: " + equipo
                + "\nESTADO: " + estado
                + "\nGOLES: " + golesAnotados
                + "\nESTADO DEL JUGADOR: " + actividad);
    }

 
    }
 
    
    
    
    

