package com.mki.prycomegana;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudRecarga;
import financiero.CRecarga;

@Controller
public class RecargaController {
	@RequestMapping(value = "agregarRecarga", method = RequestMethod.GET)
	public ModelAndView agregarRecarga() {
		ModelAndView mv = new ModelAndView("agregarRecarga", "command", new CRecarga());
		mv.setViewName("agregarRecarga");
		return mv;
	}

	@RequestMapping(value = "/rAgregarRecarga", method = RequestMethod.GET)
    public void guardarRecarga(Model model, @Validated CRecarga recarga, BindingResult result,
    		HttpSession session) { 
          CrudRecarga conexRecarga = new CrudRecarga();
          conexRecarga.Conecta();
          //INSERTA RECARGA
          conexRecarga.crearRecarga(recarga.getlCliente(),recarga.getlValor(),recarga.getsFecha(),recarga.getsHora(), session);
     }
	@RequestMapping(value = "actualizarRecarga", method = RequestMethod.GET)
	public ModelAndView actualizarRecarga() {
		ModelAndView mv = new ModelAndView("actualizarRecarga", "command", new CRecarga());
		mv.setViewName("actualizarRecarga");
		return mv;
	}
	
	@RequestMapping(value = "/rActualizarRecarga", method = RequestMethod.GET)
    public ModelAndView rActualizarRecarga(Model model, @Validated CRecarga datrecarga, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarRecarga", "command", new CRecarga());
			CRecarga recarga = new CRecarga();
			model.addAttribute("rActualizarRecarga", recarga);
			mv.setViewName("rActualizarRecarga");
			//IMPRIME EN CONSOLA VALOR DE LA CIUDAD
			System.out.println("Codigo:"+datrecarga.getlCodigo());
			CrudRecarga conexRecarga = new CrudRecarga();
			conexRecarga.Conecta();
			//INSERTA DEPARTAMENTO
			conexRecarga.consultarRecarga(datrecarga.getlCodigo(), session);
			return mv;
     }

	@RequestMapping(value = "/r2ActualizarRecarga", method = RequestMethod.GET)
    public void r2ActualizarRecarga(Model model, @Validated CRecarga recarga, BindingResult result,
    		HttpSession session) { 
          CrudRecarga conexRecarga = new CrudRecarga();
          conexRecarga.Conecta();
          //INSERTA PAIS
          conexRecarga.actualizarRecarga(recarga.getlCodigo(), recarga.getlCliente(), recarga.getlValor(), recarga.getsFecha(), recarga.getsHora(), session);
     }

	@RequestMapping(value = "consultarRecarga", method = RequestMethod.GET)
	public ModelAndView consultarRecarga(Model model) {
		ModelAndView mv = new ModelAndView("consultarRecarga", "command", new CRecarga());
        CRecarga recarga = new CRecarga();
        model.addAttribute("consultarRecarga",  recarga);
		mv.setViewName("consultarRecarga");
		return mv;
	}

	
	@RequestMapping(value = "rConsultarRecarga", method = RequestMethod.GET)
	public ModelAndView rConsultarRecarga(Model model, @Validated CRecarga datrecarga, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarRecarga", "command", new CRecarga());
        CRecarga recarga = new CRecarga();
        model.addAttribute("rConsultarRecarga",  recarga);
		mv.setViewName("rConsultarRecarga");
        //IMPRIME EN CONSOLA VALOR DEL PAIS
        CrudRecarga conexRecarga = new CrudRecarga();
        conexRecarga.Conecta();
        //INSERTA PAIS
        conexRecarga.consultarRecarga(datrecarga.getlCodigo(), session);
		return mv;
	}
	
	@RequestMapping(value = "borrarRecarga", method = RequestMethod.GET)
	public ModelAndView borrarRecarga(Model model) {
		ModelAndView mv = new ModelAndView("borrarRecarga", "command", new CRecarga());
        CRecarga recarga = new CRecarga();
        model.addAttribute("borrarRecarga",  recarga);
		mv.setViewName("borrarRecarga");
		return mv;
	}
	
	@RequestMapping(value = "/rBorrarRecarga", method = RequestMethod.GET)
    public void rBorrarRecarga(Model model, @Validated CRecarga recarga, BindingResult result,
    		HttpSession session) { 
          CrudRecarga conexRecarga = new CrudRecarga();
          conexRecarga.Conecta();
          //RESPUESTA ELIMINAR DEPARTAMENTO
          conexRecarga.borrarRecarga(recarga.getlCodigo(), session);
     }

}
