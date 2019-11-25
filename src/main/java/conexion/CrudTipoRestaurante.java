package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudTipoRestaurante {
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
	public void crearTipoRestaurante(String sNombre, String sDescripcion, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_tiporestaurante(?,?,?,?)");
	        cs.setString(1, sNombre);
	        cs.setString(2, sDescripcion);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Tipo restaurante insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Tipo restaurante insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el tipo restaurante...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el tipo de restaurante...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarTipoRestaurante(int iCodigo, String sNombre, String sDescripcion, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_tiporestaurante(?,?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sNombre);
	        cs.setString(3, sDescripcion);
	        cs.setString(4, sFecha);
	        cs.setString(5, sHora);
	        if(cs.execute()) {
		        System.out.println("Tipo de restaurante actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Tipo de restaurante actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el tipo de restaurante...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el tipo de restaurante...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del tipo de restaurante fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarTipoRestaurante(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from tiporestaurante where codigo = " + String.valueOf(iCodigo));
	        if (rs.next()) {
	        	System.out.println("Tipo de restaurante encontrado...");
	        	//obtiene codigo
	        	sesion.setAttribute("codigo_trestaurante", rs.getInt(1));
	        	//obtiene nombre
	        	sesion.setAttribute("nombre_trestaurante", rs.getString(2));
	        	//obtiene descripcion
	        	sesion.setAttribute("descrip_trestaurante", rs.getString(3));
	        	//obtiene fecha
	        	sesion.setAttribute("fecha_trestaurante", rs.getString(4));
	        	//obtiene hora
	        	sesion.setAttribute("hora_trestaurante", rs.getString(5));
	        }
	        else
	        	System.out.println("Tipo de restaurante no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del tipo de restaurante fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarTipoRestaurante(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_tiporestaurante(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Tipo de restaurante eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Tipo de restaurante eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el tipo de restaurante...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el tipo de restaurante...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del tipo de restaurante fallida...");
			System.out.println(e.getMessage());
		}
	}
}
