package br.com.senac.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.escola.entity.Professor;

@Repository
public interface ProfessorRepository  extends JpaRepository<Professor, Integer>{

}
