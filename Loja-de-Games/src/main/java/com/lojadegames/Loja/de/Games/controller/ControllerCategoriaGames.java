package com.lojadegames.Loja.de.Games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojadegames.Loja.de.Games.model.ModelCategoriaGames;
import com.lojadegames.Loja.de.Games.repository.RepositoryCategoriaGames;


@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class ControllerCategoriaGames {

	@Autowired
	private RepositoryCategoriaGames repository;

	@GetMapping
	public ResponseEntity<List<ModelCategoriaGames>> GetCategoria() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ModelCategoriaGames> GetCategoriaById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<ModelCategoriaGames> PostCategoria(ModelCategoriaGames categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}

	@PutMapping
	public ResponseEntity<ModelCategoriaGames> PutCategoria(@RequestBody ModelCategoriaGames categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping ("/{id}")
	public void DeleteCategoria (@PathVariable long id) {
		repository.deleteById(id);
	}
}
