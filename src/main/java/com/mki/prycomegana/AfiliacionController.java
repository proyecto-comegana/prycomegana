package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudAfiliacion;
import financiero.CAfiliacion;

@Controller
public class AfiliacionController {

	@RequestMapping(value = "agregarAfiliacion", method = RequestMethod.GET)
	public ModelAndView agregarAfiliacion() {
		ModelAndView mv = new ModelAndView("agregarAfiliacion", "command", new CAfiliacion());
		mv.setViewName("agregarAfiliacion");
		return mv;
	}

	@RequestMapping(value = "consultarAfiliacion", method = RequestMethod.GET)
	public ModelAndView consultarAfiliacion() {
		ModelAndView mv = new ModelAndView("consultarAfiliacion", "command", new CAfiliacion());
		mv.setViewName("consultarAfiliacion");
		return mv;
	}

	@RequestMapping(value = "actualizarAfiliacion", method = RequestMethod.GET)
	public ModelAndView actualizarAfiliacion() {
		ModelAndView mv = new ModelAndView("actualizarAfiliacion", "command", new CAfiliacion());
		mv.setViewName("actualizarAfiliacion");
		return mv;
	}

	@RequestMapping(value = "r2ActualizarAfiliacion", method = RequestMethod.GET)
	public ModelAndView r2actualizarAfiliacion() {
		ModelAndView mv = new ModelAndView("r2actualizarAfiliacion", "command", new CAfiliacion());
		mv.setViewName("r2actualizarAfiliacion");
		return mv;
	}

	@RequestMapping(value = "borrarAfiliacion", method = RequestMethod.GET)
	public ModelAndView borrarAfiliacion() {
		ModelAndView mv = new ModelAndView("borrarAfiliacion", "command", new CAfiliacion());
		mv.setViewName("borrarAfiliacion");
		return mv;
	}
}
