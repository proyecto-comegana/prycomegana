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
import conexion.CrudUsuario;
import usuarios.CPersona;
import usuarios.CUsuario;

@Controller
public class UsuarioController {
	@RequestMapping(value = "agregaUsuario", method = RequestMethod.GET)
	public ModelAndView agregarUsuario(Model model, @Validated CPersona persona, BindingResult result,
    		HttpSession session) {
        CrudPersona conexPersona = new CrudPersona();
        conexPersona.Conecta();
        String sOrigen = new String ("afil_per");
        conexPersona.crearPersona(persona.getsNombres(),persona.getsApellidos(),persona.getsDireccion(),
      		  persona.getsTelefono(),persona.getsCorreo(),persona.getsFecha_Nac(),persona.getsSexo(),
      		  persona.getsCiudad(),persona.getsFecha(),persona.getsHora(), sOrigen, session);
		//LLENA LISTA CON ROLES DE USUARIO EN FORMULARIO USUARIO
		ModelAndView mv = new ModelAndView("agregaUsuario", "command", new CUsuario());
	    List<String> lstRolesUsuario = new ArrayList<String>();
	    lstRolesUsuario.add("Administrador");
	    lstRolesUsuario.add("Empleado");
	    lstRolesUsuario.add("Propietario de restaurante");
	    lstRolesUsuario.add("Comensal");
	    model.addAttribute("lstRolesUsuario", lstRolesUsuario);
		mv.setViewName("agregaUsuario");
		return mv;
	}
	@RequestMapping(value = "agregarUsuarioReg", method = RequestMethod.GET)
	public ModelAndView agregarUsuarioReg(Model model, @Validated CPersona persona, BindingResult result,
    		HttpSession session) {
		//AGREGA AL REGISTRO DE BD LOS DATOS DE LA PERSONA
        CrudPersona conexPersona = new CrudPersona();
        conexPersona.Conecta();
        String sOrigen = new String ("reg_per");
        conexPersona.crearPersona(persona.getsNombres(),persona.getsApellidos(),persona.getsDireccion(),
      		  persona.getsTelefono(),persona.getsCorreo(),persona.getsFecha_Nac(),persona.getsSexo(),
      		  persona.getsCiudad(),persona.getsFecha(),persona.getsHora(), sOrigen, session);
		//LLENA LISTA CON ROLES DE USUARIO EN FORMULARIO USUARIO
		ModelAndView mv = new ModelAndView("agregarUsuarioReg", "command", new CUsuario());
	    List<String> lstRolesUsuario = new ArrayList<String>();
	    lstRolesUsuario.add("Administrador");
	    lstRolesUsuario.add("Empleado");
	    lstRolesUsuario.add("Propietario de restaurante");
	    lstRolesUsuario.add("Comensal");
	    model.addAttribute("lstRolesUsuario", lstRolesUsuario);
		mv.setViewName("agregarUsuarioReg");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarUsuario", method = RequestMethod.GET)
    public void guardarUsuario(Model model, @Validated CUsuario usuario, BindingResult result,
    		HttpSession session) { 
          CrudUsuario conexUsuario = new CrudUsuario();
          conexUsuario.Conecta();
          //INSERTA USUARIO
          String sOrigen = new String("afil_usuar");
          conexUsuario.crearUsuario(usuario.getsNombreUsuario(),usuario.getsContrasena(),usuario.getsTipo(),usuario.getlPersona(),usuario.getsFecha(),usuario.getsHora(), sOrigen, session);
     }

	@RequestMapping(value = "/rAgregarUsuarioReg", method = RequestMethod.GET)
    public void guardarUsuarioReg(Model model, @Validated CUsuario usuario, BindingResult result,
    		HttpSession session) { 
          CrudUsuario conexUsuario = new CrudUsuario();
          conexUsuario.Conecta();
          //INSERTA USUARIO
          String sOrigen = new String("reg_usuar");
          conexUsuario.crearUsuario(usuario.getsNombreUsuario(),usuario.getsContrasena(),usuario.getsTipo(),usuario.getlPersona(),usuario.getsFecha(),usuario.getsHora(), sOrigen,session);
     }
	
	@RequestMapping(value = "actualizarUsuario", method = RequestMethod.GET)
	public ModelAndView actualizarUsuario() {
		ModelAndView mv = new ModelAndView("actualizarUsuario", "command", new CUsuario());
		mv.setViewName("actualizarUsuario");
		return mv;
	}

	@RequestMapping(value = "/rActualizarUsuario", method = RequestMethod.GET)
    public ModelAndView rActualizarUsuario(Model model, @Validated CUsuario datUsuario, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarUsuario", "command", new CUsuario());
			CUsuario usuario= new CUsuario();
			model.addAttribute("rActualizarUsuario", usuario);
			mv.setViewName("rActualizarUsuario");
			CrudUsuario conexUsuario = new CrudUsuario();
			conexUsuario.Conecta();
			conexUsuario.consultarUsuario(datUsuario.getlCodigo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarUsuario", method = RequestMethod.GET)
    public void r2ActualizarUsuario(Model model, @Validated CUsuario usuario, BindingResult result,
    		HttpSession session) { 
          CrudUsuario conexUsuario = new CrudUsuario();
          conexUsuario.Conecta();
          //INSERTA CLIENTE
          conexUsuario.actualizarUsuario(usuario.getlCodigo(),usuario.getsNombreUsuario(),usuario.getsContrasena(),usuario.getsTipo(),usuario.getlPersona(),usuario.getsFecha(),usuario.getsHora(), session);
     }

	@RequestMapping(value = "consultarUsuario", method = RequestMethod.GET)
	public ModelAndView consultarUsuario(Model model) {
		ModelAndView mv = new ModelAndView("consultarUsuario", "command", new CUsuario());
        CUsuario usuario = new CUsuario();
        model.addAttribute("consultarUsuario",  usuario);
		mv.setViewName("consultarUsuario");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarUsuario", method = RequestMethod.GET)
	public ModelAndView rConsultarUsuario(Model model, @Validated CUsuario datUsuario, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarUsuario", "command", new CUsuario());
        CUsuario usuario = new CUsuario();
        model.addAttribute("rConsultarUsuario",  usuario);
		mv.setViewName("rConsultarUsuario");
        CrudUsuario conexUsuario = new CrudUsuario();
        conexUsuario.Conecta();
        conexUsuario.consultarUsuario(datUsuario.getlCodigo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarUsuario", method = RequestMethod.GET)
	public ModelAndView borrarUsuario(Model model) {
		ModelAndView mv = new ModelAndView("borrarUsuario", "command", new CUsuario());
        CUsuario usuario = new CUsuario();
        model.addAttribute("borrarUsuario",  usuario);
		mv.setViewName("borrarUsuario");
		return mv;
	}

	@RequestMapping(value = "/rBorrarUsuario", method = RequestMethod.GET)
    public void rBorrarUsuario(Model model, @Validated CUsuario usuario, BindingResult result,
    		HttpSession session) { 
          CrudUsuario conexUsuario = new CrudUsuario();
          conexUsuario.Conecta();
          //INSERTA PAIS
          conexUsuario.borrarUsuario(usuario.getlCodigo(), session);
     }
}
