package br.com.consulta.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import br.com.agendamento.StatusAgendamento;
import br.com.consulta.Consulta;
import br.com.consulta.infraestructure.ConsultaRepository;
import br.com.infraestructure.GenericRepository;
import br.com.medico.Medico;
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
	
	@Transactional(readOnly = true)
	public boolean existeConsultaComHoraEData(final LocalDate dataAgendamento, final LocalTime hora, final Long idMedico) {
		boolean existeConsulta = this.consultaRepository.existeConsultaComHoraEData(dataAgendamento, hora, idMedico);
		
		return existeConsulta;
	}
	
	@Transactional(readOnly = true)
	public Optional<List<Consulta>> filtroListagem(final LocalDate filtro) {

		if (filtro != null) {
			List<Consulta> ConsultasFiltradas = this.consultaRepository.buscarPorDataAgendamento(filtro);
			return Optional.ofNullable(ConsultasFiltradas);
		}
		List<Consulta>  consultas = this.consultaRepository.findAll();
		
		return Optional.ofNullable(consultas);

	}

	@Transactional
	public String salvarConsulta(final Consulta consulta) {
		
		consulta.getAgendamento().setStatus(StatusAgendamento.AGENDADO);
		
		final LocalDate dataAgendamento = consulta.getAgendamento().getDataAgendamento();
		final LocalTime hora = consulta.getAgendamento().getHoraAgendamento();
		final Long idMedico = consulta.getMedico().getId();
		
		
		final boolean existeConsulta = this.existeConsultaComHoraEData(dataAgendamento, hora, idMedico);
		
		if (existeConsulta) {
			return "Já existe uma consulta nesta data, no mesmo horario, com este médico";
		}
		
		this.salvar(consulta);
		return "";
	}
		
}
