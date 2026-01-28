package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private int idCompra;
    private Cliente cliente; // Vinculamos al objeto Cliente entero
    private LocalDateTime fecha;
    private double precioTotal;
    private double descuento;
    
    // LA CESTA: Aquí guardamos todas las entradas antes de pagar
    private List<Entrada> listaEntradas;

    public Compra() {
        this.listaEntradas = new ArrayList<>();
        this.fecha = LocalDateTime.now();
    }

    // Método para meter cosas en el carro
    public void agregarEntrada(Entrada e) {
        this.listaEntradas.add(e);
    }

    // Método que calcula el total con la lógica del profesor
    public void calcularTotal() {
        double subtotal = 0;
        int cantidadPelis = 0; // Ojo: el profe dice descuento por nº de películas (sesiones distintas)

        for (Entrada e : listaEntradas) {
            subtotal += e.getPrecio();
            cantidadPelis++; 
        }

        // Lógica de Descuentos del ejercicio
        if (cantidadPelis >= 3) {
            this.descuento = subtotal * 0.30; // 30%
        } else if (cantidadPelis == 2) {
            this.descuento = subtotal * 0.20; // 20%
        } else {
            this.descuento = 0;
        }

        this.precioTotal = subtotal - this.descuento;
    }

	public Compra(int idCompra, Cliente cliente, LocalDateTime fecha, double precioTotal, double descuento,
			List<Entrada> listaEntradas) {
		
		this.idCompra = idCompra;
		this.cliente = cliente;
		this.fecha = fecha;
		this.precioTotal = precioTotal;
		this.descuento = descuento;
		this.listaEntradas = listaEntradas;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public List<Entrada> getListaEntradas() {
		return listaEntradas;
	}

	public void setListaEntradas(List<Entrada> listaEntradas) {
		this.listaEntradas = listaEntradas;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", cliente=" + cliente + ", fecha=" + fecha + ", precioTotal="
				+ precioTotal + ", descuento=" + descuento + ", listaEntradas=" + listaEntradas + ", getIdCompra()="
				+ getIdCompra() + ", getCliente()=" + getCliente() + ", getFecha()=" + getFecha()
				+ ", getPrecioTotal()=" + getPrecioTotal() + ", getDescuento()=" + getDescuento()
				+ ", getListaEntradas()=" + getListaEntradas() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

    
	
	
   
    
}