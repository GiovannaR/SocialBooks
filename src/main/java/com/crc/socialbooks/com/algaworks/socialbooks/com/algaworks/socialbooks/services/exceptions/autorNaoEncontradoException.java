package com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.exceptions;

public class autorNaoEncontradoException extends RuntimeException {

    public autorNaoEncontradoException  (String mensagem){
        super(mensagem);
    }

    public autorNaoEncontradoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}