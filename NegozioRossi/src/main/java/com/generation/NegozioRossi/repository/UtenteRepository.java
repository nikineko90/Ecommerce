package com.generation.NegozioRossi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.generation.NegozioRossi.auth.UserDao;
import com.generation.NegozioRossi.model.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Long>, UserDao {

}