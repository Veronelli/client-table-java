package com.facu.trabajo1.domains;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_persona;
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String lastname;
	
	@NotEmpty
	@Email
	private String email;
	
	private String telefono;
		
}
