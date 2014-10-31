package datos;

import entidades.*;

public class DatosTelevision extends Datos{

	public Television registrar(Television tele){
		String query = "INSERT INTO electrodomestico ("
				+ "tipo, "
				+ "color, "
				+ "consumo, "
				+ "precio, "
				+ "peso, "
				+ "resolucion, "
				+ "sintonizadorDTD "
			+ ") VALUES ("
				+ "'Television', "
				+ "'" + tele.getColor().getNombre() + "', "
				+ "'" + tele.getConsumo().getLetra() + "', "
				+ Integer.toString(tele.getPrecioBase()) + ", "
				+ Integer.toString(tele.getPeso()) + ", "
				+ Integer.toString(tele.getResolucion()) + ", "
				+ Boolean.toString(tele.isSintonizadorDTD())
			+ ") ";
		super.registrar(query);
		
		return tele;
	}
}
