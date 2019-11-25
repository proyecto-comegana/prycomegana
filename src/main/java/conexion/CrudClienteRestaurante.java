package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudClienteRestaurante {
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
	public void crearClienteRestaurante(long lCliente, long lRestaurante, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_clienterestaurante(?,?,?,?)");
	        cs.setLong(1, lCliente);
	        cs.setLong(2, lRestaurante);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Cliente y restaurante insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Cliente y restaurante insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el cliente y el restaurante...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el cliente y el restaurante...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarClienteRestaurante(long lCliente, long lRestaurante, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_clienterestaurante(?,?,?,?)");
	        cs.setLong(1, lCliente);
	        cs.setLong(2, lRestaurante);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if(cs.execute()) {
		        System.out.println("Cliente y restaurante actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Cliente y restaurante actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el cliente y el restaurante...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el cliente y el restaurante...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del cliente y el restaurante fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarClienteRestaurante(long lCliente, long lRestaurante, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from clienterestaurante where cliente = " + String.valueOf(lCliente) + "and restaurante = " + String.valueOf(lRestaurante));
	        if (rs.next()) {
	        	System.out.println("Cliente y restaurante encontrado...");
	        	sesion.setAttribute("mensaje", "Cliente y restaurante encontrado exitosamente...");
	        	//obtiene codigo
	        	sesion.setAttribute("cliente_clienterest", rs.getLong(1));
	        	//obtiene nombre
	        	sesion.setAttribute("restaurante_clienterest", rs.getLong(2));
	        	//obtiene fecha
	        	sesion.setAttribute("fecha_clienterest", rs.getString(3));
	        	//obtiene hora
	        	sesion.setAttribute("hora_clienterest", rs.getString(4));
	        }
	        else
	        	System.out.println("Cliente y restaurante no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del cliente y restaurante fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarClienteRestaurante(long lCliente, long lRestaurante, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_clienterestaurante(?,?)");
	        cs.setLong(1, lCliente);
	        cs.setLong(2, lRestaurante);
	        if (cs.execute()) {
	        	System.out.println("Cliente y restaurante eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Cliente y restaurante eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el cliente y el restaurante...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el cliente y el restaurante...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del cliente y el restaurante fallida...");
			System.out.println(e.getMessage());
		}
	}
}
