package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import conexion.CrudClientePremio;
import financiero.CClientePremio;

@Controller
public class ClientePremioController {
	@RequestMapping(value = "/agregarClientePremio", method = RequestMethod.GET)
	public ModelAndView agregarClientePremio() {
		ModelAndView mv = new ModelAndView("agregarClientePremio", "command", new CClientePremio());
		mv.setViewName("agregarClientePremio");
		return mv;
	}
	@RequestMapping(value = "/rAgregarClientePremio", method = RequestMethod.GET)
    public void guardarClientePremio(Model model, @Validated CClientePremio clientePremio, BindingResult result,
    		HttpSession session) { 
          CrudClientePremio conexClientePremio = new CrudClientePremio();
          conexClientePremio.Conecta();
          //INSERTA TIPO RESTAURANTE
          conexClientePremio.crearClientePremio(clientePremio.getlCliente(),clientePremio.getiPremio(),clientePremio.getsFecha(),clientePremio.getsHora(), session);
     }
	@RequestMapping(value = "actualizarClientePremio", method = RequestMethod.GET)
	public ModelAndView actualizarClientePremio() {
		ModelAndView mv = new ModelAndView("actualizarClientePremio", "command", new CClientePremio());
		mv.setViewName("actualizarClientePremio");
		return mv;
	}
	@RequestMapping(value = "/rActualizarClientePremio", method = RequestMethod.GET)
    public ModelAndView rActualizarClientePremio(Model model, @Validated CClientePremio datClientePremio, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarClientePremio", "command", new CClientePremio());
			CClientePremio clientePremio = new CClientePremio();
			model.addAttribute("rActualizarClientePremio", clientePremio);
			mv.setViewName("rActualizarClientePremio");
			CrudClientePremio conexClientePremio = new CrudClientePremio();
			conexClientePremio.Conecta();
			//INSERTA DEPARTAMENTO
			conexClientePremio.consultarClientePremio(datClientePremio.getlCliente(),datClientePremio.getiPremio(), session);
			return mv;
     }
	@RequestMapping(value = "/r2ActualizarClientePremio", method = RequestMethod.GET)
    public void r2ActualizarClientePremio(Model model, @Validated CClientePremio clientePremio, BindingResult result,
    		HttpSession session) { 
          CrudClientePremio conexClientePremio = new CrudClientePremio();
          conexClientePremio.Conecta();
          //INSERTA CONVENIO
          conexClientePremio.actualizarClientePremio(clientePremio.getlCliente(),clientePremio.getiPremio(), clientePremio.getsFecha(),clientePremio.getsHora(), session);
     }
	@RequestMapping(value = "consultarClientePremio", method = RequestMethod.GET)
	public ModelAndView consultarClientePremio(Model model) {
		ModelAndView mv = new ModelAndView("consultarClientePremio", "command", new CClientePremio());
        CClientePremio clientePremio = new CClientePremio();
        model.addAttribute("consultarTipoRestaurante",  clientePremio);
		mv.setViewName("consultarClientePremio");
		return mv;
	}
	@RequestMapping(value = "rConsultarClientePremio", method = RequestMethod.GET)
	public ModelAndView rConsultarClientePremio(Model model, @Validated CClientePremio datClientePremio, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarClientePremio", "command", new CClientePremio());
        CClientePremio clientePremio = new CClientePremio();
        model.addAttribute("rConsultarClientePremio",  clientePremio);
		mv.setViewName("rConsultarClientePremio");
        CrudClientePremio conexClientePremio = new CrudClientePremio();
        conexClientePremio.Conecta();
        //INSERTA PAIS
        conexClientePremio.consultarClientePremio(datClientePremio.getlCliente(),datClientePremio.getiPremio(), session);
		return mv;
	}
	@RequestMapping(value = "borrarClientePremio", method = RequestMethod.GET)
	public ModelAndView borrarClientePremio(Model model) {
		ModelAndView mv = new ModelAndView("borrarClientePremio", "command", new CClientePremio());
        CClientePremio clientePremio = new CClientePremio();
        model.addAttribute("borrarClientePremio", clientePremio);
		mv.setViewName("borrarClientePremio");
		return mv;
	}
	@RequestMapping(value = "/rBorrarClientePremio", method = RequestMethod.GET)
    public void rBorrarClientePremio(Model model, @Validated CClientePremio clientePremio, BindingResult result,
    		HttpSession session) { 
          CrudClientePremio conexClientePremio = new CrudClientePremio();
          conexClientePremio.Conecta();
          //RESPUESTA ELIMINAR TARIFA
          conexClientePremio.borrarClientePremio(clientePremio.getlCliente(),clientePremio.getiPremio(), session);
     }
}
