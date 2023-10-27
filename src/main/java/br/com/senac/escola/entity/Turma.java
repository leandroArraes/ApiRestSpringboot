package br.com.senac.escola.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Turma {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String sala;
	private String ano;
	private Date anoInicial;
	
	private Professor parofessores;
	private Aluno Alunos;

}
