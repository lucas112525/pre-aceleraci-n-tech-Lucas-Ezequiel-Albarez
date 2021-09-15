package com.dis.disney.service;

import com.dis.disney.dto.UsuarioDto;
import com.dis.disney.model.Usuario;

public interface UsuarioService {
	public Usuario findByUsuario(String usuario);
	public Usuario save(UsuarioDto usuarioDto);
}