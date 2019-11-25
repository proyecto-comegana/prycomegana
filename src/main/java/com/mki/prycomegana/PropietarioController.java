package com.mki.prycomegana;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudPropietario;
import usuarios.CPropietario;

@Controller
public class PropietarioController {
	@RequestMapping(value = "agregarPropietario", method = RequestMethod.GET)
	public ModelAndView agregarPropietario() {
		ModelAndView mv = new ModelAndView("agregarPropietario", "command", new CPropietario());
		mv.setViewName("agregarPropietario");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarPropietario", method = RequestMethod.GET)
    public void guardarPropietario(Model model, @Validated CPropietario propietario, BindingResult result,
    		HttpSession session) { 
          CrudPropietario conexPropietario = new CrudPropietario();
          conexPropietario.Conecta();
          conexPropietario.crearPropietario(propietario.getlCedula(),propietario.getlRestaurante(),propietario.getsEstado(), propietario.getlPersona(),propietario.getsFecha(),propietario.getsHora(), session);
     }
	@RequestMapping(value = "actualizarPropietario", method = RequestMethod.GET)
	public ModelAndView actualizarPropietario() {
		ModelAndView mv = new ModelAndView("actualizarPropietario", "command", new CPropietario());
		mv.setViewName("actualizarPropietario");
		return mv;
	}

	@RequestMapping(value = "/rActualizarPropietario", method = RequestMethod.GET)
    public ModelAndView rActualizarPropietario(Model model, @Validated CPropietario datPropietario, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarPropietario", "command", new CPropietario());
			CPropietario propietario= new CPropietario();
			model.addAttribute("rActualizarPropietario", propietario);
			mv.setViewName("rActualizarPropietario");
			CrudPropietario conexPropietario = new CrudPropietario();
			conexPropietario.Conecta();
			//INSERTA DEPARTAMENTO
			conexPropietario.consultarPropietario(datPropietario.getlCedula(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarPropietario", method = RequestMethod.GET)
    public void r2ActualizarPropietario(Model model, @Validated CPropietario propietario, BindingResult result,
    		HttpSession session) { 
          CrudPropietario conexPropietario = new CrudPropietario();
          conexPropietario.Conecta();
          //INSERTA PAIS
          conexPropietario.actualizarPropietario(propietario.getlCedula(), propietario.getlRestaurante(),propietario.getsEstado(),propietario.getlPersona(), propietario.getsFecha(),propietario.getsHora(), session);
     }

	@RequestMapping(value = "consultarPropietario", method = RequestMethod.GET)
	public ModelAndView consultarPropietario(Model model) {
		ModelAndView mv = new ModelAndView("consultarPropietario", "command", new CPropietario());
        CPropietario propietario = new CPropietario();
        model.addAttribute("consultarPropietario",  propietario);
		mv.setViewName("consultarPropietario");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarPropietario", method = RequestMethod.GET)
	public ModelAndView rConsultarPropietario(Model model, @Validated CPropietario datPropietario, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarPropietario", "command", new CPropietario());
        CPropietario propietario = new CPropietario();
        model.addAttribute("rConsultarPropietario",  propietario);
		mv.setViewName("rConsultarPropietario");
        CrudPropietario conexPropietario = new CrudPropietario();
        conexPropietario.Conecta();
        //INSERTA PAIS
        conexPropietario.consultarPropietario(datPropietario.getlCedula(), session);
		return mv;
	}

	@RequestMapping(value = "borrarPropietario", method = RequestMethod.GET)
	public ModelAndView borrarPropietario(Model model) {
		ModelAndView mv = new ModelAndView("borrarPropietario", "command", new CPropietario());
        CPropietario propietario = new CPropietario();
        model.addAttribute("borrarPropietario",  propietario);
		mv.setViewName("borrarPropietario");
		return mv;
	}

	@RequestMapping(value = "/rBorrarPropietario", method = RequestMethod.GET)
    public void rBorrarPropietario(Model model, @Validated CPropietario propietario, BindingResult result,
    		HttpSession session) { 
          CrudPropietario conexPropietario = new CrudPropietario();
          conexPropietario.Conecta();
          //INSERTA PAIS
          conexPropietario.borrarPropietario(propietario.getlCedula(), session);
     }
}
