package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudTipoUsuario {
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
	public void crearTipoUsuario(String sDescripcion, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_tipousuario(?,?,?)");
	        cs.setString(1, sDescripcion);
	        cs.setString(2, sFecha);
	        cs.setString(3, sHora);
	        if (cs.execute()) {
	        	System.out.println("Tipo de usuario insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Tipo de usuario insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el tipo de usuario...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el tipo de usuario...");
	        }
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarTipoUsuario(int iCodigo, String sDescripcion, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_tipousuario(?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sDescripcion);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if(cs.execute()) {
		        System.out.println("Tipo de usuario actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Tipo de usuario actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el tipo de usuario...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el tipo de usuario...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del tipo de usuario fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarTipoUsuario(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from tipousuario where codigo = " + String.valueOf(iCodigo));
	        if (rs.next()) {
	        	System.out.println("Tipo de usuario encontrado...");
	        	sesion.setAttribute("codigo_tusuario", rs.getInt(1));
	        	sesion.setAttribute("descrip_tusuario", rs.getString(2));
	        	sesion.setAttribute("fecha_tusuario", rs.getString(3));
	        	sesion.setAttribute("hora_tusuario", rs.getString(4));
	        }
	        else
	        	System.out.println("Tipo de usuario no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del tipo de usuario fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarTipoUsuario(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_tipousuario(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Tipo de usuario eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Tipo de usuario eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el tipo de usuario...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el tipo de usuario...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del tipo de usuario fallida...");
			System.out.println(e.getMessage());
		}
	}
}
