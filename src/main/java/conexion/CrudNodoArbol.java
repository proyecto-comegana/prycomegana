package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudNodoArbol {
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
	public boolean crearNodoArbol(long lNodo, long lArbol, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_nodoarbol(?,?,?,?)");
	        cs.setLong(1, lNodo);
	        cs.setLong(2, lArbol);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Nodo y árbol insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Nodo y árbol insertado exitosamente...");
	        	return true;
	        }
	        else {
	        	System.out.println("Imposible insertar el nodo y el árbol...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el nodo y el árbol...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public void actualizarNodoArbol(long lNodo, long lArbol, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_nodoarbol(?,?,?,?)");
	        cs.setLong(1, lNodo);
	        cs.setLong(2, lArbol);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if(cs.execute()) {
		        System.out.println("Nodo y árbol actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Nodo y árbol actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el nodo y el árbol...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el nodo y el árbol...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del nodo y el árbol fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarNodoArbol(long lNodo, long lArbol, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from nodoarbol where nodo = " + String.valueOf(lNodo) + "and arbol = " + String.valueOf(lArbol));
	        if (rs.next()) {
	        	System.out.println("Nodo y árbol encontrado...");
	        	sesion.setAttribute("mensaje", "Nodo y árbol encontrado exitosamente...");
	        	//obtiene codigo
	        	sesion.setAttribute("nodo_nodoarbol", rs.getLong(1));
	        	//obtiene nombre
	        	sesion.setAttribute("arbol_nodoarbol", rs.getLong(2));
	        	//obtiene fecha
	        	sesion.setAttribute("fecha_nodoarbol", rs.getString(3));
	        	//obtiene hora
	        	sesion.setAttribute("hora_nodoarbol", rs.getString(4));
	        }
	        else
	        	System.out.println("Nodo y árbol no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta nodo y árbol fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarNodoArbol(long lNodo, long lArbol, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_nodoarbol(?,?)");
	        cs.setLong(1, lNodo);
	        cs.setLong(2, lArbol);
	        if (cs.execute()) {
	        	System.out.println("Nodo y árbol eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Nodo y árbol eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el nodo y el árbol...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el nodo y el árbol...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del nodo y el árbol fallida...");
			System.out.println(e.getMessage());
		}
	}
}
