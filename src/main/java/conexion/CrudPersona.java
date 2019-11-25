package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CrudPersona {
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
	public void crearPersona(String sNombres, String sApellidos,String sDireccion, String sTelefono, String sCorreo, 
			String sFecha_Nac, String sSexo, String sCiudad, String sFecha, String sHora, String sOrigen,HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_persona(?,?,?,?,?,?,?,?,?,?)");
	        cs.setString(1, sNombres);
	        sesion.setAttribute("nombres_persona",sNombres);
	        cs.setString(2, sApellidos);
	        sesion.setAttribute("apellidos_persona",sApellidos);
	        cs.setString(3, sDireccion);
	        cs.setString(4, sTelefono);
	        cs.setString(5, sCorreo);
	        cs.setString(6, sFecha_Nac);
	        cs.setString(7, sSexo);
			//CONSULTAR CODIGO CIUDAD
			Statement stmntIdDepto = null;
	        stmntIdDepto = con.createStatement();
	        ResultSet rsIdCiudad = stmntIdDepto.executeQuery("select * from ciudad");
	        int iIdCiudad = 0; 
	        while (rsIdCiudad.next()) { 
	        	if (rsIdCiudad.getString(2).equals(sCiudad))
	        		iIdCiudad = rsIdCiudad.getInt(1);
		        else
		        	System.out.println("Ciudad no encontrada...");
	        }
	        cs.setInt(8, iIdCiudad);
	        cs.setString(9, sFecha);
	        cs.setString(10, sHora);
	        
	        if (cs.execute()) {
	        	if (sOrigen.equals("reg_per")) { 
	        		sesion.setAttribute("res_reg_per", "true");
	        		String resultado = String.valueOf(sesion.getAttribute("res_reg_per"));
	        		System.out.println("Resultado de registrar la persona = "+ resultado);
	        		System.out.println("Persona insertada exitosamente...");
	        	}
	        	if  (sOrigen.equals("afil_per")) { 
		        	sesion.setAttribute("res_afil_person", "true");	        		
		        	System.out.println("Persona insertada exitosamente...");
		        	sesion.setAttribute("msj_afil_per", "Persona insertada exitosamente...");
	        	}
	        	//OBTIENE EL CODIGO DE LA PERSONA
	        	
	        }
	        else {
	        	if (sOrigen.equals("reg_per"))
		        	sesion.setAttribute("res_reg_per", "false");
	        	if  (sOrigen.equals("afil_per")) 
		        	sesion.setAttribute("res_afil_person","false");
        		System.out.println("Imposible insertar la persona...");
	        	sesion.setAttribute("msj_afil_per", "Imposible insertar la persona...");
	        }
    	
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	@RequestMapping(value = "consultarPersona", method = RequestMethod.GET)
	public void consultarPersona(long lPersona, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from persona where codigo = " + String.valueOf(lPersona));
	        if (rs.next()) {
	        	System.out.println("Persona encontrada...");
	        	sesion.setAttribute("codigo_persona", rs.getLong(1));
	        	sesion.setAttribute("nombre_persona", rs.getString(2));
	        	sesion.setAttribute("apel_persona", rs.getString(3));
	        	sesion.setAttribute("dir_persona", rs.getString(4));
	        	sesion.setAttribute("tel_persona", rs.getString(5));
	        	sesion.setAttribute("correo_persona", rs.getString(6));
	        	sesion.setAttribute("fnac_persona", rs.getString(7));
	        	sesion.setAttribute("sexo_persona", rs.getString(8));
	        	sesion.setAttribute("ciudad_persona", rs.getString(9));
	        	sesion.setAttribute("fecha_persona", rs.getString(10));
	        	sesion.setAttribute("hora_persona", rs.getString(11));
	        }
	        else
	        	System.out.println("Persona no encontrada...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del persona fallida...");
			System.out.println(e.getMessage());
		}
	}

	public ResultSet consultarPersonas(){
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from persona");
	        if (rs!=null) {
	        	return rs;
	        }
	        else
	        	System.out.println("Persona no encontrada...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del persona fallida...");
			System.out.println(e.getMessage());
		}
		return null;
	}

	public long consultarPersonaxNombre(String sNombres, String sApellidos){
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from persona");
	        while (rs.next()) {
	        	if (rs.getString(2).equals(sNombres) && rs.getString(3).equals(sApellidos)) {
	        		return rs.getLong(1);
	        	}
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta de la persona fallida...");
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	
	public void actualizarPersona(long lPersona, String sNombres, String sApellidos,String sDireccion, String sTelefono, 
			String sCorreo, String sFecha_Nac, String sSexo, String sCiudad, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_persona(?,?,?,?,?,?,?,?,?,?,?)");
	        cs.setLong(1, lPersona);
	        cs.setString(2, sNombres);
	        cs.setString(3, sApellidos);
	        cs.setString(4, sDireccion);
	        cs.setString(5, sTelefono);
	        cs.setString(6, sCorreo);
	        cs.setString(7, sFecha_Nac);
	        cs.setString(8, sSexo);
			//CONSULTAR CODIGO CIUDAD
			Statement stmntIdDepto = null;
	        stmntIdDepto = con.createStatement();
	        ResultSet rsIdCiudad = stmntIdDepto.executeQuery("select * from ciudad");
	        int iIdCiudad = 0; 
	        while (rsIdCiudad.next()) { 
	        	if (rsIdCiudad.getString(2).equals(sCiudad))
	        		iIdCiudad = rsIdCiudad.getInt(1);
		        else
		        	System.out.println("Ciudad no encontrada...");
	        }
	        cs.setInt(9, iIdCiudad);
	        cs.setString(10, sFecha);
	        cs.setString(11, sHora);
	        if(cs.execute()) {
		        System.out.println("Persona actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Persona actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar la persona...");
		        sesion.setAttribute("mensaje", "Imposible actualizar la persona...");
	        }
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación de la persona fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarPersona(long lPersona, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_persona(?)");
	        cs.setLong(1, lPersona);
	        if (cs.execute()) {
	        	System.out.println("Persona eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Persona eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar la persona...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar la persona...");
	        }
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Eliminación de la persona fallida...");
			System.out.println(e.getMessage());
		}
	}
}
