package br.com.funcionario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import br.com.usuario.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
public class Funcionario implements Serializable  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column
	@Length(min=3, max=20, message="O cargo não pode ser vazio")
	private String cargo;
	@Column
	private String setor;
	
	@Embedded
	private Pessoa pessoa;
}
