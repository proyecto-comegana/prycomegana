package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudAfiliacion {
	Connection con;
	private int iIdCiudad;
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
	public void crearAfiliacion(long lClientePadre, long lClienteHijo, String sEstado, String sCiudad, String sFecha, String sHora, HttpSession sesion) {
		try {
			//CONSULTAR CODIGO CIUDAD
			Statement stmntIdCiudad = null;
	        stmntIdCiudad = con.createStatement();
	        ResultSet rsIdCiudad = stmntIdCiudad.executeQuery("select * from ciudad");
	        iIdCiudad = 0;
	        while (rsIdCiudad.next()) { 
	        	if (rsIdCiudad.getString(2).equals(sCiudad))
	        		iIdCiudad = rsIdCiudad.getInt(1);
	        }
			Statement stmnt = null;
	        stmnt = con.createStatement();
	        sEstado = "Activa";
	        CallableStatement cs = con.prepareCall("select proc_crear_afiliacion(?,?,?,?,?,?)");
	        cs.setLong(1, lClientePadre);
	        cs.setLong(2, lClienteHijo);
	        cs.setString(3, sEstado);	        
	        cs.setInt(4, iIdCiudad);
	        cs.setString(5, sFecha);
	        cs.setString(6, sHora);
	        if (cs.execute()) {
	        	System.out.println("Afiliación insertada exitosamente...");
	        	sesion.setAttribute("mensaje_afil", "Afiliación insertada exitosamente...");
	        	sesion.setAttribute("res_reg_afil","true");
	        	sesion.setAttribute("cedula_cliente_hijo", lClienteHijo);
	        }
	        else {
	        	System.out.println("Imposible insertar la afiliación...");
	        	sesion.setAttribute("mensaje_afil", "Imposible insertar la afiliación...");
	        	sesion.setAttribute("res_reg_afil","false");	        	
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarAfiliacion(long lCodigo, long lClientePadre, long lClienteHijo, String sEstado, String sCiudad, String sFecha, String sHora, HttpSession sesion) {
		try {
			//CONSULTAR CODIGO CIUDAD
			Statement stmntIdCiudad = null;
	        stmntIdCiudad = con.createStatement();
	        ResultSet rsIdCiudad = stmntIdCiudad.executeQuery("select * from ciudad");
	        iIdCiudad = 0;
	        while (rsIdCiudad.next()) { 
	        	if (rsIdCiudad.getString(2).equals(sCiudad))
	        		iIdCiudad = rsIdCiudad.getInt(1);
	        }

			Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_afiliacion(?,?,?,?,?,?,?)");
	        cs.setLong(1, lCodigo);
	        cs.setLong(2, lClientePadre);
	        cs.setLong(3, lClienteHijo);
	        cs.setString(4, sEstado);
	        cs.setInt(5, iIdCiudad);
	        cs.setString(6, sFecha);
	        cs.setString(7, sHora);
	        if(cs.execute()) {
		        System.out.println("Afiliación actualizada exitosamente...");
		        sesion.setAttribute("mensaje", "Afiliación actualizada exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar la afiliación...");
		        sesion.setAttribute("mensaje", "Imposible actualizar la afiliación...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación de la actualización fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarAfiliacion(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from afiliacion where codigo = " + String.valueOf(lCodigo));
	        if (rs.next()) {
	        	System.out.println("Arbol encontrado...");
	        	sesion.setAttribute("codigo_afiliacion", rs.getInt(1));
	        	sesion.setAttribute("cpadre_afiliacion", rs.getLong(2));
	        	sesion.setAttribute("chijo_afiliacion", rs.getLong(3));
	        	sesion.setAttribute("estado_afiliacion", rs.getString(4));
	        	//CONSULTAR CODIGO DEL DEPARTAMENTO
				Statement stmntIdCiudad = null;
		        stmntIdCiudad = con.createStatement();
		        ResultSet rsIdCiudad = stmntIdCiudad.executeQuery("select * from ciudad");
		        iIdCiudad = rs.getInt(5); 
		        String sNombreCiudad = new String();
		        while (rsIdCiudad.next()) 
		        	if (rsIdCiudad.getInt(1) == iIdCiudad)
		        		sNombreCiudad = rsIdCiudad.getString(2);
		        sesion.setAttribute("nombre_ciudad", sNombreCiudad);
	        	sesion.setAttribute("ciudad_afiliacion", sNombreCiudad);
	        	sesion.setAttribute("fecha_afiliacion", rs.getString(6));
	        	sesion.setAttribute("hora_afiliacion", rs.getString(7));
	        }
	        else
	        	System.out.println("Afiliación no encontrada...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta de la afiliación fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarAfiliacion(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_afiliacion(?)");
	        cs.setLong(1, lCodigo);
	        if (cs.execute()) {
	        	System.out.println("Afiliacion eliminada exitosamente...");
	        	sesion.setAttribute("mensaje", "Afiliación eliminada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar la afiliación...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar la afiliación...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación de la afiliación incorrecta...");
			System.out.println(e.getMessage());
		}
	}
}
