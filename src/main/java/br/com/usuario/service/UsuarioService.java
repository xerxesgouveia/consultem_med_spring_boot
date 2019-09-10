/**
 * 
 */
package br.com.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infraestructure.GenericRepository;
import br.com.service.ServicoGenerico;
import br.com.usuario.Usuario;
import br.com.usuario.infraestructure.UsuarioRepository;

@Service
public class UsuarioService extends ServicoGenerico<Usuario, Long> {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public boolean verificarExistenciaLogin(final String login, final String loginAntigo) {
		return this.usuarioRepository.verificarExistenciaLogin(login, loginAntigo); 
	}
	
	@Transactional
	public String prepararParaPersistir(final Usuario usuario) {

		String loginAntigo = "";
		
		if (usuario.getId() != null) {
			
			final Usuario usuarioDB  = this.buscarPorId(usuario.getId());

			loginAntigo = usuarioDB.getLogin();
		}
		
		final boolean existeLogin = this.usuarioRepository.verificarExistenciaLogin(usuario.getLogin(), loginAntigo);
		
		if (existeLogin) {
			return "usuário já existe com login este login cadastrado";
		}
		
		return "";
	}

	@Override
	public GenericRepository<Usuario, Long> getRepository() {
		// TODO Auto-generated method stub
		return this.usuarioRepository;
	}

}
