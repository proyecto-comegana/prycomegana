package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import conexion.CrudNodoArbol;
import financiero.CNodoArbol;

@Controller
public class NodoArbolController {

	@RequestMapping(value = "agregarNodoArbol", method = RequestMethod.GET)
	public ModelAndView agregarNodoArbol() {
		ModelAndView mv = new ModelAndView("agregarNodoArbol", "command", new CNodoArbol());
		mv.setViewName("agregarNodoArbol");
		return mv;
	}

	@RequestMapping(value = "consultarNodoArbol", method = RequestMethod.GET)
	public ModelAndView consultarNodoArbol() {
		ModelAndView mv = new ModelAndView("consultarNodoArbol", "command", new CNodoArbol());
		mv.setViewName("consultarNodoArbol");
		return mv;
	}

	@RequestMapping(value = "actualizarNodoArbol", method = RequestMethod.GET)
	public ModelAndView actualizarAfiliacion() {
		ModelAndView mv = new ModelAndView("actualizarNodoArbol", "command", new CNodoArbol());
		mv.setViewName("actualizarNodoArbol");
		return mv;
	}

	@RequestMapping(value = "borrarNodoArbol", method = RequestMethod.GET)
	public ModelAndView borrarAfiliacion() {
		ModelAndView mv = new ModelAndView("borrarNodoArbol", "command", new CNodoArbol());
		mv.setViewName("borrarNodoArbol");
		return mv;
	}

}
