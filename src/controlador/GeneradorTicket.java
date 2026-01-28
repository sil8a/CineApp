package controlador;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import modelo.Pelicula;

import java.io.File; // <--- IMPORTANTE: Añadir esto
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class GeneradorTicket {

    public static void guardarFactura(Pelicula p, int cantidad) {
        
        // 1. Definimos el nombre de la carpeta y del archivo
        String nombreCarpeta = "tickets";
        String nombreArchivo = "ticket_" + p.getTitulo().replace(" ", "_") + ".txt";

        // 2. NUEVO: Creamos el objeto File para la carpeta
        File carpeta = new File(nombreCarpeta);

        // 3. NUEVO: Si la carpeta NO existe, la creamos
        if (!carpeta.exists()) {
            carpeta.mkdir(); // mkdir = make directory (crear directorio)
        }

        // 4. Preparamos la ruta completa (carpeta/archivo.txt)
        File archivoFinal = new File(carpeta, nombreArchivo);

        try {
            // Pasamos el objeto 'archivoFinal' al FileWriter
            FileWriter fw = new FileWriter(archivoFinal);
            PrintWriter pw = new PrintWriter(fw);

            double total = p.getPrecioBase() * cantidad;

            pw.println("=================================");
            pw.println("       CINE CIUDAD - TICKET      ");
            pw.println("=================================");
            pw.println("Fecha: " + LocalDateTime.now());
            pw.println("---------------------------------");
            pw.println("Película: " + p.getTitulo());
            pw.println("Duración: " + p.getDuracion() + " min");
            pw.println("Precio unidad: " + p.getPrecioBase() + "€");
            pw.println("---------------------------------");
            pw.println("Entradas: " + cantidad);
            pw.println("TOTAL A PAGAR: " + total + "€");
            pw.println("=================================");
            pw.println("    ¡Gracias por su visita!      ");

            pw.close(); 
            
            // Avisamos dónde se ha guardado
            System.out.println("📄 Ticket guardado en la carpeta '" + nombreCarpeta + "': " + nombreArchivo);

        } catch (Exception e) {
            System.out.println("❌ Error al crear el ticket: " + e.getMessage());
        }
    }
}