package br.com.paciente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.usuario.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@EqualsAndHashCode
@Data
public class Paciente implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String prontuario;
	
	@Embedded
	private Pessoa pessoa;

}
