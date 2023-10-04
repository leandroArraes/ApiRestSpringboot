package br.com.senac.escola.dto;

import lombok.Data;

@Data
public class ProfessorDTO {
	private Integer id;
	private String nome;
	
	private String sobreNome;
	
	private String email;
}
