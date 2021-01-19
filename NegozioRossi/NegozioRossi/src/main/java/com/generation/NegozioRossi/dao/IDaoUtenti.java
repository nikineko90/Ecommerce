package com.generation.NegozioRossi.dao;

import com.generation.NegozioRossi.model.Utente;

public interface IDaoUtenti {

	public Utente login(String username, String password);
	
	public void registra(Utente utente);
	
}
