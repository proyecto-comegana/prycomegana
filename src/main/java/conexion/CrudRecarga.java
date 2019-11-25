package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudRecarga {
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

	public void crearRecarga(long lCliente, long lValor, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_recarga(?,?,?,?)");
	        cs.setLong(1, lCliente);
	        cs.setLong(2, lValor);
	        cs.setString(3, sFecha);
	        cs.setString(4, sHora);
	        if (cs.execute()) {
	        	System.out.println("Recarga insertada exitosamente...");
	        	sesion.setAttribute("mensaje", "Recarga insertada exitosamente...");
	        	long lBonificacion = 0;
	        	long lBonificacionEnCoins = 0;
	        	//1 COIN EQUIVALE A $1000 PESOS COLOMBIANOS
	        	//GENERAR BONIFICACIONES
	        	if (lValor == 50000) {
	        		lBonificacion = 10000;
	        	}
	        	else if (lValor == 100000)
	        		lBonificacion = 25000;
	        	else if (lValor == 200000) 
	        		lBonificacion = 60000;
	        	else if (lValor == 300000)
	        		lBonificacion = 70000;
	        	else if (lValor == 500000)
	        		lBonificacion = 100000;
	        	if (lBonificacion > 0) {
	        		lBonificacionEnCoins = lBonificacion/1000;
	        		CrudBonificacion daoBonificacion = new CrudBonificacion();
	        		daoBonificacion.Conecta();
	        		daoBonificacion.crearBonificacion(lCliente, lBonificacion, sFecha, sHora, sesion);
	        	}
	        	//GENERAR PREMIOS VALORES SUPERIORES A 1 MILLON
	        	long lPremio = 0;
	        	String sPremio = new String();
	        	if (lValor == 1000000) {
	        		lPremio = 180000;
	        		sPremio = "Bicicleta";
	        	}
	        	else if (lValor == 1500000) {
	        		lPremio = 300000;
	        		sPremio = "Celular";	        		
	        	}
	        	else if (lValor == 2000000) { 
	        		lPremio = 450000;
	        		sPremio = "Tablet";	        		
	        	}
	        	else if (lValor == 2500000) {
	        		lPremio = 600000;
	        		sPremio = "Miniportatil";
	        	}
	        }
	        else {
	        	System.out.println("Imposible insertar la recarga...");
	        	sesion.setAttribute("mensaje", "Imposible insertar la recarga...");
	        }
	        	
	        stmnt.close();//Liberar objeto
	        //con.commit();//Confirma cambios en bd
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void consultarRecarga(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_consultar_recarga(?)");
	        cs.setLong(1, lCodigo);
	        //Obtiene el conjunto de resultados
	        ResultSet rs = cs.executeQuery();
	        if (rs.next()) {
	        	System.out.println("Recarga encontrada...");
	        	String datosRecarga = rs.getString(1);
	        	//obtiene codigo
	        	int inicio = 1;
	        	int fin = datosRecarga.indexOf(",");
	        	String codigo = datosRecarga.substring(inicio, fin);
	        	sesion.setAttribute("codigo_recarga", String.valueOf(codigo));
	        	//obtiene nombre
	        	inicio = fin+1;
	        	fin = datosRecarga.indexOf(",", inicio);
	        	String cliente = datosRecarga.substring(inicio, fin);
	        	//variable de sesion nombre
	        	sesion.setAttribute("cliente_recarga", cliente);
	        	//obtiene codigo departamento
	        	inicio = fin+1;
	        	fin = datosRecarga.indexOf(",", inicio);
	        	String valor = datosRecarga.substring(inicio, fin);
	        	//variable de sesion nombre
	        	sesion.setAttribute("valor_recarga", valor);
	        	//obtiene fecha
	        	inicio = fin + 1;
	        	fin = datosRecarga.indexOf(",", inicio);
	        	String fecha = datosRecarga.substring(inicio, fin);
	        	//variable de sesion fecha
	        	sesion.setAttribute("fecha_recarga", fecha);
	        	//obtiene hora
	        	inicio = fin + 1;
	        	String hora = datosRecarga.substring(inicio, datosRecarga.length()-1);
	        	//variable de sesion hora
	        	sesion.setAttribute("hora_recarga", hora);
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

	public void borrarRecarga(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //con.setAutoCommit(false);//Confirmar cambios en la bd manualmente
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_recarga(?)");
	        cs.setLong(1, lCodigo);
	        if (cs.execute()) {
	        	System.out.println("Recarga eliminada exitosamente...");
	        	sesion.setAttribute("mensaje", "Recarga eliminada exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar la recarga...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar la recarga...");
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
