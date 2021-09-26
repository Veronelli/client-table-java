package com.facu.trabajo1.dao;

import org.springframework.data.repository.CrudRepository;

import com.facu.trabajo1.domains.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long>{

}
