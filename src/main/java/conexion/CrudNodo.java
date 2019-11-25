package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudNodo {
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
	public boolean crearNodo(long lCliente, long lArbol,int iPosicion, String sEstado, int iNivel, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        CallableStatement cs = con.prepareCall("select proc_crear_nodo(?,?,?,?,?,?,?)");
	        cs.setLong(1, lCliente);
	        cs.setLong(2, lArbol);
	        cs.setInt(3, iPosicion);
	        cs.setString(4, sEstado);
	        cs.setInt(5, iNivel);
	        cs.setString(6, sFecha);
	        cs.setString(7, sHora);
	        if (cs.execute()) {
	        	System.out.println("Nodo insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Nodo insertado exitosamente...");
	        	return true;
	        }
	        else {
	        	System.out.println("Imposible insertar el nodo...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el nodo...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public void actualizarNodo(long lCodigo, long lCliente, long lArbol,int iPosicion, String sEstado, int iNivel, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_nodo(?,?,?,?,?,?,?,?)");
	        cs.setLong(1, lCodigo);
	        cs.setLong(2, lCliente);
	        cs.setLong(3, lArbol);
	        cs.setInt(4, iPosicion);
	        cs.setString(5, sEstado);
	        cs.setInt(6, iNivel);
	        cs.setString(7, sFecha);
	        cs.setString(8, sHora);
	        if(cs.execute()) {
		        System.out.println("Nodo actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Nodo actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el nodo...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el nodo...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del árbol fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarNodo(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from nodos where codigo = " + String.valueOf(lCodigo));
	        if (rs.next()) {
	        	System.out.println("Nodo encontrado...");
	        	sesion.setAttribute("codigo_nodo", rs.getLong(1));
	        	sesion.setAttribute("cliente_nodo", rs.getLong(2));
	        	sesion.setAttribute("arbol_nodo", rs.getLong(3));
	        	sesion.setAttribute("posicion_nodo", rs.getInt(4));
	        	sesion.setAttribute("estado_nodo", rs.getString(5));
	        	sesion.setAttribute("nivel_nodo", rs.getInt(6));
	        	sesion.setAttribute("fecha_nodo", rs.getString(7));
	        	sesion.setAttribute("hora_nodo", rs.getString(8));
	        }
	        else
	        	System.out.println("Nodo no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del nodo fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarNodo(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_nodo(?)");
	        cs.setLong(1, lCodigo);
	        if (cs.execute()) {
	        	System.out.println("Nodo eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Nodo eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el nodo...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el nodo...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del nodo incorrecta...");
			System.out.println(e.getMessage());
		}
	}
	public ResultSet consultarNodoxCliente(long lIdCliente) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from nodos" + String.valueOf(lIdCliente));
	        if (rs.next()) {
	        	System.out.println("Nodo encontrado...");
	        	return rs;
	        }
	        else {
	        	System.out.println("Nodo no encontrado...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del nodo fallida...");
			System.out.println(e.getMessage());
		}
		return null;
	}
	public int consultarSiguienteNodoVacio(long lArbol) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select max(posicion)+1 from nodos where arbol = " + String.valueOf(lArbol));
	        if (rs.next()) {
	        	System.out.println("Nodo encontrado...");
	        	return rs.getInt(1);
	        }
	        else {
	        	System.out.println("Nodo no encontrado...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del nodo fallida...");
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public int consultarSiguienteNodoVacio2(long lIdArbol, long lIdCliente) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select max(posicion) from nodos where arbol = " + String.valueOf(lIdArbol)
	        		+ " and cliente = " + String.valueOf(lIdCliente));
	        while (rs.next()) {
	        	System.out.println("Nodo encontrado...");
	        	return rs.getInt(1)+1;
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del nodo fallida...");
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public int contarNodosClientexArbol(long lIdArbol, long lIdCliente) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select count(*) from nodos where arbol = " + String.valueOf(lIdArbol)
	        		+ " and cliente = " + String.valueOf(lIdCliente));
	        while (rs.next()) {
	        	System.out.println("Nodo encontrado...");
	        	return rs.getInt(1);
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del nodo fallida...");
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public boolean encontroPosicionNodoRepetida(long lIdArbol, long lIdCliente, int iPosicion) {
		try {
			boolean bPosicionRepetida = false;
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select posicion from nodos where arbol = " + String.valueOf(lIdArbol)
	        		+ " and cliente = " + String.valueOf(lIdCliente));
	        while (rs.next()) {
	        	System.out.println("Nodo encontrado...");
	        	if (rs.getInt(1) == iPosicion) {
	        		bPosicionRepetida = true;
	        		return bPosicionRepetida;
	        	}
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del nodo fallida...");
			System.out.println(e.getMessage());
		}
		return false;
	}

}
