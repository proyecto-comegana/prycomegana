package modelo;

import usuarios.CPersona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import conexion.CrudPersona;

public class PersonaModel {
	public List<CPersona> buscarTodos(){
		try {
			List<CPersona> listaPersonas = new ArrayList<CPersona>();
			CrudPersona persona = new CrudPersona();
			persona.Conecta();
			ResultSet rs = persona.consultarPersonas();
			while (rs.next()) {
				listaPersonas.add(new CPersona(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),
						rs.getString(11)));
			}
			return listaPersonas;			
		}
		catch(SQLException e) {
			System.out.println("Consulta del persona fallida...");
			System.out.println(e.getMessage());
		}
		return null;
	}
}
