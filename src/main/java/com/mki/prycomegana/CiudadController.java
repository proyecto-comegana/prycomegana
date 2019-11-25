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
import conexion.crudCiudad;
import localizacion.CCiudad;

@Controller
public class CiudadController {
	
	@RequestMapping(value = "borrarCiudad", method = RequestMethod.GET)
	public ModelAndView borrarCiudad(Model model) {
		ModelAndView mv = new ModelAndView("borrarCiudad", "command", new CCiudad());
        CCiudad ciudad = new CCiudad();
        model.addAttribute("borrarCiudad",  ciudad);
		mv.setViewName("borrarCiudad");
		return mv;
	}

	@RequestMapping(value = "/rBorrarCiudad", method = RequestMethod.GET)
    public void rBorrarCiudad(Model model, @Validated CCiudad ciudad, BindingResult result,
    		HttpSession session) { 
          crudCiudad conexCiudad = new crudCiudad();
          conexCiudad.Conecta();
          //RESPUESTA ELIMINAR DEPARTAMENTO
          conexCiudad.borrarCiudad(ciudad.getiCodigo(), session);
     }
	@RequestMapping(value = "agregarCiudad", method = RequestMethod.GET)
	public ModelAndView agregarCiudad(Model model) {
		ModelAndView mv = new ModelAndView("agregarCiudad", "command", new CCiudad());
        //CONSULTA DEPARTAMENTOS
        CrudDepartamento conexDepto = new CrudDepartamento();
        Connection con = conexDepto.Conecta();
		try {
			//CONSULTA DEPARTAMENTO
			Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from departamento");
	        List<String> lstDeptos = new ArrayList<String>();
	        while (rs.next())
	        	lstDeptos.add(rs.getString(2));
	        mv.addObject("lstDeptos",lstDeptos);
		}catch(Exception e) {
			System.out.println("Consulta del departamento fallida...");
			System.out.println(e.getMessage());
			return null;
		}
		mv.setViewName("agregarCiudad");
		return mv;
	}

	@RequestMapping(value = "/rAgregarCiudad", method = RequestMethod.GET)
    public void guardarCiudad(Model model, @Validated CCiudad ciudad, BindingResult result,
    		HttpSession session) { 
          crudCiudad conexCiudad = new crudCiudad();
          conexCiudad.Conecta();
          //INSERTA PAIS
          conexCiudad.crearCiudad(ciudad.getsNombre(),ciudad.getsDepartamento(),ciudad.getsFecha(),ciudad.getsHora(), session);
     }
	
	@RequestMapping(value = "actualizarCiudad", method = RequestMethod.GET)
	public ModelAndView actualizarCiudad() {
		ModelAndView mv = new ModelAndView("actualizarCiudad", "command", new CCiudad());
		mv.setViewName("actualizarCiudad");
		return mv;
	}

	@RequestMapping(value = "/rActualizarCiudad", method = RequestMethod.GET)
    public ModelAndView rActualizarCiudad(Model model, @Validated CCiudad datciudad, BindingResult result,
    		HttpSession session) { 
			ModelAndView mv = new ModelAndView("rActualizarCiudad", "command", new CCiudad());
			CCiudad ciudad = new CCiudad();
			model.addAttribute("rActualizarCiudad", ciudad);
			mv.setViewName("rActualizarCiudad");
			//IMPRIME EN CONSOLA VALOR DE LA CIUDAD
			System.out.println("Codigo:"+datciudad.getiCodigo());
			crudCiudad conexCiudad = new crudCiudad();
			conexCiudad.Conecta();
	        //CONSULTA DEPARTAMENTOS
	        CrudDepartamento conexDepto = new CrudDepartamento();
	        Connection con = conexDepto.Conecta();
			try {
				//CONSULTA DEPARTAMENTO
				Statement stmnt = null;
		        stmnt = con.createStatement();
		        ResultSet rs = stmnt.executeQuery("select * from departamento");
		        List<String> lstDeptos = new ArrayList<String>();
		        while (rs.next())
		        	lstDeptos.add(rs.getString(2));
		        mv.addObject("lstDeptos",lstDeptos);
			}catch(Exception e) {
				System.out.println("Consulta del departamento fallida...");
				System.out.println(e.getMessage());
			}
			//CONSULTAR CIUDAD
			conexCiudad.consultarCiudad(datciudad.getiCodigo(), session);
			return mv;
     }

	@RequestMapping(value = "/r2ActualizarCiudad", method = RequestMethod.GET)
    public void r2ActualizarCiudad(Model model, @Validated CCiudad ciudad, BindingResult result,
    		HttpSession session) { 
          crudCiudad conexCiudad = new crudCiudad();
          conexCiudad.Conecta();
          //INSERTA PAIS
          conexCiudad.actualizarCiudad(ciudad.getiCodigo(), ciudad.getsNombre(), ciudad.getsDepartamento(), ciudad.getsFecha(), ciudad.getsHora(), session);
     }

	@RequestMapping(value = "consultarCiudad", method = RequestMethod.GET)
	public ModelAndView consultarCiudad(Model model) {
		ModelAndView mv = new ModelAndView("consultarCiudad", "command", new CCiudad());
        CCiudad ciudad = new CCiudad();
        model.addAttribute("consultarCiudad",  ciudad);
		mv.setViewName("consultarCiudad");
		return mv;
	}
	
	@RequestMapping(value = "rConsultarCiudad", method = RequestMethod.GET)
	public ModelAndView rConsultarCiudad(Model model, @Validated CCiudad datciudad, BindingResult result, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView("rConsultarCiudad", "command", new CCiudad());
        CCiudad ciudad = new CCiudad();
        model.addAttribute("rConsultarCiudad",  ciudad);
        //CONSULTA DEPARTAMENTOS
        CrudDepartamento conexDepto = new CrudDepartamento();
        Connection con = conexDepto.Conecta();
		try {
			//CONSULTA DEPARTAMENTO
			Statement stmnt = null;
	        stmnt = con.createStatement();
	        ResultSet rs = stmnt.executeQuery("select * from departamento");
	        List<String> lstDeptos = new ArrayList<String>();
	        while (rs.next())
	        	lstDeptos.add(rs.getString(2));
	        mv.addObject("lstDeptos",lstDeptos);
		}catch(Exception e) {
			System.out.println("Consulta del departamento fallida...");
			System.out.println(e.getMessage());
			return null;
		}
        crudCiudad conexCiudad = new crudCiudad();
        conexCiudad.Conecta();
        //INSERTA PAIS
        conexCiudad.consultarCiudad(datciudad.getiCodigo(), session);
		return mv;
	}
}
