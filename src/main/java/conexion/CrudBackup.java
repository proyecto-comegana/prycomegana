package conexion;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudBackup {
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
	public void crearBackup(String sDescripcion, int iTipo,String sNombreArchivo,String sRutaArchivo, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        CallableStatement cs = con.prepareCall("select proc_crear_backup(?,?,?,?,?,?)");
	        cs.setString(1, sDescripcion);
	        cs.setInt(2, iTipo);
	        cs.setString(3, sNombreArchivo);
	        cs.setString(4, sRutaArchivo);
	        cs.setString(5, sFecha);
	        cs.setString(6, sHora);
	        
	        //CODIGO QUE GENERA BACKUP EN LA BASE DE DATOS
	        //OBTIENE FECHA ACTUAL
	    	LocalDate fecha;
	    	fecha = LocalDate.now();
	    	DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM/dd/YYYY");
	    	String sFechaActual = formateador.format(fecha);
	        
	        String path = "/conexion/bd.sql";
	        Runtime r = Runtime.getRuntime();
	        String user = "postgres";
	        String dbase = "comegana";
	        String password = "123";
	        Process p;
	        ProcessBuilder pb;
	        r = Runtime.getRuntime();
	        pb = new ProcessBuilder("pg_dump", "-v", "-D", "-f", path, "-U", user, dbase);
	        pb.environment().put("PGPASSWORD", password);
	        pb.redirectErrorStream(true);
	        p = pb.start();
	        if (cs.execute()) {
	        	System.out.println("Backup insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Backup insertado exitosamente...");
	        	
	        }
	        else {
	        	System.out.println("Imposible insertar el backup...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el backup...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void actualizarBackup(int iCodigo, String sDescripcion, int iTipo,String sNombreArchivo, String sRutaArchivo,String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_backup(?,?,?,?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sDescripcion);
	        cs.setInt(3, iTipo);
	        cs.setString(4, sNombreArchivo);
	        cs.setString(5, sRutaArchivo);
	        cs.setString(6, sFecha);
	        cs.setString(7, sHora);
	        if(cs.execute()) {
		        System.out.println("Backup actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Backup actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el backup...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el backup...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del backup fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarBackup(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from backups where codigo = " + String.valueOf(iCodigo));
	        if (rs.next()) {
	        	System.out.println("Backup encontrado...");
	        	sesion.setAttribute("codigo_backup", rs.getInt(1));
	        	sesion.setAttribute("descrip_backup", rs.getString(2));
	        	sesion.setAttribute("tipo_backup", rs.getInt(3));
	        	sesion.setAttribute("archivo_backup", rs.getString(4));
	        	sesion.setAttribute("ruta_backup", rs.getString(5));
	        	sesion.setAttribute("fecha_backup", rs.getString(6));
	        	sesion.setAttribute("hora_backup", rs.getString(7));
	        }
	        else
	        	System.out.println("Backup no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del fallo fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarBackup(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_backup(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Backup eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Backup eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el backup...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el backup...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del backup incorrecta...");
			System.out.println(e.getMessage());
		}
	}
}
