package com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.exceptions;

public class SapatoNaoEncontradoException extends RuntimeException {

    public SapatoNaoEncontradoException (String mensagem){
        super(mensagem);
    }

    public SapatoNaoEncontradoException (String mensagem, Throwable causa){
        super(mensagem, causa);
    }


}
