/**
 * 
 */
package br.com.paciente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import br.com.infraestructure.GenericRepository;
import br.com.paciente.Paciente;
import br.com.paciente.infraestructure.PacienteRepository;
import br.com.service.ServicoGenerico;
import br.com.usuario.service.UsuarioService;

/**
 * @author ricardo belo
 *
 */

@Service
public class PacienteService extends ServicoGenerico<Paciente, Long> {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public GenericRepository<Paciente, Long> getRepository() {
		// TODO Auto-generated method stub
		return this.pacienteRepository;
	}


	@Transactional(readOnly = true)
	public boolean verificarExistenciaCpf(final String cpf) {
		return this.pacienteRepository.verificarExistenciaCpf(cpf); 
	}
	
	@Transactional(readOnly = true)
	public Optional<List<Paciente>> filtroListagem(final String filtro) {
		


		if (!StringUtils.isEmpty(filtro)) {
			List<Paciente> pacientesFiltrados = this.pacienteRepository.findByPessoaNomeContaining(filtro);
			return Optional.ofNullable(pacientesFiltrados);
		}
		List<Paciente>  pacientes = this.pacienteRepository.findAll();
		
		return Optional.ofNullable(pacientes);

	}

	@Transactional
	public String salvarPaciente(Paciente paciente) {
		
		String mensagemUsuario = this.usuarioService.prepararParaPersistir(paciente.getPessoa().getUsuario());
		String existeCpf = this.pacienteRepository.verificarExistenciaCpf(paciente.getPessoa().getCpf()) ? "usuário já existe com este cpf cadastrado" : "";
		
		if (mensagemUsuario.equals("") && existeCpf.equals("")) { 
			this.pacienteRepository.save(paciente);
			return "";
		}
		
		return mensagemUsuario + existeCpf;
	}
}
