package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sesion {
    private String idSesion;
    private LocalDate fecha;        // Para el campo 'date' de SQL
    private LocalTime horaInicio;   // Para el campo 'time' de SQL
    private LocalTime horaFin;      
    private String idSala;          // Guardamos el ID de la sala
    private String idPelicula;      // Guardamos el ID de la película
    private int espectadores;
    private double precioSesion;

    // Constructor
    public Sesion(String idSesion, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, 
                  String idSala, String idPelicula, int espectadores, double precioSesion) {
        this.idSesion = idSesion;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.idSala = idSala;
        this.idPelicula = idPelicula;
        this.espectadores = espectadores;
        this.precioSesion = precioSesion;
    }

    // Getters y Setters
    public String getIdSesion() { return idSesion; }
    public void setIdSesion(String idSesion) { this.idSesion = idSesion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }

    public String getIdSala() { return idSala; }
    public void setIdSala(String idSala) { this.idSala = idSala; }

    public String getIdPelicula() { return idPelicula; }
    public void setIdPelicula(String idPelicula) { this.idPelicula = idPelicula; }

    public int getEspectadores() { return espectadores; }
    public void setEspectadores(int espectadores) { this.espectadores = espectadores; }

    public double getPrecioSesion() { return precioSesion; }
    public void setPrecioSesion(double precioSesion) { this.precioSesion = precioSesion; }

    @Override
    public String toString() {
        return "Sesión " + idSesion + " - " + fecha + " a las " + horaInicio;
    }
}
