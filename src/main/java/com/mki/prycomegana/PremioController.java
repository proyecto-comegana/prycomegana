package com.mki.prycomegana;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudPremio;
import financiero.CPremio;

@Controller
public class PremioController {
	@RequestMapping(value = "/agregarPremio", method = RequestMethod.GET)
	public ModelAndView agregarPremio() {
		ModelAndView mv = new ModelAndView("agregarPremio", "command", new CPremio());
		mv.setViewName("agregarPremio");
		return mv;
	}
	@RequestMapping(value = "/rAgregarPremio", method = RequestMethod.GET)
    public void guardarPremio(Model model, @Validated CPremio premio, BindingResult result,
    		HttpSession session) { 
          CrudPremio conexPremio = new CrudPremio();
          conexPremio.Conecta();
          //INSERTA PAIS
          conexPremio.crearPremio(premio.getsDescripcion(),premio.getlValor(),premio.getsFecha(),premio.getsHora(), session);
     }
	@RequestMapping(value = "actualizarPremio", method = RequestMethod.GET)
	public ModelAndView actualizarPremio() {
		ModelAndView mv = new ModelAndView("actualizarPremio", "command", new CPremio());
		mv.setViewName("actualizarPremio");
		return mv;
	}
	@RequestMapping(value = "/rActualizarPremio", method = RequestMethod.GET)
    public ModelAndView rActualizarPremio(Model model, @Validated CPremio datpremio, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarPremio", "command", new CPremio());
			CPremio ciudad = new CPremio();
			model.addAttribute("rActualizarPremio", ciudad);
			mv.setViewName("rActualizarPremio");
			CrudPremio conexPremio = new CrudPremio();
			conexPremio.Conecta();
			//INSERTA DEPARTAMENTO
			conexPremio.consultarPremio(datpremio.getiCodigo(), session);
			return mv;
     }
	@RequestMapping(value = "/r2ActualizarPremio", method = RequestMethod.GET)
    public void r2ActualizarPremio(Model model, @Validated CPremio premio, BindingResult result,
    		HttpSession session) { 
          CrudPremio conexPremio = new CrudPremio();
          conexPremio.Conecta();
          //INSERTA PAIS
          conexPremio.actualizarPremio(premio.getiCodigo(), premio.getsDescripcion(), premio.getlValor(), premio.getsFecha(), premio.getsHora(), session);
     }
	@RequestMapping(value = "consultarPremio", method = RequestMethod.GET)
	public ModelAndView consultarPremio(Model model) {
		ModelAndView mv = new ModelAndView("consultarPremio", "command", new CPremio());
        CPremio premio = new CPremio();
        model.addAttribute("consultarPremio",  premio);
		mv.setViewName("consultarPremio");
		return mv;
	}
	@RequestMapping(value = "rConsultarPremio", method = RequestMethod.GET)
	public ModelAndView rConsultarPremio(Model model, @Validated CPremio datPremio, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarPremio", "command", new CPremio());
        CPremio Premio = new CPremio();
        model.addAttribute("rConsultarPremio",  Premio);
		mv.setViewName("rConsultarPremio");
        //IMPRIME EN CONSOLA VALOR DEL PAIS
        CrudPremio conexPremio= new CrudPremio();
        conexPremio.Conecta();
        //INSERTA PAIS
        conexPremio.consultarPremio(datPremio.getiCodigo(), session);
		return mv;
	}
	@RequestMapping(value = "borrarPremio", method = RequestMethod.GET)
	public ModelAndView borrarPremio(Model model) {
		ModelAndView mv = new ModelAndView("borrarPremio", "command", new CPremio());
        CPremio premio = new CPremio();
        model.addAttribute("borrarPremio",  premio);
		mv.setViewName("borrarPremio");
		return mv;
	}
	@RequestMapping(value = "/rBorrarPremio", method = RequestMethod.GET)
    public void rBorrarPremio(Model model, @Validated CPremio premio, BindingResult result,
    		HttpSession session) { 
          CrudPremio conexPremio = new CrudPremio();
          conexPremio.Conecta();
          //RESPUESTA ELIMINAR DEPARTAMENTO
          conexPremio.borrarPremio(premio.getiCodigo(), session);
     }
}
