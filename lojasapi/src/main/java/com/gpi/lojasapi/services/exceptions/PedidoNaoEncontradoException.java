package com.gpi.lojasapi.services.exceptions;

public class PedidoNaoEncontradoException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1072431355497614774L;

	public PedidoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public PedidoNaoEncontradoException(String mensagem, Throwable motivo) {
		super(mensagem,motivo);
	}
}
