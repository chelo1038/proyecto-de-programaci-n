package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;
import java.util.Random;

public class SimulacionPartidos {

    public static void simularPartido() {
        // Verificar si hay al menos dos equipos completos
        if (Equipos.getCantidadEquipos() < 2) {
            JOptionPane.showMessageDialog(null, "No hay suficientes equipos completos para realizar la simulación.");
            return;
        }

        // Selección de equipos
        Equipos equipoA = seleccionarEquipo("Seleccione el primer equipo para la simulación:");
        if (equipoA == null) return;

        Equipos equipoB = seleccionarEquipo("Seleccione el segundo equipo para la simulación:");
        if (equipoB == null || equipoA.getIdEquipo() == equipoB.getIdEquipo()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar dos equipos distintos.");
            return;
        }

        Random random = new Random();
        int golesEquipoA = 0, golesEquipoB = 0;
        String logPartido = "";

        // Simulación de 40 minutos
        for (int minuto = 1; minuto <= 40; minuto++) {
            int probabilidad = random.nextInt(100);

            String mensaje;
            if (probabilidad < 70) {
                // Mensajes de Tránsito (70%)
                mensaje = generarMensajeTransito(equipoA, equipoB, random);
            } else if (probabilidad < 85) {
                // Mensajes de Cambio (15%)
                mensaje = generarMensajeCambio(equipoA, equipoB, random);
            } else {
                // Mensajes de Acciones Clave (15%)
                mensaje = generarMensajeAccionClave(equipoA, equipoB, random);
                if (mensaje.startsWith("¡Gol de")) {
                    if (mensaje.startsWith("¡Gol de " + equipoA.getNombreEquipo())) golesEquipoA++;
                    if (mensaje.startsWith("¡Gol de " + equipoB.getNombreEquipo())) golesEquipoB++;
                }
            }

            String registro = "Minuto " + minuto + ": " + mensaje;
            logPartido = logPartido + registro + "\n";

            // Mostrar en consola el registro del minuto
            System.out.println(registro);
        }

        // Mostrar resultados en consola
        mostrarResultado(equipoA, equipoB, golesEquipoA, golesEquipoB, logPartido);
    }

    private static Equipos seleccionarEquipo(String mensaje) {
        String listaEquipos = mensaje + "\n";
        for (int i = 0; i < Equipos.getCantidadEquipos(); i++) {
            listaEquipos = listaEquipos + Equipos.getEquipo(i).getIdEquipo() + " - " + Equipos.getEquipo(i).getNombreEquipo() + "\n";
        }
        String seleccion = JOptionPane.showInputDialog(listaEquipos);
        if (seleccion == null || seleccion.isEmpty()) return null;  // Verifica que la selección no esté vacía
        return Equipos.buscarEquipoPorId(Integer.parseInt(seleccion));  // Busca el equipo por ID
    }

    private static String generarMensajeTransito(Equipos equipoA, Equipos equipoB, Random random) {
        String[] mensajes = {
                "El equipo " + equipoA.getNombreEquipo() + " está atacando intensamente.",
                "El equipo " + equipoB.getNombreEquipo() + " tomó el control de la pelota.",
                "Un jugador realiza una atrapada espectacular.",
                "Un defensor intercepta un pase crucial.",
                "Un mediocampista realiza un pase espectacular.",
                "Un delantero intenta un remate a puerta."
        };
        return mensajes[random.nextInt(mensajes.length)];
    }

    private static String generarMensajeCambio(Equipos equipoA, Equipos equipoB, Random random) {
        Equipos equipo;
        if (random.nextInt(2) == 0) {
            equipo = equipoA;
        } else {
            equipo = equipoB;
        }
        return "Cambio en " + equipo.getNombreEquipo() + ": Un jugador titular sale, entra un suplente.";
    }

    private static String generarMensajeAccionClave(Equipos equipoA, Equipos equipoB, Random random) {
        Equipos equipo;
        if (random.nextInt(2) == 0) {
            equipo = equipoA;
        } else {
            equipo = equipoB;
        }
        String[] mensajes = {
                "¡Gol de un jugador del equipo " + equipo.getNombreEquipo() + "!",
                "¡El árbitro ha pitado penal a favor de " + equipo.getNombreEquipo() + "!",
                "Se pita falta a favor de " + equipo.getNombreEquipo() + ". ¡Tiro libre en una posición peligrosa!"
        };
        return mensajes[random.nextInt(mensajes.length)];
    }

    private static void mostrarResultado(Equipos equipoA, Equipos equipoB, int golesA, int golesB, String logPartido) {
        String resultado = "Resultado Final:\n" +
                equipoA.getNombreEquipo() + ": " + golesA + " goles\n" +
                equipoB.getNombreEquipo() + ": " + golesB + " goles\n" +
                "Resumen del partido:\n" + logPartido;

        // Mostrar el resultado final en consola
        System.out.println(resultado);
    }
}
