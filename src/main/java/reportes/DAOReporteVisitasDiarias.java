package reportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import conexion.conexion;
import javax.servlet.http.HttpSession;

public class DAOReporteVisitasDiarias {
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
	
	public void generarReporte(String sRecurso, String sFecha, HttpSession sesion) {
		System.out.println("Nombre del recurso:" + sRecurso);
		System.out.println("Fecha de acceso:" + sFecha);
		sesion.setAttribute("sDenominacionRecurso", sRecurso);
		sesion.setAttribute("sFechaAcceso", sFecha);
		Conecta();
		consultarAcceso(sRecurso, sFecha, sesion); //Retorna cursor
	}
	
	public void consultarAcceso(String sRecurso, String sFecha, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //String consulta = "select * from accesos where pagina = " + sRecurso + " And fecha = " + sFecha;
	        String consulta = "select * from accesos where pagina = ? And fecha = ?";
	        PreparedStatement ps = con.prepareStatement(consulta);
	        ps.setString(1, sRecurso);
	        ps.setString(2, sFecha);
	        System.out.println(consulta);
	        ResultSet rs = ps.executeQuery();
	        sesion.setAttribute("cursor", rs);
	        while (rs.next()) {
	        	System.out.println("yuju!!! Acceso encontrado...");
	        	System.out.println("Codigo:"+rs.getLong(1));
	        	System.out.println("Ip:"+rs.getString(2));
	        	System.out.println("Modulo:"+rs.getInt(3));
	        	System.out.println("Pagina:"+rs.getString(4));
	        	System.out.println("Objeto:"+rs.getString(5));
	        	System.out.println("Tabla:"+rs.getString(6));
	        	System.out.println("Operacion:"+rs.getString(7));
	        	System.out.println("Acción:"+rs.getString(8));
	        	System.out.println("Proceso:"+rs.getString(9));
	        	System.out.println("Estado tarea:"+rs.getString(10));
	        	System.out.println("Comando:"+rs.getString(11));
	        	System.out.println("Aplicacion:"+rs.getString(12));
	        	System.out.println("Tiempo:"+rs.getInt(13));
	        	System.out.println("Transaccion:"+rs.getString(14));
	        	System.out.println("Fecha:"+rs.getString(15));
	        	System.out.println("Hora:"+rs.getString(16));
	        	System.out.println("Usuario:"+rs.getString(17));
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del acceso fallida...");
			System.out.println(e.getMessage());
		}
	}
}
