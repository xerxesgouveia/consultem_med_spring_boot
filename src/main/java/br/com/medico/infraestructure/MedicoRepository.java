package br.com.medico.infraestructure;

import org.springframework.stereotype.Repository;

import br.com.infraestructure.GenericRepository;
import br.com.medico.Medico;

@Repository
public interface MedicoRepository extends GenericRepository<Medico, Long> {

}
