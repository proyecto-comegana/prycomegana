package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudTipoParametro;
import parametros.CTipoParametro;

@Controller
public class TipoParametroController {
	@RequestMapping(value = "agregarTipoParametro", method = RequestMethod.GET)
	public ModelAndView agregarTipoParametro() {
		ModelAndView mv = new ModelAndView("agregarTipoParametro", "command", new CTipoParametro());
		mv.setViewName("agregarTipoParametro");
		return mv;
	}
	
	@RequestMapping(value = "actualizarTipoParametro", method = RequestMethod.GET)
	public ModelAndView actualizarTipoParametro() {
		ModelAndView mv = new ModelAndView("actualizarTipoParametro", "command", new CTipoParametro());
		mv.setViewName("actualizarTipoParametro");
		return mv;
	}

	@RequestMapping(value = "/rAgregarTipoParametro", method = RequestMethod.GET)
    public void guardarTipoParametro(Model model, @Validated CTipoParametro tipoParametro, BindingResult result,
    		HttpSession session) { 
          CrudTipoParametro conexTipoParametro = new CrudTipoParametro();
          conexTipoParametro.Conecta();
          conexTipoParametro.crearTipoParametro(tipoParametro.getsDescripcion(),tipoParametro.getsFecha(),tipoParametro.getsHora(), session);
     }

	@RequestMapping(value = "/rActualizarTipoParametro", method = RequestMethod.GET)
    public ModelAndView rActualizarTipoParametro(Model model, @Validated CTipoParametro datTipoParametro, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarTipoParametro", "command", new CTipoParametro());
			CTipoParametro tipoParametro= new CTipoParametro();
			model.addAttribute("rActualizarTipoParametro", tipoParametro);
			mv.setViewName("rActualizarTipoParametro");
			CrudTipoParametro conexTipoParametro = new CrudTipoParametro();
			conexTipoParametro.Conecta();
			conexTipoParametro.consultarTipoParametro(datTipoParametro.getiCodigo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarTipoParametro", method = RequestMethod.GET)
    public void r2ActualizarTipoParametro(Model model, @Validated CTipoParametro tipoParametro, BindingResult result,
    		HttpSession session) { 
          CrudTipoParametro conexTipoParametro = new CrudTipoParametro();
          conexTipoParametro.Conecta();
          //INSERTA PAIS
          conexTipoParametro.actualizarTipoParametro(tipoParametro.getiCodigo(), tipoParametro.getsDescripcion(),tipoParametro.getsFecha(),tipoParametro.getsHora(), session);
     }

	@RequestMapping(value = "consultarTipoParametro", method = RequestMethod.GET)
	public ModelAndView consultarTipoParametro(Model model) {
		ModelAndView mv = new ModelAndView("consultarTipoParametro", "command", new CTipoParametro());
        CTipoParametro tipoParametro = new CTipoParametro();
        model.addAttribute("consultarTipoParametro",  tipoParametro);
		mv.setViewName("consultarTipoParametro");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarTipoParametro", method = RequestMethod.GET)
	public ModelAndView rConsultarTipoParametro(Model model, @Validated CTipoParametro datTipoParametro, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarTipoParametro", "command", new CTipoParametro());
        CTipoParametro tipoParametro = new CTipoParametro();
        model.addAttribute("rConsultarTipoParametro",  tipoParametro);
		mv.setViewName("rConsultarTipoParametro");
        CrudTipoParametro conexTipoParametro = new CrudTipoParametro();
        conexTipoParametro.Conecta();
        //INSERTA PAIS
        conexTipoParametro.consultarTipoParametro(datTipoParametro.getiCodigo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarTipoParametro", method = RequestMethod.GET)
	public ModelAndView borrarTipoParametro(Model model) {
		ModelAndView mv = new ModelAndView("borrarTipoParametro", "command", new CTipoParametro());
        CTipoParametro tipoParametro = new CTipoParametro();
        model.addAttribute("borrarTipoParametro",  tipoParametro);
		mv.setViewName("borrarTipoParametro");
		return mv;
	}

	@RequestMapping(value = "/rBorrarTipoParametro", method = RequestMethod.GET)
    public void rBorrarPropietario(Model model, @Validated CTipoParametro tipoParametro, BindingResult result,
    		HttpSession session) { 
          CrudTipoParametro conexTipoParametro = new CrudTipoParametro();
          conexTipoParametro.Conecta();
          //INSERTA PAIS
          conexTipoParametro.borrarTipoParametro(tipoParametro.getiCodigo(), session);
     }
}
