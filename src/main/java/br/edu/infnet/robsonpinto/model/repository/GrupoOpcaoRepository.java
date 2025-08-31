package br.edu.infnet.robsonpinto.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.robsonpinto.model.domain.GrupoOpcao;

@Repository
public interface GrupoOpcaoRepository extends JpaRepository<GrupoOpcao, Integer> {
	List<GrupoOpcao> findByNomeContaining(String nome);
	List<GrupoOpcao> findByObrigatorioTrue();
}
