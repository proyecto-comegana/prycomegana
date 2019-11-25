package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import accesos.CModulo;
import conexion.CrudModulo;

@Controller
public class ModuloController {
	@RequestMapping(value = "agregarModulo", method = RequestMethod.GET)
	public ModelAndView agregarModulo() {
		ModelAndView mv = new ModelAndView("agregarModulo", "command", new CModulo());
		mv.setViewName("agregarModulo");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarModulo", method = RequestMethod.GET)
    public void guardarModulo(Model model, @Validated CModulo datModulo, BindingResult result,
    		HttpSession session) { 
          CrudModulo conexModulo = new CrudModulo();
          conexModulo.Conecta();
          conexModulo.crearModulo(datModulo.getsNombre(),datModulo.getsFecha(),datModulo.getsHora(), session);
     }
	@RequestMapping(value = "actualizarModulo", method = RequestMethod.GET)
	public ModelAndView actualizarModulo() {
		ModelAndView mv = new ModelAndView("actualizarModulo", "command", new CModulo());
		mv.setViewName("actualizarModulo");
		return mv;
	}

	@RequestMapping(value = "/rActualizarModulo", method = RequestMethod.GET)
    public ModelAndView rActualizarModulo(Model model, @Validated CModulo datModulo, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarModulo", "command", new CModulo());
			CModulo modulo= new CModulo();
			model.addAttribute("rActualizarModulo", modulo);
			mv.setViewName("rActualizarModulo");
			CrudModulo conexModulo = new CrudModulo();
			conexModulo.Conecta();
			conexModulo.consultarModulo(datModulo.getiCodigo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarModulo", method = RequestMethod.GET)
    public void r2ActualizarModulo(Model model, @Validated CModulo datModulo, BindingResult result,
    		HttpSession session) { 
          CrudModulo conexModulo = new CrudModulo();
          conexModulo.Conecta();
          //INSERTA PAIS
          conexModulo.actualizarModulo(datModulo.getiCodigo(), datModulo.getsNombre(),datModulo.getsFecha(),datModulo.getsHora(), session);
     }

	@RequestMapping(value = "consultarModulo", method = RequestMethod.GET)
	public ModelAndView consultarModulo(Model model) {
		ModelAndView mv = new ModelAndView("consultarModulo", "command", new CModulo());
        CModulo modulo = new CModulo();
        model.addAttribute("consultarModulo",  modulo);
		mv.setViewName("consultarModulo");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarModulo", method = RequestMethod.GET)
	public ModelAndView rConsultarModulo(Model model, @Validated CModulo datModulo, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarModulo", "command", new CModulo());
        CModulo modulo = new CModulo();
        model.addAttribute("rConsultarModulo",  modulo);
		mv.setViewName("rConsultarModulo");
        CrudModulo conexModulo = new CrudModulo();
        conexModulo.Conecta();
        conexModulo.consultarModulo(datModulo.getiCodigo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarModulo", method = RequestMethod.GET)
	public ModelAndView borrarModulo(Model model) {
		ModelAndView mv = new ModelAndView("borrarModulo", "command", new CModulo());
        CModulo modulo = new CModulo();
        model.addAttribute("borrarModulo",  modulo);
		mv.setViewName("borrarModulo");
		return mv;
	}

	@RequestMapping(value = "/rBorrarModulo", method = RequestMethod.GET)
    public void rBorrarModulo(Model model, @Validated CModulo modulo, BindingResult result,
    		HttpSession session) { 
          CrudModulo conexModulo = new CrudModulo();
          conexModulo.Conecta();
          conexModulo.borrarModulo(modulo.getiCodigo(), session);
     }
}
