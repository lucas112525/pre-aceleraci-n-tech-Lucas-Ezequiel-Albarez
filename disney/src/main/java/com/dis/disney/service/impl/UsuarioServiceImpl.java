package com.dis.disney.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dis.disney.dto.UsuarioDto;
import com.dis.disney.model.Usuario;
import com.dis.disney.repository.UsuarioRepository;
import com.dis.disney.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private SendMailServiceImpl sendMailService;
	
	@Override
	public Usuario findByUsuario(String mail) {
		return usuarioRepository.findByMail(mail);
	}

	@Override
	public Usuario save(UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setmail(usuarioDto.getMail());
		usuario.setContraseña(usuarioDto.getContraseña());
		usuario = usuarioRepository.save(usuario);
		sendMailService.enviarMail(usuario);
		return usuario;
	}

	

}
