package com.mki.prycomegana;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import accesos.CAcceso;
import conexion.CrudAcceso;

@Controller
public class AccesoController {
	@RequestMapping(value = "agregarAcceso", method = RequestMethod.GET)
	public ModelAndView agregarAcceso() {
		ModelAndView mv = new ModelAndView("agregarAcceso", "command", new CAcceso());
		mv.setViewName("agregarAcceso");
		return mv;
	}
	
	@RequestMapping(value = "/rAgregarAcceso", method = RequestMethod.GET)
    public void guardarAcceso(Model model, @Validated CAcceso datAcceso, BindingResult result,
    		HttpSession session) { 
          CrudAcceso conexAcceso = new CrudAcceso();
          conexAcceso.Conecta();
          conexAcceso.crearAcceso(datAcceso.getsIP(),datAcceso.getiModulo(), datAcceso.getsPagina(),datAcceso.getsObjeto(),
        		  datAcceso.getsTabla(),datAcceso.getsOperacion(), datAcceso.getsAccion(),datAcceso.getsProceso(),
        		  datAcceso.getsEstadoTarea(),datAcceso.getsComando(),datAcceso.getsAplicacion(),datAcceso.getiTiempo(),
        		  datAcceso.getsTransaccion(),datAcceso.getsFecha(),datAcceso.getsHora(),datAcceso.getlUsuario(),session);
     }
	@RequestMapping(value = "actualizarAcceso", method = RequestMethod.GET)
	public ModelAndView actualizarAcceso() {
		ModelAndView mv = new ModelAndView("actualizarAcceso", "command", new CAcceso());
		mv.setViewName("actualizarAcceso");
		return mv;
	}

	@RequestMapping(value = "/rActualizarAcceso", method = RequestMethod.GET)
    public ModelAndView rActualizarAcceso(Model model, @Validated CAcceso datAcceso, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarAcceso", "command", new CAcceso());
			CAcceso acceso= new CAcceso();
			model.addAttribute("rActualizarAcceso", acceso);
			mv.setViewName("rActualizarAcceso");
			CrudAcceso conexAcceso = new CrudAcceso();
			conexAcceso.Conecta();
			conexAcceso.consultarAcceso(datAcceso.getlCodigo(), session);
			return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarAcceso", method = RequestMethod.GET)
    public void r2ActualizarAcceso(Model model, @Validated CAcceso datAcceso, BindingResult result,
    		HttpSession session) { 
          CrudAcceso conexAcceso = new CrudAcceso();
          conexAcceso.Conecta();
          conexAcceso.actualizarAcceso(datAcceso.getlCodigo(), datAcceso.getsIP(),datAcceso.getiModulo(), datAcceso.getsPagina(),datAcceso.getsObjeto(),
        		  datAcceso.getsTabla(),datAcceso.getsOperacion(), datAcceso.getsAccion(),datAcceso.getsProceso(),
        		  datAcceso.getsEstadoTarea(),datAcceso.getsComando(),datAcceso.getsAplicacion(),datAcceso.getiTiempo(),
        		  datAcceso.getsTransaccion(),datAcceso.getsFecha(),datAcceso.getsHora(),datAcceso.getlUsuario(),session);
     }

	@RequestMapping(value = "consultarAcceso", method = RequestMethod.GET)
	public ModelAndView consultarAcceso(Model model) {
		ModelAndView mv = new ModelAndView("consultarAcceso", "command", new CAcceso());
        CAcceso acceso = new CAcceso();
        model.addAttribute("consultarAcceso",  acceso);
		mv.setViewName("consultarAcceso");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarAcceso", method = RequestMethod.GET)
	public ModelAndView rConsultarAcceso(Model model, @Validated CAcceso datAcceso, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarAcceso", "command", new CAcceso());
        CAcceso acceso = new CAcceso();
        model.addAttribute("rConsultarAcceso",  acceso);
		mv.setViewName("rConsultarAcceso");
        CrudAcceso conexAcceso = new CrudAcceso();
        conexAcceso.Conecta();
        conexAcceso.consultarAcceso(datAcceso.getlCodigo(), session);
		return mv;
	}

	@RequestMapping(value = "borrarAcceso", method = RequestMethod.GET)
	public ModelAndView borrarAcceso(Model model) {
		ModelAndView mv = new ModelAndView("borrarAcceso", "command", new CAcceso());
        CAcceso acceso = new CAcceso();
        model.addAttribute("borrarAcceso",  acceso);
		mv.setViewName("borrarAcceso");
		return mv;
	}

	@RequestMapping(value = "/rBorrarAcceso", method = RequestMethod.GET)
    public void rBorrarAcceso(Model model, @Validated CAcceso datAcceso, BindingResult result,
    		HttpSession session) { 
          CrudAcceso conexAcceso = new CrudAcceso();
          conexAcceso.Conecta();
          conexAcceso.borrarAcceso(datAcceso.getlCodigo(), session);
     }
}
