package modelo;

public class Entrada {
    private int idEntrada;
    private int idCompra;      // Relaciona la entrada con la compra global
    private String idSesion;
    private int numeroPersonas;
    private double precio;
    private double descuento;

    // Constructor
    public Entrada(int idEntrada, int idCompra, String idSesion, 
                   int numeroPersonas, double precio, double descuento) {
        this.idEntrada = idEntrada;
        this.idCompra = idCompra;
        this.idSesion = idSesion;
        this.numeroPersonas = numeroPersonas;
        this.precio = precio;
        this.descuento = descuento;
    }

    // Getters y Setters
    public int getIdEntrada() { return idEntrada; }
    public void setIdEntrada(int idEntrada) { this.idEntrada = idEntrada; }

    public int getIdCompra() { return idCompra; }
    public void setIdCompra(int idCompra) { this.idCompra = idCompra; }

    public String getIdSesion() { return idSesion; }
    public void setIdSesion(String idSesion) { this.idSesion = idSesion; }

    public int getNumeroPersonas() { return numeroPersonas; }
    public void setNumeroPersonas(int numeroPersonas) { this.numeroPersonas = numeroPersonas; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento; }
    
    @Override
    public String toString() {
        return "Entrada #" + idEntrada + " para sesión " + idSesion;
    }
}
