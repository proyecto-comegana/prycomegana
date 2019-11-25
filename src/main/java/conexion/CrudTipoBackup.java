package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudTipoBackup {
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
	public void crearTipoBackup(String sDescripcion,String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        CallableStatement cs = con.prepareCall("select proc_crear_tipobackup(?,?,?)");
	        cs.setString(1, sDescripcion);
	        cs.setString(2, sFecha);
	        cs.setString(3, sHora);
	        if (cs.execute()) {
	        	System.out.println("Tipo backup insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Tipo backup insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el tipo de backup...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el tipo de backup...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarTipoBackup(int iCodigo, String sDescripcion, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_tipobackup(?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sDescripcion);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if(cs.execute()) {
		        System.out.println("Tipo de backup actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Tipo de backup actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el tipo de backup...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el tipo de backup...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del tipo de backup fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarTipoBackup(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from tipobackup where codigo = " + String.valueOf(iCodigo));
	        if (rs.next()) {
	        	System.out.println("Tipo de backup encontrado...");
	        	sesion.setAttribute("codigo_tbackup", rs.getInt(1));
	        	sesion.setAttribute("descrip_tbackup", rs.getString(2));
	        	sesion.setAttribute("fecha_tbackup", rs.getString(3));
	        	sesion.setAttribute("hora_tbackup", rs.getString(4));
	        }
	        else
	        	System.out.println("Tipo de backup no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del tipo de backup fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarTipoBackup(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_tipobackup(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Tipo backup eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Tipo backup eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el tipo de backup...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el tipo de backup...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del tipo de backup incorrecta...");
			System.out.println(e.getMessage());
		}
	}
}
