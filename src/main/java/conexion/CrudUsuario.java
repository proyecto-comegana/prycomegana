package conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class CrudUsuario {
	Connection con;
	private CrudArbol conexArbol;
    private long lIdPersona = 0;
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
	public void crearUsuario(String sNombreUsuario, String sContrasena, String sTipo, long lPersona, String sFecha, String sHora, String sOrigen, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_crear_usuario(?,?,?,?,?,?)");
	        cs.setString(1, sNombreUsuario);
	        cs.setString(2, sContrasena);
	        //CONVIERTE NOMBRE TIPO USUARIO A CODIGO
	        int iTipo = 0;
	        if (sTipo.equals("Administrador"))
	        	iTipo = 1;
	        if (sTipo.equals("Empleado"))
        		iTipo = 2;
	        if (sTipo.equals("Propietario de restaurante"))
        		iTipo = 3;
	        if (sTipo.equals("Comensal"))
        		iTipo = 4;
	        cs.setInt(3, iTipo);
	        cs.setLong(4, lPersona);
	        cs.setString(5, sFecha);
	        cs.setString(6, sHora);
	        long lIdArbol = 0;
	        if (cs.execute()) {
	        	//CREA EL USUARIO EN LA BASE DE DATOS
	        	crearUsuarioEnBaseDatos(sNombreUsuario, sTipo);
	        	System.out.println("Usuario creado exitosamente...");
	        	if (sOrigen.contentEquals("reg_usuar")) { 
	        		sesion.setAttribute("res_reg_usuar", "true");
	        		//CREAR ARBOL
	        		String resAgregarPersona = String.valueOf(sesion.getAttribute("res_reg_per"));
	        		String resAgregarUsuario = String.valueOf(sesion.getAttribute("res_reg_usuar"));
        			System.out.println("persona"+ resAgregarPersona+""+" y usuario "+resAgregarUsuario);
	        		if (resAgregarPersona.equals("true") && resAgregarUsuario.contentEquals("true")) {
	        			System.out.println("persona "+ resAgregarPersona+""+" y usuario "+resAgregarUsuario);

	        			//CONSULTA CODIGO PERSONA RECIEN INSERTADA
	        			CrudPersona persona = new CrudPersona();
	        			persona.Conecta();
	        			String sNombres = String.valueOf(sesion.getAttribute("nombres_persona"));
	        			System.out.println(sNombres);
	        			String sApellidos = String.valueOf(sesion.getAttribute("apellidos_persona"));
	        			System.out.println(sApellidos);
	        			lIdPersona = persona.consultarPersonaxNombre(sNombres, sApellidos);
	        			System.out.println("Id persona recien insertada: " + lIdPersona);
	        			//CREAR ARBOL
	        			conexArbol = new CrudArbol();
	        			conexArbol.Conecta();
	        			if (conexArbol.crearArbol(1, 1, sFecha, sHora, lIdPersona, 2, sesion)) {
	        				sesion.setAttribute("Info_arbol", "Arbol creado exitosamente...");
	        			}
	        			//CONSULTA EL CODIGO DEL ARBOL ASOCIADO AL CLIENTE COMENSAL
	        			ResultSet rsArbol = conexArbol.consultarArbolxCliente(lIdPersona);
	        			lIdArbol = rsArbol.getLong(1);
	        			//CREAR NODO
	        			CrudNodo nodo = new CrudNodo();
	        			nodo.Conecta();
	        			if (nodo.crearNodo(lIdPersona, lIdArbol, 1, "Activo", 1, sFecha, sHora, sesion)) {
	        				System.out.println("Nodo creado exitosamente...");
	        				sesion.setAttribute("Info_nodo", "Nodo creado exitosamente...");
	        			}
	        			//INSERTAR EL CLIENTE
	        			CrudCliente cliente = new CrudCliente();
	        			cliente.Conecta();
	        			if (cliente.crearCliente(Long.valueOf(String.valueOf(sesion.getAttribute("cedula_cliente_hijo"))), 
	        					lIdArbol, 1, 0, lIdPersona, 0, 0, 0, sFecha, sHora, sesion)) {
	        				System.out.println("Cliente creado exitosamente...");
	        				sesion.setAttribute("Info_cliente", "Cliente creado exitosamente...");
	        			}
	        			//INSERTAR Y RELACIONAR EN NODO-ARBOL
	        			CrudNodoArbol nodoArbol = new CrudNodoArbol();
	        			nodoArbol.Conecta();
	        			//CONSULTAR CODIGO DEL NODO
 	        			ResultSet rsNodo = nodo.consultarNodoxCliente(lIdPersona);
	        			long lIdNodo = rsNodo.getLong(1);
	        			if (nodoArbol.crearNodoArbol(lIdNodo, lIdArbol, sFecha, sHora, sesion)) {
	        				System.out.println("Nodo y árbol creado exitosamente...");
	        				sesion.setAttribute("Info_NodoArbol", "Nodo y árbol creado exitosamente...");
	        			}
	        		}
	        	}//cierra reg_usuar
	        	if  (sOrigen.equals("afil_usuar")) {
		        	sesion.setAttribute("res_afil_usuar", "true");
		        	System.out.println("Resutado de afiliar usuario: "+String.valueOf(sesion.getAttribute("res_afil_usuar")));
		        	//ASOCIAR NUEVO CLIENTE A UN ARBOL
	        		String resAgregarAfiliacion = String.valueOf(sesion.getAttribute("res_reg_afil"));
	        		String resAgregarPersonaAf = String.valueOf(sesion.getAttribute("res_afil_person"));
	        		String resAgregarUsuarioAf = String.valueOf(sesion.getAttribute("res_afil_usuar"));
	        		System.out.println("Afiliacion: "+String.valueOf(sesion.getAttribute("res_reg_afil")));
	        		System.out.println("Persona: "+String.valueOf(sesion.getAttribute("res_afil_person")));
	        		System.out.println("Usuario: "+String.valueOf(sesion.getAttribute("res_afil_usuar")));
	        		if (resAgregarAfiliacion.equals("true") && resAgregarPersonaAf.equals("true") && resAgregarUsuarioAf.equals("true")) {
	        			System.out.println("Dentro...");
	        			//CONSULTAR ULTIMO ARBOL DE AFILIACION - VERIFICANDO SI EXISTE UN NODO DISPONIBLE
	        			CrudArbol crudArbol = new CrudArbol();
	        			crudArbol.Conecta();
	        			//SI EXISTE ARBOL CON NODO DISPONIBLE - INSERTAR CLIENTE NUEVO EN EL NODO
	        			ResultSet rsArboles = crudArbol.consultarArboles();
	        			int iCuposArbol = 0;
	        			boolean bArbolConNodoVacio = false;
	        			lIdArbol = 0;
	        			while (rsArboles.next()) {
	        				iCuposArbol = rsArboles.getInt(7);
	        				if (iCuposArbol == 1 || iCuposArbol == 2) {
	        					bArbolConNodoVacio = true;
	        					lIdArbol = rsArboles.getLong(1);//TOMA CODIGO ARBOL
	    		        		System.out.println("El código del arbol es: " + lIdArbol);
	    		        		bArbolConNodoVacio = true;
	        					break;
	        				}
	        			}//fin while

	        			//CODIGO PERSONA = CODIGO CLIENTE PADRE
	        			//BUSCAR PRIMER ARBOL EN LA TABLA UN ARBOL CON CUPOS - USAR CODIGO CLIENTE PADRE
	        			CrudArbol arbol = new CrudArbol();
	        			arbol.Conecta();
	        			CrudPersona person = new CrudPersona();
	        			person.Conecta();
	        			
	        			long lIdPersonaPadre = person.consultarPersonaxNombre(String.valueOf(sesion.getAttribute("nombres_persona")),
	        					String.valueOf(sesion.getAttribute("apellidos_persona")));
	        			System.out.println("Codigo persona padre: " + lIdPersonaPadre);
	        			System.out.println("Codigo arbol: " + lIdArbol);
	        			
	        			if (bArbolConNodoVacio) {
		        			//CONSULTAR TABLA NODOS CON #CLIENTE Y #ARBOL
	        				CrudNodo daoNodo = new CrudNodo();
	        				daoNodo.Conecta();
	        				int iSiguienteNodoVacio = daoNodo.consultarSiguienteNodoVacio2(lIdArbol, lIdPersonaPadre);
	        				System.out.println("El código del nodo disponible es: " + iSiguienteNodoVacio);
	        				//VERIFICA QUE CLIENTE NO TENGA MAS DE DOS NODOS HIJOS POR ARBOL Y UNO PADRE - TOTAL 3
	        				boolean bMasdeTresNodos = false;
	        				if (daoNodo.contarNodosClientexArbol(lIdArbol, lIdPersonaPadre) > 3)
	        					bMasdeTresNodos = true;
	        				System.out.println("Mas de tres nodos: " + bMasdeTresNodos);
	        				if (!bMasdeTresNodos) {
	        					//VALIDAR POSICION DEL NODO - PARA EVITAR POSICIONES REPETIDAS
	        					boolean bPosicionRepetida = false;
	        					bPosicionRepetida = daoNodo.encontroPosicionNodoRepetida(lIdArbol, lIdPersonaPadre, iSiguienteNodoVacio);
	        					System.out.println("Posicion repetida: " + bPosicionRepetida);
	        					if (!daoNodo.encontroPosicionNodoRepetida(lIdArbol, lIdPersonaPadre, iSiguienteNodoVacio)) {
	        						//CONSULTA NIVEL DEL ARBOL DONDE CREAR NUEVO NODO
	        	        			if (iSiguienteNodoVacio < 32) {
	        	        				int iNivel = 0;
	        		        			boolean bNodoMayora31 = false;
	        	        				if (iSiguienteNodoVacio == 1) {
	        		        				iNivel = 1;
	        		        			}
	        		        			else if (iSiguienteNodoVacio >=2 && iSiguienteNodoVacio <=3) {
	        		        				iNivel = 2;
	        		        			}
	        		        			else if (iSiguienteNodoVacio >=4 && iSiguienteNodoVacio<=7) {
	        		        				iNivel = 3;
	        		        			}
	        		        			else if (iSiguienteNodoVacio >=8 && iSiguienteNodoVacio<=15) {
	        		        				iNivel = 4;
	        		        			}
	        		        			else if (iSiguienteNodoVacio >=16 && iSiguienteNodoVacio<=31) {
	        		        				iNivel = 5;
	        		        			}
	        		        			else {
	        		        				System.out.println("Nivel no permitido!");
	        		        				bNodoMayora31 = true;
	        		        			}
	        	        				System.out.println("Nivel del nodo: " + iNivel);
	        	        				System.out.println("#Nodo mayor a 31: " + bNodoMayora31);
	        		        			if (!bNodoMayora31) {
	        		        				//CREAR NODO
	        		        				CrudNodo daoNodo2 = new CrudNodo();
	        		        				daoNodo2.Conecta();
	        		        				boolean bNodoInsertadoOK = false;
	        			        			if (daoNodo2.crearNodo(Long.valueOf(String.valueOf(sesion.getAttribute("cedula_cliente_hijo"))), lIdArbol, iSiguienteNodoVacio, "Activo", iNivel, sFecha, sHora, sesion)){
	        			        				sesion.setAttribute("Info_nodo", "Nodo creado exitosamente...");
	        			        				bNodoInsertadoOK = true;
        			        				}
        			        				if (bNodoInsertadoOK) {
        					        			//OBTIENE EL PREDECESOR
        					        			int iPredecesor = 0;
        					        			boolean bSalirForExterno = false;
        					        			int iContador = 0;
        					        			for (int i = 1; i <=15;i++) {
        					        				for (int j=1;j<=2;j++) {
        					        					if (j==2)
        					        						iPredecesor = i;
        					        					iContador++;
        					        					if (iContador == iSiguienteNodoVacio) {
        					        						bSalirForExterno = true;
        					        						break;
        					        					}
        					        				}
        					        				if (bSalirForExterno)
        					        					break;
        					        			}//fin for externo
        					        			System.out.println("Predecesor: " + iPredecesor);
        					        			//INSERTAR EL CLIENTE
        					        			CrudCliente cliente = new CrudCliente();
        					        			cliente.Conecta();
        					        			System.out.println(sesion.getAttribute("cedula_cliente_hijo"));
        					        			if (cliente.crearCliente(Long.valueOf(String.valueOf(sesion.getAttribute("cedula_cliente_hijo"))), 
        					        					lIdArbol, iNivel, iPredecesor, lIdPersona, 0, 0, 0, sFecha, sHora, sesion)) {
        					        				sesion.setAttribute("Info_cliente","Cliente insertado exitosamente...");
        						        			//INSERTAR Y RELACIONAR EN NODO-ARBOL
        						        			CrudNodoArbol nodoArbol = new CrudNodoArbol();
        						        			nodoArbol.Conecta();
        						        			//CONSULTAR CODIGO DEL NODO
        						        			CrudNodo daoNodo3 = new CrudNodo();
        						        			daoNodo3.Conecta();
        					 	        			ResultSet rsNodo = daoNodo3.consultarNodoxCliente(Long.valueOf(String.valueOf(sesion.getAttribute("cedula_cliente_hijo"))));
        					 	        			long lIdNodo = rsNodo.getLong(1);
        						        			if (nodoArbol.crearNodoArbol(lIdNodo, lIdArbol, sFecha, sHora, sesion))
        						        				sesion.setAttribute("Info_NodoArbol", "Nodo y árbol creado exitosamente...");
        					        			}
    			
        			        				}
	        		        			}
	        	        			}
	        					}
	        				}
	        			}
	        			
	        		}
	        	}
	        }	
	        //AQUI SE ASOCIA EL NUEVO CLIENTE AL ARBOL - ENLAZAR PADRE A HIJO
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public boolean crearUsuarioEnBaseDatos(String sNombreUsuario, String sTipo) {
		try {
			System.out.println("Dentro de crear usuario bd");
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //CREA USUARIO CON CREDENCIALES
	        ResultSet rsUser = stmnt.executeQuery("CREATE USER " + sNombreUsuario);
	        if (rsUser != null)
	        	return true;
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Creación de usuario fallida...");
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void actualizarUsuario(long lCodigo, String sNombreUsuario, String sContrasena, String sTipo, long lPersona, String sFecha, String sHora, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_modificar_usuario(?,?,?,?,?,?,?)");
	        cs.setLong(1, lCodigo);
	        cs.setString(2, sNombreUsuario);
	        cs.setString(3, sContrasena);
	        //CONVIERTE NOMBRE TIPO USUARIO A CODIGO
	        int iTipo = 0;
	        if (sTipo.equals("Administrador"))
	        	iTipo = 1;
	        if (sTipo.equals("Empleado"))
        		iTipo = 2;
	        if (sTipo.equals("Propietario de restaurante"))
        		iTipo = 3;
	        if (sTipo.equals("Comensal"))
        		iTipo = 4;
	        cs.setInt(4, iTipo);
	        cs.setLong(5, lPersona);
	        cs.setString(6, sFecha);
	        cs.setString(7, sHora);
	        if(cs.execute()) {
		        System.out.println("Usuario actualizado exitosamente...");
		        sesion.setAttribute("mensaje", "Usuario actualizado exitosamente...");
	        }
	        else {
		        System.out.println("Imposible actualizar el usuario...");
		        sesion.setAttribute("mensaje", "Imposible actualizar el usuario...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Modificación del usuario fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void consultarUsuario(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from usuario where codigo = " + String.valueOf(lCodigo));
	        if (rs.next()) {
	        	System.out.println("Usuario encontrado...");
	        	sesion.setAttribute("codigo_usuario", rs.getLong(1));
	        	sesion.setAttribute("nomusua_usuario", rs.getString(2));
	        	sesion.setAttribute("contra_usuario", rs.getString(3));
	        	sesion.setAttribute("tipo_usuario", rs.getInt(4));
	        	sesion.setAttribute("persona_usuario", rs.getLong(5));
	        	sesion.setAttribute("fecha_usuario", rs.getString(6));
	        	sesion.setAttribute("hora_usuario", rs.getString(7));
	        }
	        else
	        	System.out.println("Usuario no encontrado...");
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del usuario fallida...");
			System.out.println(e.getMessage());
		}
	}
	public void borrarUsuario(long lCodigo, HttpSession sesion) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = con.prepareCall("select proc_borrar_usuario(?)");
	        cs.setLong(1, lCodigo);
	        if (cs.execute()) {
	        	System.out.println("Usuario eliminado exitosamente...");
	        	sesion.setAttribute("mensaje", "Usuario eliminado exitosamente...");
	        }
	        else {
	        	System.out.println("Imposible eliminar el usuario...");
	        	sesion.setAttribute("mensaje", "Imposible eliminar el usuario...");
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion
		}catch(SQLException e) {
			System.out.println("Eliminación del usuario fallida...");
			System.out.println(e.getMessage());
		}
	}
	public String consultarTipoUsuario(String sNombreUsuario, String sContrasena) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select nombreusuario, contrasena, tipo from usuario");
	        while (rs.next()) {
	        	if (rs.getString(1).equals(sNombreUsuario) && rs.getString(2).equals(sContrasena)) {
	    	        String sTipo = "";
	    	        if (rs.getInt(3) == 1)
	    	        	sTipo = "Administrador";
	    	        if (rs.getInt(3) == 2)
	            		sTipo = "Empleado";
	    	        if (rs.getInt(3) == 3)
	            		sTipo = "Propietario de restaurante";
	    	        if (rs.getInt(3) == 4)
	            		sTipo = "Comensal";
	        		return sTipo;
	        	}
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del usuario fallida...");
			System.out.println(e.getMessage());
		}
		return "";
	}
	public long consultarCodigoUsuario(String sNombreUsuario, String sContrasena) {
		try {
	        Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select codigo, nombreusuario, contrasena from usuario");
	        while (rs.next()) {
	        	if (rs.getString(2).equals(sNombreUsuario) && rs.getString(3).equals(sContrasena)) {
	        		return rs.getLong(1);
	        	}
	        }
	        stmnt.close();//Liberar objeto
	        con.close();//Cierra conexion.
		}catch(SQLException e) {
			System.out.println("Consulta del usuario fallida...");
			System.out.println(e.getMessage());
		}
		return 0;
	}
}
