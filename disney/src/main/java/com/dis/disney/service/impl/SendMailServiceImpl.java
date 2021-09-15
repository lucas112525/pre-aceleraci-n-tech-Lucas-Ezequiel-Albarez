package com.dis.disney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dis.disney.model.Usuario;
import com.dis.disney.service.SendMailService;

@Service
public class SendMailServiceImpl implements SendMailService{

	@Autowired
	private JavaMailSender mailSender;
	
	
	@Override
	public void enviarMail(Usuario user) {
		SimpleMailMessage mensajeMail= new SimpleMailMessage();
		mensajeMail.setTo(user.getmail());
		mensajeMail.setSubject("Registro");
		mensajeMail.setText("La cuenta ha sido registrada con exito :)");
		mailSender.send(mensajeMail);
		
	}

}
