package br.com.senac.escola.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.escola.entity.Aluno;
import br.com.senac.escola.entity.Professor;
import br.com.senac.escola.service.AlunoService;
import br.com.senac.escola.service.ProfessorService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private ProfessorService professorService;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
//		
		 Aluno aluno1 = new Aluno();
		
		 aluno1.setNome("leandro");
		 aluno1.setEmail("leandro@gmail.com");
		 aluno1.setSobreNome("Arraes");
		 alunoService.salvar(aluno1);
		 alunoService.salvar(aluno1);

		 Aluno aluno2 = new Aluno();
		 aluno2.setEmail("gabriel@gmail.com");
		 aluno2.setNome("Gabriel");
		 aluno2.setSobreNome("Silva");
		 alunoService.salvar(aluno2);
		
		 Aluno aluno3 = new Aluno();
		 aluno3.setEmail("karen@gmail.com");
		 aluno3.setNome("Karen");
		 aluno3.setSobreNome("Silva");
		 alunoService.salvar(aluno3);

		 List<Aluno> listaAlunos =  alunoService.buscarTodosAlunos();
		 listaAlunos.forEach(aluno -> System.out.println(aluno.getNome()));

		 Professor professor1 = new Professor();
		 professor1.setEmail("marcelo@gmail.com");
		 professor1.setNome("Marcelo");
		 professor1.setSobreNome("Estruc");
		 professorService.salvar(professor1);

		 Professor professor2 = new Professor();
		 professor2.setEmail("gabi@gmail.com");
		 professor2.setNome("gabi");
		 professor2.setSobreNome("fessora");
		 professorService.salvar(professor2);
		
		
	

		// List<Professor> listaProfessores = professorService.buscarTodosProfessores();
		// listaProfessores.forEach(professor -> System.out.println(professor.getNome()));

		// Aluno alunoAlterado = new Aluno();
		// alunoAlterado.setEmail("lucas@gmail.com");
		// alunoAlterado.setNome("Luccass");
		// aluno1.setSobreNome("Silva");
		// Aluno alunoAtualizado = alunoService.updateAluno(1, alunoAlterado);
		// System.out.println("Aluno alterado: " + alunoAtualizado.getEmail());
       
    }

}