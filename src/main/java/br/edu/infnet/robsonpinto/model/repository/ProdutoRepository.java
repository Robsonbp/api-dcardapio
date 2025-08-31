package br.edu.infnet.robsonpinto.model.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.robsonpinto.model.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	List<Produto> findByNomeContaining(String nome);
	List<Produto> findByValorBetween(BigDecimal min, BigDecimal max);
	List<Produto> findByAtivoTrue();
}
