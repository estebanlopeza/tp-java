package entidades;

public class Color {

	private String nombre;

	public Color(String nombre){
		this.nombre = nombre;
	}
	
	public Color(){
		this("BLANCO");
	}

	public String getNombre() {
		return nombre;
	}
	
	public String toString(){
		return this.nombre;
	}
}