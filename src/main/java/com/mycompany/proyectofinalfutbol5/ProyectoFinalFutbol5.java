package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class ProyectoFinalFutbol5 {

    public static void main(String[] args) {
        // Inicialización de jugadores y equipos
        Jugadores.inicializarJugadores();  // Inicializa los jugadores
        Equipos.inicializarJugadoresYAsignarEquipos();  // Inicializa los equipos y asigna jugadores

        boolean ejecutar = true;

        while (ejecutar) {
            // Menú de opciones
            String mensaje = "Seleccione una opción:";
            String[] opciones = {
                "1- Gestión de jugadores🏃",
                "2- Gestión de Equipos🏃🏃",
                "3- Simulación de Partidos🏃🏼‍🏃",
                "4- Reportes⚠",
                "5- Salir 🔚"
            };
            int codigo = JOptionPane.showOptionDialog(
                    null,
                    mensaje,
                    "Gestor de Partidos de Fútbol Cinco⚽",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (codigo) {
                case 0:
                    GestionJugadores.gestionJugadores();  // Menú de gestión de jugadores
                    break;
                case 1:
                    GestionEquipo.gestionEquipos();  // Menú de gestión de equipos
                    break;
                case 2:
                    // Simulación de partidos (pendiente de implementación)
                  SimulacionPartidos.simularPartido();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Generando reportes...");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema, ¡hasta luego!");
                    ejecutar = false;  // Termina el bucle y sale del programa
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Si desea salir, seleccione la opción 5.");
            }
        }
    }
}

//Para este segundo avance (5% del total del proyecto), se solicita presentar: 
// Haber implementado los constructores y el encapsulamiento en las clases del proyecto.
// El sistema debería contener arreglos de objetos para manipular los objetos dentro del sistema.
// Implementación de la relación entre las clases, donde los jugadores se asocian a un equipo y 
//viceversa. 
// La gestión completa de jugadores y equipos en el sistema, con la funcionalidad de agregar, editar y 
//eliminar. 
// Una simulación básica de partidos, aunque no sea completa, que muestre el uso de los jugadores y 
//equipos en el sistema. 

