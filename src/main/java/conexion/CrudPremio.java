package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudPremio {
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
	public void crearPremio(String sDescripcion, long lValor,String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_premios(?,?,?,?)");
	        cs.setString(1, sDescripcion);
	        cs.setLong(2, lValor);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Premio insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Premio insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el premio...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el premio...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void consultarPremio(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_consultar_premio(?)");
	        cs.setInt(1, iCodigo);
	        //Obtiene el conjunto de resultados
	        ResultSet rs = cs.executeQuery();
	        if (rs.next()) {
	        	System.out.println("Premio encontrado...");
	        	String datosPremio = rs.getString(1);
	        	//obtiene codigo
	        	int inicio = 1;
	        	int fin = datosPremio.indexOf(",");
	        	String codigo = datosPremio.substring(inicio, fin);
	        	sesion.setAttribute("codigo_premio", String.valueOf(codigo));
	        	//obtiene descripcion
	        	inicio = fin+1;
	        	fin = datosPremio.indexOf(",", inicio);
	        	String descrip = datosPremio.substring(inicio, fin);
	        	//variable de sesion descripcion
	        	sesion.setAttribute("descrip_premio", descrip);
	        	//obtiene valor premio
	        	inicio = fin+1;
	        	fin = datosPremio.indexOf(",", inicio);
	        	String valor = datosPremio.substring(inicio, fin);
	        	//variable de sesion nombre
	        	sesion.setAttribute("valor_premio", valor);
	        	//obtiene fecha
	        	inicio = fin + 1;
	        	fin = datosPremio.indexOf(",", inicio);
	        	String fecha = datosPremio.substring(inicio, fin);
	        	//variable de sesion fecha
	        	sesion.setAttribute("fecha_premio", fecha);
	        	//obtiene hora
	        	inicio = fin + 1;
	        	String hora = datosPremio.substring(inicio, datosPremio.length()-1);
	        	//variable de sesion hora
	        	sesion.setAttribute("hora_premio", hora);
	        }
	        else
	        	System.out.println("Premio no encontrado...");
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void actualizarPremio(int iCodigo, String sDescripcion, long lValor, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_premio(?,?,?,?,?)");
	        cs.setLong(1, iCodigo);
	        cs.setString(2, sDescripcion);
	        cs.setLong(3, lValor);
	        cs.setString(4, sFecha);
	        cs.setString(5, sHora);
	        if(cs.execute()) {
		        System.out.println("Premio actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Premio actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el premio...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el premio...");
	        }
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación fallida...");
			System.out.println(e.getMessage());
		}
	}
	private String consultarNombrePremio(long lValor) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select descripcion, valor from premios");
	        while (rs.next()) {
	        	System.out.println("Premio encontrado...");
	        	if (rs.getLong(2) == lValor) {
	        		return rs.getString(1);
	        	}
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Consulta del premio fallida...");
			System.out.println(e.getMessage());
		}
		return "";
	}

	public void borrarPremio(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_premio(?)");
	        cs.setLong(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Premio eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Premio eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el premio...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el premio...");
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
