package br.com.senac.escola.dto;

import java.util.Date;

import br.com.senac.escola.entity.Aluno;
import br.com.senac.escola.entity.Professor;
import lombok.Data;

@Data
public class TurmaDTO {
private Integer id;
	
	private String sala;
	private String ano;
	private Date anoInicial;
	
	private Professor parofessores;
	private Aluno Alunos;
}
