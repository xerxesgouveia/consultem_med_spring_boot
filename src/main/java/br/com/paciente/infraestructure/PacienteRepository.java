package br.com.paciente.infraestructure;

import org.springframework.stereotype.Repository;

import br.com.infraestructure.GenericRepository;
import br.com.paciente.Paciente;

@Repository
public interface PacienteRepository extends GenericRepository<Paciente, Long> {

}
