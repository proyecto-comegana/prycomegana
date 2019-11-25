package com.mki.prycomegana;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import conexion.CrudPais;
import localizacion.CPais;


@Controller
public class PaisController {

	@RequestMapping(value = "agregarPais", method = RequestMethod.GET)
	public ModelAndView pais(Model model) {
		ModelAndView mv = new ModelAndView("agregarPais", "command", new CPais());
        CPais pais = new CPais();
        model.addAttribute("agregarPais",  pais);
		mv.setViewName("agregarPais");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarPais", method = RequestMethod.GET)
    public void guardarPais(Model model, @Validated CPais pais, BindingResult result,
    		HttpSession session) { 
          CrudPais conexPais = new CrudPais();
          conexPais.Conecta();
          //INSERTA PAIS
          conexPais.crearPais(pais.getsNombre(),pais.getsFecha(),pais.getsHora(), session);
     }

	@RequestMapping(value = "borrarPais", method = RequestMethod.GET)
	public ModelAndView borrarPais(Model model) {
		ModelAndView mv = new ModelAndView("borrarPais", "command", new CPais());
        CPais pais = new CPais();
        model.addAttribute("borrarPais",  pais);
		mv.setViewName("borrarPais");
		return mv;
	}

	@RequestMapping(value = "/rBorrarPais", method = RequestMethod.GET)
    public void rBorrarPais(Model model, @Validated CPais pais, BindingResult result) { 
          CrudPais conexPais = new CrudPais();
          conexPais.Conecta();
          //INSERTA PAIS
          conexPais.borrarPais(pais.getiCodigo());
     }

	@RequestMapping(value = "actualizarPais", method = RequestMethod.GET)
	public ModelAndView actualizarPais(Model model) {
		ModelAndView mv = new ModelAndView("actualizarPais", "command", new CPais());
        CPais pais = new CPais();
        model.addAttribute("actualizarPais",  pais);
		mv.setViewName("actualizarPais");
		return mv;
	}
	
	@RequestMapping(value = "/rActualizarPais", method = RequestMethod.GET)
    public ModelAndView rActualizarPais(Model model, @Validated CPais datpais, BindingResult result,
    		HttpSession session) {
			ModelAndView mv = new ModelAndView("rActualizarPais", "command", new CPais());
			CPais pais = new CPais();
			model.addAttribute("rActualizarPais", pais);
			mv.setViewName("rActualizarPais");
			CrudPais conexPais = new CrudPais();
			conexPais.Conecta();
			//INSERTA DEPARTAMENTO
			conexPais.consultarPais(datpais.getiCodigo(), session);
			return mv;
     }

	@RequestMapping(value = "/r2ActualizarPais", method = RequestMethod.GET)
    public void r2ActualizarPais(Model model, @Validated CPais pais, BindingResult result,
    		HttpSession session) { 
          CrudPais conexPais = new CrudPais();
          conexPais.Conecta();
          //INSERTA PAIS
          conexPais.actualizarPais(pais.getiCodigo(), pais.getsNombre(), pais.getsFecha(), pais.getsHora(), session);
     }
	
	@RequestMapping(value = "consultarPais", method = RequestMethod.GET)
	public ModelAndView consultarPais(Model model) {
		ModelAndView mv = new ModelAndView("consultarPais", "command", new CPais());
        CPais pais = new CPais();
        model.addAttribute("consultarPais",  pais);
		mv.setViewName("consultarPais");
		return mv;
	}

	@RequestMapping(value = "rConsultarPais", method = RequestMethod.GET)
	public ModelAndView rConsultarPais(Model model, @Validated CPais datpais, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarPais", "command", new CPais());
        CPais pais = new CPais();
        model.addAttribute("rConsultarPais",  pais);
		mv.setViewName("rConsultarPais");
        //IMPRIME EN CONSOLA VALOR DEL PAIS
		System.out.println("Codigo:" + datpais.getiCodigo());
        CrudPais conexPais = new CrudPais();
        conexPais.Conecta();
        //INSERTA PAIS
        conexPais.consultarPais(datpais.getiCodigo(), session);
		return mv;
	}
}
