package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudPais {
	Connection con;
	HttpSession session;
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
	
	public boolean crearPais(String sNombre, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_pais(?, ?, ?)");
	        cs.setString(1, sNombre);
	        cs.setString(2, sFecha);
	        cs.setString(3, sHora);
	        if (cs.execute()) {
	        	System.out.println("Pais insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Pais insertado exitosamente...");
	        	return true;
	        }
	        else {
	        	System.out.println("Imposible insertar el pais...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el pais...");
	        }
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean borrarPais(int iCodigo) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_pais(?)");
	        cs.setInt(1, iCodigo);
	        cs.execute();
	        System.out.println("Registro eliminado exitosamente...");
	        if (cs != null)
	        	return true;
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Eliminación fallida...");
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean actualizarPais(int iCodigo, String sNombre, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_pais(?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sNombre);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	sesion.setAttribute("mensaje", "Pais insertado exitosamente...");
	        	sesion.setAttribute("msj_pais", "Pais insertado exitosamente...");
	        	return true;
	        }
	        else
	        	sesion.setAttribute("mensaje", "Imposible insertar el pais...");

	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación fallida...");
			System.out.println(e.getMessage());
			
		}
		return false;
	}

	public boolean consultarPais(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_consultar_pais(?)");
	        cs.setInt(1, iCodigo);
	        //Obtiene el conjunto de resultados
	        ResultSet rs = cs.executeQuery();
	        if (rs.next()) {
	        	System.out.println("Registro encontrado...");
	        	String datosPais = rs.getString(1);
	        	//obtiene codigo
	        	int inicio = 1;
	        	int fin = datosPais.indexOf(",");
	        	String codigo = datosPais.substring(inicio, fin);
	        	//variable de sesion pais
	        	sesion.setAttribute("codigo_pais", String.valueOf(codigo));
	        	//obtiene nombre
	        	inicio = fin+1;
	        	fin = datosPais.indexOf(",", inicio);
	        	String nombre = datosPais.substring(inicio, fin);
	        	//variable de sesion nombre
	        	sesion.setAttribute("nombre_pais", nombre);
	        	//obtiene fecha
	        	inicio = fin + 1;
	        	fin = datosPais.indexOf(",", inicio);
	        	String fecha = datosPais.substring(inicio, fin);
	        	//variable de sesion fecha
	        	sesion.setAttribute("fecha_pais", fecha);
	        	//obtiene hora
	        	inicio = fin + 1;
	        	String hora = datosPais.substring(inicio, datosPais.length()-1);
	        	//variable de sesion hora
	        	sesion.setAttribute("hora_pais", hora);
	        	return true;
	        }
	        else
	        	System.out.println("Registro no encontrado...");
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta fallida...");
			System.out.println(e.getMessage());
		}
		return false;
	}
}
