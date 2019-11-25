package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudRestaurante {
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
	public void crearRestaurante(String sNombre, String sDescripcion, String sTelefono, long lPropietario, int iConvenio, int iTipo, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_restaurante(?,?,?,?,?,?,?,?)");
	        cs.setString(1, sNombre);
	        cs.setString(2, sDescripcion);
	        cs.setString(3, sTelefono);
	        cs.setLong(4, lPropietario);
	        cs.setInt(5, iConvenio);
	        cs.setInt(6, iTipo);
	        cs.setString(7, sFecha);
	        cs.setString(8, sHora);
	        if (cs.execute()) {
	        	System.out.println("Restaurante insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Restaurante insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el restaurante...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el restaurante...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarRestaurante(long lCodigo, String sNombre, String sDescripcion, String sTelefono, long lPropietario, int iConvenio, int iTipo, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_restaurante(?,?,?,?,?,?,?,?,?)");
	        cs.setLong(1, lCodigo);
	        cs.setString(2, sNombre);
	        cs.setString(3, sDescripcion);
	        cs.setString(4, sTelefono);
	        cs.setLong(5, lPropietario);
	        cs.setInt(6, iConvenio);
	        cs.setInt(7, iTipo);
	        cs.setString(8, sFecha);
	        cs.setString(9, sHora);
	        if(cs.execute()) {
		        System.out.println("Restaurante actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Restaurante actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el restaurante...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el Restaurante...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del restaurante fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarRestaurante(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from restaurante where codigo = " + String.valueOf(lCodigo));
	        if (rs.next()) {
	        	System.out.println("restaurante encontrado...");
	        	//obtiene codigo
	        	sesion.setAttribute("codigo_restaurante", rs.getLong(1));
	        	//obtiene nombre
	        	sesion.setAttribute("nombre_restaurante", rs.getString(2));
	        	//obtiene descripcion
	        	sesion.setAttribute("descrip_restaurante", rs.getString(3));
	        	//obtiene telefono
	        	sesion.setAttribute("telefono_restaurante", rs.getString(4));
	        	//obtiene propietario
	        	sesion.setAttribute("propietario_restaurante", rs.getLong(5));
	        	//obtiene convenio
	        	sesion.setAttribute("convenio_restaurante", rs.getInt(6));
	        	//obtiene tipo restaurante
	        	sesion.setAttribute("tipo_restaurante", rs.getInt(7));
	        	//obtiene fecha
	        	sesion.setAttribute("fecha_restaurante", rs.getString(8));
	        	//obtiene hora
	        	sesion.setAttribute("hora_restaurante", rs.getString(9));
	        }
	        else
	        	System.out.println("Restaurante no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del restaurante fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarRestaurante(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_restaurante(?)");
	        cs.setLong(1, lCodigo);
	        if (cs.execute()) {
	        	System.out.println("Restaurante eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Restaurante eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el restaurante...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el restaurante...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del restaurante fallida...");
			System.out.println(e.getMessage());
		}
	}
}
