package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudClienteSucesor {
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
	public void crearClienteSucesor(long lCliente, long lSucesor, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_clientesucesor(?,?,?,?)");
	        cs.setLong(1, lCliente);
	        cs.setLong(2, lSucesor);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Cliente y sucesor insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Cliente y sucesor insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el cliente y el sucesor...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el cliente y el sucesor...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarClienteSucesor(long lCliente, long lSucesor, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_clientesucesor(?,?,?,?)");
	        cs.setLong(1, lCliente);
	        cs.setLong(2, lSucesor);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if(cs.execute()) {
		        System.out.println("Cliente y sucesor actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Cliente y sucesor actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el cliente y el sucesor...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el cliente y el sucesor...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del cliente y el sucesor fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarClienteSucesor(long lCliente, long lSucesor, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from clientesucesor where cliente = " + String.valueOf(lCliente) + "and sucesor = " + String.valueOf(lSucesor));
	        if (rs.next()) {
	        	System.out.println("Cliente y sucesor encontrado...");
	        	sesion.setAttribute("mensaje", "Cliente y sucesor encontrado exitosamente...");
	        	//obtiene codigo
	        	sesion.setAttribute("cliente_clientesucesor", rs.getLong(1));
	        	//obtiene nombre
	        	sesion.setAttribute("sucesor_clientesucesor", rs.getLong(2));
	        	//obtiene fecha
	        	sesion.setAttribute("fecha_clientesucesor", rs.getString(3));
	        	//obtiene hora
	        	sesion.setAttribute("hora_clientesucesor", rs.getString(4));
	        }
	        else
	        	System.out.println("Cliente y sucesor no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del cliente y sucesor fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarClienteSucesor(long lCliente, long lSucesor, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_clientesucesor(?,?)");
	        cs.setLong(1, lCliente);
	        cs.setLong(2, lSucesor);
	        if (cs.execute()) {
	        	System.out.println("Cliente y sucesor eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Cliente y sucesor eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el cliente y el sucesor...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el cliente y el sucesor...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del cliente y el sucesor fallida...");
			System.out.println(e.getMessage());
		}
	}
}
