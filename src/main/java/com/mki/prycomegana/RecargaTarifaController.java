package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import conexion.CrudRecargaTarifa;
import financiero.CRecargaTarifa;

@Controller
public class RecargaTarifaController {
	@RequestMapping(value = "/agregarRecargaTarifa", method = RequestMethod.GET)
	public ModelAndView agregarRecargaTarifa() {
		ModelAndView mv = new ModelAndView("agregarRecargaTarifa", "command", new CRecargaTarifa());
		mv.setViewName("agregarRecargaTarifa");
		return mv;
	}
	@RequestMapping(value = "/rAgregarRecargaTarifa", method = RequestMethod.GET)
    public void guardarRecargaTarifa(Model model, @Validated CRecargaTarifa recargaTarifa, BindingResult result,
    		HttpSession session) { 
          CrudRecargaTarifa conexRecargaTarifa = new CrudRecargaTarifa();
          conexRecargaTarifa.Conecta();
          //INSERTA TIPO RESTAURANTE
          conexRecargaTarifa.crearRecargaTarifa(recargaTarifa.getlRecarga(),recargaTarifa.getiTarifa(),recargaTarifa.getsFecha(),recargaTarifa.getsHora(), session);
    }
	@RequestMapping(value = "actualizarRecargaTarifa", method = RequestMethod.GET)
	public ModelAndView actualizarRecargaTarifa() {
		ModelAndView mv = new ModelAndView("actualizarRecargaTarifa", "command", new CRecargaTarifa());
		mv.setViewName("actualizarRecargaTarifa");
		return mv;
	}
	@RequestMapping(value = "/rActualizarRecargaTarifa", method = RequestMethod.GET)
    public ModelAndView rActualizarRecargaTarifa(Model model, @Validated CRecargaTarifa datRecargaTarifa, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarRecargaTarifa", "command", new CRecargaTarifa());
			CRecargaTarifa recargaTarifa = new CRecargaTarifa();
			model.addAttribute("rActualizarRecargaTarifa", recargaTarifa);
			mv.setViewName("rActualizarRecargaTarifa");
			CrudRecargaTarifa conexRecargaTarifa = new CrudRecargaTarifa();
			conexRecargaTarifa.Conecta();
			//INSERTA DEPARTAMENTO
			conexRecargaTarifa.consultarRecargaTarifa(datRecargaTarifa.getlRecarga(),datRecargaTarifa.getiTarifa(), session);
			return mv;
     }
	@RequestMapping(value = "/r2ActualizarRecargaTarifa", method = RequestMethod.GET)
    public void r2ActualizarRecargaTarifa(Model model, @Validated CRecargaTarifa recargaTarifa, BindingResult result,
    		HttpSession session) { 
          CrudRecargaTarifa conexRecargaTarifa = new CrudRecargaTarifa();
          conexRecargaTarifa.Conecta();
          //INSERTA CONVENIO
          conexRecargaTarifa.actualizarRecargaTarifa(recargaTarifa.getlRecarga(),recargaTarifa.getiTarifa(), recargaTarifa.getsFecha(),recargaTarifa.getsHora(), session);
     }
	@RequestMapping(value = "consultarRecargaTarifa", method = RequestMethod.GET)
	public ModelAndView consultarRecargaTarifa(Model model) {
		ModelAndView mv = new ModelAndView("consultarRecargaTarifa", "command", new CRecargaTarifa());
        CRecargaTarifa recargaTarifa = new CRecargaTarifa();
        model.addAttribute("consultarRecargaTarifa",  recargaTarifa);
		mv.setViewName("consultarRecargaTarifa");
		return mv;
	}
	@RequestMapping(value = "rConsultarRecargaTarifa", method = RequestMethod.GET)
	public ModelAndView rConsultarRecargaTarifa(Model model, @Validated CRecargaTarifa datRecargaTarifa, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarRecargaTarifa", "command", new CRecargaTarifa());
        CRecargaTarifa recargaTarifa = new CRecargaTarifa();
        model.addAttribute("rConsultarRecargaTarifa",  recargaTarifa);
		mv.setViewName("rConsultarRecargaTarifa");
        CrudRecargaTarifa conexRecargaTarifa = new CrudRecargaTarifa();
        conexRecargaTarifa.Conecta();
        //INSERTA PAIS
        conexRecargaTarifa.consultarRecargaTarifa(datRecargaTarifa.getlRecarga(),datRecargaTarifa.getiTarifa(), session);
		return mv;
	}
	@RequestMapping(value = "borrarRecargaTarifa", method = RequestMethod.GET)
	public ModelAndView borrarRecargaTarifa(Model model) {
		ModelAndView mv = new ModelAndView("borrarRecargaTarifa", "command", new CRecargaTarifa());
        CRecargaTarifa recargaTarifa = new CRecargaTarifa();
        model.addAttribute("borrarRecargaTarifa", recargaTarifa);
		mv.setViewName("borrarRecargaTarifa");
		return mv;
	}
	@RequestMapping(value = "/rBorrarRecargaTarifa", method = RequestMethod.GET)
    public void rBorrarRecargaTarifa(Model model, @Validated CRecargaTarifa recargaTarifa, BindingResult result,
    		HttpSession session) { 
          CrudRecargaTarifa conexRecargaTarifa = new CrudRecargaTarifa();
          conexRecargaTarifa.Conecta();
          //RESPUESTA ELIMINAR TARIFA
          conexRecargaTarifa.borrarRecargaTarifa(recargaTarifa.getlRecarga(),recargaTarifa.getiTarifa(), session);
     }
}
