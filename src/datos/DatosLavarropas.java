package datos;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import entidades.*;

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
				+ "'Lavarropas', "
				+ "'" + lava.getColor().getNombre() + "', "
				+ "'" + lava.getConsumo().getLetra() + "', "
				+ Integer.toString(lava.getPrecioBase()) + ", "
				+ Integer.toString(lava.getPeso()) + ", "
				+ Integer.toString(lava.getCarga())
			+ ") ";
		super.registrar(query);
		
		return lava;
	}

	public ArrayList<Lavarropas> Consultar(){
		String query = "SELECT * FROM electrodomestico WHERE tipo = 'lavarropas'";
		ResultSet rs = super.Consultar(query);
		ArrayList<Lavarropas> lava = new ArrayList<Lavarropas>();
		try{
			while(rs.next()){ 
				lava.add(new Lavarropas( rs.getInt("carga"), rs.getInt("precio"),CatColor.getColor(rs.getString("color") ), CatConsumo.getConsumo(rs.getString("consumo").charAt(0) ), rs.getInt("peso")));
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se logró Cargar la tabla","Error",JOptionPane.ERROR_MESSAGE);
		};
		return lava;
	}
}
