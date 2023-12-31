package br.com.senac.escola.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity

@Data
public class Professor {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String sobreNome;
	
	
	private String email;
	
	@OneToOne
	@JoinColumn(name = "id_curso", referencedColumnName = "id")
	private Curso curso;

    
}
