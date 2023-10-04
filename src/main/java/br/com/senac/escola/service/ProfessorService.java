package br.com.senac.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.escola.entity.Professor;
import br.com.senac.escola.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepository repo;
	
	public Professor salvar(Professor professor) {
		
		 return repo.save(professor);
	}
	
	public List<Professor> buscarTodosProfessores( ) {
		return repo.findAll();
	}
	
	public Professor getProfessorById(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public Boolean deleteProfessor(Integer id) {
		Professor professor = repo.findById(id).orElse(null);
		if(professor != null) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Professor updateProfessor(Integer id, Professor professorAlterado) {
		Professor professorBD = repo.findById(id).orElse(null);
		if(professorBD != null) {
			professorBD.setEmail(professorAlterado.getEmail());
			professorBD.setNome(professorAlterado.getNome());
			professorBD.setSobreNome(professorAlterado.getSobreNome());
			return repo.save(professorBD);
		}else {
			return null;
		}
	}		
}