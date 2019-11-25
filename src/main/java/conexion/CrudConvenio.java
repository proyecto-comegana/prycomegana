package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudConvenio {
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
	public void crearConvenio(String sDescripcion, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_convenio(?,?,?)");
	        cs.setString(1, sDescripcion);
	        cs.setString(2, sFecha);
	        cs.setString(3, sHora);
	        if (cs.execute()) {
	        	System.out.println("Convenio insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Convenio insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el convenio...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el convenio...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarConvenio(int iCodigo, String sDescripcion, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_convenio(?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sDescripcion);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if(cs.execute()) {
		        System.out.println("Convenio actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Convenio actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el convenio...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el convenio...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del convenio fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarConvenio(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from convenios where codigo = " + String.valueOf(iCodigo));
	        if (rs.next()) {
	        	System.out.println("Convenio encontrado...");
	        	//obtiene codigo
	        	sesion.setAttribute("codigo_convenio", rs.getInt(1));
	        	//obtiene descripcion
	        	sesion.setAttribute("descrip_convenio", rs.getString(2));
	        	//obtiene fecha
	        	sesion.setAttribute("fecha_convenio", rs.getString(3));
	        	//obtiene hora
	        	sesion.setAttribute("hora_convenio", rs.getString(4));
	        }
	        else
	        	System.out.println("Convenio no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarConvenio(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_convenios(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Convenio eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Convenio eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el convenio...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el convenio...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del convenio fallida...");
			System.out.println(e.getMessage());
		}
	}
}
