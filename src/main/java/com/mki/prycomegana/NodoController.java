package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import conexion.CrudNodo;
import financiero.CNodo;

@Controller
public class NodoController {

	@RequestMapping(value = "agregarNodo", method = RequestMethod.GET)
	public ModelAndView agregarNodo() {
		ModelAndView mv = new ModelAndView("agregarNodo", "command", new CNodo());
		mv.setViewName("agregarNodo");
		return mv;
	}

	@RequestMapping(value = "consultarNodo", method = RequestMethod.GET)
	public ModelAndView consultarNodo() {
		ModelAndView mv = new ModelAndView("consultarNodo", "command", new CNodo());
		mv.setViewName("consultarNodo");
		return mv;
	}

	@RequestMapping(value = "actualizarNodo", method = RequestMethod.GET)
	public ModelAndView actualizarNodo() {
		ModelAndView mv = new ModelAndView("actualizarNodo", "command", new CNodo());
		mv.setViewName("actualizarNodo");
		return mv;
	}

	@RequestMapping(value = "borrarNodo", method = RequestMethod.GET)
	public ModelAndView borrarNodo() {
		ModelAndView mv = new ModelAndView("borrarNodo", "command", new CNodo());
		mv.setViewName("borrarNodo");
		return mv;
	}
	
}
