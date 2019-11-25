package com.mki.prycomegana;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import conexion.CrudTarifa;
import financiero.CTarifa;

@Controller
public class TarifaController {
	@RequestMapping(value = "/agregarTarifa", method = RequestMethod.GET)
	public ModelAndView agregarTarifa() {
		ModelAndView mv = new ModelAndView("agregarTarifa", "command", new CTarifa());
		mv.setViewName("agregarTarifa");
		return mv;
	}
	@RequestMapping(value = "/rAgregarTarifa", method = RequestMethod.GET)
    public void guardarTarifa(Model model, @Validated CTarifa tarifa, BindingResult result,
    		HttpSession session) { 
          CrudTarifa conexTarifa = new CrudTarifa();
          conexTarifa.Conecta();
          //INSERTA PAIS
          conexTarifa.crearTarifa(tarifa.getsDescripcion(),tarifa.getlValor(),tarifa.getsFecha(),tarifa.getsHora(), session);
     }
	@RequestMapping(value = "actualizarTarifa", method = RequestMethod.GET)
	public ModelAndView actualizarTarifa() {
		ModelAndView mv = new ModelAndView("actualizarTarifa", "command", new CTarifa());
		mv.setViewName("actualizarTarifa");
		return mv;
	}
	@RequestMapping(value = "/rActualizarTarifa", method = RequestMethod.GET)
    public ModelAndView rActualizarTarifa(Model model, @Validated CTarifa datTarifa, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarTarifa", "command", new CTarifa());
			CTarifa tarifa = new CTarifa();
			model.addAttribute("rActualizarTarifa", tarifa);
			mv.setViewName("rActualizarTarifa");
			CrudTarifa conexTarifa = new CrudTarifa();
			conexTarifa.Conecta();
			//INSERTA DEPARTAMENTO
			conexTarifa.consultarTarifa(datTarifa.getiCodigo(), session);
			return mv;
     }
	@RequestMapping(value = "/r2ActualizarTarifa", method = RequestMethod.GET)
    public void r2ActualizarTarifa(Model model, @Validated CTarifa tarifa, BindingResult result,
    		HttpSession session) { 
          CrudTarifa conexTarifa = new CrudTarifa();
          conexTarifa.Conecta();
          //INSERTA CONVENIO
          conexTarifa.actualizarTarifa(tarifa.getiCodigo(), tarifa.getsDescripcion(), tarifa.getlValor(),tarifa.getsFecha(), tarifa.getsHora(), session);
     }
	@RequestMapping(value = "consultarTarifa", method = RequestMethod.GET)
	public ModelAndView consultarTarifa(Model model) {
		ModelAndView mv = new ModelAndView("consultarTarifa", "command", new CTarifa());
        CTarifa tarifa = new CTarifa();
        model.addAttribute("consultarTarifa",  tarifa);
		mv.setViewName("consultarTarifa");
		return mv;
	}
	@RequestMapping(value = "rConsultarTarifa", method = RequestMethod.GET)
	public ModelAndView rConsultarTarifa(Model model, @Validated CTarifa datTarifa, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarTarifa", "command", new CTarifa());
        CTarifa tarifa = new CTarifa();
        model.addAttribute("rConsultarTarifa",  tarifa);
		mv.setViewName("rConsultarTarifa");
        //IMPRIME EN CONSOLA VALOR DEL PAIS
        CrudTarifa conexTarifa= new CrudTarifa();
        conexTarifa.Conecta();
        //INSERTA PAIS
        conexTarifa.consultarTarifa(datTarifa.getiCodigo(), session);
		return mv;
	}
	@RequestMapping(value = "borrarTarifa", method = RequestMethod.GET)
	public ModelAndView borrarTarifa(Model model) {
		ModelAndView mv = new ModelAndView("borrarTarifa", "command", new CTarifa());
        CTarifa tarifa = new CTarifa();
        model.addAttribute("borrarTarifa",  tarifa);
		mv.setViewName("borrarTarifa");
		return mv;
	}
	@RequestMapping(value = "/rBorrarTarifa", method = RequestMethod.GET)
    public void rBorrarTarifa(Model model, @Validated CTarifa tarifa, BindingResult result,
    		HttpSession session) { 
          CrudTarifa conexTarifa = new CrudTarifa();
          conexTarifa.Conecta();
          //RESPUESTA ELIMINAR TARIFA
          conexTarifa.borrarTarifa(tarifa.getiCodigo(), session);
     }
}
