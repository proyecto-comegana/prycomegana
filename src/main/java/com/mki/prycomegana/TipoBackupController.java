package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import backups.CTipoBackup;
import conexion.CrudTipoBackup;

@Controller
public class TipoBackupController {
	@RequestMapping(value = "agregarTipoBackup", method = RequestMethod.GET)
	public ModelAndView agregarTipoBackup() {
		ModelAndView mv = new ModelAndView("agregarTipoBackup", "command", new CTipoBackup());
		mv.setViewName("agregarTipoBackup");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarTipoBackup", method = RequestMethod.GET)
    public void guardarTipoBackup(Model model, @Validated CTipoBackup datTipoBackup, BindingResult result,
    		HttpSession session) { 
          CrudTipoBackup conexTipoBackup = new CrudTipoBackup();
          conexTipoBackup.Conecta();
          conexTipoBackup.crearTipoBackup(datTipoBackup.getsDescripcion(),datTipoBackup.getsFecha(),datTipoBackup.getsHora(), session);
     }
	@RequestMapping(value = "actualizarTipoBackup", method = RequestMethod.GET)
	public ModelAndView actualizarTipoBackup() {
		ModelAndView mv = new ModelAndView("actualizarTipoBackup", "command", new CTipoBackup());
		mv.setViewName("actualizarTipoBackup");
		return mv;
	}

	@RequestMapping(value = "/rActualizarTipoBackup", method = RequestMethod.GET)
    public ModelAndView rActualizarTipoBackup(Model model, @Validated CTipoBackup datTipoBackup, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarTipoBackup", "command", new CTipoBackup());
			CTipoBackup tipoBackup= new CTipoBackup();
			model.addAttribute("rActualizarTipoBackup", tipoBackup);
			mv.setViewName("rActualizarTipoBackup");
			CrudTipoBackup conexTipoBackup = new CrudTipoBackup();
			conexTipoBackup.Conecta();
			conexTipoBackup.consultarTipoBackup(datTipoBackup.getiCodigo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarTipoBackup", method = RequestMethod.GET)
    public void r2ActualizarTipoBackup(Model model, @Validated CTipoBackup datTipoBackup, BindingResult result,
    		HttpSession session) { 
          CrudTipoBackup conexTipoBackup = new CrudTipoBackup();
          conexTipoBackup.Conecta();
          //INSERTA PAIS
          conexTipoBackup.actualizarTipoBackup(datTipoBackup.getiCodigo(), datTipoBackup.getsDescripcion(),datTipoBackup.getsFecha(),datTipoBackup.getsHora(), session);
     }

	@RequestMapping(value = "consultarTipoBackup", method = RequestMethod.GET)
	public ModelAndView consultarTipoBackup(Model model) {
		ModelAndView mv = new ModelAndView("consultarTipoBackup", "command", new CTipoBackup());
        CTipoBackup tipoBackup = new CTipoBackup();
        model.addAttribute("consultarTipoBackup",  tipoBackup);
		mv.setViewName("consultarTipoBackup");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarTipoBackup", method = RequestMethod.GET)
	public ModelAndView rConsultarTipoBackup(Model model, @Validated CTipoBackup datTipoBackup, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarTipoBackup", "command", new CTipoBackup());
        CTipoBackup tipoBackup = new CTipoBackup();
        model.addAttribute("rConsultarTipoBackup",  tipoBackup);
		mv.setViewName("rConsultarTipoBackup");
        CrudTipoBackup conexTipoBackup = new CrudTipoBackup();
        conexTipoBackup.Conecta();
        conexTipoBackup.consultarTipoBackup(datTipoBackup.getiCodigo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarTipoBackup", method = RequestMethod.GET)
	public ModelAndView borrarTipoBackup(Model model) {
		ModelAndView mv = new ModelAndView("borrarTipoBackup", "command", new CTipoBackup());
        CTipoBackup tipoBackup = new CTipoBackup();
        model.addAttribute("borrarTipoBackup",  tipoBackup);
		mv.setViewName("borrarTipoBackup");
		return mv;
	}

	@RequestMapping(value = "/rBorrarTipoBackup", method = RequestMethod.GET)
    public void rBorrarTipoBackup(Model model, @Validated CTipoBackup tipoBackup, BindingResult result,
    		HttpSession session) { 
          CrudTipoBackup conexTipoBackup = new CrudTipoBackup();
          conexTipoBackup.Conecta();
          conexTipoBackup.borrarTipoBackup(tipoBackup.getiCodigo(), session);
     }
}
