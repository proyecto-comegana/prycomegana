package com.mki.prycomegana;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudConvenio;
import financiero.CConvenio;

@Controller
public class ConvenioController {
	@RequestMapping(value = "/agregarConvenio", method = RequestMethod.GET)
	public ModelAndView agregarConvenio() {
		ModelAndView mv = new ModelAndView("agregarConvenio", "command", new CConvenio());
		mv.setViewName("agregarConvenio");
		return mv;
	}
	@RequestMapping(value = "/rAgregarConvenio", method = RequestMethod.GET)
    public void guardarPremio(Model model, @Validated CConvenio convenio, BindingResult result,
    		HttpSession session) { 
          CrudConvenio conexConvenio = new CrudConvenio();
          conexConvenio.Conecta();
          //INSERTA PAIS
          conexConvenio.crearConvenio(convenio.getsDescripcion(),convenio.getsFecha(),convenio.getsHora(), session);
     }
	@RequestMapping(value = "actualizarConvenio", method = RequestMethod.GET)
	public ModelAndView actualizarConvenio() {
		ModelAndView mv = new ModelAndView("actualizarConvenio", "command", new CConvenio());
		mv.setViewName("actualizarConvenio");
		return mv;
	}
	@RequestMapping(value = "/rActualizarConvenio", method = RequestMethod.GET)
    public ModelAndView rActualizarConvenio(Model model, @Validated CConvenio datconvenio, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarConvenio", "command", new CConvenio());
			CConvenio convenio = new CConvenio();
			model.addAttribute("rActualizarConvenio", convenio);
			mv.setViewName("rActualizarConvenio");
			CrudConvenio conexConvenio = new CrudConvenio();
			conexConvenio.Conecta();
			//INSERTA DEPARTAMENTO
			conexConvenio.consultarConvenio(datconvenio.getiCodigo(), session);
			return mv;
     }
	@RequestMapping(value = "/r2ActualizarConvenio", method = RequestMethod.GET)
    public void r2ActualizarConvenio(Model model, @Validated CConvenio convenio, BindingResult result,
    		HttpSession session) { 
          CrudConvenio conexConvenio = new CrudConvenio();
          conexConvenio.Conecta();
          //INSERTA CONVENIO
          conexConvenio.actualizarConvenio(convenio.getiCodigo(), convenio.getsDescripcion(), convenio.getsFecha(), convenio.getsHora(), session);
     }
	@RequestMapping(value = "consultarConvenio", method = RequestMethod.GET)
	public ModelAndView consultarConvenio(Model model) {
		ModelAndView mv = new ModelAndView("consultarConvenio", "command", new CConvenio());
        CConvenio convenio = new CConvenio();
        model.addAttribute("consultarConvenio",  convenio);
		mv.setViewName("consultarConvenio");
		return mv;
	}
	@RequestMapping(value = "rConsultarConvenio", method = RequestMethod.GET)
	public ModelAndView rConsultarConvenio(Model model, @Validated CConvenio datConvenio, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarConvenio", "command", new CConvenio());
        CConvenio convenio = new CConvenio();
        model.addAttribute("rConsultarConvenio",  convenio);
		mv.setViewName("rConsultarConvenio");
        //IMPRIME EN CONSOLA VALOR DEL PAIS
        CrudConvenio conexConvenio= new CrudConvenio();
        conexConvenio.Conecta();
        //INSERTA PAIS
        conexConvenio.consultarConvenio(datConvenio.getiCodigo(), session);
		return mv;
	}
	@RequestMapping(value = "borrarConvenio", method = RequestMethod.GET)
	public ModelAndView borrarPremio(Model model) {
		ModelAndView mv = new ModelAndView("borrarConvenio", "command", new CConvenio());
        CConvenio convenio = new CConvenio();
        model.addAttribute("borrarConvenio",  convenio);
		mv.setViewName("borrarConvenio");
		return mv;
	}
	@RequestMapping(value = "/rBorrarConvenio", method = RequestMethod.GET)
    public void rBorrarConvenio(Model model, @Validated CConvenio convenio, BindingResult result,
    		HttpSession session) { 
          CrudConvenio conexConvenio = new CrudConvenio();
          conexConvenio.Conecta();
          //RESPUESTA ELIMINAR DEPARTAMENTO
          conexConvenio.borrarConvenio(convenio.getiCodigo(), session);
     }
}
