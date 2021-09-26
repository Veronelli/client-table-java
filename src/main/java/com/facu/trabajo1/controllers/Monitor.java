package com.facu.trabajo1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.facu.trabajo1.domains.Persona;
import com.facu.trabajo1.service.PersonaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class Monitor {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/")
	public String init(Model model, @AuthenticationPrincipal User user) {	
		List<Persona> personas = personaService.listarPersonas();
		log.info("ejecutando el controlador rest");
		model.addAttribute("personas", personas);
		model.addAttribute("user",user);
		return "index";	
		
	}
	
	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "modificar";
		
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Persona persona,Errors erros) {
		if(erros.hasErrors()) {
			return "modificar";
			
		}
		personaService.guardar(persona);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id_persona}")
	public String editar(Persona persona, Model model) {
		System.out.println(persona.toString());
		persona = personaService.encontrarPersona(persona);
		model.addAttribute("persona", persona);
		return "modificar";
		
	}
	
	@GetMapping("/eliminar")
	public String eliminar(Persona persona) {
		personaService.eliminar(persona);
		return "redirect:/";
		
	}
	
		
}