
package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class ProyectoFinalFutbol5 {

    public static void main(String[] args) {

        boolean ejecutar = true;

        while (ejecutar) {

            String mensaje = "selecione una opcion";

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
                    GestionJugadores.gestionJugadores();
                    break;
                case 1:
                    GestionEquipo.gestionEquipos();

                    break;
                case 2:

                    for (int i = 0; i < 5; i++) {
                        JOptionPane.showMessageDialog(null,
                                "futura simulacion de 40 jugadas.");
                    }
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null,
                            "reportes");
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null,
                            "saliendo del sistema, hasta luego! ");
                    ejecutar = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "si desea salir selecione la opcion,  5- Salir 🔚");

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



