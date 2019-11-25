package conexion;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Controller;

@Controller
public class CrudDepartamento {
	Connection con;
	HttpSession session;
	private int iIdPais;
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
	        //OBTIENE FECHA ACTUAL
	    	LocalDate fecha;
	    	fecha = LocalDate.now();
	    	DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM/dd/YYYY");
	    	String sFechaActual = formateador.format(fecha);
	    	//ESTABLECE HORA ACTUAL CON FORMATO
	    	LocalTime hora;
	    	hora = LocalTime.now();
	    	System.out.println(hora.toString());
	    	DateTimeFormatter formateador1 = DateTimeFormatter.ofPattern("hh:mm");
	    	String sHoraActual = hora.format(formateador1);
			//CAPTURA DEL ERROR EN EL LOG DE FALLOS
			CrudFallo daoFallo = new CrudFallo();
			daoFallo.Conecta();
			daoFallo.crearFallo(e.getMessage(), "/prycomegana/src/main/java/conexion", "CrudDepartamento.java", e.getErrorCode(), sFechaActual, sHoraActual, null);
		}
		return null;
	}
	
	public void crearDepartamento(String sNombre, String sPais, String sFecha, String sHora, HttpSession sesion) {
		try {
			//CONSULTAR CODIGO PAIS
			Statement stmntIdPais = null;
	        stmntIdPais = con.createStatement();
	        ResultSet rsIdPais = stmntIdPais.executeQuery("select * from pais");
	        int iIdPais = 0;
	        while (rsIdPais.next()) { 
	        	if (rsIdPais.getString(2).equals(sPais))
	        		iIdPais = rsIdPais.getInt(1);
	        }
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_departamento(?,?,?,?)");
	        cs.setString(1, sNombre);
	        cs.setInt(2, iIdPais);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Departamento insertado exitosamente...");
	        	sesion.setAttribute("mensaje", "Departamento insertado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible insertar el departamento...");
	        	sesion.setAttribute("mensaje", "Imposible insertar el departamento...");
	        }
	        	
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
	        //OBTIENE FECHA ACTUAL
	    	LocalDate fecha;
	    	fecha = LocalDate.now();
	    	DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM/dd/YYYY");
	    	String sFechaActual = formateador.format(fecha);
	    	//ESTABLECE HORA ACTUAL CON FORMATO
	    	LocalTime hora;
	    	hora = LocalTime.now();
	    	System.out.println(hora.toString());
	    	DateTimeFormatter formateador1 = DateTimeFormatter.ofPattern("hh:mm");
	    	String sHoraActual = hora.format(formateador1);
			//CAPTURA DEL ERROR EN EL LOG DE FALLOS
			CrudFallo daoFallo = new CrudFallo();
			daoFallo.Conecta();
			daoFallo.crearFallo(e.getMessage(), "/prycomegana/src/main/java/conexion", "CrudDepartamento.java", e.getErrorCode(), sFechaActual, sHoraActual, null);
		}
	}

	public void borrarDepartamento(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_departamento(?)");
	        cs.setInt(1, iCodigo);
	        if (cs.execute()) {
	        	System.out.println("Departamento eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Departamento eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el departamento...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el departamento...");
	        }
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Eliminación fallida...");
			System.out.println(e.getMessage());
	        //OBTIENE FECHA ACTUAL
	    	LocalDate fecha;
	    	fecha = LocalDate.now();
	    	DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM/dd/YYYY");
	    	String sFechaActual = formateador.format(fecha);
	    	//ESTABLECE HORA ACTUAL CON FORMATO
	    	LocalTime hora;
	    	hora = LocalTime.now();
	    	System.out.println(hora.toString());
	    	DateTimeFormatter formateador1 = DateTimeFormatter.ofPattern("hh:mm");
	    	String sHoraActual = hora.format(formateador1);
			//CAPTURA DEL ERROR EN EL LOG DE FALLOS
			CrudFallo daoFallo = new CrudFallo();
			daoFallo.Conecta();
			daoFallo.crearFallo(e.getMessage(), "/prycomegana/src/main/java/conexion", "CrudDepartamento.java", e.getErrorCode(), sFechaActual, sHoraActual, null);
		}
	}
	
	public void actualizarDepartamento(int iCodigo, String sNombre, String sPais, String sFecha, String sHora, HttpSession sesion) {
		try {
			//CONSULTAR CODIGO PAIS
			Statement stmntIdPais = null;
	        stmntIdPais = con.createStatement();
	        ResultSet rsIdPais = stmntIdPais.executeQuery("select * from pais");
	        iIdPais = 0;
	        while (rsIdPais.next()) { 
	        	if (rsIdPais.getString(2).equals(sPais))
	        		iIdPais = rsIdPais.getInt(1);
	        }
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_departamento(?,?,?,?,?)");
	        cs.setInt(1, iCodigo);
	        cs.setString(2, sNombre);
	        cs.setInt(3, iIdPais);
	        cs.setString(4, sFecha);
	        cs.setString(5, sHora);
	        if(cs.execute()) {
		        System.out.println("Departamento actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Departamento actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el departamento...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el departamento...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación fallida...");
			System.out.println(e.getMessage());
	        //OBTIENE FECHA ACTUAL
	    	LocalDate fecha;
	    	fecha = LocalDate.now();
	    	DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM/dd/YYYY");
	    	String sFechaActual = formateador.format(fecha);
	    	//ESTABLECE HORA ACTUAL CON FORMATO
	    	LocalTime hora;
	    	hora = LocalTime.now();
	    	System.out.println(hora.toString());
	    	DateTimeFormatter formateador1 = DateTimeFormatter.ofPattern("hh:mm");
	    	String sHoraActual = hora.format(formateador1);
	    	
	    	//CAPTURA DEL ERROR EN EL LOG DE FALLOS
			CrudFallo daoFallo = new CrudFallo();
			daoFallo.Conecta();
			
			daoFallo.crearFallo(e.getMessage(), "/prycomegana/src/main/java/conexion", "CrudDepartamento.java", e.getErrorCode(), sFechaActual, sHoraActual, null);
		}
	}

	public void consultarDepartamento(int iCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_consultar_departamento(?)");
	        cs.setInt(1, iCodigo);
	        //Obtiene el conjunto de resultados
	        ResultSet rs = cs.executeQuery();
	        if (rs.next()) {
	        	System.out.println("Registro encontrado...");
	        	String datosDepto = rs.getString(1);
	        	//obtiene codigo
	        	int inicio = 1;
	        	int fin = datosDepto.indexOf(",");
	        	String codigo = datosDepto.substring(inicio, fin);
	        	//System.out.println("*****Tabla pais*****");
	        	//variable de sesion pais
	        	sesion.setAttribute("codigo_depto", String.valueOf(codigo));
	        	//obtiene nombre
	        	inicio = fin+1;
	        	fin = datosDepto.indexOf(",", inicio);
	        	String nombre = datosDepto.substring(inicio, fin);
	        	//variable de sesion nombre
	        	sesion.setAttribute("nombre_depto", nombre);
	        	//obtiene nombre
	        	inicio = fin+1;
	        	fin = datosDepto.indexOf(",", inicio);
	        	String idDepto = datosDepto.substring(inicio, fin);
	        	//variable de sesion nombre
	        	sesion.setAttribute("pais_depto", idDepto);

	        	//CONSULTAR CODIGO DEL PAIS
				Statement stmntIdPais = null;
		        stmntIdPais = con.createStatement();
		        ResultSet rsIdPais = stmntIdPais.executeQuery("select * from pais");
		        iIdPais = 0; 
		        String sNombrePais = new String();
		        while (rsIdPais.next()) 
		        	if (rsIdPais.getInt(1) == Integer.parseInt(idDepto))
		        		sNombrePais = rsIdPais.getString(2);
		        sesion.setAttribute("nombre_pais", sNombrePais);

	        	//obtiene fecha
	        	inicio = fin + 1;
	        	fin = datosDepto.indexOf(",", inicio);
	        	String fecha = datosDepto.substring(inicio, fin);
	        	//variable de sesion fecha
	        	sesion.setAttribute("fecha_depto", fecha);
	        	//obtiene hora
	        	inicio = fin + 1;
	        	String hora = datosDepto.substring(inicio, datosDepto.length()-1);
	        	sesion.setAttribute("hora_depto", hora);
	        }
	        else
	        	System.out.println("Registro no encontrado...");
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta fallida...");
			System.out.println(e.getMessage());
	        //OBTIENE FECHA ACTUAL
	    	LocalDate fecha;
	    	fecha = LocalDate.now();
	    	DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM/dd/YYYY");
	    	String sFechaActual = formateador.format(fecha);
	    	//ESTABLECE HORA ACTUAL CON FORMATO
	    	LocalTime hora;
	    	hora = LocalTime.now();
	    	System.out.println(hora.toString());
	    	DateTimeFormatter formateador1 = DateTimeFormatter.ofPattern("hh:mm");
	    	String sHoraActual = hora.format(formateador1);
			//OBTENER RUTA ACTUAL
	        File miDir = new File (".");
	    	//CAPTURA DEL ERROR EN EL LOG DE FALLOS
			CrudFallo daoFallo = new CrudFallo();
			daoFallo.Conecta();
			daoFallo.crearFallo(e.getMessage(), "/prycomegana/src/main/java/conexion", "CrudDepartamento.java", e.getErrorCode(), sFechaActual, sHoraActual, null);
		}
	}
	public List<String> listarDepartamentos (){
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from departamento");
			List<String> listaDepartamentos = new ArrayList<String>();
	        while (rs.next())
  		        	listaDepartamentos.add(rs.getString(2));
			return listaDepartamentos;
		}catch(Exception e) {
			System.out.println("Consulta del persona fallida...");
			System.out.println(e.getMessage());
			return null;
		}		
	}
}