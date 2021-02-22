package test;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private String apellidos;
	private String dni;
	private int edad;

	public Persona(String nombre, String apellidos, String dni, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
	}

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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return nombre + "," + apellidos + "," + dni + "," + edad + "\n";
	}

	@Override
	public int compareTo(Persona p) {
		if (apellidos.compareToIgnoreCase(p.apellidos) == 0) {
			return nombre.compareToIgnoreCase(p.nombre);
		} else
			return apellidos.compareToIgnoreCase(p.apellidos);
	}

}
