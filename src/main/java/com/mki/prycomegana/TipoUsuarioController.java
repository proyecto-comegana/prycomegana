package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudTipoUsuario;
import usuarios.CTipoUsuario;

@Controller
public class TipoUsuarioController {
	@RequestMapping(value = "agregarTipoUsuario", method = RequestMethod.GET)
	public ModelAndView agregarUsuario() {
		ModelAndView mv = new ModelAndView("agregarTipoUsuario", "command", new CTipoUsuario());
		mv.setViewName("agregarTipoUsuario");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarTipoUsuario", method = RequestMethod.GET)
    public void guardarUsuario(Model model, @Validated CTipoUsuario tipoUsuario, BindingResult result,
    		HttpSession session) { 
          CrudTipoUsuario conexTipoUsuario = new CrudTipoUsuario();
          conexTipoUsuario.Conecta();
          conexTipoUsuario.crearTipoUsuario(tipoUsuario.getsDescripcion(),tipoUsuario.getsFecha(),tipoUsuario.getsHora(), session);
     }
	@RequestMapping(value = "actualizarTipoUsuario", method = RequestMethod.GET)
	public ModelAndView actualizarTipoUsuario() {
		ModelAndView mv = new ModelAndView("actualizarTipoUsuario", "command", new CTipoUsuario());
		mv.setViewName("actualizarTipoUsuario");
		return mv;
	}

	@RequestMapping(value = "/rActualizarTipoUsuario", method = RequestMethod.GET)
    public ModelAndView rActualizarTipoUsuario(Model model, @Validated CTipoUsuario datTipoUsuario, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarTipoUsuario", "command", new CTipoUsuario());
			CTipoUsuario tipoUsuario= new CTipoUsuario();
			model.addAttribute("rActualizarTipoUsuario", tipoUsuario);
			mv.setViewName("rActualizarTipoUsuario");
			CrudTipoUsuario conexTipoUsuario = new CrudTipoUsuario();
			conexTipoUsuario.Conecta();
			conexTipoUsuario.consultarTipoUsuario(datTipoUsuario.getiCodigo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarTipoUsuario", method = RequestMethod.GET)
    public void r2ActualizarTipoUsuario(Model model, @Validated CTipoUsuario tipoUsuario, BindingResult result,
    		HttpSession session) { 
          CrudTipoUsuario conexTipoUsuario = new CrudTipoUsuario();
          conexTipoUsuario.Conecta();
          //INSERTA CLIENTE
          conexTipoUsuario.actualizarTipoUsuario(tipoUsuario.getiCodigo(),tipoUsuario.getsDescripcion(),tipoUsuario.getsFecha(),tipoUsuario.getsHora(), session);
     }

	@RequestMapping(value = "consultarTipoUsuario", method = RequestMethod.GET)
	public ModelAndView consultarTipoUsuario(Model model) {
		ModelAndView mv = new ModelAndView("consultarTipoUsuario", "command", new CTipoUsuario());
        CTipoUsuario tipoUsuario = new CTipoUsuario();
        model.addAttribute("consultarTipoUsuario",  tipoUsuario);
		mv.setViewName("consultarTipoUsuario");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarTipoUsuario", method = RequestMethod.GET)
	public ModelAndView rConsultarTipoUsuario(Model model, @Validated CTipoUsuario datTipoUsuario, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarTipoUsuario", "command", new CTipoUsuario());
        CTipoUsuario tipoUsuario = new CTipoUsuario();
        model.addAttribute("rConsultarTipoUsuario",  tipoUsuario);
		mv.setViewName("rConsultarTipoUsuario");
        CrudTipoUsuario conexTipoUsuario = new CrudTipoUsuario();
        conexTipoUsuario.Conecta();
        conexTipoUsuario.consultarTipoUsuario(datTipoUsuario.getiCodigo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarTipoUsuario", method = RequestMethod.GET)
	public ModelAndView borrarTipoUsuario(Model model) {
		ModelAndView mv = new ModelAndView("borrarTipoUsuario", "command", new CTipoUsuario());
        CTipoUsuario tipoUsuario = new CTipoUsuario();
        model.addAttribute("borrarTipoUsuario",  tipoUsuario);
		mv.setViewName("borrarTipoUsuario");
		return mv;
	}

	@RequestMapping(value = "/rBorrarTipoUsuario", method = RequestMethod.GET)
    public void rBorrarTipoUsuario(Model model, @Validated CTipoUsuario tipoUsuario, BindingResult result,
    		HttpSession session) { 
          CrudTipoUsuario conexTipoUsuario = new CrudTipoUsuario();
          conexTipoUsuario.Conecta();
          //INSERTA PAIS
          conexTipoUsuario.borrarTipoUsuario(tipoUsuario.getiCodigo(), session);
     }
}
