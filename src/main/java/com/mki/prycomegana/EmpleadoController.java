package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudEmpleado;
import usuarios.CEmpleado;

@Controller
public class EmpleadoController {
	@RequestMapping(value = "agregarEmpleado", method = RequestMethod.GET)
	public ModelAndView agregarEmpleado() {
		ModelAndView mv = new ModelAndView("agregarEmpleado", "command", new CEmpleado());
		mv.setViewName("agregarEmpleado");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarEmpleado", method = RequestMethod.GET)
    public void guardarEmpleado(Model model, @Validated CEmpleado empleado, BindingResult result,
    		HttpSession session) { 
          CrudEmpleado conexEmpleado = new CrudEmpleado();
          conexEmpleado.Conecta();
          //INSERTA PAIS
          conexEmpleado.crearEmpleado(empleado.getiCargo(),empleado.getiArea(),empleado.getlPersona(), empleado.getsFecha(),empleado.getsHora(), session);
     }
	@RequestMapping(value = "actualizarEmpleado", method = RequestMethod.GET)
	public ModelAndView actualizarEmpleado() {
		ModelAndView mv = new ModelAndView("actualizarEmpleado", "command", new CEmpleado());
		mv.setViewName("actualizarEmpleado");
		return mv;
	}

	@RequestMapping(value = "/rActualizarEmpleado", method = RequestMethod.GET)
    public ModelAndView rActualizarEmpleado(Model model, @Validated CEmpleado datEmpleado, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarEmpleado", "command", new CEmpleado());
			CEmpleado empleado= new CEmpleado();
			model.addAttribute("rActualizarEmpleado", empleado);
			mv.setViewName("rActualizarEmpleado");
			CrudEmpleado conexEmpleado = new CrudEmpleado();
			conexEmpleado.Conecta();
			//INSERTA DEPARTAMENTO
			conexEmpleado.consultarEmpleado(datEmpleado.getlEmpleado(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarEmpleado", method = RequestMethod.GET)
    public void r2ActualizarEmpleado(Model model, @Validated CEmpleado empleado, BindingResult result,
    		HttpSession session) { 
          CrudEmpleado conexEmpleado = new CrudEmpleado();
          conexEmpleado.Conecta();
          //INSERTA PAIS
          conexEmpleado.actualizarEmpleado(empleado.getlEmpleado(), empleado.getiCargo(),empleado.getiArea(),empleado.getlPersona(), empleado.getsFecha(),empleado.getsHora(), session);
     }

	@RequestMapping(value = "consultarEmpleado", method = RequestMethod.GET)
	public ModelAndView consultarEmpleado(Model model) {
		ModelAndView mv = new ModelAndView("consultarEmpleado", "command", new CEmpleado());
        CEmpleado empleado = new CEmpleado();
        model.addAttribute("consultarEmpleado",  empleado);
		mv.setViewName("consultarEmpleado");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarEmpleado", method = RequestMethod.GET)
	public ModelAndView rConsultarEmpleado(Model model, @Validated CEmpleado datEmpleado, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarEmpleado", "command", new CEmpleado());
        CEmpleado empleado = new CEmpleado();
        model.addAttribute("rConsultarEmpleado",  empleado);
		mv.setViewName("rConsultarEmpleado");
        CrudEmpleado conexEmpleado = new CrudEmpleado();
        conexEmpleado.Conecta();
        //INSERTA PAIS
        conexEmpleado.consultarEmpleado(datEmpleado.getlEmpleado(), session);
		return mv;
	}

	@RequestMapping(value = "borrarEmpleado", method = RequestMethod.GET)
	public ModelAndView borrarEmpleado(Model model) {
		ModelAndView mv = new ModelAndView("borrarEmpleado", "command", new CEmpleado());
        CEmpleado empleado = new CEmpleado();
        model.addAttribute("borrarEmpleado",  empleado);
		mv.setViewName("borrarEmpleado");
		return mv;
	}

	@RequestMapping(value = "/rBorrarEmpleado", method = RequestMethod.GET)
    public void rBorrarEmpleado(Model model, @Validated CEmpleado empleado, BindingResult result,
    		HttpSession session) { 
          CrudEmpleado conexEmpleado = new CrudEmpleado();
          conexEmpleado.Conecta();
          //INSERTA PAIS
          conexEmpleado.borrarEmpleado(empleado.getlEmpleado(), session);
     }
}
