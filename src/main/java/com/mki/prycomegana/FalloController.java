package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudFallo;
import fallos.CFallo;

@Controller
public class FalloController {
	@RequestMapping(value = "agregarFallo", method = RequestMethod.GET)
	public ModelAndView agregarFallo() {
		ModelAndView mv = new ModelAndView("agregarFallo", "command", new CFallo());
		mv.setViewName("agregarFallo");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarFallo", method = RequestMethod.GET)
    public void guardarFallo(Model model, @Validated CFallo datFallo, BindingResult result,
    		HttpSession session) { 
          CrudFallo conexFallo = new CrudFallo();
          conexFallo.Conecta();
          conexFallo.crearFallo(datFallo.getsDescripcion(),datFallo.getsRuta(), datFallo.getsArchivo(),datFallo.getiLinea(),datFallo.getsFecha(),datFallo.getsHora(), session);
     }
	@RequestMapping(value = "actualizarFallo", method = RequestMethod.GET)
	public ModelAndView actualizarFallo() {
		ModelAndView mv = new ModelAndView("actualizarFallo", "command", new CFallo());
		mv.setViewName("actualizarFallo");
		return mv;
	}

	@RequestMapping(value = "/rActualizarFallo", method = RequestMethod.GET)
    public ModelAndView rActualizarFallo(Model model, @Validated CFallo datFallo, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarFallo", "command", new CFallo());
			CFallo fallo= new CFallo();
			model.addAttribute("rActualizarFallo", fallo);
			mv.setViewName("rActualizarFallo");
			CrudFallo conexFallo = new CrudFallo();
			conexFallo.Conecta();
			conexFallo.consultarFallo(datFallo.getiCodigo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarFallo", method = RequestMethod.GET)
    public void r2ActualizarFallo(Model model, @Validated CFallo datFallo, BindingResult result,
    		HttpSession session) { 
          CrudFallo conexFallo = new CrudFallo();
          conexFallo.Conecta();
          //INSERTA PAIS
          conexFallo.actualizarFallo(datFallo.getiCodigo(), datFallo.getsDescripcion(),datFallo.getsRuta(), datFallo.getsArchivo(),datFallo.getiLinea(),datFallo.getsFecha(),datFallo.getsHora(), session);
     }

	@RequestMapping(value = "consultarFallo", method = RequestMethod.GET)
	public ModelAndView consultarFallo(Model model) {
		ModelAndView mv = new ModelAndView("consultarFallo", "command", new CFallo());
        CFallo fallo = new CFallo();
        model.addAttribute("consultarFallo",  fallo);
		mv.setViewName("consultarFallo");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarFallo", method = RequestMethod.GET)
	public ModelAndView rConsultarFallo(Model model, @Validated CFallo datFallo, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarFallo", "command", new CFallo());
        CFallo fallo = new CFallo();
        model.addAttribute("rConsultarFallo",  fallo);
		mv.setViewName("rConsultarFallo");
        CrudFallo conexFallo = new CrudFallo();
        conexFallo.Conecta();
        conexFallo.consultarFallo(datFallo.getiCodigo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarFallo", method = RequestMethod.GET)
	public ModelAndView borrarFallo(Model model) {
		ModelAndView mv = new ModelAndView("borrarFallo", "command", new CFallo());
        CFallo fallo = new CFallo();
        model.addAttribute("borrarFallo",  fallo);
		mv.setViewName("borrarFallo");
		return mv;
	}

	@RequestMapping(value = "/rBorrarFallo", method = RequestMethod.GET)
    public void rBorrarFallo(Model model, @Validated CFallo fallo, BindingResult result,
    		HttpSession session) { 
          CrudFallo conexFallo = new CrudFallo();
          conexFallo.Conecta();
          conexFallo.borrarFallo(fallo.getiCodigo(), session);
     }
}
