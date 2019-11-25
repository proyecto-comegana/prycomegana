package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudCliente {
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
	public boolean crearCliente(long lCedula, long lNumArbol, long lNivel, long lPredecesor, long lPersona, long lSaldo, long lBonos, int iPremio, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_cliente(?,?,?,?,?,?,?,?,?,?)");
	        cs.setLong(1, lCedula);
	        cs.setLong(2, lNumArbol);
	        cs.setLong(3, lNivel);
	        cs.setLong(4, lPredecesor);
	        cs.setLong(5, lPersona);
	        cs.setLong(6, lSaldo);
	        cs.setLong(7, lBonos);
	        cs.setInt(8, iPremio);
	        cs.setString(9, sFecha);
	        cs.setString(10, sHora);
	        if (cs.execute()) {
	        	System.out.println("Cliente insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Cliente insertado exitosamente...");
	        	return true;
	        }
	        else {
	        	System.out.println("Imposible insertar el cliente...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el cliente...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public void actualizarCliente(long lCedula, long lNumArbol, long lNivel, long lPredecesor, long lPersona, long lSaldo, long lBonos, int iPremio, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_cliente(?,?,?,?,?,?,?,?,?,?)");
	        cs.setLong(1, lCedula);
	        cs.setLong(2, lNumArbol);
	        cs.setLong(3, lNivel);
	        cs.setLong(4, lPredecesor);
	        cs.setLong(5, lPersona);
	        cs.setLong(6, lSaldo);
	        cs.setLong(7, lBonos);
	        cs.setInt(8, iPremio);
	        cs.setString(9, sFecha);
	        cs.setString(10, sHora);
	        if(cs.execute()) {
		        System.out.println("Cliente actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Cliente actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el cliente...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el cliente...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del cliente fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarCliente(long lCedula, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from cliente where cedula = " + String.valueOf(lCedula));
	        if (rs.next()) {
	        	System.out.println("Cédula encontrada...");
	        	sesion.setAttribute("mensaje", "Cliente encontrado exitosamente...");
	        	sesion.setAttribute("cedula_cliente", rs.getLong(1));
	        	sesion.setAttribute("numarbol_cliente", rs.getLong(2));
	        	sesion.setAttribute("nivel_cliente", rs.getLong(3));
	        	sesion.setAttribute("predecesor_cliente", rs.getLong(4));
	        	sesion.setAttribute("persona_cliente", rs.getLong(5));
	        	sesion.setAttribute("saldo_cliente", rs.getLong(6));
	        	sesion.setAttribute("bonos_cliente", rs.getLong(7));
	        	sesion.setAttribute("premio_cliente", rs.getInt(8));
	        	sesion.setAttribute("fecha_cliente", rs.getString(9));
	        	sesion.setAttribute("hora_cliente", rs.getString(10));
	        }
	        else
	        	System.out.println("Cliente no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta de cliente fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarCliente(long lCedula, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_cliente(?)");
	        cs.setLong(1, lCedula);
	        if (cs.execute()) {
	        	System.out.println("Cliente eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Cliente eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el cliente...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el cliente...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación de cliente fallida...");
			System.out.println(e.getMessage());
		}
	}
}
