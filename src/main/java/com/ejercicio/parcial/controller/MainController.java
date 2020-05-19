package com.ejercicio.parcial.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ejercicio.parcial.dao.ContribuyenteDAO;
import com.ejercicio.parcial.dao.ImportanciaDAO;
import com.ejercicio.parcial.domain.Contribuyente;
import com.ejercicio.parcial.domain.Importancia;
import com.ejercicio.parcial.service.ContribuyenteService;
import com.ejercicio.parcial.service.ImportanciaService;


@Controller
public class MainController {
	@Autowired
	private ContribuyenteService cService;
	
	@Autowired
	private ImportanciaService iService;
	
	
	@RequestMapping("/inicio")
	public ModelAndView initInicio() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancia = null;
		try {
			importancia = iService.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("contribuyente", new Contribuyente());
		mav.addObject("importancia", importancia);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/exito")
	public ModelAndView initInicio(@ModelAttribute Contribuyente con) {
		ModelAndView mav = new ModelAndView();
		long millis = System.currentTimeMillis();
		java.sql.Date dat = new java.sql.Date(millis);
		String fecha = dat.toString();
		Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(fecha);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(date);
			con.setF_fecha_ingreso(date);
			cService.insert(con);
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("exito");
		return mav;
	}
	
	@RequestMapping("/mostrar")
	public ModelAndView mostrar() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try {
			//cService.insert(con);
			contribuyentes = cService.findAll();
			//System.out.print(contribuyentes.get(6).getImportancia().getS_importancia());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("listado", contribuyentes);
		mav.setViewName("form");
		return mav;
	}
	

}