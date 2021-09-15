package com.dis.disney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dis.disney.dto.UsuarioDto;
import com.dis.disney.model.AutenticacionRespuesta;
import com.dis.disney.model.AutenticacionResq;
import com.dis.disney.model.Usuario;
import com.dis.disney.service.UsuarioService;
import com.dis.disney.service.impl.UsuarioDetailServiceImpl;

import com.dis.disney.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioDetailServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthentication(@RequestBody AutenticacionResq autenticacionResq) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(autenticacionResq.getMail(), autenticacionResq.getContraseña())
				);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		UserDetails usuario = userDetailsService.loadUserByUsername(autenticacionResq.getMail());
		String jwt = jwtUtil.generateToken(usuario);
		return new ResponseEntity<>(new AutenticacionRespuesta(jwt), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> createAccount(@RequestBody UsuarioDto usuarioDto){
		Usuario usuario = usuarioService.save(usuarioDto);
		return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
	}
	
}
