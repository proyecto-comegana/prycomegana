package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudArbol {
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
	public boolean crearArbol(int iNiveles, int iElementos,String sFecha, String sHora, long lCliente, int iCupos, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        CallableStatement cs = con.prepareCall("select proc_crear_arbol(?,?,?,?,?,?)");
	        cs.setInt(1, iNiveles);
	        cs.setInt(2, iElementos);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        cs.setLong(5, lCliente);
	        cs.setInt(6, iCupos);	        
	        if (cs.execute()) {
	        	System.out.println("Arbol insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Arbol insertado exitosamente...");
	        	return true;
	        }
	        else {
	        	System.out.println("Imposible insertar el arbol...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el arbol...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public void actualizarArbol(long lCodigo, int iNiveles, int iElementos, String sFecha, String sHora, long lCliente, int iCupos, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_arbol(?,?,?,?,?,?,?)");
	        cs.setLong(1, lCodigo);
	        cs.setInt(2, iNiveles);
	        cs.setInt(3, iElementos);
	        cs.setString(4, sFecha);
	        cs.setString(5, sHora);
	        cs.setLong(6, lCliente);
	        cs.setInt(7, iCupos);
	        if(cs.execute()) {
		        System.out.println("Árbol actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Árbol actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el árbol...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el árbol...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del árbol fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarArbol(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from arbol where codigo = " + String.valueOf(lCodigo));
	        if (rs.next()) {
	        	System.out.println("Arbol encontrado...");
	        	sesion.setAttribute("codigo_arbol", rs.getInt(1));
	        	sesion.setAttribute("niveles_arbol", rs.getInt(2));
	        	sesion.setAttribute("elementos_arbol", rs.getString(3));
	        	sesion.setAttribute("fecha_arbol", rs.getString(4));
	        	sesion.setAttribute("hora_arbol", rs.getString(5));
	        	sesion.setAttribute("cliente_arbol", rs.getLong(6));
	        	sesion.setAttribute("cupos_arbol", rs.getInt(7));
	        }
	        else
	        	System.out.println("Árbol no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del árbol fallida...");
			System.out.println(e.getMessage());
		}
	}
	public long consultarArbolxCodigo(long lCodigo) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from arbol where codigo = " + String.valueOf(lCodigo));
	        if (rs.next()) {
	        	System.out.println("Arbol encontrado...");
	        	return rs.getInt(7);
	        }
	        else
	        	System.out.println("Árbol no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del árbol fallida...");
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public ResultSet consultarArboles() {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from arbol");
	        if (rs.next()) {
	        	System.out.println("Arboles encontrados exitosamente...");
	        	return rs;
	        }
	        else
	        	System.out.println("Árboles no encontrados...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta de árboles fallida...");
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ResultSet consultarArbolxCliente(long lIdCliente) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from arbol where cliente = " + String.valueOf(lIdCliente));
	        if (rs.next()) {
	        	System.out.println("Arbol encontrado...");
	        	return rs;
	        }
	        else {
	        	System.out.println("Árbol no encontrado...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del árbol fallida...");
			System.out.println(e.getMessage());
		}
		return null;
	}
	public long consultarArbolxCliente2(long lIdPersona) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from arbol");
	        if (rs!=null)
	        	System.out.println("Se encontraron arboles asociados al cliente!");
	        else
	        	System.out.println("No hay arboles asociados al cliente!");
	        while (rs.next()) {
	        	if (rs.getLong(6) == lIdPersona) {//localiza arbol
	        		if (rs.getInt(7) == 1 || rs.getInt(7) == 2) {//hay cupo
	        			return rs.getLong(1);
	        		}
	        		System.out.println("Arbol encontrado...");
	        	}
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta sql fallida...");
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public void borrarArbol(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_arbol(?)");
	        cs.setLong(1, lCodigo);
	        if (cs.execute()) {
	        	System.out.println("Árbol eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Árbol eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el árbol...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el árbol...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del árbol incorrecta...");
			System.out.println(e.getMessage());
		}
	}
}
