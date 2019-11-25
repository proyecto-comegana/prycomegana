package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudArea {
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
	public void crearArea(String sNombre, String sDescripcion, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_area(?,?,?,?)");
	        cs.setString(1, sNombre);
	        cs.setString(2, sDescripcion);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Area insertada exitosamente...");
	        	sesion.setAttribute("mensaje", "Area insertada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el area...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el area...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarArea(int iCodigo, String sNombre, String sDescripcion, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_area(?,?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sNombre);
	        cs.setString(3, sDescripcion);
	        cs.setString(4, sFecha);
	        cs.setString(5, sHora);
	        if(cs.execute()) {
		        System.out.println("Area actualizada exitosamente...");
		        sesion.setAttribute("mensaje", "Area actualizada exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el area...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el area...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del area fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarArea(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from area where codigo = " + String.valueOf(iCodigo));
	        if (rs.next()) {
	        	System.out.println("Area encontrada...");
	        	//obtiene codigo
	        	sesion.setAttribute("codigo_area", rs.getInt(1));
	        	//obtiene nombre
	        	sesion.setAttribute("nombre_area", rs.getString(2));
	        	//obtiene descripcion
	        	sesion.setAttribute("descrip_area", rs.getString(3));
	        	//obtiene fecha
	        	sesion.setAttribute("fecha_area", rs.getString(4));
	        	//obtiene hora
	        	sesion.setAttribute("hora_area", rs.getString(5));
	        }
	        else
	        	System.out.println("Area no encontrada...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del area fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarArea(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_area(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Area eliminada exitosamente...");
	        	sesion.setAttribute("mensaje", "Area eliminada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el area...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el area...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del area fallida...");
			System.out.println(e.getMessage());
		}
	}
}
