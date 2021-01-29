package com.generation.NegozioRossi.controller;

import java.net.http.HttpResponse;

import javax.websocket.SendResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.NegozioRossi.auth.AuthService;
import com.generation.NegozioRossi.model.Utente;

/**
 * Questo è il controller che ci permette di poter registrare un nuovo utente
 * @author niki2
 *
 */
@RestController
@RequestMapping("/signup")
public class SignupController {
	
	@Autowired
	private AuthService authService;

	@PostMapping
	public String signup(Utente nuovo) {
		authService.signup(nuovo);
		return "<p>Ok</p>"
				+ "<p>Se vuoi loggare premi qui</p>\r\n"
				+ "<a href=\"/login.html\"><button class=\"pulsante\">Login</button></a>";
	}
	
}