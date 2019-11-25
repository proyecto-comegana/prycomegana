package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudBonificacion {
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

	public void crearBonificacion(long lCliente, long lValor, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_bonificaciones(?,?,?,?)");
	        cs.setLong(1, lCliente);
	        cs.setLong(2, lValor);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Bonificación insertada exitosamente...");
	        	sesion.setAttribute("mensaje", "Bonificación insertada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar la bonificación...");
	        	sesion.setAttribute("mensaje", "Imposible insertar la bonificación...");
	        }
	        	
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void actualizarRecarga(long lCodigo, long lCliente, long lValor, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_recargas(?,?,?,?,?)");
	        cs.setLong(1, lCodigo);
	        cs.setLong(2, lCliente);
	        cs.setLong(3, lValor);
	        cs.setString(4, sFecha);
	        cs.setString(5, sHora);
	        if(cs.execute()) {
		        System.out.println("Recarga actualizada exitosamente...");
		        sesion.setAttribute("mensaje", "Recarga actualizada exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar la recarga...");
		        sesion.setAttribute("mensaje", "Imposible actualizar la recarga...");
	        }
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación fallida...");
			System.out.println(e.getMessage());
		}
	}

	public void consultarBonificacion(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_consultar_bonificaciones(?)");
	        cs.setLong(1, lCodigo);
	        //Obtiene el conjunto de resultados
	        ResultSet rs = cs.executeQuery();
	        if (rs.next()) {
	        	System.out.println("Bonificación encontrada...");
	        	String datosBonificacion = rs.getString(1);
	        	//obtiene codigo
	        	int inicio = 1;
	        	int fin = datosBonificacion.indexOf(",");
	        	String codigo = datosBonificacion.substring(inicio, fin);
	        	sesion.setAttribute("codigo_bonificacion", String.valueOf(codigo));
	        	//obtiene nombre
	        	inicio = fin+1;
	        	fin = datosBonificacion.indexOf(",", inicio);
	        	String cliente = datosBonificacion.substring(inicio, fin);
	        	//variable de sesion nombre
	        	sesion.setAttribute("cliente_bonificacion", cliente);
	        	//obtiene codigo departamento
	        	inicio = fin+1;
	        	fin = datosBonificacion.indexOf(",", inicio);
	        	String valor = datosBonificacion.substring(inicio, fin);
	        	//variable de sesion nombre
	        	sesion.setAttribute("valor_bonificacion", valor);
	        	//obtiene fecha
	        	inicio = fin + 1;
	        	fin = datosBonificacion.indexOf(",", inicio);
	        	String fecha = datosBonificacion.substring(inicio, fin);
	        	//variable de sesion fecha
	        	sesion.setAttribute("fecha_bonificacion", fecha);
	        	//obtiene hora
	        	inicio = fin + 1;
	        	String hora = datosBonificacion.substring(inicio, datosBonificacion.length()-1);
	        	//variable de sesion hora
	        	sesion.setAttribute("hora_bonificacion", hora);
	        }
	        else
	        	System.out.println("Recarga no encontrada...");
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void actualizarBonificaciones(long lCodigo, long lCliente, long lValor, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_bonificaciones(?,?,?,?,?)");
	        cs.setLong(1, lCodigo);
	        cs.setLong(2, lCliente);
	        cs.setLong(3, lValor);
	        cs.setString(4, sFecha);
	        cs.setString(5, sHora);
	        if(cs.execute()) {
		        System.out.println("Bonificación actualizada exitosamente...");
		        sesion.setAttribute("mensaje", "Bonificación actualizada exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar la bonificación...");
		        sesion.setAttribute("mensaje", "Imposible actualizar la bonificación...");
	        }
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación fallida...");
			System.out.println(e.getMessage());
		}
	}

	public void borrarBonificacion(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_bonificaciones(?)");
	        cs.setLong(1, lCodigo);
	        if (cs.execute()) {
	        	System.out.println("Bonificación eliminada exitosamente...");
	        	sesion.setAttribute("mensaje", "Bonificación eliminada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar la Bonificación...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar la Bonificación...");
	        }
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Eliminación fallida...");
			System.out.println(e.getMessage());
		}
	}
	
}
