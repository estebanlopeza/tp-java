package negocio;

import javax.swing.JOptionPane;

import entidades.*;
import datos.DatosTelevision;

public class NegocioTelevision {
	
	public void registrar(Television tele)
    {
        try
        {
            DatosTelevision.registrar(tele);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
