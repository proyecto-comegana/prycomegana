package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudFallo {
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
	public void crearFallo(String sDescripcion, String sRuta,String sArchivo, int iLinea,String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        CallableStatement cs = con.prepareCall("select proc_crear_fallo(?,?,?,?,?,?)");
	        cs.setString(1, sDescripcion);
	        cs.setString(2, sRuta);
	        cs.setString(3, sArchivo);
	        cs.setInt(4, iLinea);
	        cs.setString(5, sFecha);
	        cs.setString(6, sHora);
	        if (cs.execute()) {
	        	System.out.println("Fallo insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Fallo insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el fallo...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el fallo...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarFallo(int iCodigo, String sDescripcion, String sRuta,String sArchivo, int iLinea,String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_fallo(?,?,?,?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sDescripcion);
	        cs.setString(3, sRuta);
	        cs.setString(4, sArchivo);
	        cs.setInt(5, iLinea);
	        cs.setString(6, sFecha);
	        cs.setString(7, sHora);
	        if(cs.execute()) {
		        System.out.println("Fallo actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Fallo actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el fallo...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el fallo...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del fallo fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarFallo(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from fallos where codigo = " + String.valueOf(iCodigo));
	        if (rs.next()) {
	        	System.out.println("Fallo encontrado...");
	        	sesion.setAttribute("codigo_fallo", rs.getInt(1));
	        	sesion.setAttribute("descrip_fallo", rs.getString(2));
	        	sesion.setAttribute("ruta_fallo", rs.getString(3));
	        	sesion.setAttribute("archivo_fallo", rs.getString(4));
	        	sesion.setAttribute("linea_fallo", rs.getInt(5));
	        	sesion.setAttribute("fecha_fallo", rs.getString(6));
	        	sesion.setAttribute("hora_fallo", rs.getString(7));
	        }
	        else
	        	System.out.println("Fallo no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del fallo fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarFallo(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_fallo(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Fallo eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Fallo eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el fallo...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el fallo...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del fallo incorrecta...");
			System.out.println(e.getMessage());
		}
	}
}
