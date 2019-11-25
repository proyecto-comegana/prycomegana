package com.mki.prycomegana;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import accesos.CAcceso;
import accesos.CModulo;
import usuarios.CCliente;
import usuarios.CEmpleado;
import usuarios.CPersona;
import usuarios.CPropietario;
import usuarios.CSesion;
import usuarios.CTipoUsuario;
import usuarios.CUsuario;
import backups.CBackup;
import backups.CTipoBackup;
import conexion.Conectar;
import conexion.CrudUsuario;
import fallos.CFallo;
import financiero.CArea;
import financiero.CBonificaciones;
import financiero.CClientePremio;
import financiero.CClienteSucesor;
import financiero.CConvenio;
import financiero.CPremio;
import financiero.CRecarga;
import financiero.CRecargaTarifa;
import financiero.CRestaurante;
import financiero.CTarifa;
import financiero.CTipoRestaurante;
import localizacion.CCiudad;
import localizacion.CPais;
import parametros.CParametroModulo;
import parametros.CParametro;
import parametros.CTipoParametro;
import reporteClase.PersonaReporte;
import reportes.CReporteVisitasDiarias;
import reportes.DAOReporteVisitasDiarias;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		System.out.println(formattedDate);
		System.out.println("Bienvenido a la aplicación comegana...");
		
		return "home";
	}

	@RequestMapping(value = "respaldo", method = RequestMethod.GET)
	public ModelAndView respaldo(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("respaldo", "command", new CPersona());
		mv.setViewName("respaldo");
		return mv;
	}

	@RequestMapping(value = "estad_diaria", method = RequestMethod.GET)
	public ModelAndView estad_diaria(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("estad_diaria", "command", new CPersona());
		mv.setViewName("estad_diaria");
		return mv;
	}

	@RequestMapping(value = "blog-post", method = RequestMethod.GET)
	public ModelAndView blogpost(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("blog-post", "command", new CPersona());
		mv.setViewName("blog-post");
		return mv;
	}

	@RequestMapping(value = "grafestados", method = RequestMethod.GET)
	public ModelAndView grafestados(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("grafestados", "command", new CPersona());
		mv.setViewName("grafestados");
		return mv;
	}

	@RequestMapping(value = "grafips", method = RequestMethod.GET)
	public ModelAndView grafips(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("grafips", "command", new CPersona());
		mv.setViewName("grafips");
		return mv;
	}

	@RequestMapping(value = "grafusuarioslineal", method = RequestMethod.GET)
	public ModelAndView grafusuarioslineal(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("grafusuarioslineal", "command", new CPersona());
		mv.setViewName("grafusuarioslineal");
		return mv;
	}

	@RequestMapping(value = "grafips3d", method = RequestMethod.GET)
	public ModelAndView grafips3d(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("grafips3d", "command", new CPersona());
		mv.setViewName("grafips3d");
		return mv;
	}
	
	@RequestMapping(value = "recup", method = RequestMethod.GET)
	public ModelAndView recup(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("recup", "command", new CPersona());
		mv.setViewName("recup");
		return mv;
	}

	@RequestMapping(value = "recuperacion", method = RequestMethod.GET)
	public ModelAndView recuperacion(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("recuperacion", "command", new CPersona());
		mv.setViewName("recuperacion");
		return mv;
	}

	@RequestMapping(value = "reporte", method = RequestMethod.GET)
	public ModelAndView reporte(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("reporte", "command", new CPersona());
		mv.setViewName("reporte");
		return mv;
	}

	@RequestMapping(value = "MenuOperaciones", method = RequestMethod.GET)
	public ModelAndView MenuOperaciones(Model model) {
		ModelAndView mv = new ModelAndView("MenuOperaciones", "command", new CUsuario());
		mv.setViewName("MenuOperaciones");
		return mv;
	}

	@RequestMapping(value = "menu_estadistico", method = RequestMethod.GET)
	public ModelAndView menu_estadistico(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("menu_estadistico", "command", new CPersona());
		mv.setViewName("menu_estadistico");
		return mv;
	}

	@RequestMapping(value = "pdf", method = RequestMethod.GET)
	public ModelAndView pdf(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("pdf", "command", new CPersona());
		mv.setViewName("pdf");
		return mv;
	}

	@RequestMapping(value = "estadis_diaria", method = RequestMethod.GET)
	public ModelAndView estadis_diaria(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("estadis_diaria", "command", new CReporteVisitasDiarias());
		try {
	        List<String> lstRecursos = new ArrayList<String>();
        	lstRecursos.add("actualizarAcceso.jsp");
        	lstRecursos.add("actualizarAfiliacion.jsp");
        	lstRecursos.add("actualizarArbol.jsp");
        	lstRecursos.add("actualizarArea.jsp");
        	lstRecursos.add("actualizarBackup.jsp");

        	lstRecursos.add("actualizarBonificacion.jsp");
        	lstRecursos.add("actualizarCiudad.jsp");
        	lstRecursos.add("actualizarCliente.jsp");
        	lstRecursos.add("actualizarClientePremio.jsp");
        	lstRecursos.add("actualizarClienteRestaurante.jsp");
        	
        	lstRecursos.add("actualizarClienteSucesor.jsp");
        	lstRecursos.add("actualizarConvenio.jsp");
        	lstRecursos.add("actualizarDepartamento.jsp");
        	lstRecursos.add("actualizarEmpleado.jsp");
        	lstRecursos.add("actualizarFallo.jsp");

        	lstRecursos.add("actualizarModulo.jsp");
        	lstRecursos.add("actualizarNodo.jsp");
        	lstRecursos.add("actualizarNodoArbol.jsp");
        	lstRecursos.add("actualizarPais.jsp");
        	lstRecursos.add("actualizarParametro.jsp");

        	lstRecursos.add("actualizarParametroModulo.jsp");
        	lstRecursos.add("actualizarPersona.jsp");
        	lstRecursos.add("actualizarPremio.jsp");
        	lstRecursos.add("actualizarPropietario.jsp");
        	lstRecursos.add("actualizarRecarga.jsp");

        	lstRecursos.add("actualizarRecargaTarifa.jsp");
        	lstRecursos.add("actualizarRestaurante.jsp");
        	lstRecursos.add("actualizarTarifa.jsp");
        	lstRecursos.add("actualizarTipoBackup.jsp");
        	lstRecursos.add("actualizarTipoParametro.jsp");
        	
        	lstRecursos.add("actualizarTipoRestaurante.jsp");
        	lstRecursos.add("actualizarTipoUsuario.jsp");
        	lstRecursos.add("actualizarUsuario.jsp");
        	lstRecursos.add("actualizarAcceso.jsp");
        	lstRecursos.add("actualizarAfiliacion.jsp");

        	lstRecursos.add("agregarArbol.jsp");
        	lstRecursos.add("agregarArea.jsp");
        	lstRecursos.add("agregarBackup.jsp");
        	lstRecursos.add("agregarBonificacion.jsp");
        	lstRecursos.add("agregarCiudad.jsp");

        	lstRecursos.add("agregarCliente.jsp");
        	lstRecursos.add("agregarClientePremio.jsp");
        	lstRecursos.add("agregarClienteRestaurante.jsp");
        	lstRecursos.add("agregarClienteSucesor.jsp");
        	lstRecursos.add("agregarConvenio.jsp");

        	lstRecursos.add("agregarDepartamento.jsp");
        	lstRecursos.add("agregarEmpleado.jsp");
        	lstRecursos.add("agregarFallo.jsp");
        	lstRecursos.add("agregarModulo.jsp");
        	lstRecursos.add("agregarNodo.jsp");

        	lstRecursos.add("agregarNodoArbol.jsp");
        	lstRecursos.add("agregarPais.jsp");
        	lstRecursos.add("agregarParametro.jsp");
        	lstRecursos.add("agregarParametroModulo.jsp");
        	lstRecursos.add("agregarPersona.jsp");

        	lstRecursos.add("agregarPersonaReg.jsp");
        	lstRecursos.add("agregarPremio.jsp");
        	lstRecursos.add("agregarPropietario.jsp");
        	lstRecursos.add("agregarRecarga.jsp");
        	lstRecursos.add("agregarRecargaTarifa.jsp");

        	lstRecursos.add("agregarRestaurante.jsp");
        	lstRecursos.add("agregarTarifa.jsp");
        	lstRecursos.add("agregarTipoBackup.jsp");
        	lstRecursos.add("agregarTipoParametro.jsp");
        	lstRecursos.add("agregarTipoRestaurante.jsp");
        	
        	lstRecursos.add("agregarTipoUsuario.jsp");
        	lstRecursos.add("agregarUsuarioReg.jsp");
        	lstRecursos.add("agregarUsuario.jsp");
        	lstRecursos.add("blog.jsp");

        	lstRecursos.add("blog-post.jsp");
        	lstRecursos.add("borrarAcceso.jsp");
        	lstRecursos.add("borrarAfiliacion.jsp");
        	lstRecursos.add("borrarArbol.jsp");
        	lstRecursos.add("borrarArea.jsp");

        	lstRecursos.add("borrarBackup.jsp");
        	lstRecursos.add("borrarBonificacion.jsp");
        	lstRecursos.add("borrarCiudad.jsp");
        	lstRecursos.add("borrarCliente.jsp");
        	lstRecursos.add("borrarClientePremio.jsp");

        	lstRecursos.add("borrarClienteRestaurante.jsp");
        	lstRecursos.add("borrarClienteSucesor.jsp");
        	lstRecursos.add("borrarConvenio.jsp");
        	lstRecursos.add("borrarDepartamento.jsp");
        	lstRecursos.add("borrarFallo.jsp");

        	lstRecursos.add("borrarModulo.jsp");
        	lstRecursos.add("borrarNodo.jsp");
        	lstRecursos.add("borrarNodoArbol.jsp");
        	lstRecursos.add("borrarPais.jsp");
        	lstRecursos.add("borrarParametro.jsp");

        	lstRecursos.add("borrarParametroModulo.jsp");
        	lstRecursos.add("borrarPersona.jsp");
        	lstRecursos.add("borrarPremio.jsp");
        	lstRecursos.add("borrarPropietario.jsp");
        	lstRecursos.add("borrarRecarga.jsp");

        	lstRecursos.add("borrarRecargaTarifa.jsp");
        	lstRecursos.add("borrarRestaurante.jsp");
        	lstRecursos.add("borrarTarifa.jsp");
        	lstRecursos.add("borrarTipoBackup.jsp");
        	lstRecursos.add("borrarTipoParametro.jsp");

        	lstRecursos.add("borrarTipoRestaurante.jsp");
        	lstRecursos.add("borrarTipoUsuario.jsp");
        	lstRecursos.add("borrarUsuario.jsp");
        	lstRecursos.add("ConsultarAcceso.jsp");
        	lstRecursos.add("ConsultarAfiliacion.jsp");

        	lstRecursos.add("consultarArbol.jsp");
        	lstRecursos.add("consultarArea.jsp");
        	lstRecursos.add("consultarBackup.jsp");
        	lstRecursos.add("ConsultarBonificacion.jsp");
        	lstRecursos.add("ConsultarCiudad.jsp");
        	
        	lstRecursos.add("consultarCliente.jsp");
        	lstRecursos.add("consultarClientePremio.jsp");
        	lstRecursos.add("consultarClienteRestaurante.jsp");
        	lstRecursos.add("ConsultarClienteSucesor.jsp");
        	lstRecursos.add("ConsultarConvenio.jsp");

        	lstRecursos.add("consultarDepartamento.jsp");
        	lstRecursos.add("consultarEmpleado.jsp");
        	lstRecursos.add("consultarFallo.jsp");
        	lstRecursos.add("ConsultarModulo.jsp");
        	lstRecursos.add("ConsultarNodo.jsp");

        	lstRecursos.add("consultarNodoArbol.jsp");
        	lstRecursos.add("consultarPais.jsp");
        	lstRecursos.add("consultarParametro.jsp");
        	lstRecursos.add("ConsultarParametroModulo.jsp");
        	lstRecursos.add("ConsultarPersona.jsp");

        	lstRecursos.add("consultarPremio.jsp");
        	lstRecursos.add("consultarPropietario.jsp");
        	lstRecursos.add("consultarRecarga.jsp");
        	lstRecursos.add("ConsultarRecargaTarifa.jsp");
        	lstRecursos.add("ConsultarRestaurante.jsp");
        	
        	lstRecursos.add("consultarTarifa.jsp");
        	lstRecursos.add("consultarTipoBackup.jsp");
        	lstRecursos.add("consultarTipoParametro.jsp");
        	lstRecursos.add("ConsultarTipoRestaurante.jsp");
        	lstRecursos.add("ConsultarTipoUsuario.jsp");

        	lstRecursos.add("consultarUsuario.jsp");
        	lstRecursos.add("consultarPropietario.jsp");
        	lstRecursos.add("estadis_diaria.jsp");
        	lstRecursos.add("home.jsp");
        	lstRecursos.add("login.jsp");

        	lstRecursos.add("menu_estadistico.jsp");
        	lstRecursos.add("MenuOperaciones.jsp");
        	lstRecursos.add("MenuOperacionesComensal.jsp");
        	lstRecursos.add("MenuOperacionesDuenoRes.jsp");
        	lstRecursos.add("MenuOperacionesEmp.jsp");

        	lstRecursos.add("r2ActualizarAcceso.jsp");
        	lstRecursos.add("r2ActualizarAfiliacion.jsp");
        	lstRecursos.add("r2ActualizarArbol.jsp");
        	lstRecursos.add("r2ActualizarArea.jsp");
        	lstRecursos.add("r2ActualizarBackup.jsp");

        	lstRecursos.add("r2ActualizarBonificacion.jsp");
        	lstRecursos.add("r2ActualizarCiudad.jsp");
        	lstRecursos.add("r2ActualizarCliente.jsp");
        	lstRecursos.add("r2ActualizarClientePremio.jsp");
        	lstRecursos.add("r2ActualizarClienteRestaurante.jsp");

        	lstRecursos.add("r2ActualizarClienteSucesor.jsp");
        	lstRecursos.add("r2ActualizarConvenio.jsp");
        	lstRecursos.add("r2ActualizarDepartamento.jsp");
        	lstRecursos.add("r2ActualizarEmpleado.jsp");
        	lstRecursos.add("r2ActualizarFallo.jsp");

        	lstRecursos.add("r2ActualizarModulo.jsp");
        	lstRecursos.add("r2ActualizarNodo.jsp");
        	lstRecursos.add("r2ActualizarNodoArbol.jsp");
        	lstRecursos.add("r2ActualizarPais.jsp");
        	lstRecursos.add("r2ActualizarParametro.jsp");

        	lstRecursos.add("r2ActualizarParametroModulo.jsp");
        	lstRecursos.add("r2ActualizarPersona.jsp");
        	lstRecursos.add("r2ActualizarPremio.jsp");
        	lstRecursos.add("r2ActualizarPropietario.jsp");
        	lstRecursos.add("r2ActualizarRecarga.jsp");
        	
        	lstRecursos.add("r2ActualizarRecargaTarifa.jsp");
        	lstRecursos.add("r2ActualizarRestaurante.jsp");
        	lstRecursos.add("r2ActualizarTarifa.jsp");
        	lstRecursos.add("r2ActualizarTipoBackup.jsp");
        	lstRecursos.add("r2ActualizarTipoParametro.jsp");

        	lstRecursos.add("r2ActualizarTipoRestaurante.jsp");
        	lstRecursos.add("r2ActualizarTipoUsuario.jsp");
        	lstRecursos.add("r2ActualizarUsuario.jsp");
        	lstRecursos.add("r2ActualizarDepartamento.jsp");
        	lstRecursos.add("rActualizarAcceso.jsp");
        	
        	lstRecursos.add("rActualizarAfiliacion.jsp");
        	lstRecursos.add("rActualizarArbol.jsp");
        	lstRecursos.add("rActualizarArea.jsp");
        	lstRecursos.add("rActualizarBackup.jsp");
        	lstRecursos.add("rActualizarBonificacion.jsp");

        	lstRecursos.add("rActualizarCiudad.jsp");
        	lstRecursos.add("rActualizarCliente.jsp");
        	lstRecursos.add("rActualizarClientePremio.jsp");
        	lstRecursos.add("rActualizarClienteRestaurante.jsp");
        	lstRecursos.add("rActualizarClienteSucesor.jsp");

        	lstRecursos.add("rActualizarConvenio.jsp");
        	lstRecursos.add("rActualizarDepartamento.jsp");
        	lstRecursos.add("rActualizarEmpleado.jsp");
        	lstRecursos.add("rActualizarFallo.jsp");
        	lstRecursos.add("rActualizarModulo.jsp");

        	lstRecursos.add("rActualizarNodo.jsp");
        	lstRecursos.add("rActualizarNodoArbol.jsp");
        	lstRecursos.add("rActualizarPais.jsp");
        	lstRecursos.add("rActualizarParametro.jsp");
        	lstRecursos.add("rActualizarParametroModulo.jsp");

        	lstRecursos.add("rActualizarPersona.jsp");
        	lstRecursos.add("rActualizarPremio.jsp");
        	lstRecursos.add("rActualizarPropietario.jsp");
        	lstRecursos.add("rActualizarRecarga.jsp");
        	lstRecursos.add("rActualizarRecargaTarifa.jsp");

        	lstRecursos.add("rActualizarRestaurante.jsp");
        	lstRecursos.add("rActualizarTarifa.jsp");
        	lstRecursos.add("rActualizarTipoBackup.jsp");
        	lstRecursos.add("rActualizarTipoParametro.jsp");
        	lstRecursos.add("rActualizarTipoRestaurante.jsp");
        	
        	lstRecursos.add("rActualizarTipoUsuario.jsp");
        	lstRecursos.add("rActualizarUsuario.jsp");
        	lstRecursos.add("rAgregarAcceso.jsp");
        	lstRecursos.add("rAgregarAfiliacion.jsp");
        	lstRecursos.add("rAgregarArbol.jsp");
        	
        	lstRecursos.add("rAgregarArea.jsp");
        	lstRecursos.add("rAgregarBackup.jsp");
        	lstRecursos.add("rAgregarBonificacion.jsp");
        	lstRecursos.add("rAgregarCiudad.jsp");
        	lstRecursos.add("rAgregarCliente.jsp");

        	lstRecursos.add("rAgregarClientePremio.jsp");
        	lstRecursos.add("rAgregarClienteRestaurante.jsp");
        	lstRecursos.add("rAgregarClienteSucesor.jsp");
        	lstRecursos.add("rAgregarConvenio.jsp");
        	lstRecursos.add("rAgregarDepartamento.jsp");
        	
        	lstRecursos.add("rAgregarEmpleado.jsp");
        	lstRecursos.add("rAgregarFallo.jsp");
        	lstRecursos.add("rAgregarModulo.jsp");
        	lstRecursos.add("rAgregarNodo.jsp");
        	lstRecursos.add("rAgregarNodoArbol.jsp");

        	lstRecursos.add("rAgregarPais.jsp");
        	lstRecursos.add("rAgregarParametro.jsp");
        	lstRecursos.add("rAgregarParametroModulo.jsp");
        	lstRecursos.add("rAgregarPersona.jsp");
        	lstRecursos.add("rAgregarModulo.jsp");

        	lstRecursos.add("rAgregarNodo.jsp");
        	lstRecursos.add("rAgregarNodoArbol.jsp");
        	lstRecursos.add("rAgregarPais.jsp");
        	lstRecursos.add("rAgregarParametro.jsp");
        	lstRecursos.add("rAgregarParametroModulo.jsp");

        	lstRecursos.add("rAgregarPersona.jsp");
        	lstRecursos.add("rAgregarPremio.jsp");
        	lstRecursos.add("rAgregarPropietario.jsp");
        	lstRecursos.add("rAgregarRecarga.jsp");
        	lstRecursos.add("rAgregarRecargaTarifa.jsp");

        	lstRecursos.add("rAgregarRestaurante.jsp");
        	lstRecursos.add("rAgregarTarifa.jsp");
        	lstRecursos.add("rAgregarTipoBackup.jsp");
        	lstRecursos.add("rAgregarTipoParametro.jsp");
        	lstRecursos.add("rAgregarTipoRestaurante.jsp");

        	lstRecursos.add("rAgregarTipoUsuario.jsp");
        	lstRecursos.add("rAgregarUsuario.jsp");
        	lstRecursos.add("rAgregarUsuarioReg.jsp");
        	lstRecursos.add("rBorrarAcceso.jsp");
        	lstRecursos.add("rBorrarAfiliacion.jsp");

        	lstRecursos.add("rBorrarArbol.jsp");
        	lstRecursos.add("rBorrarArea.jsp");
        	lstRecursos.add("rBorrarBackup.jsp");
        	lstRecursos.add("rBorrarBonificacion.jsp");
        	lstRecursos.add("rBorrarCiudad.jsp");

        	lstRecursos.add("rBorrarCliente.jsp");
        	lstRecursos.add("rBorrarClientePremio.jsp");
        	lstRecursos.add("rBorrarClienteRestaurante.jsp");
        	lstRecursos.add("rBorrarClienteSucesor.jsp");
        	lstRecursos.add("rBorrarConvenio.jsp");

        	lstRecursos.add("rBorrarDepartamento.jsp");
        	lstRecursos.add("rBorrarEmpleado.jsp");
        	lstRecursos.add("rBorrarFallo.jsp");
        	lstRecursos.add("rBorrarModulo.jsp");
        	lstRecursos.add("rBorrarNodo.jsp");

        	lstRecursos.add("rBorrarNodoArbol.jsp");
        	lstRecursos.add("rBorrarPais.jsp");
        	lstRecursos.add("rBorrarParametro.jsp");
        	lstRecursos.add("rBorrarParametroModulo.jsp");
        	lstRecursos.add("rBorrarPersona.jsp");

        	lstRecursos.add("rBorrarPremio.jsp");
        	lstRecursos.add("rBorrarPropietario.jsp");
        	lstRecursos.add("rBorrarRecarga.jsp");
        	lstRecursos.add("rBorrarRecargaTarifa.jsp");
        	lstRecursos.add("rBorrarRestaurante.jsp");
  	
        	lstRecursos.add("rBorrarTarifa.jsp");
        	lstRecursos.add("rBorrarTipoBackup.jsp");
        	lstRecursos.add("rBorrarTipoParametro.jsp");
        	lstRecursos.add("rBorrarTipoRestaurante.jsp");
        	lstRecursos.add("rBorrarTipoUsuario.jsp");

        	lstRecursos.add("rBorrarUsuario.jsp");
        	lstRecursos.add("rConsultarAcceso.jsp");
        	lstRecursos.add("rConsultarAfiliacion.jsp");
        	lstRecursos.add("rConsultarArbol.jsp");
        	lstRecursos.add("rConsultarArea.jsp");

        	lstRecursos.add("rConsultarBackup.jsp");
        	lstRecursos.add("rConsultarBonificacion.jsp");
        	lstRecursos.add("rConsultarCiudad.jsp");
        	lstRecursos.add("rConsultarCliente.jsp");
        	lstRecursos.add("rConsultarClientePremio.jsp");

        	lstRecursos.add("rConsultarClienteRestaurante.jsp");
        	lstRecursos.add("rConsultarClienteSucesor.jsp");
        	lstRecursos.add("rConsultarConvenio.jsp");
        	lstRecursos.add("rConsultarDepartamento.jsp");
        	lstRecursos.add("rConsultarEmpleado.jsp");

        	lstRecursos.add("rConsultarFallo.jsp");
        	lstRecursos.add("rConsultarModulo.jsp");
        	lstRecursos.add("rConsultarNodo.jsp");
        	lstRecursos.add("rConsultarNodoArbol.jsp");
        	lstRecursos.add("rConsultarPais.jsp");

        	lstRecursos.add("rConsultarParametro.jsp");
        	lstRecursos.add("rConsultarParametroModulo.jsp");
        	lstRecursos.add("rConsultarPersona.jsp");
        	lstRecursos.add("rConsultarPremio.jsp");
        	lstRecursos.add("rConsultarPropietario.jsp");

        	lstRecursos.add("rConsultarRecarga.jsp");
        	lstRecursos.add("rConsultarRecargaTarifa.jsp");
        	lstRecursos.add("rConsultarRestaurante.jsp");
        	lstRecursos.add("rConsultarTarifa.jsp");
        	lstRecursos.add("rConsultarTipoBackup.jsp");

        	lstRecursos.add("rConsultarTipoParametro.jsp");
        	lstRecursos.add("rConsultarTipoRestaurante.jsp");
        	lstRecursos.add("rConsultarTipoUsuario.jsp");
        	lstRecursos.add("rConsultarUsuario.jsp");
        	lstRecursos.add("redireccionar.jsp");
       	
        	lstRecursos.add("registro.jsp");
        	lstRecursos.add("reporte.jsp");
        	
        	mv.addObject("lstRecursos",lstRecursos);

		}catch(Exception e) {
			System.out.println("Consulta del país fallida...");
			System.out.println(e.getMessage());
		}
		mv.setViewName("estadis_diaria");
		return mv;
	}

	@RequestMapping(value = "/rEstadis_Diaria", method = RequestMethod.GET)
    public ModelAndView generarEstadisticaDiaria(Model model, @Validated CReporteVisitasDiarias reporteVisitas, BindingResult result,
    		HttpSession session) {
		ModelAndView mv = new ModelAndView("rEstadis_Diaria", "command", new CReporteVisitasDiarias());
		DAOReporteVisitasDiarias daoReporteVisitas = new DAOReporteVisitasDiarias();
        daoReporteVisitas.generarReporte(reporteVisitas.getsNombreRecurso(),reporteVisitas.getsFecha(), session);
		session.setAttribute("recur", reporteVisitas.getsNombreRecurso());
		session.setAttribute("fec", reporteVisitas.getsFecha());
        mv.setViewName("rEstadis_Diaria");
        
        return mv;
	}

	@RequestMapping(value = "MenuOperacionesEmp", method = RequestMethod.GET)
	public ModelAndView MenuOperacionesEmp(Model model) {
		ModelAndView mv = new ModelAndView("MenuOperacionesEmp", "command", new CUsuario());
		mv.setViewName("MenuOperacionesEmp");
		return mv;
	}

	@RequestMapping(value = "grafusuarios", method = RequestMethod.GET)
	public ModelAndView grafusuarios(Model model) {
		ModelAndView mv = new ModelAndView("grafusuarios", "command", new CUsuario());
		mv.setViewName("grafusuarios");
		return mv;
	}

	@RequestMapping(value = "plantilla1", method = RequestMethod.GET)
	public ModelAndView plantilla1(Model model) {
		ModelAndView mv = new ModelAndView("plantilla1", "command", new CUsuario());
		mv.setViewName("plantilla1");
		return mv;
	}
	
	@RequestMapping(value = "redireccionar", method = RequestMethod.GET)
	public ModelAndView redireccionar(Model model, @Validated CSesion datSesion, BindingResult result,
    		HttpSession session) {
		CrudUsuario daoUsuario = new CrudUsuario();
		daoUsuario.Conecta();
		String sTipoUsuario = daoUsuario.consultarTipoUsuario(datSesion.getsNombreUsuario(), datSesion.getsContrasena());
		long lCodigoUsuario = daoUsuario.consultarCodigoUsuario(datSesion.getsNombreUsuario(), datSesion.getsContrasena());
		session.setAttribute("ses_id_usuario", lCodigoUsuario);
		if (sTipoUsuario.equals("Administrador")) {
			ModelAndView mv = new ModelAndView("MenuOperaciones", "command", new CSesion());
			mv.setViewName("MenuOperaciones");
			return mv;
		}
		else if (sTipoUsuario.equals("Empleado")) {
			ModelAndView mv = new ModelAndView("MenuOperacionesEmp", "command", new CSesion());
			mv.setViewName("MenuOperacionesEmp");
			return mv;
		}
		else if (sTipoUsuario.equals("Propietario de restaurante")) {
			ModelAndView mv = new ModelAndView("MenuOperacionesDuenoRes", "command", new CSesion());
			mv.setViewName("MenuOperacionesDuenoRes");
			return mv;
		}
		else{
			ModelAndView mv = new ModelAndView("MenuOperacionesComensal", "command", new CSesion());
			mv.setViewName("MenuOperacionesComensal");
			return mv;
		}
	}

	@RequestMapping(value = "MenuOperacionesDuenoRes", method = RequestMethod.GET)
	public ModelAndView MenuOperacionesDuenoRes(Model model) {
		ModelAndView mv = new ModelAndView("MenuOperacionesDuenoRes", "command", new CUsuario());
		mv.setViewName("MenuOperacionesDuenoRes");
		return mv;
	}
	
	@RequestMapping(value = "MenuOperacionesComensal", method = RequestMethod.GET)
	public ModelAndView MenuOperacionesComensal(Model model) {
		ModelAndView mv = new ModelAndView("MenuOperacionesComensal", "command", new CUsuario());
		mv.setViewName("MenuOperacionesComensal");
		return mv;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login", "command", new CPersona());
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "blog", method = RequestMethod.GET)
	public ModelAndView blog() {
		ModelAndView mv = new ModelAndView("blog", "command", new CPersona());
		mv.setViewName("blog");
		return mv;
	}


	@RequestMapping(value = "registro", method = RequestMethod.GET)
	public ModelAndView registro() {
		ModelAndView mv = new ModelAndView("registro", "command", new CPersona());
		mv.setViewName("registro");
		return mv;
	}

	@RequestMapping(value = "calendar", method = RequestMethod.POST)
	public ModelAndView calendar() {
		ModelAndView mv = new ModelAndView("calendar", "command", new CPersona());
		mv.setViewName("calendar");
		return mv;
	}

	@RequestMapping(value = "calendario", method = RequestMethod.POST)
	public ModelAndView calendario() {
		ModelAndView mv = new ModelAndView("calendario", "command", new CPersona());
		mv.setViewName("calendario");
		return mv;
	}

	@RequestMapping(value = "datos_cliente", method = RequestMethod.POST)
	public ModelAndView datos_cliente() {
		ModelAndView mv = new ModelAndView("datos_cliente", "command", new CCliente());
		mv.setViewName("datos_cliente");
		return mv;
	}

	@RequestMapping(value = "datos_propietario", method = RequestMethod.POST)
	public ModelAndView datos_propietario() {
		ModelAndView mv = new ModelAndView("datos_propietario", "command", new CPropietario());
		mv.setViewName("datos_propietario");
		return mv;
	}

	@RequestMapping(value = "datos_empleado", method = RequestMethod.POST)
	public ModelAndView datos_empleado() {
		ModelAndView mv = new ModelAndView("datos_empleado", "command", new CEmpleado());
		mv.setViewName("datos_empleado");
		return mv;
	}

	@RequestMapping(value = "tipo_usuario", method = RequestMethod.POST)
	public ModelAndView tipo_usuario() {
		ModelAndView mv = new ModelAndView("tipo_usuario", "command", new CTipoUsuario());
		mv.setViewName("tipo_usuario");
		return mv;
	}
	
	@RequestMapping(value = "empleado", method = RequestMethod.GET)
	public ModelAndView empleado() {
		ModelAndView mv = new ModelAndView("empleado", "command", new CEmpleado());
		mv.setViewName("empleado");
		return mv;
	}

	@RequestMapping(value = "persona", method = RequestMethod.POST)
	public ModelAndView persona() {
		ModelAndView mv = new ModelAndView("persona", "command", new CPersona());
		mv.setViewName("persona");
		return mv;
	}

	@RequestMapping(value = "propietario", method = RequestMethod.POST)
	public ModelAndView propietario() {
		ModelAndView mv = new ModelAndView("propietario", "command", new CPropietario());
		mv.setViewName("propietario");
		return mv;
	}

	@RequestMapping(value = "acceso", method = RequestMethod.POST)
	public ModelAndView acceso() {
		ModelAndView mv = new ModelAndView("acceso", "command", new CAcceso());
		mv.setViewName("acceso");
		return mv;
	}

	@RequestMapping(value = "modulo", method = RequestMethod.POST)
	public ModelAndView modulo() {
		ModelAndView mv = new ModelAndView("modulo", "command", new CModulo());
		mv.setViewName("modulo");
		return mv;
	}

	@RequestMapping(value = "backup", method = RequestMethod.POST)
	public ModelAndView backup() {
		ModelAndView mv = new ModelAndView("backup", "command", new CBackup());
		mv.setViewName("backup");
		return mv;
	}
	@RequestMapping(value = "tipo_backup", method = RequestMethod.POST)
	public ModelAndView tipo_backup() {
		ModelAndView mv = new ModelAndView("tipo_backup", "command", new CTipoBackup());
		mv.setViewName("tipo_backup");
		return mv;
	}
	@RequestMapping(value = "fallo", method = RequestMethod.POST)
	public ModelAndView fallo() {
		ModelAndView mv = new ModelAndView("fallo", "command", new CFallo());
		mv.setViewName("fallo");
		return mv;
	}
	
	@RequestMapping(value = "area", method = RequestMethod.POST)
	public ModelAndView area() {
		ModelAndView mv = new ModelAndView("area", "command", new CArea());
		mv.setViewName("area");
		return mv;
	}

	@RequestMapping(value = "bonificacion", method = RequestMethod.POST)
	public ModelAndView bonificacion() {
		ModelAndView mv = new ModelAndView("bonificacion", "command", new CBonificaciones());
		mv.setViewName("bonificacion");
		return mv;
	}
	
	@RequestMapping(value = "cliente_premio", method = RequestMethod.POST)
	public ModelAndView cliente_premio() {
		ModelAndView mv = new ModelAndView("cliente_premio", "command", new CClientePremio());
		mv.setViewName("cliente_premio");
		return mv;
	}
	@RequestMapping(value = "cliente_sucesor", method = RequestMethod.POST)
	public ModelAndView cliente_sucesor() {
		ModelAndView mv = new ModelAndView("cliente_sucesor", "command", new CClienteSucesor());
		mv.setViewName("cliente_sucesor");
		return mv;
	}
	@RequestMapping(value = "recarga", method = RequestMethod.POST)
	public ModelAndView recarga() {
		ModelAndView mv = new ModelAndView("recarga", "command", new CRecarga());
		mv.setViewName("recarga");
		return mv;
	}
	@RequestMapping(value = "recarga_tarifa", method = RequestMethod.POST)
	public ModelAndView recarga_tarifa() {
		ModelAndView mv = new ModelAndView("recarga_tarifa", "command", new CRecargaTarifa());
		mv.setViewName("recarga_tarifa");
		return mv;
	}
	@RequestMapping(value = "convenio", method = RequestMethod.POST)
	public ModelAndView convenio() {
		ModelAndView mv = new ModelAndView("convenio", "command", new CConvenio());
		mv.setViewName("convenio");
		return mv;
	}
	@RequestMapping(value = "premio", method = RequestMethod.POST)
	public ModelAndView premio() {
		ModelAndView mv = new ModelAndView("premio", "command", new CPremio());
		mv.setViewName("premio");
		return mv;
	}
	@RequestMapping(value = "tarifa", method = RequestMethod.POST)
	public ModelAndView tarifa() {
		ModelAndView mv = new ModelAndView("tarifa", "command", new CTarifa());
		mv.setViewName("tarifa");
		return mv;
	}
	@RequestMapping(value = "restaurante", method = RequestMethod.POST)
	public ModelAndView restaurante() {
		ModelAndView mv = new ModelAndView("restaurante", "command", new CRestaurante());
		mv.setViewName("restaurante");
		return mv;
	}
	@RequestMapping(value = "tipo_restaurante", method = RequestMethod.POST)
	public ModelAndView tipo_restaurante() {
		ModelAndView mv = new ModelAndView("tipo_restaurante", "command", new CTipoRestaurante());
		mv.setViewName("tipo_restaurante");
		return mv;
	}

	@RequestMapping(value = "pais", method = RequestMethod.POST)
	public ModelAndView pais() {
		ModelAndView mv = new ModelAndView("pais", "command", new CPais());
		mv.setViewName("pais");
		return mv;
	}

	@RequestMapping(value = "ciudad", method = RequestMethod.POST)
	public ModelAndView ciudad() {
		ModelAndView mv = new ModelAndView("ciudad", "command", new CCiudad());
		mv.setViewName("ciudad");
		return mv;
	}
	
	@RequestMapping(value = "parametro", method = RequestMethod.POST)
	public ModelAndView parametro() {
		ModelAndView mv = new ModelAndView("parametro", "command", new CParametro());
		mv.setViewName("parametro");
		return mv;
	}
	@RequestMapping(value = "tipo_parametro", method = RequestMethod.POST)
	public ModelAndView tipo_parametro() {
		ModelAndView mv = new ModelAndView("tipo_parametro", "command", new CTipoParametro());
		mv.setViewName("tipo_parametro");
		return mv;
	}
	@RequestMapping(value = "parametro_modulo", method = RequestMethod.POST)
	public ModelAndView parametro_modulo() {
		ModelAndView mv = new ModelAndView("parametro_modulo", "command", new CParametroModulo());
		mv.setViewName("parametro_modulo");
		return mv;
	}
	@RequestMapping(value = "bd_conex", method = RequestMethod.GET)
	public ModelAndView bd_conex() {
		ModelAndView mv = new ModelAndView("bd_conex", "command", new CParametroModulo());
		mv.setViewName("bd_conex");
		return mv;
	}
}
