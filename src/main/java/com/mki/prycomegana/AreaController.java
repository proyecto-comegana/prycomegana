package com.mki.prycomegana;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudArea;
import financiero.CArea;

@Controller
public class AreaController {
	@RequestMapping(value = "agregarArea", method = RequestMethod.GET)
	public ModelAndView agregarArea() {
		ModelAndView mv = new ModelAndView("agregarArea", "command", new CArea());
		mv.setViewName("agregarArea");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarArea", method = RequestMethod.GET)
    public void guardarArea(Model model, @Validated CArea area, BindingResult result,
    		HttpSession session) { 
          CrudArea conexArea = new CrudArea();
          conexArea.Conecta();
          //INSERTA PAIS
          conexArea.crearArea(area.getsNombre(),area.getsDescripcion(),area.getsFecha(),area.getsHora(), session);
     }
	@RequestMapping(value = "actualizarArea", method = RequestMethod.GET)
	public ModelAndView actualizarBonificacion() {
		ModelAndView mv = new ModelAndView("actualizarArea", "command", new CArea());
		mv.setViewName("actualizarArea");
		return mv;
	}

	@RequestMapping(value = "/rActualizarArea", method = RequestMethod.GET)
    public ModelAndView rActualizarArea(Model model, @Validated CArea datArea, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarArea", "command", new CArea());
			CArea area= new CArea();
			model.addAttribute("rActualizarArea", area);
			mv.setViewName("rActualizarArea");
			CrudArea conexArea = new CrudArea();
			conexArea.Conecta();
			//INSERTA DEPARTAMENTO
			conexArea.consultarArea(datArea.getiCodigo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarArea", method = RequestMethod.GET)
    public void r2ActualizarArea(Model model, @Validated CArea area, BindingResult result,
    		HttpSession session) { 
          CrudArea conexArea = new CrudArea();
          conexArea.Conecta();
          //INSERTA PAIS
          conexArea.actualizarArea(area.getiCodigo(), area.getsNombre(), area.getsDescripcion(), area.getsFecha(), area.getsHora(), session);
     }

	@RequestMapping(value = "consultarArea", method = RequestMethod.GET)
	public ModelAndView consultarArea(Model model) {
		ModelAndView mv = new ModelAndView("consultarArea", "command", new CArea());
        CArea area = new CArea();
        model.addAttribute("consultarArea",  area);
		mv.setViewName("consultarArea");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarArea", method = RequestMethod.GET)
	public ModelAndView rConsultarArea(Model model, @Validated CArea datArea, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarArea", "command", new CArea());
        CArea area = new CArea();
        model.addAttribute("rConsultarArea",  area);
		mv.setViewName("rConsultarArea");
        //IMPRIME EN CONSOLA VALOR DEL PAIS
        CrudArea conexArea = new CrudArea();
        conexArea.Conecta();
        //INSERTA PAIS
        conexArea.consultarArea(datArea.getiCodigo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarArea", method = RequestMethod.GET)
	public ModelAndView borrarArea(Model model) {
		ModelAndView mv = new ModelAndView("borrarArea", "command", new CArea());
        CArea bonificacion = new CArea();
        model.addAttribute("borrarArea",  bonificacion);
		mv.setViewName("borrarArea");
		return mv;
	}

	@RequestMapping(value = "/rBorrarArea", method = RequestMethod.GET)
    public void rBorrarArea(Model model, @Validated CArea area, BindingResult result,
    		HttpSession session) { 
          CrudArea conexArea = new CrudArea();
          conexArea.Conecta();
          //INSERTA PAIS
          conexArea.borrarArea(area.getiCodigo(), session);
     }
}
