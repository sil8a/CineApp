package modelo;

public class Pelicula {
    // 1. Atributos (Variables) basados en  SQL
    private String idPelicula;  // varchar(3) en SQL
    private String titulo;      // varchar(100) en SQL
    private int duracion;       // int en SQL
    private String genero;      // varchar(30) en SQL
    private double precioBase;  // decimal(6,2) en SQL
    
   

    // 2. Constructor (Sirve para crear nuevas películas)
    public Pelicula(String idPelicula, String titulo, int duracion, String genero, double precioBase) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.precioBase = precioBase;
    }

    // 3. Getters y Setters los getters y setters sirven para organizar los datos.
    public String getIdPelicula() { return idPelicula; }
    public void setIdPelicula(String idPelicula) { this.idPelicula = idPelicula; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

	

    // Método toString 
   /* @Override
    public String toString() {
        return titulo + " (" + duracion + " min)";
    }*/
    @Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", titulo=" + titulo + ", duracion=" + duracion + ", genero="
				+ genero + ", precioBase=" + precioBase + "]";
	} 
}