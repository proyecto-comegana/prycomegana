package reporteClase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.PersonaModel;
import usuarios.CPersona;

public class PersonaReporte {
	public List<Map<String,?>> buscarTodos(){
		List<Map<String,?>> listaPersonas = new ArrayList<Map<String,?>>();
		PersonaModel personaModel = new PersonaModel();
		for (CPersona p: personaModel.buscarTodos()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("codigo", p.getlPersona());
			m.put("nombres", p.getsNombres());
			m.put("apellidos", p.getsApellidos());
			m.put("direccion", p.getsDireccion());
			m.put("telefono", p.getsTelefono());
			m.put("correo", p.getsCorreo());
			m.put("fechanac", p.getsCorreo());
			m.put("sexo", p.getsSexo());
			m.put("ciudad", p.getsCiudad());
			m.put("fecha", p.getsFecha());
			m.put("hora", p.getsHora());
			listaPersonas.add(m);
		}
		return listaPersonas;
	}
}
