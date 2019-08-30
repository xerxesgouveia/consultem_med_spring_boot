/**
 * 
 */
package br.com.medico;

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

/**
 * @author edmar soares
 *
 */

@Entity
@Table()
@Data
@EqualsAndHashCode
public class Medico implements Serializable{ 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "CRM")
	private String crm;
	
	@Embedded
	private Pessoa pessoa;

}
