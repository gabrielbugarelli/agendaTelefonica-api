package com.gabriel.AgendaTelefonica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.AgendaTelefonica.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	Optional<Contato> findById(Long id);
}
