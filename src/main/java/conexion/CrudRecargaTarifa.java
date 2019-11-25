package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudRecargaTarifa {
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
	public void crearRecargaTarifa(long lRecarga, int iTarifa, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_recargatarifa(?,?,?,?)");
	        cs.setLong(1, lRecarga);
	        cs.setInt(2, iTarifa);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Recarga y tarifa insertada exitosamente...");
	        	sesion.setAttribute("mensaje", "Recarga y tarifa insertada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar la recarga y la tarífa...");
	        	sesion.setAttribute("mensaje", "Imposible insertar la recarga y la tarífa...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarRecargaTarifa(long lRecarga, int iTarifa, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_recargatarifa(?,?,?,?)");
	        cs.setLong(1, lRecarga);
	        cs.setInt(2, iTarifa);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if(cs.execute()) {
		        System.out.println("Recarga y tarífa actualizada exitosamente...");
		        sesion.setAttribute("mensaje", "Recarga y tarífa actualizada exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar la recarga y la tarífa...");
		        sesion.setAttribute("mensaje", "Imposible actualizar la recarga y la tarífa...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación de la recarga y la tarífa fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarRecargaTarifa(long lRecarga, int iTarifa, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from recargatarifa where recarga = " + String.valueOf(lRecarga) + "and tarifa = " + String.valueOf(iTarifa));
	        if (rs.next()) {
	        	System.out.println("Recarga y tarífa encontrada...");
	        	sesion.setAttribute("mensaje", "Recarga y tarífa encontrada exitosamente...");
	        	//obtiene codigo
	        	sesion.setAttribute("recarga_recargatarifa", rs.getLong(1));
	        	//obtiene nombre
	        	sesion.setAttribute("tarifa_recargatarifa", rs.getInt(2));
	        	//obtiene fecha
	        	sesion.setAttribute("fecha_recargatarifa", rs.getString(3));
	        	//obtiene hora
	        	sesion.setAttribute("hora_recargatarifa", rs.getString(4));
	        }
	        else
	        	System.out.println("Recarga y tarífa no encontrada...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta de recarga y tarífa fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarRecargaTarifa(long lRecarga, int iTarifa, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_recargatarifa(?,?)");
	        cs.setLong(1, lRecarga);
	        cs.setInt(2, iTarifa);
	        if (cs.execute()) {
	        	System.out.println("Recarga y tarífa eliminada exitosamente...");
	        	sesion.setAttribute("mensaje", "Recarga y tarífa eliminada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar la recarga y la tarifa...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar la recarga y la tarífa...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación de la recarga y la tarífa fallida...");
			System.out.println(e.getMessage());
		}
	}
}
