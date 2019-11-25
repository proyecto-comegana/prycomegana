package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class crudCiudad {
	Connection con;
	int iIdDepto;
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
	
	public void crearCiudad(String sNombre, String sDepartamento, String sFecha, String sHora, HttpSession sesion) {
		try {
			//CONSULTAR CODIGO DEPARTAMENTO
			Statement stmntIdDepto = null;
	        stmntIdDepto = con.createStatement();
	        ResultSet rsIdDepto = stmntIdDepto.executeQuery("select * from departamento");
	        int iIdDepto = 0; 
	        while (rsIdDepto.next()) { 
	        	if (rsIdDepto.getString(2).equals(sDepartamento))
	        		iIdDepto = rsIdDepto.getInt(1);
		        else
		        	System.out.println("Departamento no encontrado...");
	        }
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_ciudad(?,?,?,?)");
	        cs.setString(1, sNombre);
	        cs.setInt(2, iIdDepto);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Ciudad insertada exitosamente...");
	        	sesion.setAttribute("mensaje", "Ciudad insertada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar la ciudad...");
	        	sesion.setAttribute("mensaje", "Imposible insertar la ciudad...");
	        }
	        	
	        stmnt.close();//Liberar objeto
	        stmntIdDepto.close();
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void actualizarCiudad(int iCodigo, String sNombre, String sDepartamento, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
			//CONSULTAR CODIGO DEPARTAMENTO
			Statement stmntIdDepto = null;
	        stmntIdDepto = con.createStatement();
	        ResultSet rsIdDepto = stmntIdDepto.executeQuery("select * from departamento");
	        int iIdDepto = 0; 
	        while (rsIdDepto.next()) { 
	        	if (rsIdDepto.getString(2).equals(sDepartamento))
	        		iIdDepto = rsIdDepto.getInt(1);
		        else
		        	System.out.println("Departamento no encontrado...");
	        }
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_ciudad(?,?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sNombre);
	        cs.setInt(3, iIdDepto);
	        cs.setString(4, sFecha);
	        cs.setString(5, sHora);
	        if(cs.execute()) {
		        System.out.println("Ciudad actualizada exitosamente...");
		        sesion.setAttribute("mensaje", "Ciudad actualizada exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar la ciudad...");
		        sesion.setAttribute("mensaje", "Imposible actualizar la ciudad...");
	        }
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación fallida...");
			System.out.println(e.getMessage());
		}
	}

	public void consultarCiudad(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_consultar_ciudad(?)");
	        cs.setInt(1, iCodigo);
	        //Obtiene el conjunto de resultados
	        ResultSet rs = cs.executeQuery();
	        if (rs.next()) {
	        	System.out.println("Ciudad encontrada...");
	        	String datosCiudad = rs.getString(1);
	        	//obtiene codigo
	        	int inicio = 1;
	        	int fin = datosCiudad.indexOf(",");
	        	String codigo = datosCiudad.substring(inicio, fin);
	        	sesion.setAttribute("codigo_ciudad", String.valueOf(codigo));
	        	//obtiene nombre
	        	inicio = fin+1;
	        	fin = datosCiudad.indexOf(",", inicio);
	        	String nombre = datosCiudad.substring(inicio, fin);
	        	//variable de sesion nombre
	        	sesion.setAttribute("nombre_ciudad", nombre);
	        	//obtiene codigo departamento
	        	inicio = fin+1;
	        	fin = datosCiudad.indexOf(",", inicio);
	        	String cod_depto = datosCiudad.substring(inicio, fin);
	        	//variable de sesion nombre
	        	sesion.setAttribute("depto_ciudad", cod_depto);
				//CONSULTAR CODIGO DEPARTAMENTO
				Statement stmntIdDepto = null;
		        stmntIdDepto = con.createStatement();
		        ResultSet rsIdDepto = stmntIdDepto.executeQuery("select * from departamento");
		        iIdDepto = 0; 
		        String sNombreDepto = new String();
		        while (rsIdDepto.next()) { 
		        	if (rsIdDepto.getInt(1) == Integer.parseInt(cod_depto))
		        		sNombreDepto = rsIdDepto.getString(2);
			        else 
			        	System.out.println("Departamento no encontrado...");
		        }
		        sesion.setAttribute("nombre_depto", sNombreDepto);
	        	//obtiene fecha
	        	inicio = fin + 1;
	        	fin = datosCiudad.indexOf(",", inicio);
	        	String fecha = datosCiudad.substring(inicio, fin);
	        	//variable de sesion fecha
	        	sesion.setAttribute("fecha_ciudad", fecha);
	        	//obtiene hora
	        	inicio = fin + 1;
	        	String hora = datosCiudad.substring(inicio, datosCiudad.length()-1);
	        	//variable de sesion hora
	        	sesion.setAttribute("hora_ciudad", hora);
	        }
	        else
	        	System.out.println("Ciudad no encontrada...");
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta fallida...");
			System.out.println(e.getMessage());
		}
	}

	public void borrarCiudad(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_ciudad(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Ciudad eliminada exitosamente...");
	        	sesion.setAttribute("mensaje", "Ciudad eliminada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar la ciudad...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar la ciudad...");
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
