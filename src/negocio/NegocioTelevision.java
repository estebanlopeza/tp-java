package negocio;

import javax.swing.JOptionPane;

import entidades.*;
import datos.DatosTelevision;

public class NegocioTelevision {
	
	public Object[] registrar(Television tele)
    {
        try
        {
        	DatosTelevision dl = new DatosTelevision();
        	dl.registrar(tele);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
		Object[] row = {
				"Television",
				tele.getColor().getNombre(),
				Character.toString(tele.getConsumo().getLetra()),
				tele.precioFinal(),
				tele.getPeso(),
				"-",
				tele.getResolucion(),
				(tele.isSintonizadorDTD())?"si":"no"
		};
		return row;
    }
}
