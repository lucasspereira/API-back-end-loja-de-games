package com.lojadegames.Loja.de.Games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.Loja.de.Games.model.ModelCategoriaGames;

@Repository
public interface RepositoryCategoriaGames extends JpaRepository<ModelCategoriaGames, Long>{
	public List<ModelCategoriaGames> findAllByDescricaoContainingIgnoreCase (String descricao);
}
