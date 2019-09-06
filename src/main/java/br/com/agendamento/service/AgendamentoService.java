package br.com.agendamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendamento.Agendamento;
import br.com.agendamento.infraestructure.AgendamentoRepository;
import br.com.infraestructure.GenericRepository;
import br.com.service.ServicoGenerico;

@Service
public class AgendamentoService extends ServicoGenerico<Agendamento, Long>{
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Override
	public GenericRepository<Agendamento, Long> getRepository() {
		// TODO Auto-generated method stub
		return agendamentoRepository;
	}

}
