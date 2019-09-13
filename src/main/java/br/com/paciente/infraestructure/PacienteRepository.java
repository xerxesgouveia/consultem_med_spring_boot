package br.com.paciente.infraestructure;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.infraestructure.GenericRepository;
import br.com.paciente.Paciente;

/**
 * @author ricardo belo
 *
 */

@Repository
public interface PacienteRepository extends GenericRepository<Paciente, Long> {
	
	public List<Paciente> findByPessoaNomeContaining(String nome);
	                                                                                                                                                                        
	@Query("select case when (count(p.id) > 0) then true else false end from Paciente p where p.pessoa.cpf= :cpf")
	boolean verificarExistenciaCpf( @Param("cpf") final String cpf);


}

