package entidades;

public class CatColor {
	
	public static final Color[] COLOR = {
		new Color("blanco"),
		new Color("negro"),
		new Color("rojo"),
		new Color("azul"),
		new Color("gris")
	};

	public static Color getColor(String nombre){
		for (Color c: COLOR) {
			if( c.getNombre().equals(nombre) ){
				return c;
			}
		}
		return new Color(nombre);
	}
}
