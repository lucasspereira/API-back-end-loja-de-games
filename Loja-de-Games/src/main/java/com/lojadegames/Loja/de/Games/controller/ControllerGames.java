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

import com.lojadegames.Loja.de.Games.model.ModelGames;
import com.lojadegames.Loja.de.Games.repository.RepositorioGames;

@RestController
@RequestMapping("/games")
@CrossOrigin("*")
public class ControllerGames {
	
	@Autowired
	private RepositorioGames repository;
	
	@GetMapping
	public ResponseEntity<List<ModelGames>> GetGame() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModelGames> GetGameById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<ModelGames> PostGame(ModelGames game) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(game));
	}
	
	@PutMapping
	public ResponseEntity<ModelGames> PutGame(@RequestBody ModelGames game) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(game));
	}
	
	@DeleteMapping ("/{id}")
	public void DeleteCategoria (@PathVariable long id) {
		repository.deleteById(id);
	}


}
