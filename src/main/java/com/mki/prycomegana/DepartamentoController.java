package com.mki.prycomegana;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import conexion.CrudDepartamento;
import conexion.CrudPais;
import localizacion.CDepartamento;

@Controller
public class DepartamentoController {
	//CONTROLADORES DEPARTAMENTO
	@RequestMapping(value = "agregarDepartamento", method = RequestMethod.GET)
	public ModelAndView agregarDepartamento(Model model) {
		ModelAndView mv = new ModelAndView("agregarDepartamento", "command", new CDepartamento());
        CDepartamento depto = new CDepartamento();
        model.addAttribute("agregarDepartamento",  depto);
        //CONSULTA PAIS
        CrudPais conexPais = new CrudPais();
        Connection con = conexPais.Conecta();
		try {
			//CONSULTA PAIS
			Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from pais");
	        List<String> lstPaises = new ArrayList<String>();
	        while (rs.next())
	        	lstPaises.add(rs.getString(2));
	        mv.addObject("lstPaises",lstPaises);
		}catch(Exception e) {
			System.out.println("Consulta del país fallida...");
			System.out.println(e.getMessage());
		}
        mv.setViewName("agregarDepartamento");
		return mv;
	}

	@RequestMapping(value = "/rAgregarDepartamento", method = RequestMethod.GET)
    public void guardarDepartamento(Model model, @Validated CDepartamento depto, BindingResult result,
    		HttpSession session) { 
          CrudDepartamento conexDepto = new CrudDepartamento();
          conexDepto.Conecta();
          //INSERTA PAIS
          conexDepto.crearDepartamento(depto.getsNombre(),depto.getsPais(),depto.getsFecha(),depto.getsHora(), session);
     }

	@RequestMapping(value = "actualizarDepartamento", method = RequestMethod.GET)
	public ModelAndView actualizarDepartamento(Model model) {
		ModelAndView mv = new ModelAndView("actualizarDepartamento", "command", new CDepartamento());
        CDepartamento depto = new CDepartamento();
        model.addAttribute("actualizarDepartamento",  depto);
		mv.setViewName("actualizarDepartamento");
		return mv;
	}

	@RequestMapping(value = "/rActualizarDepartamento", method = RequestMethod.GET)
    public ModelAndView rActualizarDepartamento(Model model, @Validated CDepartamento datDepto, BindingResult result, 
    		HttpSession session) { 
		ModelAndView mv = new ModelAndView("rActualizarDepartamento", "command", new CDepartamento());
		CDepartamento departamento = new CDepartamento();
		model.addAttribute("rActualizarDepartamento", departamento);
		mv.setViewName("rActualizarDepartamento");
		CrudDepartamento conexDepartamento = new CrudDepartamento();
		conexDepartamento.Conecta();
        //CONSULTA PAISES
        CrudDepartamento conexDepto = new CrudDepartamento();
        Connection con = conexDepto.Conecta();
		try {
			//CONSULTA DEPARTAMENTO
			Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from pais");
	        List<String> lstPaises = new ArrayList<String>();
	        while (rs.next())
	        	lstPaises.add(rs.getString(2));
	        mv.addObject("lstPaises",lstPaises);
		}catch(Exception e) {
			System.out.println("Consulta del país fallida...");
			System.out.println(e.getMessage());
		}
		//CONSULTAR CIUDAD
		conexDepartamento.consultarDepartamento(datDepto.getiCodigo(), session);
		return mv;
     }
	
	@RequestMapping(value = "/r2ActualizarDepartamento", method = RequestMethod.GET)
    public void r2ActualizarDepartamento(Model model, @Validated CDepartamento datDepartamento, BindingResult result,
    		HttpSession session) { 
          CrudDepartamento conexDepartamento = new CrudDepartamento();
          conexDepartamento.Conecta();
          //INSERTA DEPARTAMENTO
          conexDepartamento.actualizarDepartamento(datDepartamento.getiCodigo(), datDepartamento.getsNombre(), datDepartamento.getsPais(), datDepartamento.getsFecha(), datDepartamento.getsHora(), session);
     }

	@RequestMapping(value = "borrarDepartamento", method = RequestMethod.GET)
	public ModelAndView borrarDepartamento(Model model) {
		ModelAndView mv = new ModelAndView("borrarDepartamento", "command", new CDepartamento());
        CDepartamento depto = new CDepartamento();
        model.addAttribute("borrarDepartamento",  depto);
		mv.setViewName("borrarDepartamento");
		return mv;
	}

	@RequestMapping(value = "consultarDepartamento", method = RequestMethod.GET)
	public ModelAndView consultarDepartamento(Model model) {
		ModelAndView mv = new ModelAndView("consultarDepartamento", "command", new CDepartamento());
        CDepartamento departamento = new CDepartamento();
        model.addAttribute("consultarDepartamento",  departamento);
		mv.setViewName("consultarDepartamento");
		return mv;
	}
	@RequestMapping(value = "rConsultarDepartamento", method = RequestMethod.GET)
	public ModelAndView rConsultarDepartamento(Model model, @Validated CDepartamento datdepto, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarDepartamento", "command", new CDepartamento());
        CDepartamento depto = new CDepartamento();
        model.addAttribute("rConsultarDepartamento",  depto);
		mv.setViewName("rConsultarDepartamento");

        //CONSULTA PAIS
        CrudPais conexPais = new CrudPais();
        Connection con = conexPais.Conecta();
		try {
			//CONSULTA PAIS
			Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from pais");
	        List<String> lstPaises = new ArrayList<String>();
	        while (rs.next())
	        	lstPaises.add(rs.getString(2));
	        mv.addObject("lstPaises",lstPaises);
		}catch(Exception e) {
			System.out.println("Consulta del pais fallida...");
			System.out.println(e.getMessage());
		}
		
		CrudDepartamento conexDepto = new CrudDepartamento();
        conexDepto.Conecta();
        //INSERTA PAIS
        conexDepto.consultarDepartamento(datdepto.getiCodigo(), session);
		return mv;
	}
	
	@RequestMapping(value = "departamento", method = RequestMethod.POST)
	public ModelAndView departamento() {
		ModelAndView mv = new ModelAndView("departamento", "command", new CDepartamento());
		mv.setViewName("departamento");
		return mv;
	}

	@RequestMapping(value = "/rBorrarDepartamento", method = RequestMethod.GET)
    public void rBorrarDepartamento(Model model, @Validated CDepartamento depto, BindingResult result,
    		HttpSession session) { 
          CrudDepartamento conexDepto = new CrudDepartamento();
          conexDepto.Conecta();
          //RESPUESTA ELIMINAR DEPARTAMENTO
          conexDepto.borrarDepartamento(depto.getiCodigo(), session);
     }
}
