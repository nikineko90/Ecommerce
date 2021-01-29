package com.generation.NegozioRossi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.NegozioRossi.auth.AuthService;
import com.generation.NegozioRossi.model.Utente;



@RestController
@RequestMapping("/accountmanager")
public class AccountController {

	@Autowired
	private AuthService dao;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public String get() {
		return "<h1>Welcome account manager</h1>";
	}

	@GetMapping("/detail")
	public Utente test(@AuthenticationPrincipal Utente utente) {
		return utente;
	}
	
	
}
