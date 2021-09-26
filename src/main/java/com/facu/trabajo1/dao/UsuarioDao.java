package com.facu.trabajo1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facu.trabajo1.domains.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
	Usuario findByUsername(String username);

}
