package modelo;

import java.security.MessageDigest;
import java.util.Base64;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String contrasena; // Aquí guardaremos la encriptada

    // Constructor normal
    public Cliente(String dni, String nombre, String apellidos, String email, String contrasena) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasena = contrasena; // Ojo: Aquí debería llegar ya encriptada o encriptarla tú
    }
    
    // MÉTODO ESTÁTICO: Úsalo para convertir "1234" en "A8F3..."
    public static String encriptar(String texto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(texto.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception ex) {
            throw new RuntimeException("Error al encriptar", ex);
        }
    }

    // Getters y Setters...
    
    public String getDni() { return dni; }
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getContrasena() { return contrasena; }
   
}