/**
 * 
 */
package br.com.funcionario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import br.com.funcionario.Funcionario;
import br.com.funcionario.infraestructure.FuncionarioRepository;
import br.com.infraestructure.GenericRepository;
import br.com.service.ServicoGenerico;
import br.com.usuario.Usuario;
import br.com.usuario.service.UsuarioService;

@Service
public class FuncionarioService extends ServicoGenerico<Funcionario, Long> {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public GenericRepository<Funcionario, Long> getRepository() {
		// TODO Auto-generated method stub
		return this.funcionarioRepository;
	}

	@Transactional(readOnly = true)
	public List<Funcionario> filtroListagem(final String filtro) {

		if (!StringUtils.isEmpty(filtro)) {
			List<Funcionario> funcionarios = this.funcionarioRepository.findByPessoaNomeContaining(filtro);
			return funcionarios;
		}
		return super.listar();

	}

	@Transactional
	public Optional<Funcionario> salvarFuncionario(Funcionario funcionario) {
		Usuario usuario = this.usuarioService.prepararParaPersistir(funcionario.getPessoa().getUsuario());
		
		if (Optional.ofNullable(usuario).isPresent()) {
			return Optional.of(this.funcionarioRepository.save(funcionario));
		}
		
		return null;
	}
}
