package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudArbol;
import financiero.CArbol;

@Controller
public class ArbolController {

	@RequestMapping(value = "agregarArbol", method = RequestMethod.GET)
	public ModelAndView agregarArbol() {
		ModelAndView mv = new ModelAndView("agregarArbol", "command", new CArbol());
		mv.setViewName("agregarArbol");
		return mv;
	}

	@RequestMapping(value = "consultarArbol", method = RequestMethod.GET)
	public ModelAndView consultarArbol() {
		ModelAndView mv = new ModelAndView("consultarArbol", "command", new CArbol());
		mv.setViewName("consultarArbol");
		return mv;
	}

	@RequestMapping(value = "actualizarArbol", method = RequestMethod.GET)
	public ModelAndView actualizarArbol() {
		ModelAndView mv = new ModelAndView("actualizarArbol", "command", new CArbol());
		mv.setViewName("actualizarArbol");
		return mv;
	}

	@RequestMapping(value = "borrarArbol", method = RequestMethod.GET)
	public ModelAndView borrarArbol() {
		ModelAndView mv = new ModelAndView("borrarArbol", "command", new CArbol());
		mv.setViewName("borrarArbol");
		return mv;
	}
	
}
