package com.gpi.lojasapi.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpi.lojasapi.model.Pedido;
import com.gpi.lojasapi.repository.ClienteRepository;
import com.gpi.lojasapi.repository.PedidoRepository;
import com.gpi.lojasapi.services.exceptions.PedidoNaoEncontradoException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Pedido salvar(Pedido pedido, Long idCliente) {
		pedido.setIdPedido(null);
		pedido.setCliente(clienteRepository.findById(idCliente).get());
		pedido.setData(new Date());
		return repository.save(pedido);
	}

	public Pedido buscar(Long id) {
		if(repository.existsById(id)) {
			Optional<Pedido> pedido = repository.findById(id);			
			return pedido.get();
		}else {
			throw new PedidoNaoEncontradoException("Pedido não encontrado");
		}
	}
}
