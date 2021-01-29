package com.generation.NegozioRossi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.generation.NegozioRossi.model.Carrello;

@Repository
public interface CarrelloRepository extends CrudRepository<Carrello, Long>{

}
