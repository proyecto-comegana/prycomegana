package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudPropietario {
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
	public void crearPropietario(long lCodigo, long lRestaurante, String sEstado, long lPersona, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_propietario(?,?,?,?,?,?)");
	        cs.setLong(1, lCodigo);
	        cs.setLong(2, lRestaurante);
	        cs.setString(3, sEstado);
	        cs.setLong(4, lPersona);
	        cs.setString(5, sFecha);
	        cs.setString(6, sHora);
	        if (cs.execute()) {
	        	System.out.println("Propietario insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Propietario insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el propietario...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el propietario...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarPropietario(long lCedula, long lRestaurante, String sEstado, long lPersona, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_propietario(?,?,?,?,?,?)");
	        cs.setLong(1, lCedula);
	        cs.setLong(2, lRestaurante);
	        cs.setString(3, sEstado);
	        cs.setLong(4, lPersona);
	        cs.setString(5, sFecha);
	        cs.setString(6, sHora);
	        if(cs.execute()) {
		        System.out.println("Propietario actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Propietario actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el propietario...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el propietario...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del propietario fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarPropietario(long lCedula, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from propietario where cedula = " + String.valueOf(lCedula));
	        if (rs.next()) {
	        	System.out.println("Propietario encontrado...");
	        	sesion.setAttribute("cedula_propietario", rs.getLong(1));
	        	sesion.setAttribute("rest_propietario", rs.getLong(2));
	        	sesion.setAttribute("estado_propietario", rs.getString(3));
	        	sesion.setAttribute("persona_propietario", rs.getLong(4));
	        	sesion.setAttribute("fecha_propietario", rs.getString(5));
	        	sesion.setAttribute("hora_propietario", rs.getString(6));
	        }
	        else
	        	System.out.println("Propietario no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del propietario fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarPropietario(long lCedula, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_propietario(?)");
	        cs.setLong(1, lCedula);
	        if (cs.execute()) {
	        	System.out.println("Propietario eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Propietario eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el propietario...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el propietario...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del propietario fallida...");
			System.out.println(e.getMessage());
		}
	}
}
