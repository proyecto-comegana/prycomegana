package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import conexion.CrudTipoRestaurante;
import financiero.CTipoRestaurante;

@Controller
public class TipoRestauranteController {
	@RequestMapping(value = "/agregarTipoRestaurante", method = RequestMethod.GET)
	public ModelAndView agregarTipoRestaurante() {
		ModelAndView mv = new ModelAndView("agregarTipoRestaurante", "command", new CTipoRestaurante());
		mv.setViewName("agregarTipoRestaurante");
		return mv;
	}
	@RequestMapping(value = "/rAgregarTipoRestaurante", method = RequestMethod.GET)
    public void guardarTipoRestaurante(Model model, @Validated CTipoRestaurante tipoRestaurante, BindingResult result,
    		HttpSession session) { 
          CrudTipoRestaurante conexTipoRestaurante = new CrudTipoRestaurante();
          conexTipoRestaurante.Conecta();
          //INSERTA TIPO RESTAURANTE
          conexTipoRestaurante.crearTipoRestaurante(tipoRestaurante.getsNombre(),tipoRestaurante.getsDescripcion(),tipoRestaurante.getsFecha(),tipoRestaurante.getsHora(), session);
     }
	@RequestMapping(value = "actualizarTipoRestaurante", method = RequestMethod.GET)
	public ModelAndView actualizarTipoRestaurante() {
		ModelAndView mv = new ModelAndView("actualizarTipoRestaurante", "command", new CTipoRestaurante());
		mv.setViewName("actualizarTipoRestaurante");
		return mv;
	}
	@RequestMapping(value = "/rActualizarTipoRestaurante", method = RequestMethod.GET)
    public ModelAndView rActualizarTipoRestaurante(Model model, @Validated CTipoRestaurante datTipoRestaurante, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarTipoRestaurante", "command", new CTipoRestaurante());
			CTipoRestaurante tipoRestaurante = new CTipoRestaurante();
			model.addAttribute("rActualizarTipoRestaurante", tipoRestaurante);
			mv.setViewName("rActualizarTipoRestaurante");
			CrudTipoRestaurante conexTipoRestaurante = new CrudTipoRestaurante();
			conexTipoRestaurante.Conecta();
			//INSERTA DEPARTAMENTO
			conexTipoRestaurante.consultarTipoRestaurante(datTipoRestaurante.getiCodigo(), session);
			return mv;
     }
	@RequestMapping(value = "/r2ActualizarTipoRestaurante", method = RequestMethod.GET)
    public void r2ActualizarTipoRestaurante(Model model, @Validated CTipoRestaurante tipoRestaurante, BindingResult result,
    		HttpSession session) { 
          CrudTipoRestaurante conexTipoRestaurante = new CrudTipoRestaurante();
          conexTipoRestaurante.Conecta();
          //INSERTA CONVENIO
          conexTipoRestaurante.actualizarTipoRestaurante(tipoRestaurante.getiCodigo(), tipoRestaurante.getsNombre(),tipoRestaurante.getsDescripcion(), tipoRestaurante.getsFecha(),tipoRestaurante.getsHora(), session);
     }
	@RequestMapping(value = "consultarTipoRestaurante", method = RequestMethod.GET)
	public ModelAndView consultarTipoRestaurante(Model model) {
		ModelAndView mv = new ModelAndView("consultarTipoRestaurante", "command", new CTipoRestaurante());
        CTipoRestaurante tipoRestaurante = new CTipoRestaurante();
        model.addAttribute("consultarTipoRestaurante",  tipoRestaurante);
		mv.setViewName("consultarTipoRestaurante");
		return mv;
	}
	@RequestMapping(value = "rConsultarTipoRestaurante", method = RequestMethod.GET)
	public ModelAndView rConsultarTipoRestaurante(Model model, @Validated CTipoRestaurante datTipoRestaurante, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarTipoRestaurante", "command", new CTipoRestaurante());
        CTipoRestaurante tipoRestaurante = new CTipoRestaurante();
        model.addAttribute("rConsultarTipoRestaurante",  tipoRestaurante);
		mv.setViewName("rConsultarTipoRestaurante");
        //IMPRIME EN CONSOLA VALOR DEL PAIS
        CrudTipoRestaurante conexTipoRestaurante= new CrudTipoRestaurante();
        conexTipoRestaurante.Conecta();
        //INSERTA PAIS
        conexTipoRestaurante.consultarTipoRestaurante(datTipoRestaurante.getiCodigo(), session);
		return mv;
	}
	@RequestMapping(value = "borrarTipoRestaurante", method = RequestMethod.GET)
	public ModelAndView borrarTipoRestaurante(Model model) {
		ModelAndView mv = new ModelAndView("borrarTipoRestaurante", "command", new CTipoRestaurante());
        CTipoRestaurante tipoRestaurante = new CTipoRestaurante();
        model.addAttribute("borrarTipoRestaurante", tipoRestaurante);
		mv.setViewName("borrarTipoRestaurante");
		return mv;
	}
	@RequestMapping(value = "/rBorrarTipoRestaurante", method = RequestMethod.GET)
    public void rBorrarTarifa(Model model, @Validated CTipoRestaurante restaurante, BindingResult result,
    		HttpSession session) { 
          CrudTipoRestaurante conexTipoRestaurante = new CrudTipoRestaurante();
          conexTipoRestaurante.Conecta();
          //RESPUESTA ELIMINAR TARIFA
          conexTipoRestaurante.borrarTipoRestaurante(restaurante.getiCodigo(), session);
     }
}
