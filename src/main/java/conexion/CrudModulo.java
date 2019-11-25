package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudModulo {
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
	public void crearModulo(String sNombre, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        CallableStatement cs = con.prepareCall("select proc_crear_Modulo(?,?,?)");
	        cs.setString(1, sNombre);
	        cs.setString(2, sFecha);
	        cs.setString(3, sHora);
	        if (cs.execute()) {
	        	System.out.println("Modulo insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Modulo insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el módulo...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el módulo...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarModulo(int iCodigo, String sNombre, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_modulo(?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sNombre);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if(cs.execute()) {
		        System.out.println("Módulo actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Módulo actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el modulo...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el modulo...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del modulo fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarModulo(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from modulos where codigo = " + String.valueOf(iCodigo));
	        if (rs.next()) {
	        	System.out.println("Módulo encontrado...");
	        	sesion.setAttribute("codigo_modulo", rs.getInt(1));
	        	sesion.setAttribute("nombre_modulo", rs.getString(2));
	        	sesion.setAttribute("fecha_modulo", rs.getString(3));
	        	sesion.setAttribute("hora_modulo", rs.getString(4));
	        }
	        else
	        	System.out.println("Módulo no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del modulo fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarModulo(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_modulo(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Módulo eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Módulo eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el módulo...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el módulo...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del módulo incorrecta...");
			System.out.println(e.getMessage());
		}
	}
}
