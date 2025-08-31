package br.edu.infnet.robsonpinto.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.robsonpinto.model.domain.Opcao;

@Repository
public interface OpcaoRepository extends JpaRepository<Opcao, Integer> {
	List<Opcao> findByNomeContaining(String nome);
	List<Opcao> findByAtivoTrue();
}
