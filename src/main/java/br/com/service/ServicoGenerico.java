package br.com.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.infraestructure.GenericRepository;

public abstract class ServicoGenerico<T,ID extends Serializable> {
	
	@Autowired
	private GenericRepository<T, ID> repository;
	
	@Transactional
	public void salvar(final T entidade) {
		System.out.println();
		this.repository.save(entidade);
	}
	
	@Transactional(readOnly=true)
	public void remover(final ID id) {
		this.repository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public T buscarPorId(final ID id) {
		return this.repository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public List<T> listar(){
		return this.repository.findAll();
	}
}
