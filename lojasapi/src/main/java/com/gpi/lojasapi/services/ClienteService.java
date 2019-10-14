package com.gpi.lojasapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpi.lojasapi.model.Cliente;
import com.gpi.lojasapi.repository.ClienteRepository;
import com.gpi.lojasapi.services.exceptions.ClienteNaoEncontradoException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> listar(){
		return repository.findAll();
	}
	
	public Cliente buscar(Long id) {		
		if(repository.existsById(id)) {
			Optional<Cliente> cliente = repository.findById(id);			
			return cliente.get();
		}else {
			throw new ClienteNaoEncontradoException("Cliente não encontrado");
		}		
	}
	
	public Cliente salvar(Cliente cliente) {
		cliente.setIdCliente(null);
		return repository.save(cliente);
	}
	
	public void deletar(Long id) {
		try {
			repository.deleteById(id);
		} catch (ClienteNaoEncontradoException e) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado");
		} 
	}
	
	public void atualizar(Cliente cliente) {
		if(repository.existsById(cliente.getIdCliente())) {
			repository.save(cliente);
		}
	}
}
