package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudParametroModulo {
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
	public void crearParametroModulo(int iParametro, int iModulo,String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_parametromodulo(?,?,?,?)");
	        cs.setInt(1, iParametro);
	        cs.setInt(2, iModulo);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Parámetro y modulo insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Parámetro y modulo insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el parámetro y el modulo...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el parámetro y el modulo...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarParametroModulo(int iParametro, int iModulo, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_parametromodulo(?,?,?,?)");
	        cs.setInt(1, iParametro);
	        cs.setInt(2, iModulo);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if(cs.execute()) {
		        System.out.println("Parámetro y modulo actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Parámetro y modulo actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el parámetro y el modulo...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el parámetro y el modulo...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del parámetro y el modulo fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarParametroModulo(int iParametro, int iModulo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from parametromodulo where parametro = " + String.valueOf(iParametro)+ " and modulo = "+String.valueOf(iModulo));
	        if (rs.next()) {
	        	System.out.println("Parámetro y modulo encontrado...");
	        	sesion.setAttribute("parametro_paramod", rs.getInt(1));
	        	sesion.setAttribute("modulo_paramod", rs.getInt(2));
	        	sesion.setAttribute("fecha_paramod", rs.getString(3));
	        	sesion.setAttribute("hora_paramod", rs.getString(4));
	        }
	        else
	        	System.out.println("Parámetro y modulo no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del parámetro fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarParametroModulo(int iParametro, int iModulo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_parametromodulo(?,?)");
	        cs.setInt(1, iParametro);
	        cs.setInt(2, iModulo);
	        if (cs.execute()) {
	        	System.out.println("Parámetro y modulo eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Parámetro y modulo eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el parámetro y el modulo...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el parámetro y el modulo...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del parámetro y el modulo fallida...");
			System.out.println(e.getMessage());
		}
	}
}
