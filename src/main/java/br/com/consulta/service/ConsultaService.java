package br.com.consulta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.consulta.Consulta;
import br.com.consulta.infraestructure.ConsultaRepository;
import br.com.infraestructure.GenericRepository;
import br.com.service.ServicoGenerico;

@Service
public class ConsultaService extends ServicoGenerico<Consulta, Long> {
	
	@Autowired
	private ConsultaRepository consultaRepository;

	@Override
	public GenericRepository<Consulta, Long> getRepository() {
		// TODO Auto-generated method stub
		return this.consultaRepository;
	}
	
	
}
