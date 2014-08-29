package entidades;

public class Tamanio {
	
	private int pesoDesde;
	private int precio;
	
	public Tamanio(int pesoDesde, int precio){
		this.pesoDesde = pesoDesde;
		this.precio = precio;
	}

	public int getPesoDesde() {
		return pesoDesde;
	}

	public int getPrecio() {
		return precio;
	}
	
}
