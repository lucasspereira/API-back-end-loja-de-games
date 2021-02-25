package com.lojadegames.Loja.de.Games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.Loja.de.Games.model.ModelGames;

@Repository
public interface RepositorioGames extends JpaRepository<ModelGames, Long>{
	public List<ModelGames> findAllByNomeContainingIgnoreCase (String descricao);
}
