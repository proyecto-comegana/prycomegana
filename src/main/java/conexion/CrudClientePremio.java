package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudClientePremio {
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
	public void crearClientePremio(long lCliente, int iPremio, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_clientepremio(?,?,?,?)");
	        cs.setLong(1, lCliente);
	        cs.setInt(2, iPremio);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Cliente y premio insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Cliente y premio insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el cliente y el premio...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el cliente y el premio...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarClientePremio(long lCliente, int iPremio, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_clientepremio(?,?,?,?)");
	        cs.setLong(1, lCliente);
	        cs.setInt(2, iPremio);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if(cs.execute()) {
		        System.out.println("Cliente y premio actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Cliente y premio actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el cliente y el premio...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el cliente y el premio...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del cliente y el premio fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarClientePremio(long lCliente, int iPremio, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from clientepremio where cliente = " + String.valueOf(lCliente) + "and premio = " + String.valueOf(iPremio));
	        if (rs.next()) {
	        	System.out.println("Cliente y premio encontrado...");
	        	sesion.setAttribute("mensaje", "Cliente y premio encontrado exitosamente...");
	        	//obtiene codigo
	        	sesion.setAttribute("cliente_clientepremio", rs.getLong(1));
	        	//obtiene nombre
	        	sesion.setAttribute("premio_clientepremio", rs.getInt(2));
	        	//obtiene fecha
	        	sesion.setAttribute("fecha_clientepremio", rs.getString(3));
	        	//obtiene hora
	        	sesion.setAttribute("hora_clientepremio", rs.getString(4));
	        }
	        else
	        	System.out.println("Cliente y premio no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del cliente y premio fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarClientePremio(long lCliente, int iPremio, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_clientepremio(?,?)");
	        cs.setLong(1, lCliente);
	        cs.setInt(2, iPremio);
	        if (cs.execute()) {
	        	System.out.println("Cliente y premio eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Cliente y premio eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el cliente y el premio...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el cliente y el premio...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del cliente y el premio fallida...");
			System.out.println(e.getMessage());
		}
	}
}
