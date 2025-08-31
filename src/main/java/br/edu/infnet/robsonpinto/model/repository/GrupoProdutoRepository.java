package br.edu.infnet.robsonpinto.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.robsonpinto.model.domain.GrupoProduto;

@Repository
public interface GrupoProdutoRepository extends JpaRepository<GrupoProduto, Integer> {
	List<GrupoProduto> findByNomeContaining(String nome);
	List<GrupoProduto> findByAtivoTrue();
}
