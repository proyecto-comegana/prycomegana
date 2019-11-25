package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudEmpleado {
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
	public void crearEmpleado(int iCargo, int iArea, long lPersona,String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_empleado(?,?,?,?,?)");
	        cs.setInt(1, iCargo);
	        cs.setInt(2, iArea);
	        cs.setLong(3, lPersona);
	        cs.setString(4, sFecha);
	        cs.setString(5, sHora);
	        if (cs.execute()) {
	        	System.out.println("Empleado insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Empleado insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el empleado...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el empleado...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarEmpleado(long lEmpleado, int iCargo, int iArea, long lPersona,String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_empleado(?,?,?,?,?,?)");
	        cs.setLong(1, lEmpleado);
	        cs.setInt(2, iCargo);
	        cs.setInt(3, iArea);
	        cs.setLong(4, lPersona);
	        cs.setString(5, sFecha);
	        cs.setString(6, sHora);
	        if(cs.execute()) {
		        System.out.println("Empleado actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Empleado actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el empleado...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el empleado...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del Empleado fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarEmpleado(long lEmpleado, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from empleado where codigo = " + String.valueOf(lEmpleado));
	        if (rs.next()) {
	        	System.out.println("Empleado encontrado...");
	        	sesion.setAttribute("codigo_empleado", rs.getLong(1));
	        	sesion.setAttribute("cargo_empleado", rs.getInt(2));
	        	sesion.setAttribute("area_empleado", rs.getInt(3));
	        	sesion.setAttribute("persona_empleado", rs.getLong(4));
	        	sesion.setAttribute("fecha_empleado", rs.getString(5));
	        	sesion.setAttribute("hora_empleado", rs.getString(6));
	        }
	        else
	        	System.out.println("Empleado no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del empleado fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarEmpleado(long lEmpleado, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_empleado(?)");
	        cs.setLong(1, lEmpleado);
	        if (cs.execute()) {
	        	System.out.println("Empleado eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Empleado eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el empleado...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el empleado...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del empleado fallida...");
			System.out.println(e.getMessage());
		}
	}
}
