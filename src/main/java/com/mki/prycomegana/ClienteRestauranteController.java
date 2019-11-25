package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudClienteRestaurante;
import financiero.CClienteRestaurante;

@Controller
public class ClienteRestauranteController {
	@RequestMapping(value = "agregarClienteRestaurante", method = RequestMethod.GET)
	public ModelAndView agregarClienteRestaurante() {
		ModelAndView mv = new ModelAndView("agregarClienteRestaurante", "command", new CClienteRestaurante());
		mv.setViewName("agregarClienteRestaurante");
		return mv;
	}
	
	@RequestMapping(value = "actualizarClienteRestaurante", method = RequestMethod.GET)
	public ModelAndView actualizarClienteRestaurante() {
		ModelAndView mv = new ModelAndView("actualizarClienteRestaurante", "command", new CClienteRestaurante());
		mv.setViewName("actualizarClienteRestaurante");
		return mv;
	}

	@RequestMapping(value = "/rAgregarClienteRestaurante", method = RequestMethod.GET)
    public void guardarClienteRestaurante(Model model, @Validated CClienteRestaurante datClienteRestaurante, BindingResult result,
    		HttpSession session) { 
          CrudClienteRestaurante conexClienteRestaurante = new CrudClienteRestaurante();
          conexClienteRestaurante.Conecta();
          conexClienteRestaurante.crearClienteRestaurante(datClienteRestaurante.getlCliente(),datClienteRestaurante.getlRestaurante(), datClienteRestaurante.getsFecha(),datClienteRestaurante.getsHora(), session);
     }

	@RequestMapping(value = "/rActualizarClienteRestaurante", method = RequestMethod.GET)
    public ModelAndView rActualizarClienteRestaurante(Model model, @Validated CClienteRestaurante datClienteRestaurante, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarClienteRestaurante", "command", new CClienteRestaurante());
			CClienteRestaurante clienteRestaurante= new CClienteRestaurante();
			model.addAttribute("rActualizarClienteRestaurante", clienteRestaurante);
			mv.setViewName("rActualizarClienteRestaurante");
			CrudClienteRestaurante conexClienteRestaurante = new CrudClienteRestaurante();
			conexClienteRestaurante.Conecta();
			conexClienteRestaurante.consultarClienteRestaurante(datClienteRestaurante.getlCliente(), datClienteRestaurante.getlRestaurante(),session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarClienteRestaurante", method = RequestMethod.GET)
    public void r2ActualizarClienteRestaurante(Model model, @Validated CClienteRestaurante datClienteRestaurante, BindingResult result,
    		HttpSession session) { 
          CrudClienteRestaurante conexClienteRestaurante = new CrudClienteRestaurante();
          conexClienteRestaurante.Conecta();
          //INSERTA PAIS
          conexClienteRestaurante.actualizarClienteRestaurante(datClienteRestaurante.getlCliente(), datClienteRestaurante.getlRestaurante(),datClienteRestaurante.getsFecha(),datClienteRestaurante.getsHora(), session);
     }

	@RequestMapping(value = "consultarClienteRestaurante", method = RequestMethod.GET)
	public ModelAndView consultarClienteRestaurante(Model model) {
		ModelAndView mv = new ModelAndView("consultarClienteRestaurante", "command", new CClienteRestaurante());
        CClienteRestaurante clienteRestaurante = new CClienteRestaurante();
        model.addAttribute("consultarClienteRestaurante",  clienteRestaurante);
		mv.setViewName("consultarClienteRestaurante");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarClienteRestaurante", method = RequestMethod.GET)
	public ModelAndView rConsultarClienteRestaurante(Model model, @Validated CClienteRestaurante datClienteRestaurante, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarClienteRestaurante", "command", new CClienteRestaurante());
        CClienteRestaurante clienteRestaurante = new CClienteRestaurante();
        model.addAttribute("rConsultarClienteRestaurante",  clienteRestaurante);
		mv.setViewName("rConsultarClienteRestaurante");
        CrudClienteRestaurante conexClienteRestaurante = new CrudClienteRestaurante();
        conexClienteRestaurante.Conecta();
        conexClienteRestaurante.consultarClienteRestaurante(datClienteRestaurante.getlCliente(), datClienteRestaurante.getlRestaurante(),session);
		return mv;
	}

	@RequestMapping(value = "borrarClienteRestaurante", method = RequestMethod.GET)
	public ModelAndView borrarClienteRestaurante(Model model) {
		ModelAndView mv = new ModelAndView("borrarClienteRestaurante", "command", new CClienteRestaurante());
        CClienteRestaurante clienteRestaurante = new CClienteRestaurante();
        model.addAttribute("borrarClienteRestaurante",  clienteRestaurante);
		mv.setViewName("borrarClienteRestaurante");
		return mv;
	}

	@RequestMapping(value = "/rBorrarClienteRestaurante", method = RequestMethod.GET)
    public void rBorrarClienteRestaurante(Model model, @Validated CClienteRestaurante clienteRestaurante, BindingResult result,
    		HttpSession session) { 
          CrudClienteRestaurante conexClienteRestaurante = new CrudClienteRestaurante();
          conexClienteRestaurante.Conecta();
          conexClienteRestaurante.borrarClienteRestaurante(clienteRestaurante.getlCliente(),clienteRestaurante.getlRestaurante(), session);
     }
}
