package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import backups.CBackup;
import conexion.CrudBackup;

@Controller
public class BackupController {
	@RequestMapping(value = "agregarBackup", method = RequestMethod.GET)
	public ModelAndView agregarBackup() {
		ModelAndView mv = new ModelAndView("agregarBackup", "command", new CBackup());
		mv.setViewName("agregarBackup");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarBackup", method = RequestMethod.GET)
    public void guardarBackup(Model model, @Validated CBackup datBackup, BindingResult result,
    		HttpSession session) { 
          CrudBackup conexBackup = new CrudBackup();
          conexBackup.Conecta();
          conexBackup.crearBackup(datBackup.getsDescripcion(),datBackup.getiTipo(), datBackup.getsNombreArchivo(),datBackup.getsRutaArchivo(),datBackup.getsFecha(),datBackup.getsHora(), session);
     }
	@RequestMapping(value = "actualizarBackup", method = RequestMethod.GET)
	public ModelAndView actualizarBackup() {
		ModelAndView mv = new ModelAndView("actualizarBackup", "command", new CBackup());
		mv.setViewName("actualizarBackup");
		return mv;
	}

	@RequestMapping(value = "/rActualizarBackup", method = RequestMethod.GET)
    public ModelAndView rActualizarBackup(Model model, @Validated CBackup datBackup, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarBackup", "command", new CBackup());
			CBackup backup= new CBackup();
			model.addAttribute("rActualizarBackup", backup);
			mv.setViewName("rActualizarBackup");
			CrudBackup conexBackup = new CrudBackup();
			conexBackup.Conecta();
			conexBackup.consultarBackup(datBackup.getiCodigo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarBackup", method = RequestMethod.GET)
    public void r2ActualizarBackup(Model model, @Validated CBackup datBackup, BindingResult result,
    		HttpSession session) { 
          CrudBackup conexBackup = new CrudBackup();
          conexBackup.Conecta();
          //INSERTA BACKUP
          conexBackup.actualizarBackup(datBackup.getiCodigo(), datBackup.getsDescripcion(),datBackup.getiTipo(), datBackup.getsNombreArchivo(),datBackup.getsRutaArchivo(),datBackup.getsFecha(),datBackup.getsHora(), session);
     }

	@RequestMapping(value = "consultarBackup", method = RequestMethod.GET)
	public ModelAndView consultarBackup(Model model) {
		ModelAndView mv = new ModelAndView("consultarBackup", "command", new CBackup());
        CBackup backup = new CBackup();
        model.addAttribute("consultarBackup",  backup);
		mv.setViewName("consultarBackup");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarBackup", method = RequestMethod.GET)
	public ModelAndView rConsultarBackup(Model model, @Validated CBackup datBackup, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarBackup", "command", new CBackup());
        CBackup backup = new CBackup();
        model.addAttribute("rConsultarBackup",  backup);
		mv.setViewName("rConsultarBackup");
        CrudBackup conexBackup = new CrudBackup();
        conexBackup.Conecta();
        conexBackup.consultarBackup(datBackup.getiCodigo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarBackup", method = RequestMethod.GET)
	public ModelAndView borrarBackup(Model model) {
		ModelAndView mv = new ModelAndView("borrarBackup", "command", new CBackup());
        CBackup backup = new CBackup();
        model.addAttribute("borrarBackup",  backup);
		mv.setViewName("borrarBackup");
		return mv;
	}

	@RequestMapping(value = "/rBorrarBackup", method = RequestMethod.GET)
    public void rBorrarBackup(Model model, @Validated CBackup datBackup, BindingResult result,
    		HttpSession session) { 
          CrudBackup conexBackup = new CrudBackup();
          conexBackup.Conecta();
          conexBackup.borrarBackup(datBackup.getiCodigo(), session);
     }
}
