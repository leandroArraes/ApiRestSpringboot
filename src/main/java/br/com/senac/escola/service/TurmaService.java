package br.com.senac.escola.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.escola.entity.Turma;
import br.com.senac.escola.repository.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
	TurmaRepository repo;
	
	public Turma salvar(Turma turma) {
		
		 return repo.save(turma);
	}
	
	public List<Turma> buscarTodosTurmas( ) {
		return repo.findAll();
	}
	
	public Turma getTurmaById(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public Boolean deleteTurma(Integer id) {
		Turma turma = repo.findById(id).orElse(null);
		if(turma != null) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Turma updateTurma(Integer id, Turma turmaAlterado) {
		Turma turmaBD = repo.findById(id).orElse(null);
		if(turmaBD != null) {
			turmaBD.setSala(turmaAlterado.getSala());
			turmaBD.setAno(turmaAlterado.getAno());
			turmaBD.setAnoInicial(turmaAlterado.getAnoInicial());
			turmaBD.setParofessores(turmaAlterado.getParofessores());
			turmaBD.setAlunos(turmaAlterado.getAlunos());
			return repo.save(turmaBD);
		}else {
			return null;
		}
	}	
}
