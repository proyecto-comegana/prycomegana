package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudParametroModulo;
import parametros.CParametroModulo;

@Controller
public class ParametroModuloController {
	@RequestMapping(value = "agregarParametroModulo", method = RequestMethod.GET)
	public ModelAndView agregarParametro() {
		ModelAndView mv = new ModelAndView("agregarParametroModulo", "command", new CParametroModulo());
		mv.setViewName("agregarParametroModulo");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarParametroModulo", method = RequestMethod.GET)
    public void guardarParametroModulo(Model model, @Validated CParametroModulo parametroModulo, BindingResult result,
    		HttpSession session) { 
          CrudParametroModulo conexParametroModulo = new CrudParametroModulo();
          conexParametroModulo.Conecta();
          conexParametroModulo.crearParametroModulo(parametroModulo.getiParametro(),parametroModulo.getiModulo(),parametroModulo.getsFecha(), parametroModulo.getsHora(), session);
     }
	@RequestMapping(value = "actualizarParametroModulo", method = RequestMethod.GET)
	public ModelAndView actualizarParametroModulo() {
		ModelAndView mv = new ModelAndView("actualizarParametroModulo", "command", new CParametroModulo());
		mv.setViewName("actualizarParametroModulo");
		return mv;
	}

	@RequestMapping(value = "/rActualizarParametroModulo", method = RequestMethod.GET)
    public ModelAndView rActualizarParametroModulo(Model model, @Validated CParametroModulo datParametroModulo, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarParametroModulo", "command", new CParametroModulo());
			CParametroModulo parametroModulo= new CParametroModulo();
			model.addAttribute("rActualizarParametroModulo", parametroModulo);
			mv.setViewName("rActualizarParametroModulo");
			CrudParametroModulo conexParametroModulo = new CrudParametroModulo();
			conexParametroModulo.Conecta();
			conexParametroModulo.consultarParametroModulo(datParametroModulo.getiParametro(),datParametroModulo.getiModulo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarParametroModulo", method = RequestMethod.GET)
    public void r2ActualizarParametroModulo(Model model, @Validated CParametroModulo parametroModulo, BindingResult result,
    		HttpSession session) { 
          CrudParametroModulo conexParametroModulo = new CrudParametroModulo();
          conexParametroModulo.Conecta();
          //INSERTA PAIS
          conexParametroModulo.actualizarParametroModulo(parametroModulo.getiParametro(), parametroModulo.getiModulo(),parametroModulo.getsFecha(),parametroModulo.getsHora(), session);
     }

	@RequestMapping(value = "consultarParametroModulo", method = RequestMethod.GET)
	public ModelAndView consultarParametroModulo(Model model) {
		ModelAndView mv = new ModelAndView("consultarParametroModulo", "command", new CParametroModulo());
        CParametroModulo parametroModulo = new CParametroModulo();
        model.addAttribute("consultarParametroModulo",  parametroModulo);
		mv.setViewName("consultarParametroModulo");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarParametroModulo", method = RequestMethod.GET)
	public ModelAndView rConsultarParametroModulo(Model model, @Validated CParametroModulo datParametroModulo, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarParametroModulo", "command", new CParametroModulo());
        CParametroModulo parametroModulo = new CParametroModulo();
        model.addAttribute("rConsultarParametroModulo",  parametroModulo);
		mv.setViewName("rConsultarParametroModulo");
        CrudParametroModulo conexParametroModulo = new CrudParametroModulo();
        conexParametroModulo.Conecta();
        conexParametroModulo.consultarParametroModulo(datParametroModulo.getiParametro(),datParametroModulo.getiModulo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarParametroModulo", method = RequestMethod.GET)
	public ModelAndView borrarPropietarioModulo(Model model) {
		ModelAndView mv = new ModelAndView("borrarParametroModulo", "command", new CParametroModulo());
        CParametroModulo parametroModulo = new CParametroModulo();
        model.addAttribute("borrarParametroModulo",  parametroModulo);
		mv.setViewName("borrarParametroModulo");
		return mv;
	}

	@RequestMapping(value = "/rBorrarParametroModulo", method = RequestMethod.GET)
    public void rBorrarParametroModulo(Model model, @Validated CParametroModulo parametroModulo, BindingResult result,
    		HttpSession session) { 
          CrudParametroModulo conexParametroModulo = new CrudParametroModulo();
          conexParametroModulo.Conecta();
          conexParametroModulo.borrarParametroModulo(parametroModulo.getiParametro(),parametroModulo.getiModulo(), session);
     }
}
