package br.com.usuario;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
@Data
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column
	private String nome;
	@Column
	private String telefone;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_usuario") 
	private Usuario usuario;
		
}
