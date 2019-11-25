package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import conexion.CrudRestaurante;
import financiero.CRestaurante;

@Controller
public class RestauranteController {
	@RequestMapping(value = "/agregarRestaurante", method = RequestMethod.GET)
	public ModelAndView agregarRestaurante() {
		ModelAndView mv = new ModelAndView("agregarRestaurante", "command", new CRestaurante());
		mv.setViewName("agregarRestaurante");
		return mv;
	}
	@RequestMapping(value = "/rAgregarRestaurante", method = RequestMethod.GET)
    public void guardarTarifa(Model model, @Validated CRestaurante restaurante, BindingResult result,
    		HttpSession session) { 
          CrudRestaurante conexRestaurante = new CrudRestaurante();
          conexRestaurante.Conecta();
          //INSERTA PAIS
          conexRestaurante.crearRestaurante(restaurante.getsNombre(),restaurante.getsDescripcion(),restaurante.getsTelefono(),restaurante.getlPropietario(),restaurante.getiConvenio(),restaurante.getiTipo(),restaurante.getsFecha(),restaurante.getsHora(), session);
     }
	@RequestMapping(value = "actualizarRestaurante", method = RequestMethod.GET)
	public ModelAndView actualizarRestaurante() {
		ModelAndView mv = new ModelAndView("actualizarRestaurante", "command", new CRestaurante());
		mv.setViewName("actualizarRestaurante");
		return mv;
	}
	@RequestMapping(value = "/rActualizarRestaurante", method = RequestMethod.GET)
    public ModelAndView rActualizarRestaurante(Model model, @Validated CRestaurante datRestaurante, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarRestaurante", "command", new CRestaurante());
			CRestaurante restaurante = new CRestaurante();
			model.addAttribute("rActualizarRestaurante", restaurante);
			mv.setViewName("rActualizarRestaurante");
			CrudRestaurante conexRestaurante = new CrudRestaurante();
			conexRestaurante.Conecta();
			//INSERTA DEPARTAMENTO
			conexRestaurante.consultarRestaurante(datRestaurante.getlCodigo(), session);
			return mv;
     }
	@RequestMapping(value = "/r2ActualizarRestaurante", method = RequestMethod.GET)
    public void r2ActualizarRestaurante(Model model, @Validated CRestaurante restaurante, BindingResult result,
    		HttpSession session) { 
          CrudRestaurante conexRestaurante = new CrudRestaurante();
          conexRestaurante.Conecta();
          //INSERTA CONVENIO
          conexRestaurante.actualizarRestaurante(restaurante.getlCodigo(), restaurante.getsNombre(),restaurante.getsDescripcion(), restaurante.getsTelefono(),restaurante.getlPropietario(), restaurante.getiConvenio(),restaurante.getiTipo(),restaurante.getsFecha(),restaurante.getsHora(), session);
     }
	@RequestMapping(value = "consultarRestaurante", method = RequestMethod.GET)
	public ModelAndView consultarRestaurante(Model model) {
		ModelAndView mv = new ModelAndView("consultarRestaurante", "command", new CRestaurante());
        CRestaurante restaurante = new CRestaurante();
        model.addAttribute("consultarRestaurante",  restaurante);
		mv.setViewName("consultarRestaurante");
		return mv;
	}
	@RequestMapping(value = "rConsultarRestaurante", method = RequestMethod.GET)
	public ModelAndView rConsultarRestaurante(Model model, @Validated CRestaurante datRestaurante, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarRestaurante", "command", new CRestaurante());
        CRestaurante restaurante = new CRestaurante();
        model.addAttribute("rConsultarRestaurante",  restaurante);
		mv.setViewName("rConsultarRestaurante");
        //IMPRIME EN CONSOLA VALOR DEL PAIS
        CrudRestaurante conexRestaurante= new CrudRestaurante();
        conexRestaurante.Conecta();
        //INSERTA PAIS
        conexRestaurante.consultarRestaurante(datRestaurante.getlCodigo(), session);
		return mv;
	}
	@RequestMapping(value = "borrarRestaurante", method = RequestMethod.GET)
	public ModelAndView borrarRestaurante(Model model) {
		ModelAndView mv = new ModelAndView("borrarRestaurante", "command", new CRestaurante());
        CRestaurante restaurante = new CRestaurante();
        model.addAttribute("borrarRestaurante", restaurante);
		mv.setViewName("borrarRestaurante");
		return mv;
	}
	@RequestMapping(value = "/rBorrarRestaurante", method = RequestMethod.GET)
    public void rBorrarTarifa(Model model, @Validated CRestaurante restaurante, BindingResult result,
    		HttpSession session) { 
          CrudRestaurante conexRestaurante = new CrudRestaurante();
          conexRestaurante.Conecta();
          //RESPUESTA ELIMINAR TARIFA
          conexRestaurante.borrarRestaurante(restaurante.getlCodigo(), session);
     }
}
