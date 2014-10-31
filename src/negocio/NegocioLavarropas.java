package negocio;

import javax.swing.JOptionPane;

import entidades.*;
import datos.DatosLavarropas;

public class NegocioLavarropas {
	
	public Object[] registrar(Lavarropas lava)
    {
        try
        {
        	DatosLavarropas dl = new DatosLavarropas();
        	dl.registrar(lava);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
		Object[] row = {
				"Lavarropas",
				lava.getColor().getNombre(),
				Character.toString(lava.getConsumo().getLetra()),
				lava.precioFinal(),
				lava.getPeso(),
				lava.getCarga(),
				"-",
				"-"
		};
		return row;
    }
}
