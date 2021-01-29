package com.generation.NegozioRossi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.NegozioRossi.model.Articolo;
import com.generation.NegozioRossi.repository.ArticoloRepository;

@RestController
@RequestMapping("/articoli")
public class ArticoliController {

	@Autowired
	private ArticoloRepository articoloDao;
	
	
//	@GetMapping
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
//	public List<Articolo> get(String keyword, String sesso) {
//		if(keyword !=null)
//		return dao.ricercaArticoli(keyword);
//		if(sesso!=null) 
//			return dao.articoli(sesso);
//		return dao.articoli();
//	}
	
	@GetMapping
	public Iterable<Articolo> get(@RequestParam(defaultValue = "") String sesso) {
		if(sesso.equals("F"))	{
			return articoloDao.findBySesso(sesso);
		}
		if(sesso.equals("M"))	{
			return articoloDao.findBySesso(sesso);
		}
		return articoloDao.findAll();
	}
	
//	@GetMapping("/{id}")
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
//	public Articolo get(@PathVariable Integer id) {
//		return dao.articolo(id);
//	}
	
	
	@GetMapping("/dettaglio/{id}")
	public Articolo getOne(@PathVariable Long id) {
		Articolo a = articoloDao.findById(id).orElse(null);
		return a;
	}
	
	
//	@PostMapping
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
//	public void post(@RequestBody Articolo articolo) {
//		dao.addArticolo(articolo);
//	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public void addOne(@RequestBody Articolo articolo) {
		articoloDao.save(articolo);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public void delete(@PathVariable Long id) {
		articoloDao.deleteById(id);
	}
	
	@PutMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public void put(@RequestBody Articolo articolo) {
		if(articoloDao.findById(articolo.getId()).isPresent())
			articoloDao.save(articolo);
	}
	
	
}
