package modelo;

import java.time.LocalDateTime;

public class Compra {
    private int idCompra;
    private String dniCliente;
    private LocalDateTime fechaHora; // Importante: Fecha y hora juntas
    private int numEntradas;
    private double precioTotal;
    private double descuentoAplicado;

    // Constructor
    public Compra(int idCompra, String dniCliente, LocalDateTime fechaHora, 
                  int numEntradas, double precioTotal, double descuentoAplicado) {
        this.idCompra = idCompra;
        this.dniCliente = dniCliente;
        this.fechaHora = fechaHora;
        this.numEntradas = numEntradas;
        this.precioTotal = precioTotal;
        this.descuentoAplicado = descuentoAplicado;
    }

    // Getters y Setters
    public int getIdCompra() { return idCompra; }
    public void setIdCompra(int idCompra) { this.idCompra = idCompra; }

    public String getDniCliente() { return dniCliente; }
    public void setDniCliente(String dniCliente) { this.dniCliente = dniCliente; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public int getNumEntradas() { return numEntradas; }
    public void setNumEntradas(int numEntradas) { this.numEntradas = numEntradas; }

    public double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }

    public double getDescuentoAplicado() { return descuentoAplicado; }
    public void setDescuentoAplicado(double descuentoAplicado) { this.descuentoAplicado = descuentoAplicado; }

    @Override
    public String toString() {
        return "Compra #" + idCompra + " - Total: " + precioTotal + "€";
    }
}