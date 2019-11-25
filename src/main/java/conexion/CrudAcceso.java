package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


public class CrudAcceso {
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
	public void crearAcceso(String sIP, int iModulo,String sPagina, String sObjeto,String sTabla,String sOperacion, 
			String sAccion, String sProceso, String sEstadoTarea, String sComando, String sAplicacion, int iTiempo, 
			String sTransaccion, String sFecha, String sHora, long lUsuario,HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_acceso(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	        cs.setString(1, sIP);
	        cs.setInt(2, iModulo);
	        cs.setString(3, sPagina);
	        cs.setString(4, sObjeto);
	        cs.setString(5, sTabla);
	        cs.setString(6, sOperacion);
	        cs.setString(7, sAccion);
	        cs.setString(8, sProceso);
	        cs.setString(9, sEstadoTarea);
	        cs.setString(10, sComando);
	        cs.setString(11, sAplicacion);
	        cs.setInt(12, iTiempo);
	        cs.setString(13, sTransaccion);
	        cs.setString(14, sFecha);
	        cs.setString(15, sHora);
	        cs.setLong(16, lUsuario);
	        
	        if (cs.execute()) {
	        	System.out.println("Acceso insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Acceso insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el acceso...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el acceso...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarAcceso(long lCodigo, String sIP, int iModulo,String sPagina, String sObjeto,String sTabla,
			String sOperacion, String sAccion, String sProceso, String sEstadoTarea, String sComando, String sAplicacion, 
			int iTiempo, String sTransaccion, String sFecha, String sHora, long lUsuario,HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        CallableStatement cs = con.prepareCall("select proc_modificar_acceso(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	        cs.setLong(1, lCodigo);
	        cs.setString(2, sIP);
	        cs.setInt(3, iModulo);
	        cs.setString(4, sPagina);
	        cs.setString(5, sObjeto);
	        cs.setString(6, sTabla);
	        cs.setString(7, sOperacion);
	        cs.setString(8, sAccion);
	        cs.setString(9, sProceso);
	        cs.setString(10, sEstadoTarea);
	        cs.setString(11, sComando);
	        cs.setString(12, sAplicacion);
	        cs.setInt(13, iTiempo);
	        cs.setString(14, sTransaccion);
	        cs.setString(15, sFecha);
	        cs.setString(16, sHora);
	        cs.setLong(17, lUsuario);

	        if(cs.execute()) {
		        System.out.println("Acceso actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Acceso actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el acceso...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el acceso...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del acceso fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarAcceso(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from accesos where codigo = " + String.valueOf(lCodigo));
	        if (rs.next()) {
	        	System.out.println("Acceso encontrado...");
	        	sesion.setAttribute("codigo_acceso", rs.getLong(1));
	        	sesion.setAttribute("ip_acceso", rs.getString(2));
	        	sesion.setAttribute("modulo_acceso", rs.getInt(3));
	        	sesion.setAttribute("pagina_acceso", rs.getString(4));
	        	sesion.setAttribute("objeto_acceso", rs.getString(5));
	        	sesion.setAttribute("tabla_acceso", rs.getString(6));
	        	sesion.setAttribute("operacion_acceso", rs.getString(7));
	        	sesion.setAttribute("accion_acceso", rs.getString(8));
	        	sesion.setAttribute("proceso_acceso", rs.getString(9));
	        	sesion.setAttribute("estadotarea_acceso", rs.getString(10));
	        	sesion.setAttribute("comando_acceso", rs.getString(11));
	        	sesion.setAttribute("aplicacion_acceso", rs.getString(12));
	        	sesion.setAttribute("tiempo_acceso", rs.getInt(13));
	        	sesion.setAttribute("transaccion_acceso", rs.getString(14));
	        	sesion.setAttribute("fecha_acceso", rs.getString(15));
	        	sesion.setAttribute("hora_acceso", rs.getString(16));
	        	sesion.setAttribute("usuario_acceso", rs.getLong(17));
	        }
	        else
	        	System.out.println("Acceso no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del acceso fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarAcceso(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        CallableStatement cs = con.prepareCall("select proc_borrar_acceso(?)");
	        cs.setLong(1, lCodigo);
	        if (cs.execute()) {
	        	System.out.println("Acceso eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Acceso eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el acceso...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el acceso...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del acceso fallida...");
			System.out.println(e.getMessage());
		}
	}
}
