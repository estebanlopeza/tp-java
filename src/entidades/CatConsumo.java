package entidades;
import javax.swing.JOptionPane;

public class CatConsumo {
	
	public static final Consumo[] CONSUMO = {
		new Consumo('A',100),
		new Consumo('B',80),
		new Consumo('C',60),
		new Consumo('D',50),
		new Consumo('E',30),
		new Consumo('F',10)
	};

	public static Consumo getConsumo(char letra){
		for (Consumo c: CONSUMO) {
			if( Character.compare(c.getLetra(), letra) == 0 ){
				return c;
			}
		}
		return new Consumo(letra,0);
	}
}
