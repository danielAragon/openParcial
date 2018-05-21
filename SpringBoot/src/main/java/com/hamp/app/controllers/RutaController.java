package com.hamp.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hamp.app.models.entity.Ruta;
import com.hamp.app.models.service.IRutaService;

@Controller
public class RutaController {
	@Autowired
	public IRutaService rutaService;
	
	@RequestMapping(value = "/rutas", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de rutas");
		model.addAttribute("rutas", rutaService.findAll());
		return "rutas";
	}
	
	@RequestMapping(value = "/rutaAddEdit")
	public String crear(Model model) {
		Ruta ruta = new Ruta();
		model.addAttribute("ruta", ruta);
		model.addAttribute("Titulo","Formulario Ruta");
		return "rutaAddEdit";
	}
}
