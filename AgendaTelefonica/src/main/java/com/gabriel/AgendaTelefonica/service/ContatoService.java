package com.gabriel.AgendaTelefonica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.AgendaTelefonica.model.Contato;
import com.gabriel.AgendaTelefonica.repository.ContatoRepository;

@RestController
@RequestMapping("/")
public class ContatoService {
	
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@GetMapping
	public String home() {
		return "teste da api";
	}
	
	@GetMapping("listar")
	public List<Contato> listar(){
		return contatoRepository.findAll();
	}
	
	@PostMapping("adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionaContato(@RequestBody Contato contato) {
		contatoRepository.save(contato);
	}
	
	@DeleteMapping("delete")
	public void deletarContato(@RequestBody Contato contato) {
		contatoRepository.delete(contato);
	}
	
	@PutMapping("alterar/{id}")
	public Contato alterarContato(@PathVariable(value = "id") long id, @RequestBody Contato contato) {
		contatoRepository.findById(id);
		return contatoRepository.save(contato);
	}
	
	@GetMapping("listar/{id}")
	public Optional<Contato> listarId(@PathVariable(value = "id") long id){
		return contatoRepository.findById(id);
	}
	
	
}
