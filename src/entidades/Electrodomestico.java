package entidades;

public abstract class Electrodomestico {

	/*Atributos*/
	private int precioBase;
	private Color color;
	private Consumo consumo;
	private int peso;

	/*Valores x defecto*/
	static final int PRECIO_BASE = 100;
	static final Color COLOR = new Color();
	static final Consumo CONSUMO = new Consumo();
	static final char PESO = 5;

	/*Constructores*/
	public Electrodomestico(int precio, Color color, Consumo consumo, int peso){
		this.precioBase = precio;
		this.color = comprobarColor(color);
		this.consumo = comprobarConsumoEnergetico(consumo);
		this.peso = peso;
	}

	public Electrodomestico(int precio, int peso){
		this(precio, COLOR, CONSUMO, peso);
	}

	public Electrodomestico(){
		this(PRECIO_BASE, COLOR, CONSUMO, PESO);
	}
	
	/*Getters*/
	public int getPrecioBase() {
		return precioBase;
	}

	public Color getColor() {
		return color;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public int getPeso() {
		return peso;
	}
	
	/*Metodos*/
	private Consumo comprobarConsumoEnergetico(Consumo itemConsumo){
		for (Consumo item : CatConsumo.CONSUMO) {
			if(item.getLetra() == itemConsumo.getLetra()){
				return item;
			}			
		}
		return CONSUMO;
	}

	private Color comprobarColor(Color color){
		//TODO resolver haciendo los metodos e instancias de catColor de clase
		for (Color item : CatColor.COLOR) { 
			if(item.getNombre().compareToIgnoreCase(color.getNombre()) == 0){
				return item;
			}
		}
		return COLOR;
	}
	
	public int precioFinal(){
		int precioFinal = this.precioBase;
		int valorTamanio = 0;
		
		precioFinal+= this.consumo.getPrecio();
		
		for (Tamanio item : CatTamanio.TAMANIO) { 
			if(item.getPesoDesde() < this.peso){
				valorTamanio = item.getPrecio();
			}else{
				precioFinal+= valorTamanio;
				break;
			}
		}

		return precioFinal;
	}
}
