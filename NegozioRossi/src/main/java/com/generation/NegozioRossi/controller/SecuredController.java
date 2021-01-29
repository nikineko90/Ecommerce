package com.generation.NegozioRossi.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.NegozioRossi.model.Utente;

@RestController
@RequestMapping("secured")
public class SecuredController {

	@GetMapping
    public Utente detail(@AuthenticationPrincipal Utente utente) {
        return utente;
    }

}
