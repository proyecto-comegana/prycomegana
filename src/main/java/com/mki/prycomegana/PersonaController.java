package com.mki.prycomegana;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudPersona;
import usuarios.CPersona;

@Controller
public class PersonaController {
	@RequestMapping(value = "agregarPersona", method = RequestMethod.GET)
	public ModelAndView agregarPersona(Model model) {
		ModelAndView mv = new ModelAndView("agregarPersona", "command", new CPersona());
	    List<String> rolusuario = new ArrayList<String>();
	    rolusuario.add("Administrador");
	    rolusuario.add("Empleado");
	    rolusuario.add("Propietario de restaurante");
	    rolusuario.add("Comensal");
	    model.addAttribute("tipo_usuario", rolusuario);
		mv.setViewName("agregarPersona");
		return mv;
	}

	@RequestMapping(value = "agregarPersonaReg", method = RequestMethod.GET)
	public ModelAndView agregarPersonaReg(Model model) {
		ModelAndView mv = new ModelAndView("agregarPersonaReg", "command", new CPersona());
	    List<String> rolusuario = new ArrayList<String>();
	    rolusuario.add("Administrador");
	    rolusuario.add("Empleado");
	    rolusuario.add("Propietario de restaurante");
	    rolusuario.add("Comensal");
	    model.addAttribute("tipo_usuario", rolusuario);
		mv.setViewName("agregarPersonaReg");
		return mv;
	}

	@RequestMapping(value = "/rAgregarPersona", method = RequestMethod.GET)
    public void guardarPersona(Model model, @Validated CPersona persona, BindingResult result,
    		HttpSession session) { 
          CrudPersona conexPersona = new CrudPersona();
          conexPersona.Conecta();
          /*
           DEFINE CUANDO LA PERSONA ES AGREGADA VIA REGISTRO POR PRIMERA VEZ 
           O POR UNA AFILIACION DE UN CLIENTE QUE YA ESTA REGISTRADO EN EL SISTEMA
           */
          String sOrigen = new String("reg_per"); //NO ESTOY SEGURO SI LA VIA ES REG_PER O AFIL_PER
          conexPersona.crearPersona(persona.getsNombres(),persona.getsApellidos(),persona.getsDireccion(),persona.getsTelefono(),persona.getsCorreo(),persona.getsFecha_Nac(),persona.getsSexo(),persona.getsCiudad(),persona.getsFecha(),persona.getsHora(),sOrigen, session);
     }

	@RequestMapping(value = "actualizarPersona", method = RequestMethod.GET)
	public ModelAndView actualizarPersona() {
		ModelAndView mv = new ModelAndView("actualizarPersona", "command", new CPersona());
		mv.setViewName("actualizarPersona");
		return mv;
	}

	@RequestMapping(value = "/rActualizarPersona", method = RequestMethod.GET)
    public ModelAndView rActualizarPersona(Model model, @Validated CPersona datPersona, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarPersona", "command", new CPersona());
			CPersona persona= new CPersona();
			model.addAttribute("rActualizarPersona", persona);
			mv.setViewName("rActualizarPersona");
			CrudPersona conexPersona = new CrudPersona();
			conexPersona.Conecta();
			conexPersona.consultarPersona(datPersona.getlPersona(), session);
			return mv;
     }

	@RequestMapping(value = "/r2ActualizarPersona", method = RequestMethod.GET)
    public void r2ActualizarPersona(Model model, @Validated CPersona persona, BindingResult result,
    		HttpSession session) { 
          CrudPersona conexPersona = new CrudPersona();
          conexPersona.Conecta();
          conexPersona.actualizarPersona(persona.getlPersona(),persona.getsNombres(),persona.getsApellidos(),persona.getsDireccion(),persona.getsTelefono(),persona.getsCorreo(),persona.getsFecha_Nac(),persona.getsSexo(),persona.getsCiudad(),persona.getsHora(),persona.getsHora(), session);
     }

	@RequestMapping(value = "consultarPersona", method = RequestMethod.GET)
	public ModelAndView consultarPersona(Model model) {
		ModelAndView mv = new ModelAndView("consultarPersona", "command", new CPersona());
        CPersona persona = new CPersona();
        model.addAttribute("consultarPersona",  persona);
		mv.setViewName("consultarPersona");
		return mv;
	}

	@RequestMapping(value = "rConsultarPersona", method = RequestMethod.GET)
	public ModelAndView rConsultarPersona(Model model, @Validated CPersona datPersona, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarPersona", "command", new CPersona());
        CPersona persona = new CPersona();
        model.addAttribute("rConsultarPersona",  persona);
		mv.setViewName("rConsultarPersona");
        CrudPersona conexPersona = new CrudPersona();
        conexPersona.Conecta();
        conexPersona.consultarPersona(datPersona.getlPersona(), session);
		return mv;
	}

	@RequestMapping(value = "borrarPersona", method = RequestMethod.GET)
	public ModelAndView borrarPersona(Model model) {
		ModelAndView mv = new ModelAndView("borrarPersona", "command", new CPersona());
        CPersona persona = new CPersona();
        model.addAttribute("borrarPersona",  persona);
		mv.setViewName("borrarPersona");
		return mv;
	}

	@RequestMapping(value = "/rBorrarPersona", method = RequestMethod.GET)
    public void rBorrarPersona(Model model, @Validated CPersona persona, BindingResult result,
    		HttpSession session) { 
          CrudPersona conexPersona = new CrudPersona();
          conexPersona.Conecta();
          //INSERTA PAIS
          conexPersona.borrarPersona(persona.getlPersona(), session);
     }

}
