package com.generation.NegozioRossi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.generation.NegozioRossi.model.Articolo;


@Repository
public interface ArticoloRepository extends CrudRepository<Articolo, Long>{

	List<Articolo> findBySesso(String sesso);

	
}
