package modelo;

public class Sala {
    private String idSala;
    private String nombre;

    public Sala(String idSala, String nombre) {
        this.idSala = idSala;
        this.nombre = nombre;
    }

    public String getIdSala() { return idSala; }
    public void setIdSala(String idSala) { this.idSala = idSala; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return nombre;
    }
}