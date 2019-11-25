package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudTarifa {
	Connection con;
	public Connection Conecta() {
		try {
			con = conexion.crearConexion();
			return con;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();//Msg error en consola
			JOptionPane.showMessageDialog(null, "Clase driver sin encontrar",
					  "ERROR_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		catch(SQLException e) {
			e.printStackTrace();//Msg error en consola
			JOptionPane.showMessageDialog(null, "No se ha podido conectar a la base de datos",
					  "ERROR_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}
	public void crearTarifa(String sDescripcion, long lValor, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_tarifa(?,?,?,?)");
	        cs.setString(1, sDescripcion);
	        cs.setLong(2, lValor);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Tarifa insertada exitosamente...");
	        	sesion.setAttribute("mensaje", "Tarifa insertada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar la tarifa...");
	        	sesion.setAttribute("mensaje", "Imposible insertar la tarifa...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarTarifa(int iCodigo, String sDescripcion, long lValor, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_tarifa(?,?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sDescripcion);
	        cs.setLong(3, lValor);
	        cs.setString(4, sFecha);
	        cs.setString(5, sHora);
	        if(cs.execute()) {
		        System.out.println("Tarifa actualizada exitosamente...");
		        sesion.setAttribute("mensaje", "Tarifa actualizada exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar la tarifa...");
		        sesion.setAttribute("mensaje", "Imposible actualizar la tarifa...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación de la tarifa fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarTarifa(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from tarifas where codigo = " + String.valueOf(iCodigo));
	        if (rs.next()) {
	        	System.out.println("Tarifa encontrada...");
	        	//obtiene codigo
	        	sesion.setAttribute("codigo_tarifa", rs.getInt(1));
	        	//obtiene descripcion
	        	sesion.setAttribute("descrip_tarifa", rs.getString(2));
	        	//obtiene valor
	        	sesion.setAttribute("valor_tarifa", rs.getString(3));
	        	//obtiene fecha
	        	sesion.setAttribute("fecha_tarifa", rs.getString(4));
	        	//obtiene hora
	        	sesion.setAttribute("hora_tarifa", rs.getString(5));
	        }
	        else
	        	System.out.println("Tarifa no encontrada...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta de la tarifa fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarTarifa(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_tarifa(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Tarifa eliminada exitosamente...");
	        	sesion.setAttribute("mensaje", "Tarifa eliminada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar la tarifa...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar la tarifa...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación de la tarifa fallida...");
			System.out.println(e.getMessage());
		}
	}
}
