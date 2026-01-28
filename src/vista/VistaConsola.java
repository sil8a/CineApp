package vista;

import java.util.Scanner;

public class VistaConsola {
    
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarListado(String listado) {
        System.out.println("\n------ CARTELERA ------");
        System.out.println(listado);
        System.out.println("-----------------------");
    }

    // NUEVO: Método para mostrar el menú y devolver la opción elegida
    public int mostrarMenu() {
        System.out.println("\n=== MENÚ DE CINE ===");
        System.out.println("1. Ver Películas");
        System.out.println("2. Nueva Película");
        System.out.println("3. Actualizar Precio");
        System.out.println("4. Borrar Película");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
        // Leemos el número. Si da error, devolvemos -1
        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            return opcion;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // NUEVO: Métodos para pedir datos al usuario
    public String pedirDato(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }
    
    public double pedirDouble(String mensaje) {
        System.out.print(mensaje + ": ");
        return Double.parseDouble(scanner.nextLine());
    }
    
    public int pedirInt(String mensaje) {
        System.out.print(mensaje + ": ");
        return Integer.parseInt(scanner.nextLine());
    }
}