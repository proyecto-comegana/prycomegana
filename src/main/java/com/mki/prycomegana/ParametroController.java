package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudParametro;
import parametros.CParametro;

@Controller
public class ParametroController {
	@RequestMapping(value = "agregarParametro", method = RequestMethod.GET)
	public ModelAndView agregarParametro() {
		ModelAndView mv = new ModelAndView("agregarParametro", "command", new CParametro());
		mv.setViewName("agregarParametro");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarParametro", method = RequestMethod.GET)
    public void guardarParametro(Model model, @Validated CParametro parametro, BindingResult result,
    		HttpSession session) { 
          CrudParametro conexParametro = new CrudParametro();
          conexParametro.Conecta();
          conexParametro.crearParametro(parametro.getsNombre(),parametro.getsDescripcion(), parametro.getlValor(),parametro.getiTipo(),parametro.getiModulo(),parametro.getsFecha(),parametro.getsHora(), session);
     }
	@RequestMapping(value = "actualizarParametro", method = RequestMethod.GET)
	public ModelAndView actualizarParametro() {
		ModelAndView mv = new ModelAndView("actualizarParametro", "command", new CParametro());
		mv.setViewName("actualizarParametro");
		return mv;
	}

	@RequestMapping(value = "/rActualizarParametro", method = RequestMethod.GET)
    public ModelAndView rActualizarParametro(Model model, @Validated CParametro datParametro, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarParametro", "command", new CParametro());
			CParametro parametro= new CParametro();
			model.addAttribute("rActualizarParametro", parametro);
			mv.setViewName("rActualizarParametro");
			CrudParametro conexParametro = new CrudParametro();
			conexParametro.Conecta();
			conexParametro.consultarParametro(datParametro.getiCodigo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarParametro", method = RequestMethod.GET)
    public void r2ActualizarParametro(Model model, @Validated CParametro parametro, BindingResult result,
    		HttpSession session) { 
          CrudParametro conexParametro = new CrudParametro();
          conexParametro.Conecta();
          //INSERTA PAIS
          conexParametro.actualizarParametro(parametro.getiCodigo(), parametro.getsNombre(),parametro.getsDescripcion(), parametro.getlValor(),parametro.getiTipo(),parametro.getiModulo(),parametro.getsFecha(),parametro.getsHora(), session);
     }

	@RequestMapping(value = "consultarParametro", method = RequestMethod.GET)
	public ModelAndView consultarParametro(Model model) {
		ModelAndView mv = new ModelAndView("consultarParametro", "command", new CParametro());
        CParametro parametro = new CParametro();
        model.addAttribute("consultarParametro",  parametro);
		mv.setViewName("consultarParametro");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarParametro", method = RequestMethod.GET)
	public ModelAndView rConsultarParametro(Model model, @Validated CParametro datParametro, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarParametro", "command", new CParametro());
        CParametro parametro = new CParametro();
        model.addAttribute("rConsultarParametro",  parametro);
		mv.setViewName("rConsultarParametro");
        CrudParametro conexParametro = new CrudParametro();
        conexParametro.Conecta();
        //INSERTA PAIS
        conexParametro.consultarParametro(datParametro.getiCodigo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarParametro", method = RequestMethod.GET)
	public ModelAndView borrarPropietario(Model model) {
		ModelAndView mv = new ModelAndView("borrarParametro", "command", new CParametro());
        CParametro parametro = new CParametro();
        model.addAttribute("borrarParametro",  parametro);
		mv.setViewName("borrarParametro");
		return mv;
	}

	@RequestMapping(value = "/rBorrarParametro", method = RequestMethod.GET)
    public void rBorrarParametro(Model model, @Validated CParametro parametro, BindingResult result,
    		HttpSession session) { 
          CrudParametro conexParametro = new CrudParametro();
          conexParametro.Conecta();
          conexParametro.borrarParametro(parametro.getiCodigo(), session);
     }
}
