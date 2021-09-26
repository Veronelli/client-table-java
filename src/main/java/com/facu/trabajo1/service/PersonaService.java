package com.facu.trabajo1.service;

import java.util.List;

import com.facu.trabajo1.domains.Persona;

public interface PersonaService {
	public List<Persona> listarPersonas();
	public void guardar(Persona persona);
	public void eliminar(Persona persona);
	public Persona encontrarPersona(Persona persona);
	
	
}
