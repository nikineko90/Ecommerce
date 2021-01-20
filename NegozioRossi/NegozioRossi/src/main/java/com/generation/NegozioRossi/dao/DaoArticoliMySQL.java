package com.generation.NegozioRossi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.generation.NegozioRossi.model.Articolo;
import com.generation.NegozioRossi.util.BasicDao;

@Repository
public class DaoArticoliMySQL extends BasicDao implements IDaoArticoli{

	public DaoArticoliMySQL(
			@Value("${db.address}")String dbAddress, 
			@Value("${db.user}")String user, 
			@Value("${db.psw}")String password) {
		super(dbAddress, user, password);
		// TODO Auto-generated constructor stub
	}



	@Override
	public List<Articolo> articoli() {
		List<Articolo> ris = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM articoli");
		
		for (Map<String, String> map : maps) {
			Articolo a = new Articolo();
			a.fromMap(map);
			ris.add(a);
		}
		return ris;
	}

	@Override
	public Articolo articolo(int id) {
		Articolo ris = null;
		
		Map<String, String> map = getOne("SELECT * FROM articoli WHERE id=?", id);
		
		if(map!= null) {
			ris = new Articolo();
			ris.fromMap(map);
		}
		return ris;
	}

	@Override
	public void addArticolo(Articolo articolo) {
		execute("INSERT into articoli (nome,codicearticolo,categoria,prezzo,colore,taglia,quantita,sesso,brand) VALUES (?,?,?,?,?,?,?,?,?)", 
				articolo.getNome(),articolo.getCodicearticolo(), articolo.getCategoria(), articolo.getPrezzo(), articolo.getColore(), articolo.getTaglia(), articolo.getQuantita(), articolo.getSesso(), articolo.getBrand());
		
	}

	@Override
	public void updateArticolo(Articolo articolo) {
		execute("UPDATE articoli SET nome=?, codicearticolo=?, prezzo=?, colore=?, taglia=?, quantita=?, sesso=?, brand=? WHERE id=?", 
				articolo.getNome(), articolo.getCodicearticolo(), articolo.getPrezzo(), articolo.getColore(), articolo.getTaglia(), articolo.getQuantita(), articolo.getSesso(), articolo.getBrand(), articolo.getId());
		
	}

	@Override
	public void deleteArticolo(int id) {
		execute("DELETE FROM articoli WHERE id=?", id);
		
	}

	
	@Override
	public List<Articolo> articoli(String sesso) {
		List<Articolo> ris= new ArrayList<>();
		
		List<Map<String,String>> maps = getAll("SELECT * FROM articoli WHERE sesso = ?", sesso);
		
		for (Map<String, String> map : maps) {
			Articolo a = new Articolo();
			a.fromMap(map);
			ris.add(a);
		}
		return ris;
	}



	@Override
	public List<Articolo> ricercaArticoli(String ricerca) {
		List<Articolo> ris = new ArrayList<>();
		
		List<Map<String,String>> maps = getAll("SELECT * FROM articoli where CONCAT(nome,brand,colore) like %?%", ricerca);
		
		for(Map<String, String> map : maps) {
			Articolo a = new Articolo();
			a.fromMap(map);
			ris.add(a);
		}
		return ris;
	}

}
