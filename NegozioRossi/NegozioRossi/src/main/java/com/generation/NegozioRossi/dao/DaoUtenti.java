package com.generation.NegozioRossi.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.generation.NegozioRossi.model.Utente;
import com.generation.NegozioRossi.util.BasicDao;

@Repository
public class DaoUtenti extends BasicDao implements IDaoUtenti{

	public DaoUtenti(@Value("${db.address}")String dbAddress, 
			@Value("${db.user}")String user, 
			@Value("${db.psw}")String password) {
		super(dbAddress, user, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Utente login(String username, String password) {
		Utente ris = null;
		
		Map<String, String> map = getOne("SELECT * FROM utenti WHERE username = ? AND password = ?", username, password);
		
		if(map!=null) {
			ris = new Utente(Integer.parseInt(map.get("id")), map.get("username"), map.get("password"), map.get("nome"), map.get("cognome"), map.get("indirizzo"));
		}
		return ris;
	}

	@Override
	public void registra(Utente utente) {
		execute("INSERT INTO utenti(username,password,nome,cognome,indirizzo) VALUES (?,?,?,?,?)",
				utente.getUsername(), utente.getPassword(), utente.getNome(), utente.getCognome(), utente.getIndirizzo());
		
	}

}
