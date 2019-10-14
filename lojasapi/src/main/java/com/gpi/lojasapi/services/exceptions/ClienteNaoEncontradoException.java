package com.gpi.lojasapi.services.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1072431355497614774L;

	public ClienteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ClienteNaoEncontradoException(String mensagem, Throwable motivo) {
		super(mensagem,motivo);
	}
}
