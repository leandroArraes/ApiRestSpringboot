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

import br.com.senac.escola.dto.CursoDTO;
import br.com.senac.escola.entity.Curso;
import br.com.senac.escola.service.CursoService;

@RestController
@RequestMapping("turmas")
public class TurmaResource {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CursoService cursoService;
	
	@PostMapping
	public ResponseEntity<CursoDTO> cadastrarCurso(@RequestBody CursoDTO cursoDTO) {
		
		Curso curso = mapper.map(cursoDTO, Curso.class);
		
		curso = cursoService.salvar(curso);
	
		CursoDTO cursoNovo = mapper.map(curso, CursoDTO.class);
		
		return ResponseEntity.ok().body(cursoNovo);
	}
	
	@GetMapping
	public ResponseEntity<List<CursoDTO>> buscarTodosturmas() {
		
		List<Curso> listaturmas = cursoService.buscarTodosCurso();
		
		List<CursoDTO> listaCursoDTO = listaturmas.stream().map(curso -> mapper.map(curso, CursoDTO.class)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaCursoDTO);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CursoDTO> buscarCursoPorID(@PathVariable("id") Integer id){
		Curso curso = cursoService.getCursoById(id);
		CursoDTO cursoDTO = mapper.map(curso, CursoDTO.class);
		return ResponseEntity.ok().body(cursoDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CursoDTO> atualizarCurso(@PathVariable("id") Integer id, @RequestBody CursoDTO cursoDTO) {
		Curso curso = mapper.map(cursoDTO, Curso.class);
		curso = cursoService.updateCurso(id, curso);
		CursoDTO cursoAlteradoDTO = mapper.map(curso, CursoDTO.class);
		return ResponseEntity.ok().body(cursoAlteradoDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excluirCurso(@PathVariable("id") Integer id){
		Boolean flag = cursoService.deleteCurso(id);
		return ResponseEntity.ok().body(flag);
	}
	
	
	
	
	
	
	
}