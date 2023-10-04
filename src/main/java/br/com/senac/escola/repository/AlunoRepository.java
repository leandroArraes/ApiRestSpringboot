package br.com.senac.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.escola.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}