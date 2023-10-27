package br.com.senac.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.escola.entity.Aluno;
import br.com.senac.escola.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}