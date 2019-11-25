package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudParametro {
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
	public void crearParametro(String sNombre, String sDescripcion,long lValor, int iTipoParametro,int iModulo,String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_parametros(?,?,?,?,?,?,?)");
	        cs.setString(1, sNombre);
	        cs.setString(2, sDescripcion);
	        cs.setLong(3, lValor);
	        cs.setInt(4, iTipoParametro);
	        cs.setInt(5, iModulo);
	        cs.setString(6, sFecha);
	        cs.setString(7, sHora);
	        if (cs.execute()) {
	        	System.out.println("Parámetro insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Parámetro insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el parámetro...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el parámetro...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarParametro(int iCodigo, String sNombre, String sDescripcion,long lValor, int iTipoParametro,int iModulo,String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_parametro(?,?,?,?,?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sNombre);
	        cs.setString(3, sDescripcion);
	        cs.setLong(4, lValor);
	        cs.setInt(5, iTipoParametro);
	        cs.setInt(6, iModulo);
	        cs.setString(7, sFecha);
	        cs.setString(8, sHora);
	        if(cs.execute()) {
		        System.out.println("Parámetro actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Parámetro actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el parámetro...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el parámetro...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del parámetro fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarParametro(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from parametro where codigo = " + String.valueOf(iCodigo));
	        if (rs.next()) {
	        	System.out.println("Tipo de parametro encontrado...");
	        	sesion.setAttribute("codigo_parametro", rs.getInt(1));
	        	sesion.setAttribute("nombre_parametro", rs.getString(2));
	        	sesion.setAttribute("descrip_parametro", rs.getString(3));
	        	sesion.setAttribute("valor_parametro", rs.getString(4));
	        	sesion.setAttribute("tipo_parametro", rs.getString(5));
	        	sesion.setAttribute("modulo_parametro", rs.getString(6));
	        	sesion.setAttribute("fecha_parametro", rs.getString(7));
	        	sesion.setAttribute("hora_parametro", rs.getString(8));
	        }
	        else
	        	System.out.println("Parámetro no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del parámetro fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarParametro(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_parametro(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Parámetro eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Parámetro eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el parámetro...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el parámetro...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del parámetro fallida...");
			System.out.println(e.getMessage());
		}
	}
}
