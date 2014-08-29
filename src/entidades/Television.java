package entidades;

public class Television extends Electrodomestico {
	
	/*Atributos*/
	private int resolucion;
	private boolean sintonizadorDTD;
	
	/*Valores x defecto*/
	static final int RESOLUCION = 20;
	static final boolean SINTONIZADORDTD = false;

	/*Constructores*/	
	public Television(int resolucion, boolean sintonizadorDTD, int precio, Color color, Consumo consumo, int peso){
		super(precio, color, consumo, peso);
		this.resolucion = resolucion;
		this.sintonizadorDTD = sintonizadorDTD;
	}

	public Television(int precio, int peso){
		this(RESOLUCION, SINTONIZADORDTD, precio, COLOR, CONSUMO, peso);
	}

	public Television(){
		this(RESOLUCION, SINTONIZADORDTD, PRECIO_BASE, COLOR, CONSUMO, PESO);
	}

	/*Metodos*/
	public int getResolucion() {
		return resolucion;
	}

	public boolean isSintonizadorDTD() {
		return sintonizadorDTD;
	}
	
	public int precioFinal(){
		int precioFinal = super.precioFinal();
		if(this.resolucion > 40 ){
			precioFinal*= 1.3;
		}
		if(this.sintonizadorDTD){
			precioFinal+= 50;
		}
		return precioFinal;
	}
}
