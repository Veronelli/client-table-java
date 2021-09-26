package com.facu.trabajo1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facu.trabajo1.dao.UsuarioDao;
import com.facu.trabajo1.domains.Rol;
import com.facu.trabajo1.domains.Usuario;

import lombok.extern.slf4j.Slf4j;

@Service("userDetailsService")
@Slf4j
public class UserService implements UserDetailsService{
	@Autowired
	private UsuarioDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userDao.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
			
		}
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		for(Rol rol: user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getRol()));
			
		}
		return new User(user.getUsername(),user.getPassword(),roles);
	}	
	
}
