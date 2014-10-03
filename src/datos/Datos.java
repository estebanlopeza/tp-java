package datos;
import java.sql.*;

import javax.swing.JOptionPane;

public class Datos {
	
	private Connection conexion;
	
	private void Conectar(){
		try{
			//Cargo driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establezco conexion
			conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electrodomesticos", "root", "");
			
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "No se logró establecer la conexión con la Base de datos SQL","Error",JOptionPane.ERROR_MESSAGE);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se logró establecer la conexión con la Base de datos","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ResultSet Consultar(String sql){
		this.Conectar();
		
		ResultSet rs = null;
		Statement sentencia = null;
		
		try{
			sentencia = conexion.createStatement();
			rs = sentencia.executeQuery(sql);
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "No se logró realizar la consulta con la Base de datos SQL (" + e + ")","Error",JOptionPane.ERROR_MESSAGE);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se logró realizar la consulta con la Base de datos","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		return rs;
	}

	public void registrar(String sql){
		this.Conectar();

		Statement sentencia = null;
		
		try{
			sentencia = conexion.createStatement();
			sentencia.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "El electrodoméstico se ha registrado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "No se logró realizar la consulta con la Base de datos SQL (" + e + ")","Error",JOptionPane.ERROR_MESSAGE);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se logró realizar la consulta con la Base de datos","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
