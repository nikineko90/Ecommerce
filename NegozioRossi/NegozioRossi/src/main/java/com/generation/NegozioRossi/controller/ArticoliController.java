package com.generation.NegozioRossi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.NegozioRossi.dao.DaoArticoliMySQL;
import com.generation.NegozioRossi.model.Articolo;

@RestController
@RequestMapping("/articoli")
public class ArticoliController {

	@Autowired
	private DaoArticoliMySQL dao;
	
	@GetMapping
	public List<Articolo> get(@RequestParam(defaultValue = "") String sesso) {
		if(sesso.equals(""))
		return dao.articoli();
		
		return dao.articoli(sesso);
	}
	
	@GetMapping("/{id}")
	public Articolo get(@PathVariable int id) {
		return dao.articolo(id);
	}
	
	@PostMapping
	public void post(@RequestBody Articolo articolo) {
		dao.addArticolo(articolo);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		dao.deleteArticolo(id);
	}
	
	@PutMapping("/{id}")
	public void put(@RequestBody Articolo articolo) {
		dao.updateArticolo(articolo);
	}
	
	@GetMapping("/{ricerca}")
	public List<Articolo> ricerca(@RequestParam(defaultValue="") String ricerca) {
		System.out.println("Siam qui");
		if(ricerca.equals("")) {
			System.out.println("AHO non va");
		}
			return dao.ricercaArticoli(ricerca);
		
	}
	
}
