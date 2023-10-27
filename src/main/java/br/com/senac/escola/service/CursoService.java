package br.com.senac.escola.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.escola.entity.Curso;
import br.com.senac.escola.entity.Curso;
import br.com.senac.escola.repository.CursoRepository;
import br.com.senac.escola.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
	CursoRepository repo;
	
	public Curso salvar(Curso Curso) {
		
		 return repo.save(Curso);
	}
	
	public List<Curso> buscarTodosCurso( ) {
		return repo.findAll();
	}
	
	public Curso getCursoById(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public Boolean deleteCurso(Integer id) {
		Curso curso = repo.findById(id).orElse(null);
		if(curso != null) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Curso updateCurso(Integer id, Curso cursoAlterado) {
		Curso cursoBD = repo.findById(id).orElse(null);
		if(cursoBD != null) {
			cursoBD.setNome(cursoAlterado.getNome());

			return repo.save(cursoBD);
		}else {
			return null;
		}
	}	
}
