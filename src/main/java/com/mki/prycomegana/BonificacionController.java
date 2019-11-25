package com.mki.prycomegana;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudBonificacion;
import financiero.CBonificaciones;
import financiero.CRecarga;

@Controller
public class BonificacionController {
	@RequestMapping(value = "agregarBonificacion", method = RequestMethod.GET)
	public ModelAndView agregarBonificacion() {
		ModelAndView mv = new ModelAndView("agregarBonificacion", "command", new CBonificaciones());
		mv.setViewName("agregarBonificacion");
		return mv;
	}
	
	@RequestMapping(value = "actualizarBonificacion", method = RequestMethod.GET)
	public ModelAndView actualizarBonificacion() {
		ModelAndView mv = new ModelAndView("actualizarBonificacion", "command", new CBonificaciones());
		mv.setViewName("actualizarBonificacion");
		return mv;
	}

	@RequestMapping(value = "/rAgregarBonificacion", method = RequestMethod.GET)
    public void guardarBonificacion(Model model, @Validated CBonificaciones bonificacion, BindingResult result,
    		HttpSession session) { 
          CrudBonificacion conexBonificacion = new CrudBonificacion();
          conexBonificacion.Conecta();
          //INSERTA PAIS
          conexBonificacion.crearBonificacion(bonificacion.getlCliente(),bonificacion.getlValor(),bonificacion.getsFecha(),bonificacion.getsHora(), session);
     }

	@RequestMapping(value = "/rActualizarBonificacion", method = RequestMethod.GET)
    public ModelAndView rActualizarBonificacion(Model model, @Validated CBonificaciones datbonificacion, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarBonificacion", "command", new CBonificaciones());
			CBonificaciones bonificacion = new CBonificaciones();
			model.addAttribute("rActualizarBonificacion", bonificacion);
			mv.setViewName("rActualizarBonificacion");
			CrudBonificacion conexBonificacion = new CrudBonificacion();
			conexBonificacion.Conecta();
			//INSERTA DEPARTAMENTO
			conexBonificacion.consultarBonificacion(datbonificacion.getlCodigo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarBonificacion", method = RequestMethod.GET)
    public void r2ActualizarBonificacion(Model model, @Validated CBonificaciones bonificacion, BindingResult result,
    		HttpSession session) { 
          CrudBonificacion conexBonificacion = new CrudBonificacion();
          conexBonificacion.Conecta();
          //INSERTA PAIS
          conexBonificacion.actualizarBonificaciones(bonificacion.getlCodigo(), bonificacion.getlCliente(), bonificacion.getlValor(), bonificacion.getsFecha(), bonificacion.getsHora(), session);
     }

	@RequestMapping(value = "consultarBonificacion", method = RequestMethod.GET)
	public ModelAndView consultarBonificacion(Model model) {
		ModelAndView mv = new ModelAndView("consultarBonificacion", "command", new CBonificaciones());
        CBonificaciones bonificacion = new CBonificaciones();
        model.addAttribute("consultarBonificacion",  bonificacion);
		mv.setViewName("consultarBonificacion");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarBonificacion", method = RequestMethod.GET)
	public ModelAndView rConsultarBonificacion(Model model, @Validated CBonificaciones datbonificacion, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarBonificacion", "command", new CBonificaciones());
        CRecarga recarga = new CRecarga();
        model.addAttribute("rConsultarBonificacion",  recarga);
		mv.setViewName("rConsultarBonificacion");
        //IMPRIME EN CONSOLA VALOR DEL PAIS
        CrudBonificacion conexBonificacion = new CrudBonificacion();
        conexBonificacion.Conecta();
        //INSERTA PAIS
        conexBonificacion.consultarBonificacion(datbonificacion.getlCodigo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarBonificacion", method = RequestMethod.GET)
	public ModelAndView borrarBonificacion(Model model) {
		ModelAndView mv = new ModelAndView("borrarBonificacion", "command", new CBonificaciones());
        CBonificaciones bonificacion = new CBonificaciones();
        model.addAttribute("borrarBonificacion",  bonificacion);
		mv.setViewName("borrarBonificacion");
		return mv;
	}

	@RequestMapping(value = "/rBorrarBonificacion", method = RequestMethod.GET)
    public void rBorrarBonificacion(Model model, @Validated CBonificaciones bonificacion, BindingResult result,
    		HttpSession session) { 
          CrudBonificacion conexBonificacion = new CrudBonificacion();
          conexBonificacion.Conecta();
          //INSERTA PAIS
          conexBonificacion.borrarBonificacion(bonificacion.getlCodigo(), session);
     }
}
