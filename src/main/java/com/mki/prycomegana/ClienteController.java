package com.mki.prycomegana;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import conexion.CrudCliente;
import usuarios.CCliente;


@Controller
public class ClienteController {
	@RequestMapping(value = "agregarCliente", method = RequestMethod.GET)
	public ModelAndView agregarCliente() {
		ModelAndView mv = new ModelAndView("agregarCliente", "command", new CCliente());
		mv.setViewName("agregarCliente");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarCliente", method = RequestMethod.GET)
    public void guardarCliente(Model model, @Validated CCliente cliente, BindingResult result,
    		HttpSession session) { 
          CrudCliente conexCliente = new CrudCliente();
          conexCliente.Conecta();
          //INSERTA PAIS
          conexCliente.crearCliente(cliente.getlCedula(),cliente.getlNumArbol(),cliente.getlNivel(),cliente.getlPredecesor(),cliente.getlPersona(),cliente.getlSaldo(),cliente.getlBonos(),cliente.getiPremio(),cliente.getsFecha(),cliente.getsHora(), session);
     }
	@RequestMapping(value = "actualizarCliente", method = RequestMethod.GET)
	public ModelAndView actualizarCliente() {
		ModelAndView mv = new ModelAndView("actualizarCliente", "command", new CCliente());
		mv.setViewName("actualizarCliente");
		return mv;
	}

	@RequestMapping(value = "/rActualizarCliente", method = RequestMethod.GET)
    public ModelAndView rActualizarCliente(Model model, @Validated CCliente datCliente, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarCliente", "command", new CCliente());
			CCliente cliente= new CCliente();
			model.addAttribute("rActualizarCliente", cliente);
			mv.setViewName("rActualizarCliente");
			CrudCliente conexCliente = new CrudCliente();
			conexCliente.Conecta();
			//INSERTA DEPARTAMENTO
			conexCliente.consultarCliente(datCliente.getlCedula(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarCliente", method = RequestMethod.GET)
    public void r2ActualizarCliente(Model model, @Validated CCliente cliente, BindingResult result,
    		HttpSession session) { 
          CrudCliente conexCliente = new CrudCliente();
          conexCliente.Conecta();
          //INSERTA CLIENTE
          conexCliente.actualizarCliente(cliente.getlCedula(),cliente.getlNumArbol(),cliente.getlNivel(),cliente.getlPredecesor(),cliente.getlPersona(),cliente.getlSaldo(),cliente.getlBonos(),cliente.getiPremio(),cliente.getsFecha(),cliente.getsHora(), session);
     }

	@RequestMapping(value = "consultarCliente", method = RequestMethod.GET)
	public ModelAndView consultarArea(Model model) {
		ModelAndView mv = new ModelAndView("consultarCliente", "command", new CCliente());
        CCliente cliente = new CCliente();
        model.addAttribute("consultarCliente",  cliente);
		mv.setViewName("consultarCliente");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarCliente", method = RequestMethod.GET)
	public ModelAndView rConsultarArea(Model model, @Validated CCliente datCliente, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarCliente", "command", new CCliente());
        CCliente cliente = new CCliente();
        model.addAttribute("rConsultarCliente",  cliente);
		mv.setViewName("rConsultarCliente");
        CrudCliente conexCliente = new CrudCliente();
        conexCliente.Conecta();
        conexCliente.consultarCliente(datCliente.getlCedula(), session);
		return mv;
	}

	@RequestMapping(value = "borrarCliente", method = RequestMethod.GET)
	public ModelAndView borrarCliente(Model model) {
		ModelAndView mv = new ModelAndView("borrarCliente", "command", new CCliente());
        CCliente cliente = new CCliente();
        model.addAttribute("borrarCliente",  cliente);
		mv.setViewName("borrarCliente");
		return mv;
	}

	@RequestMapping(value = "/rBorrarCliente", method = RequestMethod.GET)
    public void rBorrarCliente(Model model, @Validated CCliente cliente, BindingResult result,
    		HttpSession session) { 
          CrudCliente conexCliente = new CrudCliente();
          conexCliente.Conecta();
          //INSERTA PAIS
          conexCliente.borrarCliente(cliente.getlCedula(), session);
     }
}
