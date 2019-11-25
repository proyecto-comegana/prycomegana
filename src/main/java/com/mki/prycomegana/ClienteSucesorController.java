package com.mki.prycomegana;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import conexion.CrudClienteSucesor;
import financiero.CClienteSucesor;

@Controller
public class ClienteSucesorController {
	@RequestMapping(value = "/agregarClienteSucesor", method = RequestMethod.GET)
	public ModelAndView agregarClienteSucesor() {
		ModelAndView mv = new ModelAndView("agregarClienteSucesor", "command", new CClienteSucesor());
		mv.setViewName("agregarClienteSucesor");
		return mv;
	}
	@RequestMapping(value = "/rAgregarClienteSucesor", method = RequestMethod.GET)
    public void guardarClienteSucesor(Model model, @Validated CClienteSucesor clienteSucesor, BindingResult result,
    		HttpSession session) { 
          CrudClienteSucesor conexClienteSucesor = new CrudClienteSucesor();
          conexClienteSucesor.Conecta();
          //INSERTA TIPO RESTAURANTE
          conexClienteSucesor.crearClienteSucesor(clienteSucesor.getlCliente(),clienteSucesor.getlSucesor(),clienteSucesor.getsFecha(),clienteSucesor.getsHora(), session);
     }
	@RequestMapping(value = "actualizarClienteSucesor", method = RequestMethod.GET)
	public ModelAndView actualizarClienteSucesor() {
		ModelAndView mv = new ModelAndView("actualizarClienteSucesor", "command", new CClienteSucesor());
		mv.setViewName("actualizarClienteSucesor");
		return mv;
	}
	@RequestMapping(value = "/rActualizarClienteSucesor", method = RequestMethod.GET)
    public ModelAndView rActualizarClienteSucesor(Model model, @Validated CClienteSucesor datClienteSucesor, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarClienteSucesor", "command", new CClienteSucesor());
			CClienteSucesor clienteSucesor = new CClienteSucesor();
			model.addAttribute("rActualizarClienteSucesor", clienteSucesor);
			mv.setViewName("rActualizarClienteSucesor");
			CrudClienteSucesor conexClienteSucesor = new CrudClienteSucesor();
			conexClienteSucesor.Conecta();
			//INSERTA DEPARTAMENTO
			conexClienteSucesor.consultarClienteSucesor(datClienteSucesor.getlCliente(),datClienteSucesor.getlSucesor(), session);
			return mv;
     }
	@RequestMapping(value = "/r2ActualizarClienteSucesor", method = RequestMethod.GET)
    public void r2ActualizarClienteSucesor(Model model, @Validated CClienteSucesor clienteSucesor, BindingResult result,
    		HttpSession session) { 
          CrudClienteSucesor conexClienteSucesor = new CrudClienteSucesor();
          conexClienteSucesor.Conecta();
          //INSERTA CONVENIO
          conexClienteSucesor.actualizarClienteSucesor(clienteSucesor.getlCliente(),clienteSucesor.getlSucesor(), clienteSucesor.getsFecha(),clienteSucesor.getsHora(), session);
     }
	@RequestMapping(value = "consultarClienteSucesor", method = RequestMethod.GET)
	public ModelAndView consultarClienteSucesor(Model model) {
		ModelAndView mv = new ModelAndView("consultarClienteSucesor", "command", new CClienteSucesor());
        CClienteSucesor clienteSucesor = new CClienteSucesor();
        model.addAttribute("consultarClienteSucesor",  clienteSucesor);
		mv.setViewName("consultarClienteSucesor");
		return mv;
	}
	@RequestMapping(value = "rConsultarClienteSucesor", method = RequestMethod.GET)
	public ModelAndView rConsultarClienteSucesor(Model model, @Validated CClienteSucesor datClienteSucesor, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarClienteSucesor", "command", new CClienteSucesor());
        CClienteSucesor clienteSucesor = new CClienteSucesor();
        model.addAttribute("rConsultarClienteSucesor",  clienteSucesor);
		mv.setViewName("rConsultarClienteSucesor");
        CrudClienteSucesor conexClienteSucesor = new CrudClienteSucesor();
        conexClienteSucesor.Conecta();
        //INSERTA PAIS
        conexClienteSucesor.consultarClienteSucesor(datClienteSucesor.getlCliente(),datClienteSucesor.getlSucesor(), session);
		return mv;
	}
	@RequestMapping(value = "borrarClienteSucesor", method = RequestMethod.GET)
	public ModelAndView borrarClienteSucesor(Model model) {
		ModelAndView mv = new ModelAndView("borrarClienteSucesor", "command", new CClienteSucesor());
        CClienteSucesor clienteSucesor = new CClienteSucesor();
        model.addAttribute("borrarClienteSucesor", clienteSucesor);
		mv.setViewName("borrarClienteSucesor");
		return mv;
	}
	@RequestMapping(value = "/rBorrarClienteSucesor", method = RequestMethod.GET)
    public void rBorrarClienteSucesor(Model model, @Validated CClienteSucesor clienteSucesor, BindingResult result,
    		HttpSession session) { 
          CrudClienteSucesor conexClienteSucesor = new CrudClienteSucesor();
          conexClienteSucesor.Conecta();
          //RESPUESTA ELIMINAR TARIFA
          conexClienteSucesor.borrarClienteSucesor(clienteSucesor.getlCliente(),clienteSucesor.getlSucesor(), session);
     }
}
