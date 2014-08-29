package entidades;

public class Consumo {
	
	private char letra;
	private int precio;
	
	public Consumo(char letra, int precio){
		this.letra = letra;
		this.precio = precio;
	}

	public Consumo(){
		this('F',10);
	}

	public char getLetra() {
		return letra;
	}

	public int getPrecio() {
		return precio;
	}
	
}
