package datos;

import entidades.*;
import java.sql.*;

public class DatosLavarropas extends Datos{

	public Lavarropas registrar(Lavarropas lava){
		String query = "INSERT INTO electrodomestico ("
				+ "tipo, "
				+ "color, "
				+ "consumo, "
				+ "precio, "
				+ "peso, "
				+ "carga "
			+ ") VALUES ("
				+ "'lavarropas', "
				+ "'" + lava.getColor().getNombre() + "', "
				+ "'" + lava.getConsumo().getLetra() + "', "
				+ Integer.toString(lava.getPrecioBase()) + ", "
				+ Integer.toString(lava.getPeso()) + ", "
				+ Integer.toString(lava.getCarga())
			+ ") ";
		
		super.registrar(query);
		
		return lava;
	}
}
