/**
 * 
 */
package br.com.medico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infraestructure.GenericRepository;
import br.com.medico.Medico;
import br.com.medico.infraestructure.MedicoRepository;
import br.com.service.ServicoGenerico;

@Service
public class MedicoService extends ServicoGenerico<Medico, Long> {

	@Autowired
	private MedicoRepository medicoRepository;

	@Override
	public GenericRepository<Medico, Long> getRepository() {
		// TODO Auto-generated method stub
		return this.medicoRepository;
	}
	
//	public MedicoService() {
//		super(Medico.class);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	protected GenericRepository<Medico, Long> getRepository() {
//		// TODO Auto-generated method stub
//		return this.medicoRepository;
//	}
//
//	public Medico salvarMedico(Medico medico) {
//
//		Usuario usuario = this.preparadorPersistencia.prepararParaPersistir(medico.getPessoa().getUsuario());
//
//		if (usuario == null) {
//			return null;
//		}
//		medico.getPessoa().setUsuario(usuario);
//
//		if (medico.getId() != null) {
//			this.medicoRepository.editar(medico);
//		} else {
//			this.medicoRepository.salvar(medico);
//		}
//
//		return medico;
//	}

	

}
