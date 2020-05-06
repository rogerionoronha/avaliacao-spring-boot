package br.com.tokiomarine.seguradora.avaliacao.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name="Estudante")
public class Estudante {
	
	@Id
	@SequenceGenerator(name="estudante_seq", sequenceName="estudante_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="estudante_seq")
	private Long id;
	
	@NotNull(message = "Nome é obrigatório")
	@NotEmpty(message = "Nome é obrigatório")
	@Column(name = "nome")
	private String name;
	
	@NotNull(message = "Email é obrigatório")
	@NotEmpty(message = "Email é obrigatório")
	private String email;
	
	@NotNull(message = "Matrícula é obrigatória")
	@NotEmpty(message = "Matrícula é obrigatória")
	private String matricula;
	
	private String telefone;
	private String curso;
	
}
