package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Conexion;
import modelo.Pelicula;
import vista.VistaConsola;

public class ControladorCine {
    
    private VistaConsola vista; // Ahora usamos la vista de consola

    // Constructor
    public ControladorCine(VistaConsola vista) {
        this.vista = vista;
    }

    // Método principal para arrancar la lógica
    public void iniciar() {
        int opcion = 0;
        
        // El bucle se repite mientras NO elijas la opción 5
        while (opcion != 5) {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1: // VER
                    mostrarPeliculas();
                    break;
                    
                case 2: // INSERTAR
                    vista.mostrarMensaje("--- NUEVA PELÍCULA ---");
                    String id = vista.pedirDato("Dime el ID (ej: N01)");
                    String tit = vista.pedirDato("Título");
                    int dur = vista.pedirInt("Duración (minutos)");
                    String gen = vista.pedirDato("Género");
                    double pre = vista.pedirDouble("Precio");
                    
                    Pelicula p = new Pelicula(id, tit, dur, gen, pre);
                    registrarPelicula(p);
                    break;
                    
                case 3: // ACTUALIZAR
                    vista.mostrarMensaje("--- CAMBIAR PRECIO ---");
                    String idMod = vista.pedirDato("ID de la película a cambiar");
                    double nuevoPre = vista.pedirDouble("Nuevo precio");
                    actualizarPrecio(idMod, nuevoPre);
                    break;

                case 4: // BORRAR
                    vista.mostrarMensaje("--- BORRAR PELÍCULA ---");
                    String idBorrar = vista.pedirDato("ID de la película a eliminar");
                    borrarPelicula(idBorrar);
                    break;
                    
                case 5:
                    vista.mostrarMensaje("¡Adiós! 👋");
                    break;
                    
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void mostrarPeliculas() {
        Connection con = Conexion.conectar();
        
        // Si la conexión falla, avisamos y salimos
        if (con == null) {
            vista.mostrarMensaje("Error: No hay conexión con la base de datos.");
            return;
        }

        String sql = "SELECT * FROM pelicula";
        StringBuilder textoFinal = new StringBuilder();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                int duracion = rs.getInt("duracion");
                double precio = rs.getDouble("precio_base");

                // Formateamos el texto: Título - Duración - Precio
                String linea = String.format("* %s (%d min) -> %.2f euros\n", titulo, duracion, precio);
                textoFinal.append(linea);
            }
            
            // Enviamos el texto acumulado a la VISTA para que ella lo imprima
            vista.mostrarListado(textoFinal.toString());
            
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace(); // Esto muestra el error técnico en rojo si pasa algo raro
        }
        
        
    }
    
    //----------------------------------------------------
    //----------------------------------------------------
  //Estaparte es nueva es lo que ha puesto ALEJANDRo  
 // Método para INSERTAR una película nueva en la base de dato NUEVO que ha dicho Alejandro
    public void registrarPelicula(Pelicula p) {
        Connection con = Conexion.conectar();
        
        // La interrogación (?) es un hueco que rellenaremos después
        String sql = "INSERT INTO pelicula (id_pelicula, titulo, duracion, genero, precio_base) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            // Rellenamos los huecos (?) con los datos del objeto Pelicula
            ps.setString(1, p.getIdPelicula());
            ps.setString(2, p.getTitulo());
            ps.setInt(3, p.getDuracion());
            ps.setString(4, p.getGenero());
            ps.setDouble(5, p.getPrecioBase());

            // EJECUTAMOS la inserción
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                vista.mostrarMensaje("¡Éxito! Película guardada: " + p.getTitulo());
            }

            con.close();

        } catch (Exception ex) {
            vista.mostrarMensaje("❌ Error al guardar la película. (¿Quizás el ID ya existe?)");
            ex.printStackTrace();
        }
    }
  //-------------------------------------------------------  
    //-------------------------------------------------------  
    //------------------------------------------------------- 
    
 // MÉTODO ACTUALIZAR (UPDATE): Cambia el precio de una película
    public void actualizarPrecio(String idPelicula, double nuevoPrecio) {
        Connection con = Conexion.conectar();
        String sql = "UPDATE pelicula SET precio_base = ? WHERE id_pelicula = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nuevoPrecio);
            ps.setString(2, idPelicula);
            
            int filas = ps.executeUpdate();
            if (filas > 0) {
                vista.mostrarMensaje("✅ Precio actualizado correctamente.");
            } else {
                vista.mostrarMensaje("❌ No encontré ninguna película con ese ID.");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // MÉTODO BORRAR (DELETE): Elimina una película
    public void borrarPelicula(String idPelicula) {
        Connection con = Conexion.conectar();
        String sql = "DELETE FROM pelicula WHERE id_pelicula = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idPelicula);
            
            int filas = ps.executeUpdate();
            if (filas > 0) {
                vista.mostrarMensaje("🗑️ Película eliminada.");
            } else {
                vista.mostrarMensaje("❌ No existe ese ID para borrar.");
            }
            con.close();
        } catch (Exception e) {
            vista.mostrarMensaje("❌ No se puede borrar (quizás tiene sesiones asignadas).");
        }
    } 
    
}