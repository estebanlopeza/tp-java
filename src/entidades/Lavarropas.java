package entidades;

public class Lavarropas extends Electrodomestico {

	/*Atributos*/
	private int carga;
	
	/*Valores x defecto*/
	public static final int CARGA = 5;
	
	/*Constructores*/	
	public Lavarropas(int carga, int precio, Color color, Consumo consumo, int peso){
		super(precio, color, consumo, peso);
		this.carga = carga;
	}

	public Lavarropas(int precio, int peso){
		this(CARGA, precio, COLOR, CONSUMO, peso);
	}

	public Lavarropas(){
		this(CARGA, PRECIO_BASE, COLOR, CONSUMO, PESO);
	}

	/*Metodos*/
	public int getCarga(){
		return this.carga;
	}
	
	public int precioFinal(){
		int precioFinal = super.precioFinal();
		if(this.carga > 30 ){
			precioFinal+= 50;
		}
		return precioFinal;
	}

}
