package br.com.senac.escola.resource;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.escola.dto.TurmaDTO;
import br.com.senac.escola.entity.Turma;
import br.com.senac.escola.service.TurmaService;

@RestController
@RequestMapping("turmaes")
public class CursoResource {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private TurmaService turmaService;
	
	@PostMapping
	public ResponseEntity<TurmaDTO> cadastrarTurma(@RequestBody TurmaDTO turmaDTO) {
		
		Turma turma = mapper.map(turmaDTO, Turma.class);
		
		turma = turmaService.salvar(turma);
	
		TurmaDTO turmaNovo = mapper.map(turma, TurmaDTO.class);
		
		return ResponseEntity.ok().body(turmaNovo);
	}
	
	@GetMapping
	public ResponseEntity<List<TurmaDTO>> buscarTodosTurmaes() {
		
		List<Turma> listaTurmaes = turmaService.buscarTodosTurmas();
		
		List<TurmaDTO> listaTurmaDTO = listaTurmaes.stream().map(turma -> mapper.map(turma, TurmaDTO.class)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaTurmaDTO);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<TurmaDTO> buscarTurmaPorID(@PathVariable("id") Integer id){
		Turma turma = turmaService.getTurmaById(id);
		TurmaDTO turmaDTO = mapper.map(turma, TurmaDTO.class);
		return ResponseEntity.ok().body(turmaDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TurmaDTO> atualizarTurma(@PathVariable("id") Integer id, @RequestBody TurmaDTO turmaDTO) {
		Turma turma = mapper.map(turmaDTO, Turma.class);
		turma = turmaService.updateTurma(id, turma);
		TurmaDTO turmaAlteradoDTO = mapper.map(turma, TurmaDTO.class);
		return ResponseEntity.ok().body(turmaAlteradoDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excluirTurma(@PathVariable("id") Integer id){
		Boolean flag = turmaService.deleteTurma(id);
		return ResponseEntity.ok().body(flag);
	}
	
	
	
	
	
	
	
}