package negocio;

import javax.swing.JOptionPane;

import entidades.*;
import datos.DatosLavarropas;

public class NegocioLavarropas {
	
	public void registrar(Lavarropas lava)
    {
        try
        {
            DatosLavarropas.registrar(lava);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}