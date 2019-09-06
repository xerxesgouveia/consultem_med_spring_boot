/**
 * 
 */
package br.com.paciente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infraestructure.GenericRepository;
import br.com.paciente.Paciente;
import br.com.paciente.infraestructure.PacienteRepository;
import br.com.service.ServicoGenerico;

/**
 * @author edmar soares de lima
 *
 */
@Service
public class PacienteService extends ServicoGenerico<Paciente, Long> {
	
	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public GenericRepository<Paciente, Long> getRepository() {
		// TODO Auto-generated method stub
		return this.pacienteRepository;
	}

//	
//	private UsuarioService usuarioService;
//	
//	public PacienteService() {
//		super(Paciente.class);
//		// TODO Auto-generated constructor stub
//	}
//
//	
//	public Paciente salvarPaciente(Paciente paciente) {
//		Usuario usuario = this.preparadorPersistencia.prepararParaPersistir(paciente.getPessoa().getUsuario());
//
//		if (usuario == null) {
//			return null;
//		}
//		paciente.getPessoa().setUsuario(usuario);
//
//		if (paciente.getId() != null) {
//			this.pacienteRepository.editar(paciente);
//		} else {
//			this.pacienteRepository.salvar(paciente);
//		}
//
//		return paciente;
//	}
//
//	@Override
//	protected GenericRepository<Paciente, Long> getRepository() {
//		// TODO Auto-generated method stub
//		return this.pacienteRepository;
//	}

}
